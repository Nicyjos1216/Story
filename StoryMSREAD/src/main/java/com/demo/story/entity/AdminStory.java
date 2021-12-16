package com.demo.story.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminStory {

	@Id
	@Column(nullable = false)
	Integer storyId;
	@Column(nullable = false)
	String storyTitle;
	@Column(nullable = false)
	String contributorName;
	@Column(nullable = false)
	String comments;
	@Column(nullable = false)
	String date;


	public Integer getStoryId() {
		return storyId;
	}


	public void setStoryId(Integer storyId) {
		this.storyId = storyId;
	}



	public String getStoryTitle() {
		return storyTitle;
	}



	public void setStoryTitle(String storyTitle) {
		this.storyTitle = storyTitle;
	}



	public String getContributorName() {
		return contributorName;
	}



	public void setContributorName(String contributorName) {
		this.contributorName = contributorName;
	}



	public String getComments() {
		return comments;
	}



	public void setComments(String comments) {
		this.comments = comments;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public AdminStory() {
		super();
	}
}