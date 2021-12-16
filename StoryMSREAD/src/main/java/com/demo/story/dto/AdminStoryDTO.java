package com.demo.story.dto;

import java.util.List;

import com.demo.story.entity.AdminStory;


public class AdminStoryDTO {

	Integer storyId;
	String storyTitle;
	String contributorName;
	String comments;
	String date;
	
	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

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

	@Override
	public String toString() {
		return "AdminStoryDTO [storyId=" + storyId + ", storyTitle=" + storyTitle + ", contributorName=" + contributorName + ", date=" + date
				 + ", comments=" + comments
				 + "]";
	}

		// Converts Entity into DTO
		public static AdminStoryDTO valueOf(AdminStory adminStory) {
			AdminStoryDTO adminStoryDTO = new AdminStoryDTO();
			adminStoryDTO.setStoryId(adminStory.getStoryId());
			adminStoryDTO.setStoryTitle(adminStory.getStoryTitle());
			adminStoryDTO.setContributorName(adminStory.getContributorName());
			adminStoryDTO.setDate(adminStory.getDate());
			adminStoryDTO.setComments(adminStory.getComments());
		    return adminStoryDTO;
		}

		// Converts DTO into Entity
		public AdminStory createEntity() {
			AdminStory adminStory = new AdminStory();
			adminStory.setStoryId(this.getStoryId());
			adminStory.setStoryTitle(this.getStoryTitle());
			adminStory.setContributorName(this.getContributorName());
			adminStory.setDate(this.getDate());
			adminStory.setComments(this.getComments());
			return adminStory;
		}


}
