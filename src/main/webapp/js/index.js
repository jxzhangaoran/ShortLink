$(document).ready(function() {
			/*开发初期用于调试数据,现保留代码以供可能的后续使用
   $("#showAll").on("click",function(){
       $.ajax({
           type:"GET",
           url:"o/allLinkMap",
           datatype:"json",
           success:function(allLinkMap){
               console.log(allLinkMap);
               $("#testTable").css("display","block");
               var linklist = JSON.parse(allLinkMap);
               $("#testTable tbody").html("");
               for(var i = 0;i < linklist.length;i++){
                   $("#testTable tbody").append(
                       "<tr>" +
                       "<td>" + linklist[i].no + "</td>" +
                       "<td>" + linklist[i].shortlink + "</td>" +
                       "<td>" + linklist[i].originlink + "</td>" +
                       "</tr>"
                   );
               }
           }
       })
   });
   */

			layui.use('form', function() {
				var form = layui.form;
				form.verify({
					originlink: function(value, item) {
						//去除空格和回车
						var trimValue = value.replace(/[ ]/g, "").replace(/[\r\n]/g, "");
						$("#originlink").val(trimValue);
						if (!new RegExp("^(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]$").test(trimValue)) {
							return "源链接非法,请输入正确的URL格式!";
						}
						//f?s=6LAzf 长度为9
						else if (trimValue.length <= (window.location.href.length + 9)) {
							return "源链接较短，无需进行缩短:)"
						}
					}
				});
				form.on("submit(submit)", function(data) {
					//alert(window.location.href);
					getShortLink($("#originlink").val());
					return false;
				})
			});

			function getShortLink(originlink) {
				$.ajax({
					type: "GET",
					url: "o/getShortLink",
					datatype: "text",
					data: {
						"originlink": originlink
					},
					success: function(shortlink) {
						//本站域名 + 62进制链接对编码
						$("#shortlink").html(window.location.href + "f?s=" + shortlink);
						$("#shortlink").removeClass("layui-quote-nm");
						$("#copy").removeClass("layui-btn-disabled");
						$("#copy").attr("disabled", false);
						$("#jump").removeClass("layui-btn-disabled");
						$("#jump").attr("disabled", false);
					}
				})
			}

			$("#link-icon").on("click touchend", function() {
				var othis = $(this),
					anim = othis.data('anim');
				othis.removeClass(anim);
				setTimeout(function() {
					othis.addClass(anim);
				});
			});

			$("#welcometitle").on("click", function() {
				location.reload();
			});

			layui.use('element', function() {

			});

			$("#originlink").on("input propertychange", function() {
				if ($(this).val().length > 0) {
					$("#reset").removeClass("layui-btn-disabled");
					$("#reset").attr("disabled", false);
				} else {
					$("#reset").addClass("layui-btn-disabled");
					$("#reset").attr("disabled", "disabled");
				}
			})

			$("#reset").on("click", function() {
				$("#originlink").val("");
				$("#reset").addClass("layui-btn-disabled");
				$("#reset").attr("disabled", "disabled");
			})

			new ClipboardJS("#copy");

			layui.use('layer', function() {
				var layer = layui.layer;

				$("#copy").on("click", function() {
					layer.msg("复制成功:)", {
						time: 1500
					});
				});
			});

			$("#jump").on("click", function() {
				window.open($("#shortlink").html(), "_blank");
			})

			layui.use(['rate'], function() {
					var rate = layui.rate;
					//基础效果
					rate.render({
						elem: '#rank',
						choose: function(value){
							layui.use('layer', function() {
								var layer = layui.layer;
							
								if(value == 5){
									layer.msg("谢谢您的肯定~",{time:1500});
								}else if(value > 2){
									layer.msg("会继续努力的!",{time:1500});
								}else layer.msg("抱歉让您失望了TT",{time:1500});
							});
						}
					})
				});
			
			$(function(){
					$("#particlebackground").jParticle({
						background: "rgba(0,0,0,0)",//背景颜色
						color: "#000",//粒子和连线的颜色
						particlesNumber:$(window).width() / 35,//粒子数量
						//disableLinks:true,//禁止粒子间连线
						//disableMouse:true,//禁止粒子间连线(鼠标)
						particle: {
							minSize: 1,//最小粒子
							maxSize: 3,//最大粒子
							speed: 30,//粒子的动画速度
						 }
					});
				});
			});
