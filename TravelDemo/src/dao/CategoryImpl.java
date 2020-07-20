package dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import domain.Category;
import util.JDBCUtils;

public class CategoryImpl implements CategoryDao {

	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	
	@Override
	public List<Category> findAll() {
		String sql="select * from tab_category";
		
		return template.query(sql,new BeanPropertyRowMapper<Category>(Category.class));
	}

}
