package com.DAO;

import com.Pojo.LinkMap;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShortLinkDAO {
    /**
     * 获取所有生成过的链接对
     * @return
     */
    List<LinkMap> getAllLinkMap();

    /**
     * 获取指定源链接的链接对
     * @param originlink
     * @return
     */
    List<LinkMap> getSpecificLinkMap(String originlink);

    /**
     * 插入新链接对
     * @param newLinkMap
     * @return
     */
    int insertNewLinkMap(LinkMap newLinkMap);

    /**
     * 获取当前自增ID数
     * @return
     */
    Long getCurrAutoIncrementNo();

    /**
     * 根据短链接获取源链接
     * @param shortlink
     * @return
     */
    String getOriginLink(String shortlink);
}
