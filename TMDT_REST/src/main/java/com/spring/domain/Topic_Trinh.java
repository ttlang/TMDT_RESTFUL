package com.spring.domain;

public class Topic_Trinh {
	private String id;
	private String title;
	private String description;
	private Integer status;
	
	
	public Topic_Trinh() {
		super();
	}


	public Topic_Trinh(String id, String title, String description, Integer status) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
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


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Topic_Trinh [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ "]";
	}
	
	
}
