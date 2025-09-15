package Vinh.dao.imp;

import Vinh.models.User;

public interface UserDao {
	User get(String username);
	User insert(String email, String username, String password, String fullname, String avatar);
	User find(String email);
	User update(User user, String newpass);
	User updateprofile(User  newuser);
}
