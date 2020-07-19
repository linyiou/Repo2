package dao;

import java.util.List;

import domain.Route;

public interface RouteDao {

    public int findTotalCount(int cid,String rname);

	public List<Route> findByPage(int cid , int start , int pageSize,String rname);
	 public Route findOne(int rid);
}
