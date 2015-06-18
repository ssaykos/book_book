package com.homepage.book.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homepage.book.bean.BookBean;



/**
 * Servlet implementation class BookInfoSearch
 */
@WebServlet("/book/bookInfoSearch.soso")
public class BookInfoSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("일단 들어옴");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Date a = new Date();//더미값에 들어갈 출판일 날짜
		BookBean[] bean = { new BookBean("사람은무엇으로사는가?", "레브니콜라예비치톨스토이", "더클래식", "소설/세계소설/러시아", a , "0102040021",10),
							new BookBean("사람은무엇으로사는가?", "레브니콜라예비치톨스토이", "더클래식", "소설/세계소설/러시아", a , "0102040022",8),
							new BookBean("부활", "레프니콜라예비치톨스토이", "더클래식", "소설/세계소설/러시아", a , "0102030011",10),
							new BookBean("등대지기", "조창인", "밝은세상", "소설/테마소설/로맨스소설", a , "0104010022",100),
							new BookBean("호질", "박지원", "자필", "소설/고전소설/한국고전", a , "0101010011",111),
							new BookBean("양반전", "박지원", "자필", "소설/고전소설/한국고전", a , "0101010021",99) };
		//더미값
		
		Vector<BookBean> vector = new Vector<BookBean>();
		//더미값을 검색하기 위한 벡터 선언
		for (int i = 0; i < bean.length; i++) {
			vector.add(bean[i]);
		}
		//목록을 검색 조건으로 걸르기전 모든 더미값 벡터에 넣기
		String search1 = request.getParameter("search1");//검색 분류 가져오기	
		System.out.println("검색분류 -> "+search1);
		switch (search1) {
		//
		
		case "serialNo":
						
			searchSerialNo(request, response, vector, search1);
			break;
			
		case "bTitle":
			
			searchbTitle(request, response, vector, search1);
			break;
			
		case "author":
						
			searchAuthor(request, response, vector, search1);
			
			break;
		case "publisher":
			
			searchPublisher(request, response, a, vector, search1);
			break;

		default:
			break;
		}
		
	}

	private void searchPublisher(HttpServletRequest request,
			HttpServletResponse response, Date a, Vector<BookBean> vector,
			String search1) throws ServletException,
			IOException {
		String search2= request.getParameter("search2");//검색 값 가져오기
		System.out.println("검색값 -> "+search2);
		String aa="";
		
		int count=0;
		for (int i = 0; i < vector.size(); i++) {
			for (int j = 0; j < vector.elementAt(i).getPublisher().length()-search2.length(); j++) {
				if(vector.elementAt(i).getPublisher().substring(j, (j+search2.length())).equals(search2)){
					count++;
					break;
				}
			}
		}
		String[][] sResult;
		if(count==0){
			aa="검색분류"+search1+"로"+search2+"를 검색한 결과 없습니다.";
			request.setAttribute("search", aa);
		}else{
			sResult = new String[count+1][6];
			sResult[0][0]="no.";
			sResult[0][1]="책 제목";
			sResult[0][2]="책 지은이";
			sResult[0][3]="출판사";
			sResult[0][4]="책식별번호(이거 없애고 하나로 합쳐야 할듯.)";
			sResult[0][5]="인기도(빌림수) 미구현(이걸로목록정렬)";
			for (int i = 1; i < sResult.length; i++) {
				for (int j = 0; j < vector.elementAt(i-1).getPublisher().length()-search2.length(); j++) {
					if(vector.elementAt(i-1).getPublisher().substring(j, (j+search2.length())).equals(search2)){
						sResult[i][0]=""+i;
						sResult[i][1]=vector.elementAt(i-1).getbTitle();
						sResult[i][2]=vector.elementAt(i-1).getAuthor();
						sResult[i][3]=vector.elementAt(i-1).getPublisher();
						sResult[i][4]=vector.elementAt(i-1).getSerialNo();
						sResult[i][5]="인기도(빌림수) 미구현(이걸로목록정렬)";
						break;
					}
				}
			}
			for (int i = 0; i < sResult.length; i++) {
				for (int j = 0; j < sResult[i].length; j++) {
					System.out.println(sResult[i][j]);
				}
			}
			request.setAttribute("search", sResult);
		}
		request.setAttribute("count", ""+count);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/views/book/BookInfoSearchForm.jsp");
		dispatcher.forward(request, response);
		/*String search2= request.getParameter("search2");//검색 값 가져오기
		
		String aa="검색분류"+search1+"로"+search2+" 을 검색한 내용"+"\n no.\t 책 제목 \t\t\t\t\t 저자명 \t\t 출판사 \t\t 식별번호 \n";
		
		for (int i = 0; i < vector.size(); i++) {
			if(vector.elementAt(i).getPublisher().equals(search2)){
				aa+="  "+(i+1)+"/   "+vector.elementAt(i).getbTitle();
				aa+="/  "+vector.elementAt(i).getAuthor();
				aa+="/  "+vector.elementAt(i).getPublisher();
				aa+="/  "+vector.elementAt(i).getSerialNo();
				aa+="\n";
			}else{
				if(i ==vector.size()-1 && a.equals("검색분류"+search1+"로"+search2+" 을 검색한 내용"+"\n no.\t 책 제목 \t\t\t\t\t 저자명 \t\t 출판사 \t\t 식별번호 \n")){
					aa="검색분류"+search1+"로"+search2+"를 검색한 결과 없습니다.";
				}
			}
		}
		System.out.println(aa);
		request.setAttribute("search", aa);

		RequestDispatcher dispatcher=request.getRequestDispatcher("/views/book/BookInfoSearch.jsp");
		dispatcher.forward(request, response);*/
	}


	private void searchAuthor(HttpServletRequest request,
			HttpServletResponse response, Vector<BookBean> vector,
			String search1) throws ServletException,
			IOException {
		
		String search2= request.getParameter("search2");//검색 값 가져오기
		System.out.println("검색값 -> "+search2);
		String aa="";
		
		int count=0;
		for (int i = 0; i < vector.size(); i++) {
			for (int j = 0; j < vector.elementAt(i).getAuthor().length()-search2.length(); j++) {
				if(vector.elementAt(i).getAuthor().substring(j, (j+search2.length())).equals(search2)){
					count++;
					break;
				}
			}
		}
		String[][] sResult;
		if(count==0){
			aa="검색분류"+search1+"로"+search2+"를 검색한 결과 없습니다.";
			request.setAttribute("search", aa);
		}else{
			sResult = new String[count+1][6];
			sResult[0][0]="no.";
			sResult[0][1]="책 제목";
			sResult[0][2]="책 지은이";
			sResult[0][3]="출판사";
			sResult[0][4]="책식별번호(이거 없애고 하나로 합쳐야 할듯.)";
			sResult[0][5]="인기도(빌림수) 미구현(이걸로목록정렬)";
			for (int i = 1; i < sResult.length; i++) {
				for (int j = 0; j < vector.elementAt(i-1).getAuthor().length()-search2.length(); j++) {
					if(vector.elementAt(i-1).getAuthor().substring(j, (j+search2.length())).equals(search2)){
						sResult[i][0]=""+i;
						sResult[i][1]=vector.elementAt(i-1).getbTitle();
						sResult[i][2]=vector.elementAt(i-1).getAuthor();
						sResult[i][3]=vector.elementAt(i-1).getPublisher();
						sResult[i][4]=vector.elementAt(i-1).getSerialNo();
						sResult[i][5]="인기도(빌림수) 미구현(이걸로목록정렬)";
						break;
					}
				}
			}
			for (int i = 0; i < sResult.length; i++) {
				for (int j = 0; j < sResult[i].length; j++) {
					System.out.println(sResult[i][j]);
				}
			}
			request.setAttribute("search", sResult);
		}
		request.setAttribute("count", ""+count);		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/views/book/BookInfoSearchForm.jsp");
		dispatcher.forward(request, response);
		
	}


	private void searchbTitle(HttpServletRequest request,
			HttpServletResponse response, Vector<BookBean> vector,
			String search1) throws ServletException,
			IOException {
		
		String search2= request.getParameter("search2");//검색 값 가져오기
		System.out.println("검색값 -> "+search2);
		String aa="";
		
		int count=0;
		for (int i = 0; i < vector.size(); i++) {
			for (int j = 0; j < vector.elementAt(i).getbTitle().length()-search2.length(); j++) {
				if(vector.elementAt(i).getbTitle().substring(j, (j+search2.length())).equals(search2)){
					count++;
					break;
				}
			}
		}
		String[][] sResult;
		if(count==0){
			aa="검색분류"+search1+"로"+search2+"를 검색한 결과 없습니다.";
			request.setAttribute("search", aa);
		}else{
			sResult = new String[count+1][6];
			sResult[0][0]="no.";
			sResult[0][1]="책 제목";
			sResult[0][2]="책 지은이";
			sResult[0][3]="출판사";
			sResult[0][4]="책식별번호(이거 없애고 하나로 합쳐야 할듯.)";
			sResult[0][5]="인기도(빌림수) 미구현(이걸로목록정렬)";
			for (int i = 1; i < sResult.length; i++) {
				for (int j = 0; j < vector.elementAt(i-1).getbTitle().length()-search2.length(); j++) {
					if(vector.elementAt(i-1).getbTitle().substring(j, (j+search2.length())).equals(search2)){
						sResult[i][0]=""+i;
						sResult[i][1]=vector.elementAt(i-1).getbTitle();
						sResult[i][2]=vector.elementAt(i-1).getAuthor();
						sResult[i][3]=vector.elementAt(i-1).getPublisher();
						sResult[i][4]=vector.elementAt(i-1).getSerialNo();
						sResult[i][5]="인기도(빌림수) 미구현(이걸로목록정렬)";
						break;
					}
				}
			}
			for (int i = 0; i < sResult.length; i++) {
				for (int j = 0; j < sResult[i].length; j++) {
					System.out.println(sResult[i][j]);
				}
			}
			request.setAttribute("search", sResult);
		}
		request.setAttribute("count", ""+count);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/views/book/BookInfoSearchForm.jsp");
		dispatcher.forward(request, response);
	}


	private void searchSerialNo(HttpServletRequest request,
			HttpServletResponse response, Vector<BookBean> vector,
			String search1) throws ServletException,
			IOException {
		
		String search2= request.getParameter("search2");//검색 값 가져오기
		System.out.println("검색값 -> "+search2);
		String aa="";
		
		int count=0;
		for (int i = 0; i < vector.size(); i++) {
			for (int j = 0; j < vector.elementAt(i).getSerialNo().length()-search2.length(); j++) {
				if(vector.elementAt(i).getSerialNo().substring(j, (j+search2.length())).equals(search2)){
					count++;
					break;
				}
			}
		}
		String[][] sResult;
		if(count==0){
			aa="검색분류"+search1+"로"+search2+"를 검색한 결과 없습니다.";
			request.setAttribute("search", aa);
		}else{
			sResult = new String[count+1][6];
			sResult[0][0]="no.";
			sResult[0][1]="책 제목";
			sResult[0][2]="책 지은이";
			sResult[0][3]="출판사";
			sResult[0][4]="책식별번호(이거 없애고 하나로 합쳐야 할듯.)";
			sResult[0][5]="인기도(빌림수) 미구현(이걸로목록정렬)";
			for (int i = 1; i < sResult.length; i++) {
				for (int j = 0; j < vector.elementAt(i-1).getSerialNo().length()-search2.length(); j++) {
					if(vector.elementAt(i-1).getSerialNo().substring(j, (j+search2.length())).equals(search2)){
						sResult[i][0]=""+i;
						sResult[i][1]=vector.elementAt(i-1).getbTitle();
						sResult[i][2]=vector.elementAt(i-1).getAuthor();
						sResult[i][3]=vector.elementAt(i-1).getPublisher();
						sResult[i][4]=vector.elementAt(i-1).getSerialNo();
						sResult[i][5]="인기도(빌림수) 미구현(이걸로목록정렬)";
						break;
					}
				}
			}
			for (int i = 0; i < sResult.length; i++) {
				for (int j = 0; j < sResult[i].length; j++) {
					System.out.println(sResult[i][j]);
				}
			}
			request.setAttribute("search", sResult);
		}
		request.setAttribute("count", ""+count);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/views/book/BookInfoSearchForm.jsp");
		dispatcher.forward(request, response);
	}


}
