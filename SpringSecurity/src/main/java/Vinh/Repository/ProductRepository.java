package Vinh.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Vinh.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}