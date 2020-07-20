package service;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;
import util.MailUtils;
import util.UuidUtil;

public class UserServiceImpl implements UserService{
	private UserDao userDao = new UserDaoImpl();
	@Override
	public boolean regist(User user) {
		User u = userDao.findnameByUsername(user.getUsername());
		if(u != null) {
			return false;
		}
		user.setCode(UuidUtil.getUuid());
		user.setStatus("N");
		userDao.save(user);
		
		String content = "<a href='http://localhost/TravelDemo1/activeUserServlet?code="+user.getCode()+"'>点击激活</a>";
		MailUtils.sendMail(user.getEmail(),content,"激活邮件");
		return true;
	}
	
	public boolean active(String code) {
		User user = userDao.findByCode(code);
		if(user!=null) {
			userDao.updateStatus(user);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public User login(User user) {
		return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
	}
	

}
