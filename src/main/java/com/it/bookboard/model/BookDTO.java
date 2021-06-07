package com.it.bookboard.model;

import java.sql.Timestamp;

public class BookDTO {
	private int no;
	private String title;
	private int price;
	private String publisher;
	private Timestamp joindate;
	private int groupNo;
	private int step;
	private int sortNo;
	private String delFlag;
	
	//24시간 이내의 글인지 체크
	private int newImgTerm;
	
	public int getNewImgTerm() {
		return newImgTerm;
	}

	public void setNewImgTerm(int newImgTerm) {
		this.newImgTerm = newImgTerm;
	}

	

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Timestamp getJoindate() {
		return joindate;
	}

	public void setJoindate(Timestamp joindate) {
		this.joindate = joindate;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getSortNo() {
		return sortNo;
	}

	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	public String toString() {
		return "BookDTO [no=" + no + ", title=" + title + ", price=" + price + ", publisher=" + publisher
				+ ", joindate=" + joindate + ", groupNo=" + groupNo + ", step=" + step + ", sortNo=" + sortNo
				+ ", delFlag=" + delFlag + "]";
	}


}
