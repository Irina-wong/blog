package com.blogIn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogIn.dao.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long>{
 
}
