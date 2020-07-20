package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import domain.Route;
import util.JDBCUtils;

public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotalCount(int cid,String rname) {
       
        //1.����sqlģ��
        String sql = "select count(*) from tab_route where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();//������
        //2.�жϲ����Ƿ���ֵ
        if(cid != 0){
            sb.append( " and cid = ? ");

            params.add(cid);//��ӣ���Ӧ��ֵ
        }

        if(rname != null && rname.length() > 0){
            sb.append(" and rname like ? ");

            params.add("%"+rname+"%");
        }

        sql = sb.toString();


        return template.queryForObject(sql,Integer.class,params.toArray());
    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize,String rname) {
        //String sql = "select * from tab_route where cid = ? and rname like ?  limit ? , ?";
        String sql = " select * from tab_route where 1 = 1 ";
        //1.����sqlģ��
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();//������
        //2.�жϲ����Ƿ���ֵ
        if(cid != 0){
            sb.append( " and cid = ? ");

            params.add(cid);//��ӣ���Ӧ��ֵ
        }

        if(rname != null && rname.length() > 0){
            sb.append(" and rname like ? ");

            params.add("%"+rname+"%");
        }
        sb.append(" limit ? , ? ");//��ҳ����

        sql = sb.toString();

        params.add(start);
        params.add(pageSize);


        return template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),params.toArray());
    }

    @Override
    public Route findOne(int rid) {
        String sql = "select * from tab_route where rid = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Route>(Route.class),rid);
    }
}
