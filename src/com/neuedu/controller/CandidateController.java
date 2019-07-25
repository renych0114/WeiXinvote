package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.neuedu.model.bean.Candidate;
import com.neuedu.model.service.ActivityService;
import com.neuedu.model.service.CandidateService;

@Controller
public class CandidateController {
	@Autowired
	private CandidateService candidateService;
	
	@RequestMapping("selectCandidate/{aid}/{pagenum}/{pagesize}")
	@ResponseBody
	public List<Candidate> selectCandidate(@PathVariable int aid,@PathVariable int pagenum,@PathVariable int pagesize){
		List<Candidate> list = candidateService.selectCandidate(aid, pagenum, pagesize);
		return list;
	}
	
	@RequestMapping("selectCandidateByName/{name}")
	@ResponseBody
	public List<Candidate> selectCandidateByName(@PathVariable String name){
		return candidateService.selectCandidateByName(name);
	}
	
	@RequestMapping("saveCandidate")
	@ResponseBody
	public String saveCandidate(Candidate c,@RequestParam MultipartFile[] upload,HttpServletRequest request  ) throws IllegalStateException, IOException{
		candidateService.saveCandidate(c, upload,request);
		return "{\"result\":\"报名成功\"}";
	}
	
	@RequestMapping("updateCandidateHot/{cid}")
	@ResponseBody
	public String updateCandidateHot(@PathVariable int cid){
		candidateService.updateCandidateHot(cid);
		return "{\"result\":\"更新成功\"}";
	}
	
	@RequestMapping("selectCandidateById/{cid}")
	@ResponseBody
	public Candidate selectCandidateById(@PathVariable int cid){
		return candidateService.selectCandidateById(cid);
	}
	
	@RequestMapping("voteCandidate/{cid}/{aid}")
	@ResponseBody
	public String voteCandidate(@PathVariable int cid,@PathVariable int aid){
		candidateService.updateCandiAndActiTickets(cid, aid);
		return "{\"result\":\"投票成功\"}";
	}
	
	@RequestMapping("saveGiftForCandidate/{aid}/{cid}/{gid}/{giftcount}")
	@ResponseBody
	public String saveGiftForCandidate(@PathVariable int cid,@PathVariable int aid,@PathVariable int gid,@PathVariable int giftcount){
		candidateService.saveGiftForCandidate(aid,cid,gid,giftcount);
		return "{\"result\":\"送礼物成功\"}";
	}
	
	
}



