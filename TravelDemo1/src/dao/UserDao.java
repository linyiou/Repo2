package dao;

import domain.User;

public interface UserDao {
	public User findnameByUsername(String username);
	
    User findByCode(String code);

    void updateStatus(User user);
	public void save(User user);

	User findByUsernameAndPassword(String username, String password);
}
