package com.app.Service;

import java.util.List;

import com.app.entity.Coustmer;
import com.app.entity.Foods;

public interface CoustmerFoodService {

			public void saveCoustmer() ;
			
			public void updateCoustmer();

			public void deleteCoustmer();

			public List<Coustmer> displayCoustmer() ;
			
			public void saveFoodwithCoustmer() ;

			public void updateFood();

			public void deleteFood() ;

			public List<Foods> displayFood();

			
			
			
		}
	
