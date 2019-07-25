package com.neuedu.model.service;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.neuedu.model.bean.Candidate;
import com.neuedu.model.bean.Giftrecord;
import com.neuedu.model.bean.Images;
import com.neuedu.model.bean.Voterecord;
import com.neuedu.model.mapper.ActivityMapper;
import com.neuedu.model.mapper.CandidateMapper;
import com.neuedu.model.mapper.GiftRecordMapper;
import com.neuedu.model.mapper.ImagesMapper;
import com.neuedu.model.mapper.VoteRecordMapper;

@Service
public class CandidateService {
	@Autowired
	private CandidateMapper candidateMapper;
	@Autowired
	private ActivityMapper activityMapper;
	@Autowired
	private ImagesMapper imagesMapper;
	@Autowired
	private VoteRecordMapper voteRecordMapper;
	@Autowired
	private GiftRecordMapper giftRecordMapper;
	
	public List<Candidate> selectCandidate(int aid,int pagenum,int pagesize){
		Map<String,Object> map = new HashMap<>();
		map.put("k_aid", aid);
		map.put("k_beginIndex", (pagenum-1)*pagesize);
		map.put("k_pagesize", pagesize);
		return candidateMapper.selectCandidate(map);
	}
	
	public List<Candidate> selectCandidateByName(String name){
		return candidateMapper.selectCandidateByName("%"+name+"%");
	}
	
	public void saveCandidate(Candidate c,MultipartFile[] upload, HttpServletRequest request) throws IllegalStateException, IOException{
		
		//���»���ܱ�������
		activityMapper.updateActivityTotalPeople(c.getAid());
		//�洢ѡ����Ϣ
		for(int i=0;i<upload.length;i++){
			//ͼƬ������
			String oldName = upload[i].getOriginalFilename();
			String newName = System.currentTimeMillis()+oldName.substring(oldName.indexOf('.'));
			File file = new File(request.getServletContext().getRealPath("/img/"),newName);
			upload[i].transferTo(file);
			if(i==0){
				c.setImgurl(newName);
				c.setTickets(0);
				c.setHots(0);
				c.setGifts(0);
				c.setStatus(1);
				c.setOperator("1");
				c.setOperatorDate(new java.sql.Date(new Date().getTime()));
				candidateMapper.saveCandidate(c);
			}else{
				//�洢ѡ�ֵ�ͼƬ��Ϣ
				Images image = new Images();
				image.setCid(c.getCid());
				image.setImgurl(newName);
				imagesMapper.saveImage(image);
			}
		}
	}
	
	public void updateCandidateHot(int cid){
		candidateMapper.updateCandidateHot(cid);
	}
	
	public Candidate selectCandidateById(int cid){
		return candidateMapper.selectCandidateById(cid);
	}
	
	public void updateCandiAndActiTickets(int cid,int aid){
		//���»��Ʊ��
		activityMapper.updateActivityTotalTickets(aid);
		//����ѡ����Ʊ��
		candidateMapper.updateCandidateTickets(cid);
		//�洢ͶƱ��¼
		Voterecord v = new Voterecord();
		v.setCid(cid);
		v.setOpenid("11");
		v.setVotetime(new Timestamp(new Date().getTime()));
		voteRecordMapper.saveVoteRecord(v);
	}

	public void saveGiftForCandidate(int aid, int cid, int gid, int giftcount) {
		//����ѡ�ֵ�������
		Map<String,Object> map = new HashMap<>();
		map.put("k_cid", cid);
		map.put("k_giftcount", giftcount);
		candidateMapper.updateCandidateGift(map);
		//�洢�������¼
		Giftrecord ge = new Giftrecord();
		ge.setOpenid(11);
		ge.setCid(cid);
		ge.setGid(gid);
		ge.setCount(giftcount);
		ge.setGifttime(new Timestamp(new Date().getTime()));
		giftRecordMapper.saveGiftRecord(ge);
	}
	
}










