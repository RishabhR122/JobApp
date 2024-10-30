package com.JobApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.JobApp.models.JobPost;
import com.JobApp.services.JobService;

import jakarta.validation.Valid;

@RestController
@Validated
public class JobController {
	
	@Autowired
	JobService serv;
	
	@GetMapping("jobPosts")
	public List<JobPost> getAllJobs() {
		return serv.getAllJobs();
	}
	
	@GetMapping("jobPost/{id}")
	public JobPost getJobById(@PathVariable("id") int id) {
		return serv.getJobById(id);
	}
	
	@PostMapping("addJob")
	public String addJob(@Valid @RequestBody JobPost job) {
		serv.addJob(job);
		return "Job Added Successfully";
	}
	
	@PutMapping("updateJob")
	public String updateJob(@Valid @RequestBody JobPost job) {
		serv.updateJob(job);
		return "Job Updateed Successfully";
	}
	@DeleteMapping("deleteJob/{id}")
	public String deleteJob(@PathVariable("id") int id) {
		serv.deleteJob(id);
		return "Job Deleted Successfully";
	}
	
	
}
