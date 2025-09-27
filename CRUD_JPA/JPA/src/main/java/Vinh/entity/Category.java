package Vinh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categories")
@NamedQuery(name= "Category.findAll",query = "SELECT  c FROM Category c")
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cate_id")

	private int cate_id;
	@Column(name = "cate_name", columnDefinition = "NVARCHAR(255) NULL")
	private String cate_name;
	
	@Column(name = "icons", columnDefinition = "NVARCHAR(255) NULL")

	private String icons;
	@Column(name ="status")
	private int status;
	
	@OneToMany(mappedBy= "category")
	private List<Video> videos;
	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}

	public String getCate_name() {
		return cate_name;
	}

	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}

	public String getIcons() {
		return icons;
	}

	public void setIcons(String icons) {
		this.icons = icons;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	public Video addVideo(Video video)
	{
		getVideos().add(video);
		video.setCategory(this);
		return video;
	}
	public Video removeVideo(Video video)
	{
		getVideos().remove(video);
		video.setCategory(null);
		return video;
	}
	
	

}
