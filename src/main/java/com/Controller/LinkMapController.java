package com.Controller;

import com.Pojo.LinkMap;
import com.Service.LinkMapService;
import com.Utils.JacksonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value="/",produces="text/html;charset=UTF-8")
public class LinkMapController {
    @Autowired
    private LinkMapService linkMapService;

    /**
     * 获取所有链接对
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/o/allLinkMap",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String showAllLinkMap() throws Exception {
        List<LinkMap> allLinkMap = linkMapService.getAllLinkMap();
        return JacksonUtils.obj2json(allLinkMap);
    }

    /**
     * 获取短链接
     * @param request
     * @return
     */
    @RequestMapping(value="/o/getShortLink",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getShortLink(HttpServletRequest request){
        //System.out.println(request.getParameter("originlink"));
        return linkMapService.getShortLink(request.getParameter("originlink"));
    }

    /**
     * 短链接转发
     */
    @RequestMapping(value="/f",produces="text/html;charset=UTF-8")
    public String forward(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String shortlink = request.getParameter("s");
        System.out.println("shortlink = " + shortlink);
        return "redirect:" + linkMapService.getOriginLink(shortlink);
    }
}