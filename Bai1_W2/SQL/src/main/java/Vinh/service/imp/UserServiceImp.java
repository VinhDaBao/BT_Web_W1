package Vinh.service.imp;

import Vinh.dao.imp.UserDao;
import Vinh.dao.imp.UserDaoImp;
import Vinh.models.User;

public class UserServiceImp implements UserService {
	UserDao userDao = new UserDaoImp();

	@Override
	public User login(String username, String password) {
		User user = this.get(username);
		if (user != null && password.equals(user.getPassWord().trim())) {
			
		return user;
		}

		return null;
	}

	@Override
	public User get(String username) {
		return userDao.get(username);

	}

}
