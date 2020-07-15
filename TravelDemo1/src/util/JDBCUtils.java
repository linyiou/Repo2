package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
	1. ������̬����Դ��Ա����
	2. �������ӳض���
	3. ���幫�еĵõ�����Դ�ķ���
	4. ����õ����Ӷ���ķ���
	5. ����ر���Դ�ķ���
 */
public class JDBCUtils {
	// 1.	������̬����Դ��Ա����
	private static DataSource ds;

	// 2. �������ӳض���
	static {
		// ���������ļ��е�����
		InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
		Properties pp = new Properties();
		try {
			pp.load(is);
			// �������ӳأ�ʹ�������ļ��еĲ���
			ds = DruidDataSourceFactory.createDataSource(pp);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 3. ���幫�еĵõ�����Դ�ķ���
	public static DataSource getDataSource() {
		return ds;
	}

	// 4. ����õ����Ӷ���ķ���
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	// 5.����ر���Դ�ķ���
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {}
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}

	// 6.���عرշ���
	public static void close(Connection conn, Statement stmt) {
		close(conn, stmt, null);
	}
}
