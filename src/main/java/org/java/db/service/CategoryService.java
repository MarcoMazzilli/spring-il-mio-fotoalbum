package org.java.db.service;

import java.util.List;

import org.java.db.pojo.Category;
import org.java.db.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public void save(Category category) {
		categoryRepository.save(category);
	}
	public List<Category> findAll(){

		List<Category> arrayCategory = categoryRepository.findAll();

		return arrayCategory;
	}

	public Category findById(int id) {

		return categoryRepository.findById(id).get();
	}
	
	public void delete(Category category) {
		
		categoryRepository.delete(category);
	}
}
