package Vinh.service;

import java.util.List;

import Vinh.entity.Category;

public interface ICategoryJPAService {
	int count();

	List<Category> findAll(int page, int pagesize);

	List<Category> findByCategoryname(String catname);

	List<Category> findAll();

	Category findById(int cate_id);

	void delete(Category category);

	void update(Category category);

	void insert(Category category);
}
