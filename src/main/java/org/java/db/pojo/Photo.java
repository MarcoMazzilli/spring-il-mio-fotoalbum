package org.java.db.pojo;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	@NotBlank(message = "Title cannot be null")
	private String title;
	
	@Column(nullable = true)
	@Length(
			min = 2 ,
			max = 255 ,
			message = "Length must be between 2 and 255 characters")
	private String description;
	
	@Column(nullable = false)
	@NotBlank(message = "Url cannot be null")
	@Length(
			min = 2 ,
			max = 255 ,
			message = "Length must be between 2 and 255 characters")
	private String url;
	
	private boolean visible = true;
	
	public Photo() {}
	public Photo(String title,String description,String url,boolean visible) {
		
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
	}
		
	// GETTER & SETTER

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	};
	
	
	//visible,categoryes
}
