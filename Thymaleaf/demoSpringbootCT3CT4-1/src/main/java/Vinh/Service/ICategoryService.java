package Vinh.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import Vinh.entity.CategoryEntity;

public interface ICategoryService {

	<S extends CategoryEntity> S save(S entity);

	List<CategoryEntity> findAll();

	Optional<CategoryEntity> findById(Long id);

	long count();

	<S extends CategoryEntity> Optional<S> findOne(Example<S> example);


	List<CategoryEntity> findAllById(Iterable<Long> ids);

	List<CategoryEntity> findAll(Sort sort);

	Page<CategoryEntity> findAll(Pageable pageable);

	void deleteAll();

	void delete(CategoryEntity entity);

	void deleteById(Long id);

	Page<CategoryEntity> findByNameContaining(String name, Pageable pageable);

	List<CategoryEntity> findByNameContaining(String name);

}
