package Vinh.service;

import Vinh.entity.NguoiDung;

public interface IUserServiceJPA {

	NguoiDung updateProfile(NguoiDung newUser);

	NguoiDung changepass(String email, String newpass);

	NguoiDung register(NguoiDung newUser);

	NguoiDung get(String username);

	NguoiDung login(String username, String password);

}
