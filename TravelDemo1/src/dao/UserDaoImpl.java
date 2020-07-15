package dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import domain.User;
import util.JDBCUtils;

public class UserDaoImpl implements UserDao {
	
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	
	public User findnameByUsername(String username) {
		 User user = null;
	        try {
	            //1.∂®“Âsql
	            String sql = "select * from tab_user where username = ?";
	            //2.÷¥––sql
	            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
	        } catch (Exception e) {

	        }

	        return user;
	}

	public void save(User user) {
		String sql = "insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code) values(?,?,?,?,?,?,?,?,?)";
		
		template.update(sql,user.getUsername(),
				user.getPassword(),
				user.getName(),
				user.getBirthday(),
				user.getSex(),
				user.getTelephone(),
				user.getEmail(),
				user.getStatus(),
				user.getCode()
		);
	}

	@Override
	public User findByCode(String code) {
		User user =null;
		try {
			String sql ="select * from tab_user where code =?";
			
			user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void updateStatus(User user) {
		String sql = "update tab_user set status = 'Y' where uid=?";
		template.update(sql,user.getUid());
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		User user =null;
		try {
			String sql = "select * from tab_user where username =? and password=?";
			user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

}
