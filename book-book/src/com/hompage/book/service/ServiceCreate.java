package com.hompage.book.service;

public interface ServiceCreate {
	public void bookAdditionFull();//정식 등록
	public void bookAdditionSmall();//약식등록인데 파라미터 값들 별로 만들어야 한다.
	public String bookSerialNumberGenerator(String bookCategory);// 책 식별넘버 생성기
	public String FirstSerialNumberGenerator(String bookCategory);// 책 식별넘버 생성을 위한 첫분류 즉 대분류로 십억자리와 억자리수를 결정하는 메서드
	public String SecondSerialNumberGenerator(String bookCategory);//책 식별넘버 생성을 위한 두번째 분류 즉 중분류로  천만자리과 백만자리수를 결정하는 메서드
	public String ThirdSerialNumberGenerator(String bookCategory);//책 식별넘버 생성을 위한 세번째 분류 즉 소분류로 십만자리와 만자리수를 결정하는 메서드
	public String FourthSerialNumberGenerator(String bookCategory);//같은 분류의 책 안에 몇권의 책이 있나 세본후 +1해서 천자리와 백자리 십자리 수를 결정하는 메서드
	public String FifthSerialNumberGenerator(String bookTitle,String bookWriter);//같은 분류의 책 안에 같은 이름 같은 저자의 책이 몇권있나 세본후 마지막 일의 자리수를 결정하는 메서드
}
