package com.Service;

import com.Pojo.LinkMap;

import java.util.List;

public interface LinkMapService {
    /**
     * 获取所有生成过的链接对
     * @return
     */
    List<LinkMap> getAllLinkMap();

    /**
     * 获取/生成短链接
     * 业务逻辑：
     * 先查询数据库，如果有已经生成的短链接，直接返回该短链接；
     * 如果没有，则调用62进制转换方法生成一个新的短链接并插入数据库，返回新生成的短链接。
     * @param originlink
     * @return
     */
    String getShortLink(String originlink);

    /**
     * 根据用户访问的短链接，找到源链接并返回
     * @param shortlink
     * @return
     */
    String getOriginLink(String shortlink);
}
