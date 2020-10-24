package com.blogIn.service;

import com.blogIn.dao.Vote;


public interface VoteService {
	
	Vote getVoteById(Long id);
	
	void removeVote(Long id);
}
