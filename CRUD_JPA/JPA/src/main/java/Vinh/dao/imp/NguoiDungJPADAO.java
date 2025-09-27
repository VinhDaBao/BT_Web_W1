package Vinh.dao.imp;

import Vinh.entity.NguoiDung;
import Vinh.config.Config;
import Vinh.dao.INguoiDungJPADAO;
import jakarta.persistence.*;
import java.util.List;

public class NguoiDungJPADAO implements INguoiDungJPADAO {

	@Override
	public NguoiDung get(String username) {
		EntityManager em = Config.getEntityManager();
		try {
			TypedQuery<NguoiDung> query = em.createQuery("SELECT u FROM NguoiDung u WHERE u.username = :username",
					NguoiDung.class);
			query.setParameter("username", username);
			List<NguoiDung> result = query.getResultList();
			return result.isEmpty() ? null : result.get(0);
		} finally {
			em.close();
		}
	}

	@Override
	public NguoiDung insert(String email, String username, String password, String fullname, String avatar) {
		EntityManager em = Config.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		NguoiDung user = new NguoiDung();
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(password);
		user.setFullname(fullname);
		user.setAvatar(avatar);
		try {
			tx.begin();
			em.persist(user);
			tx.commit();
			return user;
		} catch (Exception e) {
			if (tx.isActive())
				tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public NguoiDung find(String email) {
		EntityManager em = Config.getEntityManager();
		try {
			TypedQuery<NguoiDung> query = em.createQuery("SELECT u FROM NguoiDung u WHERE u.email = :email",
					NguoiDung.class);
			query.setParameter("email", email);
			List<NguoiDung> result = query.getResultList();
			return result.isEmpty() ? null : result.get(0);
		} finally {
			em.close();
		}
	}

	@Override
	public NguoiDung update(NguoiDung user, String newpass) {
		EntityManager em = Config.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			NguoiDung u = em.find(NguoiDung.class, user.getId());
			if (u != null) {
				u.setPassword(newpass);
				em.merge(u);
				tx.commit();
				return u;
			}
		} catch (Exception e) {
			if (tx.isActive())
				tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public NguoiDung updateprofile(NguoiDung newuser) {
		EntityManager em = Config.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			NguoiDung u = em.find(NguoiDung.class, newuser.getId());
			if (u != null) {
				u.setEmail(newuser.getEmail());
				u.setFullname(newuser.getFullname());
				u.setAvatar(newuser.getAvatar());
				em.merge(u);
				tx.commit();
				return u;
			}
		} catch (Exception e) {
			if (tx.isActive())
				tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}
}