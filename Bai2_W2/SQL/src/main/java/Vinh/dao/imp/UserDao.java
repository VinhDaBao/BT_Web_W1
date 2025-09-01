package Vinh.dao.imp;

import Vinh.models.User;

public interface UserDao {
	User get(String username);
	User insert(String username, String password, String fullname, String avatar);
}
