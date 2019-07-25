package com.neuedu.model.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class Activity {
private int aid;
private String imgurl;
private int totalpeople;
private int totalticket;
private int totalaccess;
private Timestamp begintime;
private Timestamp endtime;
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getImgurl() {
	return imgurl;
}
public void setImgurl(String imgurl) {
	this.imgurl = imgurl;
}
public int getTotalpeople() {
	return totalpeople;
}
public void setTotalpeople(int totalpeople) {
	this.totalpeople = totalpeople;
}
public int getTotalticket() {
	return totalticket;
}
public void setTotalticket(int totalticket) {
	this.totalticket = totalticket;
}
public int getTotalaccess() {
	return totalaccess;
}
public void setTotalaccess(int totalaccess) {
	this.totalaccess = totalaccess;
}
public Timestamp getBegintime() {
	return begintime;
}
public void setBegintime(Timestamp begintime) {
	this.begintime = begintime;
}
public Timestamp getEndtime() {
	return endtime;
}
public void setEndtime(Timestamp endtime) {
	this.endtime = endtime;
}

}
