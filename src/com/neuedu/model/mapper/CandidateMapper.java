package com.neuedu.model.mapper;

import java.util.List;
import java.util.Map;

import com.neuedu.model.bean.Candidate;

public interface CandidateMapper {
	
	public List<Candidate> selectCandidate(Map<String, Object> map);
	
	public List<Candidate> selectCandidateByName(String name);
	
	public void saveCandidate(Candidate c);
	
	public void updateCandidateHot(int cid);
	
	public Candidate selectCandidateById(int cid);
	
	public void updateCandidateTickets(int cid);

	public void updateCandidateGift(Map<String, Object> map);
}
