package com.neuedu.model.bean;

import java.sql.Date;
import java.util.List;

public class Candidate {
private int cid;
private int aid;
private String name;
private String declaration;
//≤ª”√int
private String mobile;
private String sex;
private String address;
private String imgurl;
private int tickets;
private int hots;
private int gifts;
//bit
private int status;
private String operator;
private Date operatorDate;

private List<Images>  images;


public List<Images> getImages() {
	return images;
}
public void setImages(List<Images> images) {
	this.images = images;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDeclaration() {
	return declaration;
}
public void setDeclaration(String declaration) {
	this.declaration = declaration;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getImgurl() {
	return imgurl;
}
public void setImgurl(String imgurl) {
	this.imgurl = imgurl;
}
public int getTickets() {
	return tickets;
}
public void setTickets(int tickets) {
	this.tickets = tickets;
}
public int getHots() {
	return hots;
}
public void setHots(int hots) {
	this.hots = hots;
}
public int getGifts() {
	return gifts;
}
public void setGifts(int gifts) {
	this.gifts = gifts;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getOperator() {
	return operator;
}
public void setOperator(String operator) {
	this.operator = operator;
}
public Date getOperatorDate() {
	return operatorDate;
}
public void setOperatorDate(Date operatorDate) {
	this.operatorDate = operatorDate;
}



}
