package com.neuedu.model.bean;

public class Prize {
private int id;
private int aid;
private String name;
private String level;
private int count;
private String imgurl;
private Activity activity;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getLevel() {
	return level;
}
public void setLevel(String level) {
	this.level = level;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public String getImgurl() {
	return imgurl;
}
public void setImgurl(String imgurl) {
	this.imgurl = imgurl;
}
public Activity getActivity() {
	return activity;
}
public void setActivity(Activity activity) {
	this.activity = activity;
}

}
