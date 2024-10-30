package com.JobApp.models;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
@Component
public class JobPost {
	
	@Id
	@Positive(message = "Id should be positive")
	private int postId;

	@NotBlank(message = "job post profile should not be empty")
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "job post profile should have only characters")
	private String postProfile; 

	@Pattern(regexp = "^[a-zA-Z ]+$", message = "job post description should have only characters")
	@NotNull(message = "job post description should not be empty")
	private String postDesc;
	
	@Positive(message = "Required Experience should be positive")
	private Integer reqExperience;
	
	@ElementCollection
	private List<String> postTechStack;
	
	public int getPostId() {
		return postId;
	}
	public JobPost() {}
	
	public void setPostId(int postId) {
		this.postId = postId;
	}

	public JobPost(@Positive(message = "Id should be positive") int postId,
			@NotBlank(message = "job post profile should not be empty") @Pattern(regexp = "^[a-zA-Z ]+$", message = "job post profile should have only characters") String postProfile,
			@Pattern(regexp = "^[a-zA-Z ]+$", message = "job post description should have only characters") @NotNull(message = "job post description should not be empty") String postDesc,
			@Positive(message = "Required Experience should be positive") Integer reqExperience,
			List<String> postTechStack) {
		this.postId = postId;
		this.postProfile = postProfile;
		this.postDesc = postDesc;
		this.reqExperience = reqExperience;
		this.postTechStack = postTechStack;
	}
	

	public String getPostProfile() {
		return postProfile;
	}

	public void setPostProfile(String postProfile) {
		this.postProfile = postProfile;
	}

	public String getPostDesc() {
		return postDesc;
	}

	public void setPostDesc(String postDesc) {
		this.postDesc = postDesc;
	}

	public Integer getReqExperience() {
		return reqExperience;
	}

	public void setReqExperience(Integer reqExperience) {
		this.reqExperience = reqExperience;
	}

	public List<String> getPostTechStack() {
		return postTechStack;
	}

	public void setPostTechStack(List<String> postTechStack) {
		this.postTechStack = postTechStack;
	}

	
}
