package com.homepage.book.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import com.homepage.book.bean.BookBean;
import com.hompage.book.service.ServiceCreate;



public class ServiceCreateImpl implements ServiceCreate{
	
	
	
	
	
	Vector<BookBean> vector = new Vector<BookBean>();
	//더미값을 검색하기 위한 벡터 선언
	Set<String> set = new HashSet<String>();
	public void dumyAddition() {
		Date a = new Date();//더미값에 들어갈 출판일 날짜
		BookBean[] bean = { new BookBean("사람은무엇으로사는가?", "레브니콜라예비치톨스토이", "더클래식", "소설/세계소설/러시아", a , "0102040021"),
							new BookBean("사람은무엇으로사는가?", "레브니콜라예비치톨스토이", "더클래식", "소설/세계소설/러시아", a , "0102040022"),
							new BookBean("부활", "레프니콜라예비치톨스토이", "더클래식", "소설/세계소설/러시아", a , "0102040011"),
							new BookBean("등대지기", "조창인", "밝은세상", "소설/테마소설/로맨스소설", a , "0104010022"),
							new BookBean("호질", "박지원", "자필", "소설/고전소설/한국고전", a , "0101010011"),
							new BookBean("양반전", "박지원", "자필", "소설/고전소설/한국고전", a , "0101010021") };//더미값
		for (int i = 0; i < bean.length; i++) {
			vector.add(bean[i]);
		}
	}
	

	@Override
	public String bookSerialNumberGenerator(String bookCategory, String bTitle, String author) {//aa/bb/cc
		// TODO Auto-generated method stub
		dumyAddition();	//목록을 검색 조건으로 걸르기전 모든 더미값 벡터에 넣기
		
		String bookSerialNumber="";
		String firstCategory=bookCategory.substring(0,bookCategory.indexOf("/"));//문자열의 0번째부터 /가 있는 곳의 문자열까지 잘라서 넣는다.//aa
		String tempSecondCategory=bookCategory.substring(bookCategory.indexOf("/")+1);//bb/cc
		String secondCategory="";//값을 넣기 전 초기화
		String thirdCategory="";//값을 넣기 전 초기화
		secondCategory=tempSecondCategory.contains("/") ? tempSecondCategory.substring(0,tempSecondCategory.indexOf("/")) : tempSecondCategory;
		//첫번째 분류 즉 대분류와 "/"표시를 삭제한 값을두번째 tempSecondCategory에  넣은후 tempsecondCategory에  "/" 가 없으면 SecondCategory에 tempSecondCategory를 넣고 "/"가있으면 tempSecondCategory열중 "/" 앞의 문자열을 넣는다.
		thirdCategory=tempSecondCategory.contains("/") ? tempSecondCategory.substring(tempSecondCategory.indexOf("/")+1,tempSecondCategory.length()) : "";
		//첫번째 분류 즉 대분류와 "/"표시를 삭제한 값을두번째 tempSecondCategory에  넣은후 tempSecondCategory에 "/" 가 없으면 ThirdCategory에 널값을 넣고  "/"가있으면 tempSecondCategory열중 "/"+1부터 그 뒤의 문자열을 넣는다.
		
		bookSerialNumber+=FirstSerialNumberGenerator(firstCategory);
		bookSerialNumber+=SecondSerialNumberGenerator(secondCategory);
		bookSerialNumber+=ThirdSerialNumberGenerator(thirdCategory);
		//이 뒤에 모든 데이터들의 넘버를 같은자리에 같은데이터 값을 가진것들을 검색하면서 카운트를 올리고 +1 해서  += 를 시켜준후 동일 책
		bookSerialNumber+=FourthSerialNumberGenerator(bookCategory,bTitle,author);//
		//책분류의 값이 동일한 것들을 쭉 비교하면서 동일한 만큼 카운트를 올리고 +1시킨다음 세자릿수 맞춰서 
		bookSerialNumber+=FifthSerialNumberGenerator(bTitle, author);//맵 해시맵 객체를 생성해서 bookVO를 넣게 되면 파라미터를 한번 더 감싸야 하는 부분?
		
		return bookSerialNumber;
	}

	@Override
	public String FirstSerialNumberGenerator(String bookCategory) {
		// TODO Auto-generated method stub
		String firstSerialNumber="";
		
		switch (bookCategory) {//참고 교보문고의 분류 참고함
		case "소설": 
			firstSerialNumber="01";
			break;
		case "시":
			firstSerialNumber="02";
			break;
		case "수필":
			firstSerialNumber="03";
			break;
		case "경제와경영":
			firstSerialNumber="04";
			break;
		case "자기계발":
			firstSerialNumber="05";
			break;
		case "인문":
			firstSerialNumber="06";
			break;
		case "역사":
			firstSerialNumber="07";
			break;
		case "문화":
			firstSerialNumber="08";
			break;
		case "예술":
			firstSerialNumber="09";
			break;
		case "종교":
			firstSerialNumber="10";
			break;
		case "사회":
			firstSerialNumber="11";
			break;
		case "과학":
			firstSerialNumber="12";
			break;
		case "기술":
			firstSerialNumber="13";
			break;
		case "컴퓨터":
			firstSerialNumber="14";
			break;
		case "참고서":
			firstSerialNumber="15";
			break;
		case "수험서"://외국어탑재
			firstSerialNumber="16";
			break;
		case "가정":
			firstSerialNumber="17";
			break;
		case "건강":
			firstSerialNumber="18";
			break;
		case "취미":
			firstSerialNumber="19";
			break;
//		case "여행":
//			firstSerialNumber="20";
//			break;
//		case "요리":
//			firstSerialNumber="01";
//			break;
		case "잡지"://요리 여행 만화 편입
			firstSerialNumber="20";
			break;
		case "":
			firstSerialNumber="21";
			break;
//		case "만화":
//			firstSerialNumber="01";
//			break;

		default:
			firstSerialNumber="에러..";
			break;
		}
		
		return firstSerialNumber;
	}

