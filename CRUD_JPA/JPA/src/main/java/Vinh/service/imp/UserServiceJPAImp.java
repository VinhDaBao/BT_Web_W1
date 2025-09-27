package Vinh.service.imp;

import java.io.File;
import jakarta.persistence.*;

import Vinh.controller.Constant;
import Vinh.dao.INguoiDungJPADAO;
import Vinh.dao.imp.NguoiDungJPADAO;
import Vinh.entity.NguoiDung;
import Vinh.service.IUserServiceJPA;

public class UserServiceJPAImp implements IUserServiceJPA {
    private INguoiDungJPADAO userDao = new NguoiDungJPADAO();

    @Override
    public NguoiDung login(String username, String password) {
        NguoiDung user = this.get(username);
        if (user != null && password.equals(user.getPassword().trim())) {
            return user;
        }
        return null;
    }

    @Override
    public NguoiDung get(String username) {
        return userDao.get(username);
    }

    @Override
    public NguoiDung register(NguoiDung newUser) {
        NguoiDung user = this.get(newUser.getUsername());
        if (user != null) {
            // Đã tồn tại user
            return user;
        }
        // Nếu chưa tồn tại thì insert (JPA sẽ trả về user đã tạo)
        return userDao.insert(
            newUser.getEmail(),
            newUser.getUsername(),
            newUser.getPassword(),
            newUser.getFullname(),
            newUser.getAvatar()
        );
    }

    @Override
    public NguoiDung changepass(String email, String newpass) {
        NguoiDung forgotuser = userDao.find(email);
        if (forgotuser != null) {
            return userDao.update(forgotuser, newpass);
        }
        return null;
    }

    @Override
    public NguoiDung updateProfile(NguoiDung newUser) {
        NguoiDung oldUser = userDao.get(newUser.getUsername());
        if (oldUser != null && newUser.getAvatar() != null) {
            String filename = oldUser.getAvatar();
            File file = new File(Constant.ADIR + File.separator + filename);
            if (file.exists()) {
                file.delete();
                System.out.println("Trying to delete: " + file.getAbsolutePath());
            }
        }
        return userDao.updateprofile(newUser);
    }
}