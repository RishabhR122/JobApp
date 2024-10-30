package com.JobApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JobApp.exceptions.InvalidApiRequestException;
import com.JobApp.models.JobPost;
import com.JobApp.repo.JobRepository;

@Service
public class JobService {

	@Autowired
	JobRepository repo;
	
	public List<JobPost> getAllJobs(){
		return repo.findAll();
	}
	public JobPost getJobById(int id) {
		Optional<JobPost> op=repo.findById(id);
		if(op.isEmpty()) {
			throw new InvalidApiRequestException("No such Job Exist");
		}
		return op.get();
	}
	public void addJob(JobPost job) {
		Optional<JobPost> op=repo.findById(job.getPostId());
		if(!op.isEmpty()) {
			throw new InvalidApiRequestException("Job Already Exist");
		}
		repo.save(job);
		
	}
	public void updateJob(JobPost job) {
		// TODO Auto-generated method stub
		Optional<JobPost> op=repo.findById(job.getPostId());
		if(op.isEmpty()) {
			throw new InvalidApiRequestException("No such Job Exist");
		}
		repo.save(job);
		
	}
	public void deleteJob(int id) {
		// TODO Auto-generated method stub
		Optional<JobPost> op=repo.findById(id);
		if(op.isEmpty()) {
			throw new InvalidApiRequestException("No such Job Exist");
		}
		repo.deleteById(id);
	}
}
