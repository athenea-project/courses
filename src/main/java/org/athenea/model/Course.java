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
}
