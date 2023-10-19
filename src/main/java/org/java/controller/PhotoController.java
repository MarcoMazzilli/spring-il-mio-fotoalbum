package org.java.controller;

import java.util.List;

import org.java.db.pojo.Photo;
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
public class PhotoController {
	
	@Autowired
	private PhotoService photoService;
	
	@GetMapping("/admin/photo")
	public String photoIndex(
			Model model,
			@RequestParam(required = false) String photoName ) {
			
		List<Photo> arrayPhotos = photoService.findAll();
		
		model.addAttribute("arrayPhotos", arrayPhotos);
		
		return "photoCRUDtemplate/index";
	}
	
	@GetMapping("/admin/photo/{id}")
	public String photoShow(
			@PathVariable int id ,
			Model model) {
		
		Photo photo = photoService.findById(id);
		model.addAttribute("photo", photo);
		
		return "photoCRUDtemplate/show";
	}
	
	@GetMapping("/admin/photo/create")
	public String create(Model model) {
		
		model.addAttribute("photo", new Photo());
		
		return "photoCRUDtemplate/create_update";
	}
	
	@PostMapping("/admin/photo/create")
	public String store(
			Model model,
			@Valid @ModelAttribute("photo") Photo photo,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "photoCRUDtemplate/create_update";
			}
		
		try {
			photoService.save(photo);			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.println("Photo saved on db");
		
		return "redirect:/admin/photo";
	}
	
	@GetMapping("admin/photo/update/{id}")
	public String getUpdate(
			@PathVariable int id,
			Model model
			) {
		
		Photo photo = photoService.findById(id);
		model.addAttribute("photo", photo);
		
		return "photoCRUDtemplate/create_update";
	}
	
	@PostMapping("admin/photo/update/{id}")
	public String postUpdate(
			@Valid @ModelAttribute Photo photo,
			BindingResult bindingResult,
			Model model) {
		
		if(bindingResult.hasErrors()) {
			return "photoCRUDtemplate/create_update";
			}
		
		try {
			photoService.save(photo);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("New Photo updated on db");
		
		return "redirect:/admin/photo";
	}
	
	@PostMapping("admin/photo/delete/{id}")
	public String delete(@PathVariable int id) {
		
		photoService.delete(photoService.findById(id));
		
		return "redirect:/admin/photo";
	}

}
