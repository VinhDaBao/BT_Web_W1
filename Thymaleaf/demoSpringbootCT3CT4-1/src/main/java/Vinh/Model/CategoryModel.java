package Vinh.Model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class CategoryModel implements Serializable {
	private static final long serialVersionUID = 1L;

		@Id
		private Long categoryId;
		private String name;
		private String images;
		private int status;	
		private Boolean isEdit = false;
	

}
