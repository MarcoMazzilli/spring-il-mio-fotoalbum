package org.java.controller;


import java.util.List;

import org.java.db.pojo.Category;
import org.java.db.pojo.Photo;
import org.java.db.service.CategoryService;
import org.java.db.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PhotoService photoService;
	
	
//	INDEX 
	
	@GetMapping("/admin/category")
	public String photoIndex(
			Model model,
			@RequestParam(required = false) String photoName ) {
			
			List<Category> arrayCategories = categoryService.findAll();
		
			model.addAttribute("arrayCategories", arrayCategories);
		
		return "categoryCRUDtemplate/index";
	}
	
//	CREATE
	
	@GetMapping("/admin/category/create")
	public String create(Model model) {
		
		model.addAttribute("category", new Category());
		
        
		return "categoryCRUDtemplate/create_update";
	}
	
	@PostMapping("/admin/category/create")
	public String store(
			@Valid @ModelAttribute("category") Category category,
			Model model,
			BindingResult bindingResult
			) {
			
		if(bindingResult.hasErrors()) {
			return "categoryCRUDtemplate/create_update";
			}
		
		try {
			categoryService.save(category);		
			
		} catch (Exception e) {
			
			System.err.println(e.getMessage());
			model.addAttribute("name_unique","Esiste già una categoria con questo nome");
			return "categoryCRUDtemplate/create_update";
		}
		System.out.println("Category saved on db");
		
		
		categoryService.save(category);
	
		return "redirect:/admin/category";
	}
	
// UPDATE 
	
	@GetMapping("admin/category/update/{id}")
	public String getUpdate(
			@PathVariable int id,
			Model model
			) {
		
		Category category = categoryService.findById(id);
		List <Photo> arrayPhotos = photoService.findAll();
		
		model.addAttribute("category", category);
		model.addAttribute("arrayPhotos", arrayPhotos);
	
		
		return "categoryCRUDtemplate/create_update";
	}
	
	@PostMapping("admin/category/update/{id}")
	public String postUpdate(
			@Valid @ModelAttribute Category category,
			BindingResult bindingResult,
			Model model) {
		
		if(bindingResult.hasErrors()) {
			return "categoryCRUDtemplate/create_update";
			}
		
		try {
			categoryService.save(category);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("New category updated on db");
		
		return "redirect:/admin/category";
	}
	
	// delete
	@PostMapping("admin/category/delete/{id}")
	public String delete(@PathVariable int id) {
		
		Category categoryToDelete = categoryService.findById(id);
		
		for (Photo c : categoryToDelete.getPhotos() ) {
					
					c.deleteCategories(categoryToDelete);
					photoService.save(c);
				}
		
		categoryService.delete(categoryToDelete);
		
		
		
		return "redirect:/admin/photo";
	}

}
