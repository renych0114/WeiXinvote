package com.neuedu.model.bean;

import java.sql.Timestamp;

public class Giftrecord {
private int id;
private int openid;
private int cid;
private int gid;
private int count;
private Timestamp gifttime;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getOpenid() {
	return openid;
}
public void setOpenid(int openid) {
	this.openid = openid;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getGid() {
	return gid;
}
public void setGid(int gid) {
	this.gid = gid;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public Timestamp getGifttime() {
	return gifttime;
}
public void setGifttime(Timestamp gifttime) {
	this.gifttime = gifttime;
}


}
