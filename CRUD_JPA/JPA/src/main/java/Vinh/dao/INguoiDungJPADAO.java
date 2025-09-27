package Vinh.dao;

import Vinh.entity.NguoiDung;

public interface INguoiDungJPADAO {

	NguoiDung updateprofile(NguoiDung newuser);

	NguoiDung update(NguoiDung user, String newpass);

	NguoiDung find(String email);

	NguoiDung insert(String email, String username, String password, String fullname, String avatar);

	NguoiDung get(String username);

}
