package com.homepage.book.beans;

import java.util.Date;

public class BookBean {
	private String bTitle;//책이름
	private String author;//책저자
	private String publisher;//출판사
	private String bGroup;//책분류
	private String bGroupCode;//책분류 코드
	private String bKDCCode;//한국도서분류 코드
	private String bKDC;//한국 도서분류기호
	private String serialNo;//책식별번호
	private String rentID;//해당책을 누군가 빌려갔다면 누가 빌려갔는지 식별하기 위한 id저장 공간
	private String bPicture;//해당 책표지사진
	private boolean exist;//책이 도서실에 있나 없나
	private boolean isRent;//책 빌리기 신청이 들어왓나 안들어왓나
	private boolean isDelay;//책 빌려가고 연장을 햇나 안햇나.
	private int rentCount;//책 빌려간 횟수
	private String pressDate;//책 출판일
	private String rentDate;//책 대여일//대여일들의 누적값에 대한 수정 필요
	private String entrada;//입고일
	//데이터 타입 일자 스트링으로 바꾸면서 뜨는 에러들 변경 시간 부족으로 생성자 주석 처리	
	/*public BookBean() {
		
	}
	
	public BookBean(String bookTitle, String bookWriter) {
		this.bTitle=bookTitle;
		this.author=bookWriter;
	}
	
	public BookBean(String bookTitle, String bookWriter, String bookCompany) {
		this.bTitle=bookTitle;
		this.author=bookWriter;
		this.publisher=bookCompany;
	}
	
	public BookBean(String bookTitle, String bookWriter, String bookCompany, String bookCategory) {
		this.bTitle=bookTitle;
		this.author=bookWriter;
		this.publisher=bookCompany;
		this.bGroup=bookCategory;
	}
	
	public BookBean(String bookTitle, String bookWriter, String bookCompany, String bookCategory, Date bookMakeDate, String serialNumber) {
		this.bTitle=bookTitle; //도서 입고를 위한 생성자.
		this.author=bookWriter;
		this.publisher=bookCompany;
		this.bGroup=bookCategory;
		this.pressDate=bookMakeDate;
		this.serialNo=serialNumber;
		this.entrada=new Date();
		this.exist=true;//입고를 하면서 입고일이 들어왓는데..있나 없나 확인 하는 곳이 비어있으면 웃기다..
	}
	public BookBean(String bookTitle, String bookWriter, String bookCompany, String bookCategory, Date bookMakeDate, String serialNumber, int rentCount) {
		this.bTitle=bookTitle;//도서 통합검색을 위한 더미값을 넣기 위한 생성자
		this.author=bookWriter;
		this.publisher=bookCompany;
		this.bGroup=bookCategory;
		this.pressDate=bookMakeDate;
		this.serialNo=serialNumber;
		this.entrada=new Date();
		this.exist=true;//입고를 하면서 입고일이 들어왓는데..있나 없나 확인 하는 곳이 비어있으면 웃기다..
		this.rentCount=rentCount;
	}*/
	public String getbKDC() {
		return bKDC;
	}

	public void setbKDC(String bKDC) {
		this.bKDC = bKDC;
	}

	public String getbPicture() {
		return bPicture;
	}

	public void setbPicture(String bPicture) {
		this.bPicture = bPicture;
	}
	
	public String getbTitle() {
		return bTitle;
	}

	
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	
	public String getAuthor() {
		return author;
	}

	
	public void setAuthor(String author) {
		this.author = author;
	}

	
	public String getPublisher() {
		return publisher;
	}

	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	
	public String getbGroup() {
		return bGroup;
	}

	
	public void setbGroup(String bGroup) {
		this.bGroup = bGroup;
	}

	
	public String getSerialNo() {
		return serialNo;
	}

	
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	
	public String getRentID() {
		return rentID;
	}

	
	public void setRentID(String rentID) {
		this.rentID = rentID;
	}

	
	public boolean isExist() {
		return exist;
	}

	
	public void setExist(boolean exist) {
		this.exist = exist;
	}

	
	public boolean isRent() {
		return isRent;
	}

	
	public void setRent(boolean isRent) {
		this.isRent = isRent;
	}

	
	public boolean isDelay() {
		return isDelay;
	}

	
	public void setDelay(boolean isDelay) {
		this.isDelay = isDelay;
	}

	
	public int getRentCount() {
		return rentCount;
	}

	
	public void setRentCount(int rentCount) {
		this.rentCount = rentCount;
	}

	
	public String getPressDate() {
		return pressDate;
	}

	
	public void setPressDate(String pressDate) {
		this.pressDate = pressDate;
	}

	
	public String getRentDate() {
		return rentDate;
	}

	
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}

	
	public String getEntrada() {
		return entrada;
	}
	
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getbGroupCode() {
		return bGroupCode;
	}

	public void setbGroupCode(String bGroupCode) {
		this.bGroupCode = bGroupCode;
	}

	public String getbKDCCode() {
		return bKDCCode;
	}

	public void setbKDCCode(String bKDCCode) {
		this.bKDCCode = bKDCCode;
	}



	
}
