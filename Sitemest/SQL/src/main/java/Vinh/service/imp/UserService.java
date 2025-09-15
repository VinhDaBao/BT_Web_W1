package Vinh.service.imp;
import Vinh.models.User;
public interface UserService {
	User login(String username, String password);
	User get(String username);
	User register(User newuser);
	User changepass(String email, String newpass);
	User updateProfile(User newuser);
}
