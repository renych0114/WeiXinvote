package com.neuedu.model.bean;

public class Images {
private int id;
private int cid;
private String imgurl;
private Candidate candidate;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getImgurl() {
	return imgurl;
}
public void setImgurl(String imgurl) {
	this.imgurl = imgurl;
}
public Candidate getCandidate() {
	return candidate;
}
public void setCandidate(Candidate candidate) {
	this.candidate = candidate;
}

}
