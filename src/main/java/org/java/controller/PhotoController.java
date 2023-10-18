package org.java.controller;

import java.util.List;

import org.java.db.pojo.Photo;
import org.java.db.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/photo")
public class PhotoController {
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@GetMapping
	public String photoIndex(Model model) {
			
		List<Photo> arrayPhotos = photoRepository.findAll();
		
		model.addAttribute("arrayPhotos", arrayPhotos);
		
		return "photoCRUDtemplate/index";
	}
	
	@GetMapping("/{id}")
	public String photoShow(
			@PathVariable int id ,
			Model model) {
		
		return "photoCRUDtemplate/show";
	}

}
