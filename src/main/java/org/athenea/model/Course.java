package org.athenea.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection="courses")
public class Course {
	@Id
	private String id;
	private String name;
	private String description;
	private double latitude;
	private double longitude;
	@Field("profesor")
	private String profesorEmail;
	private double price;
	private long likes;
	private List<String> tags;
	
	public Course(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


  public Course(String id, String name, String description, double latitude, double longitude,
      String profesorEmail, double price, long likes, List<String> tags) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.latitude = latitude;
    this.longitude = longitude;
    this.profesorEmail = profesorEmail;
    this.price = price;
    this.likes = likes;
    this.tags = tags;
  }

  public Course() {
  }

  /**
	 * @param tags the tags to set
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	/**
	 * @param profesorEmail the profesorEmail to set
	 */
	public void setProfesorEmail(String profesorEmail) {
		this.profesorEmail = profesorEmail;
	}

    @Override
    public String toString() {
        return String.format(
                "Grade[id=%s, name='%s']",
                id, name);
    }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public String getProfesorEmail() {
    return profesorEmail;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public long getLikes() {
    return likes;
  }

  public void setLikes(long likes) {
    this.likes = likes;
  }

  public List<String> getTags() {
    return tags;
  }
}
