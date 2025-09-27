package Vinh.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.persistence.NamedQuery;
@Entity
@Table(name= "videos")
@NamedQuery(name = "Video.findAll", query = "SELECT v FROM Video v")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="VideoId")
	private String videoid;
	@Column(name="Active")
	private int active;

	@Column(name="Description", columnDefinition = "NVARCHAR(MAX)")
	private String description;

	@Column(name="Poster")
	private String poster;

	@Column(name="Title")
	private String title;
	@Column(name="Views")
	private int views;

	@ManyToOne
	@JoinColumn(name="cate_id")
	private Category category;

	public Video() {
	}

	public String getVideoid() {
		return videoid;
	}

	public void setVideoid(String videoid) {
		this.videoid = videoid;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