	@Override
	public String SecondSerialNumberGenerator(String bookCategory) {
		// TODO Auto-generated method stub
		String secondSerialNumber="";
		
		switch (bookCategory) {
		case "고전소설": case "시조": case "인물수필":
			secondSerialNumber="01";
			break;

		case "세계소설": case "현대시": case "지혜수필":
			secondSerialNumber="02";
			break;

		case "추리소설": case "사랑시": case "테마수필":
			secondSerialNumber="03";
			break;

		case "테마소설": case "한시": case "명언수필":
			secondSerialNumber="04";
			break;

		case "역사소설": case "명시모음": case "상식수필":
			secondSerialNumber="05";
			break;

		case "판타지소설": case "그림시": case "인생수필":
			secondSerialNumber="06";
			break;

		case "무협소설": case "다른나라시": case "명상수필":
			secondSerialNumber="07";
			break;

		case "퓨전소설": case "감성수필":
			secondSerialNumber="08";
			break;

		case "탈무드수필":
			secondSerialNumber="09";
			break;

		case "나라별수필":
			secondSerialNumber="10";
			break;

		case "":
			secondSerialNumber="11";
			break;



		default:
			break;
		}
		
		return secondSerialNumber;
	}

	@Override
	public String ThirdSerialNumberGenerator(String bookCategory) {
		// TODO Auto-generated method stub
		String thirdSerialNumber="";
		
		switch (bookCategory) {
		case "":
			thirdSerialNumber="00";
			break;
		case "한국고전": case "미국": case "한국추리":
			thirdSerialNumber="01";
			break;

		case "일본고전": case "일본": case "일본추리":
			thirdSerialNumber="02";
			break;

		case "중국고전": case "중국": case "중국추리":
			thirdSerialNumber="03";
			break;

		case "러시아고전": case "러시아": case "영미추리":
			thirdSerialNumber="04";
			break;

		case "유럽고전": case "유럽": case "유럽추리":
			thirdSerialNumber="05";
			break;

		case "아시아고전": case "아시아": case "아시아추리":
			thirdSerialNumber="06";
			break;

		case "아프리카고전": case "아프리카": case "기타추리":
			thirdSerialNumber="07";
			break;

		case "기타고전": case "기타나라":
			thirdSerialNumber="08";
			break;

		case "defaut1":
			thirdSerialNumber="09";
			break;

		case "defaut2":
			thirdSerialNumber="10";
			break;

		case "defaut3":
			thirdSerialNumber="11";
			break;
			
		default:
			break;
		}
		
		return thirdSerialNumber;
	}

	@Override
	public String FourthSerialNumberGenerator(String bookCategory, String bookTitle, String bookWriter) {
		// TODO Auto-generated method stub
		String fourthSerialNumber="";
		int count=0;
		String b=bookTitle+bookWriter;//넘어온 책제목과 저자명을 합치고
		for (int i = 0; i < vector.size(); i++) {
			String a=vector.elementAt(i).getbTitle()+vector.elementAt(i).getAuthor();//더미값 마다 책제목과 저자명을 합친후
			if(bookCategory.equals(vector.elementAt(i).getbGroup())&&a.equals(b)){//두가지가 같으면
				return vector.elementAt(i).getSerialNo().substring(vector.elementAt(i).getSerialNo().length()-4, vector.elementAt(i).getSerialNo().length()-1);//벡터에서 더미 값의 시리얼 넘버 중 4번째파트에 해당하는 부위를 잘라 리턴한다. 
			}else{
				count++;//같은것이 없으면 카운트를 올리고
			}
		}
		//중복 되지 않는 크기만큼 카운트를 세고
		count++;//한번 더 추가 해준 후
		fourthSerialNumber=""+count;// 해당 카운트를 스트링으로 바꾸고
		if(fourthSerialNumber.length()==1){//한자릿수라면 00을 더해주고
			fourthSerialNumber="00"+fourthSerialNumber;
		}else if(fourthSerialNumber.length()==2){//두자릿수라면 0을 더해줘서
			fourthSerialNumber="0"+fourthSerialNumber;
		}
		return fourthSerialNumber;//해당 4번째 파트의 시리얼 넘버를 리턴한다.
	}

	@Override
	public String FifthSerialNumberGenerator(String bookTitle,
			String bookWriter) {
		// TODO Auto-generated method stub
		String fifthSerialNumber="";
		int count=0;
		String b=bookTitle+bookWriter;//책제목과 저자명을 합친후
		for (int i = 0; i < vector.size(); i++) {
			String a=vector.elementAt(i).getbTitle()+vector.elementAt(i).getAuthor();//벡터 요소마다의 책제목과 저자명을 합치면서
			if (b.equals(a)) {//같은것이 있으면
				count++;//카운트를 올리고
			}
		}
		count++;//해당책의 카운트룰 추가한후
		fifthSerialNumber=""+count;// 스트링으로 만들어서
				
		return fifthSerialNumber;//넘겨준다.
	}


}
