package org.java.db.service;

import java.util.List;

import org.java.db.pojo.Photo;
import org.java.db.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {
	
	@Autowired
	private PhotoRepository photoRepo;

	public void save(Photo photo) {
		photoRepo.save(photo);
	}
	
	public List<Photo> findAll(){

		List<Photo> arrayPhoto = photoRepo.findAll();

		return arrayPhoto;
	}

	public Photo findById(int id) {

		return photoRepo.findById(id).get();
	}
	
	public void delete(Photo photo) {
		
		photoRepo.delete(photo);
	}

}
