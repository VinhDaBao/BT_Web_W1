package Vinh.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Vinh.Entity.Product;
import Vinh.Repository.ProductRepository;

public class ProductServiceImpl implements ProductServices {

	@Autowired
	private ProductRepository repo;
	
 	public ProductServiceImpl(ProductRepository repo) {
		this.repo = repo;
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);		
	}

	@Override
	public Product get(Long id) {
		
		return repo.findById(id).get();
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return repo.save(product);
	}

	@Override
	public List<Product> listAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
}
