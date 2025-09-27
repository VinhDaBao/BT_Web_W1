package Vinh.dao.imp;

import java.util.List;

import Vinh.config.Config;
import Vinh.dao.ICategoryJPADAO;
import Vinh.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class CategoryJPADAO implements ICategoryJPADAO {
	@Override
	public void insert(Category category) {

		EntityManager enma = Config.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.persist(category);

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}

	}

	@Override
	public void update(Category category) {

		EntityManager enma = Config.getEntityManager();

		EntityTransaction trans = enma.getTransaction();



		try {

			trans.begin();


			enma.merge(category);
			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}

	}

	@Override
	public void delete(Category category) {

		EntityManager enma = Config.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			Category managedCategory = enma.find(Category.class, category.getCate_id());
	        if (managedCategory != null) {
	            enma.remove(managedCategory);
	        }			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}

	}
	@Override
	public Category findById(int cate_id)
	{
		EntityManager enma = Config.getEntityManager();
		Category  category = enma.find(Category.class, cate_id);
		return category;
	}
	@Override
	public List<Category> findAll(){
		EntityManager enma = Config.getEntityManager();
		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll",Category.class);
		return query.getResultList();
	}
	@Override
	public List<Category> findByCategoryname(String catname) {
		EntityManager enma = Config.getEntityManager();
		String jpql = "SELECT c FROM Category c WHERE c.catename like :catname";
		TypedQuery<Category> query= enma.createQuery(jpql, Category.class);
		query.setParameter("catename", "%" + catname + "%");
		return query.getResultList();
	}

		@Override
		public List<Category> findAll(int page, int pagesize) {
		EntityManager enma = Config.getEntityManager();
		TypedQuery<Category> query= enma. createNamedQuery("Category.findAll", Category.class);
		query.setFirstResult(page*pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();
		}

		@Override
		public int count() {
		EntityManager enma = Config.getEntityManager();
		String jpql = "SELECT count(c) FROM Category c";
		Query query = enma.createQuery(jpql);
		return ((Long)query.getSingleResult()).intValue();
		}
}
