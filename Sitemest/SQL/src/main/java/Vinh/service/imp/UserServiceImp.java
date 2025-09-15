package Vinh.service.imp;

import java.io.File;

import Vinh.controller.Constant;
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

	@Override
	public User register(User newuser) {
		User user = this.get(newuser.getUserName());
		if (user != null)
		{
			return user;

		}
		userDao.insert(newuser.getEmail(), newuser.getUserName(), newuser.getPassWord(), newuser.getFullName(), newuser.getAvatar());
		return null;
	}

	@Override
	public User changepass(String email, String newpass) {
		User forgotuser = null;
		if (userDao.find(email) != null)
		{
			forgotuser = userDao.find(email);
			return userDao.update(forgotuser,newpass);
		}
		return null;
	}

	@Override
	public User updateProfile(User newuser) {
		User olduser = userDao.get(newuser.getUserName());
		if (newuser.getAvatar() != null)
		{
			String filename = olduser.getAvatar();
			File file = new File(Constant.ADIR +"\\"+ filename);
			if (file.exists()) {
				file.delete();
				System.out.println("Trying to delete: " + file.getAbsolutePath());
				}
			
		}
		return userDao.updateprofile(newuser);
	}
	
	

}
