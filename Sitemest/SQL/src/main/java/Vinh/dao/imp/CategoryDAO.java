package Vinh.dao.imp;
import java.util.List;
import Vinh.models.Category;
public interface CategoryDAO {
	void insert(Category category);
	void edit(Category category);
	void delete(int id);
	Category get(int id);
	Category get(String name);
	List<Category> getAll();
	List<Category> search(String keyword);
}
