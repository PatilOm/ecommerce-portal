package com.omkar.pro.dao;

import java.util.List;

import com.omkar.pro.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id); 

}
