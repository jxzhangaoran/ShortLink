package com.Service.impl;

import com.DAO.ShortLinkDAO;
import com.Pojo.LinkMap;
import com.Service.LinkMapService;
import com.Utils.SixtyTwoBinarySystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkMapServiceImpl implements LinkMapService {

    @Autowired
    private ShortLinkDAO shortLinkDAO;

    @Override
    public List<LinkMap> getAllLinkMap() {
        return shortLinkDAO.getAllLinkMap();
    }

    @Override
    public String getShortLink(String originlink) {
        LinkMap map;
        List<LinkMap> shortlinklist = shortLinkDAO.getSpecificLinkMap(originlink);
        if(shortlinklist.size() == 0){
            map = new LinkMap(shortLinkDAO.getCurrAutoIncrementNo() + 1L,
                            SixtyTwoBinarySystemUtil.toSixtyTwoString
                                    (shortLinkDAO.getCurrAutoIncrementNo() + 1L),
                    originlink);
            shortLinkDAO.insertNewLinkMap(map);
        }else map = shortlinklist.get(0);
        return map.getShortlink();
    }

    @Override
    public String getOriginLink(String shortlink) {
        if(shortlink == null)return "error404";
        String res = shortLinkDAO.getOriginLink(shortlink);
        return res == null ? "error404" : res;
    }
}