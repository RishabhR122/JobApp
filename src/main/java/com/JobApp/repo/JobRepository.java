package com.JobApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JobApp.models.JobPost;

@Repository
public interface JobRepository extends JpaRepository<JobPost, Integer> {

}
