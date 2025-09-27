package Vinh.config;

import Vinh.entity.Category;
import Vinh.service.ICategoryJPAService;
import Vinh.service.imp.CategoryJPAService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TEST {
	public static void main(String[] args) {

		EntityManager enma = Config.getEntityManager();

		EntityTransaction trans = enma.getTransaction();



		ICategoryJPAService cate_ser = new CategoryJPAService();
		Category cate = cate_ser.findById(14);
		System.out.print(cate.getIcons());

	}

}
