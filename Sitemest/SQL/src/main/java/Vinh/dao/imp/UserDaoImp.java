package Vinh.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Vinh.SQL.DB;
import Vinh.models.User;

public class UserDaoImp implements UserDao{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public User get(String username) {
		String sql = "SELECT * FROM [NguoiDung] WHERE username = ? ";
		try {
		conn = new DB().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		rs = ps.executeQuery();
		while (rs.next()) {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setUserName(rs.getString("username"));
		user.setFullName(rs.getString("fullname"));
		user.setPassWord(rs.getString("password"));
		user.setAvatar(rs.getString("avatar"));
		user.setRole_id(rs.getString("role_id"));


		return user; }
		} catch (Exception e) {e.printStackTrace(); }
		return null;
	}

	@Override
	public User insert(String email ,String username, String password, String fullname, String avatar) {
		 String sql = "INSERT INTO [NguoiDung] (username, fullname, password, avatar,email) VALUES (?, ?, ?, ?,?)";
		    
		    try (Connection conn = new DB().getConnection();
		         PreparedStatement ps = conn.prepareStatement(sql)) {
		        
		        ps.setString(1, username);
		        ps.setString(2, fullname);
		        ps.setString(3, password);
		        ps.setString(4, avatar);
		        ps.setString(5,email);
		        
		        int rows = ps.executeUpdate(); // số dòng bị ảnh hưởng (thường = 1 nếu insert thành công)
		        System.out.println(rows);
		        return this.get(username);               // trả về true nếu có chèn
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return null;

	}

	@Override
	public User find(String email) {
		String sql = "SELECT * FROM [NguoiDung] WHERE email = ? ";
		try {
		conn = new DB().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		rs = ps.executeQuery();
		while (rs.next()) {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setUserName(rs.getString("username"));
		user.setFullName(rs.getString("fullname"));
		user.setPassWord(rs.getString("password"));
		user.setAvatar(rs.getString("avatar"));


		return user; }
		} catch (Exception e) {e.printStackTrace(); }
		return null;
	}

	@Override
	public User update(User user, String newpass) {
		String sql = "UPDATE [NguoiDung] SET password = ? WHERE username = ? ;";
		try {
			
			conn = new DB().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, newpass);
			ps.setString(2,user.getUserName());
			int row = ps.executeUpdate();
			return user;
			
			} catch (Exception e) {e.printStackTrace(); }
			return null;
	}

	@Override
	public User updateprofile(User newuser) {

		String sql = "UPDATE [NguoiDung] SET email = ?  ,fullname = ? , avatar= ? WHERE username = ? ;";
		try {
			conn = new DB().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, newuser.getEmail());
			ps.setString(2, newuser.getFullName());
			ps.setString(3, newuser.getAvatar());
			ps.setString(4, newuser.getUserName());
			int row = ps.executeUpdate();
			return newuser;
		} catch (Exception e) {e.printStackTrace();}
		return null;
	}
	
	
	

}
