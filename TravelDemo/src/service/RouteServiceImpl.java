package service;

import java.util.List;

import dao.RouteDao;
import dao.RouteDaoImpl;
import dao.RouteImgDao;
import dao.RouteImgDaoImpl;
import dao.SellerDao;
import dao.SellerDaoImpl;
import domain.PageBean;
import domain.Route;
import domain.RouteImg;
import domain.Seller;


public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao = new RouteDaoImpl();
    private RouteImgDao routeImgDao = new RouteImgDaoImpl();

    private SellerDao sellerDao = new SellerDaoImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize,String rname ) {
        //��װPageBean
        PageBean<Route> pb = new PageBean<Route>();
        //���õ�ǰҳ��
        pb.setCurrentPage(currentPage);
        //����ÿҳ��ʾ����
        pb.setPageSize(pageSize);
        
        //�����ܼ�¼��
        int totalCount = routeDao.findTotalCount(cid,rname);
        pb.setTotalCount(totalCount);
        //���õ�ǰҳ��ʾ�����ݼ���
        int start = (currentPage - 1) * pageSize;//��ʼ�ļ�¼��
        List<Route> list = routeDao.findByPage(cid,start,pageSize,rname);
        pb.setList(list);

        //������ҳ�� = �ܼ�¼��/ÿҳ��ʾ����
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize :(totalCount / pageSize) + 1 ;
        pb.setTotalPage(totalPage);


        return pb;
    }
    public Route findOne(String rid) {
        //1.����idȥroute���в�ѯroute����
        Route route = routeDao.findOne(Integer.parseInt(rid));

        //2.����route��id ��ѯͼƬ������Ϣ
        List<RouteImg> routeImgList = routeImgDao.findByRid(route.getRid());
        //2.2���������õ�route����
        route.setRouteImgList(routeImgList);
        //3.����route��sid���̼�id����ѯ�̼Ҷ���
        Seller seller = sellerDao.findById(route.getSid());
        route.setSeller(seller);

        return route;
    }
}