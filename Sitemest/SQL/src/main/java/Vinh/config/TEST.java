package Vinh.config;

import Vinh.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TEST {
	public static void main(String[] args) {

		EntityManager enma = Config.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		Category cate = new Category();
		cate.setCate_id(0);

		cate.setCate_name("Iphone");

		cate.setIcons("abc.jpg");

		try {

			trans.begin();

			enma.persist(cate);


			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}

	}

}
