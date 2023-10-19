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
	@NotBlank(message = "Il titolo è un campo obbligatorio")
	private String title;
	
	@Column(nullable = true)
	@Length(
			min = 2 ,
			max = 255 ,
			message = "La lunghezza deve essere compresa tra 2 e 255 caratteri")
	private String description;
	
	@Column(nullable = false)
	@NotBlank(message = "L'url è un campo obbligatorio")
	@Length(
			max = 255 ,
			message = "Lunghezza massima dell'url 255 caratteri")
	private String url;
	
	private boolean visible = true;
	
	public Photo() {}
	public Photo(String title,String description,String url,boolean visible) {
		
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
	}
	public Photo(String title,String description,String url) {
		
		setTitle(title);
		setDescription(description);
		setUrl(url);
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
	
	@Override
	public String toString() {
		return  "[id] : " + getId() + "\n" +
				"[title] : " + getTitle() + "\n" +
				"[description] : " + getDescription() + "\n" +
				"[url] : " + getUrl() + "\n" +
				"[visible] : " + isVisible() + "\n";
	}
	
	//visible,categoryes
}
