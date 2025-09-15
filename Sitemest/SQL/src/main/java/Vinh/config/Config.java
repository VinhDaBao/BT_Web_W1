package Vinh.config;
import jakarta.persistence.EntityManager;


import jakarta.persistence.EntityManagerFactory;


import jakarta.persistence.Persistence;


import jakarta.persistence.PersistenceContext;
@PersistenceContext



public class Config {
	 public static EntityManager getEntityManager() {


		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("dataSource");


		 return factory.createEntityManager();


		 }
}
