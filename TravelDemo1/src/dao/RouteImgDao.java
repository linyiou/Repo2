package dao;



import java.util.List;

import domain.RouteImg;

public interface RouteImgDao {

    /**
     * ����route��id��ѯͼƬ
     * @param rid
     * @return
     */
    public List<RouteImg> findByRid(int rid);
}
