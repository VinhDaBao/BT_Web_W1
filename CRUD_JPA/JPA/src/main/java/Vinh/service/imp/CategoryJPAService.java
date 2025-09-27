package Vinh.service.imp;

import java.util.List;

import Vinh.dao.imp.CategoryJPADAO;
import Vinh.entity.Category;
import Vinh.service.ICategoryJPAService;

public class CategoryJPAService implements ICategoryJPAService {
	CategoryJPADAO cateDao = new CategoryJPADAO();
	@Override
	public int count() {
		return cateDao.count();
	}

	@Override
	public List<Category> findAll(int page, int pagesize) {
		// TODO Auto-generated method stub
		return cateDao.findAll(page, pagesize);
	}

	@Override
	public List<Category> findByCategoryname(String catname) {
		// TODO Auto-generated method stub
		return cateDao.findByCategoryname(catname);
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cateDao.findAll();
	}

	@Override
	public Category findById(int cate_id) {
		// TODO Auto-generated method stub
		return cateDao.findById(cate_id);
	}

	@Override
	public void delete(Category category) {
		// TODO Auto-generated method stub
		cateDao.delete(category);
		
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		cateDao.update(category);
		
	}

	@Override
	public void insert(Category category) {
		// TODO Auto-generated method stub
		cateDao.insert(category);
		
	}

}
