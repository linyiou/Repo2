package dao;



import java.util.List;

import domain.RouteImg;

public interface RouteImgDao {

    /**
     * 根据route的id查询图片
     * @param rid
     * @return
     */
    public List<RouteImg> findByRid(int rid);
}
