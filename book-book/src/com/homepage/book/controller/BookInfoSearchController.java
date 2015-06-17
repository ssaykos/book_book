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
		BookBean[] bean = { new BookBean("사람은 무엇으로 사는가?", "레프 니콜라예비치 톨스토이", "더클래식", "소설/세계소설/러시아", a , "0102030021"),
							new BookBean("사람은 무엇으로 사는가?", "레프 니콜라예비치 톨스토이", "더클래식", "소설/세계소설/러시아", a , "0102030022"),
							new BookBean("부활", "레프 니콜라예비치 톨스토이", "더클래식", "소설/세계소설/러시아", a , "0102030011"),
							new BookBean("등대지기", "조창인", "밝은세상", "소설/테마소설/로맨스소설", a , "0104010022"),
							new BookBean("호질", "박지원", "자필", "소설/고전소설/한국고전", a , "0101010011"),
							new BookBean("양반전", "박지원", "자필", "소설/고전소설/한국고전", a , "0101010021") };
		//더미값
		
		Vector<BookBean> vector = new Vector<BookBean>();
		
		//더미값을 검색하기 위한 컬렉터 선언
		/*  serialNo

		bTitle

		author

		publisher  */
		
		String search1 = request.getParameter("search1");//검색 분류 가져오기
		
		String search2= request.getParameter("search2");//검색 값 가져오기
		
						
		String aa="검색분류"+search1+"로"+search2+" 을 검색한 내용"+"\n no.\t 책 제목 \t\t\t\t\t 저자명 \t\t 출판사 \t\t 식별번호 \n";
		//목록을 뽑아오기위한 스트링값
		for (int i = 0; i < bean.length; i++) {
			vector.add(bean[i]);
		}
		//목록을 검색 조건으로 걸르기전 모든 더미값 벡터에 넣기
		
		switch (search1) {
		//
		
		case "serialNo":
						
			searchSerialNo(request, response, vector, search1, search2, aa);
			break;
			
		case "bTitle":
			
			searchbTitle(request, response, vector, search1, search2, aa);
			break;
			
		case "author":
						
			searchAuthor(request, response, vector, search1, search2, aa);
			
			break;
		case "publisher":
			
			searchPublisher(request, response, a, vector, search1, search2, aa);
			break;

		default:
			break;
		}
		

		
		
		
		
	}


	private void searchPublisher(HttpServletRequest request,
			HttpServletResponse response, Date a, Vector<BookBean> vector,
			String search1, String search2, String aa) throws ServletException,
			IOException {
		
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
		dispatcher.forward(request, response);
	}


	private void searchAuthor(HttpServletRequest request,
			HttpServletResponse response, Vector<BookBean> vector,
			String search1, String search2, String aa) throws ServletException,
			IOException {
		int count=0;
		for (int i = 0; i < vector.size(); i++) {
			if(vector.elementAt(i).getAuthor().equals(search2)){
				aa+=""+(count)+"/"+vector.elementAt(i).getbTitle();
				aa+="/"+vector.elementAt(i).getAuthor();
				aa+="/"+vector.elementAt(i).getPublisher();
				aa+="/"+vector.elementAt(i).getSerialNo();
			}else{
				if(i == vector.size()-1 && aa.equals("검색분류"+search1+"로"+search2+" 을 검색한 내용"+"\n no.\t 책 제목 \t\t\t\t\t 저자명 \t\t 출판사 \t\t 식별번호 \n")){
					aa="검색분류"+search1+"로"+search2+"를 검색한 결과 없습니다.";
				}
			}
		}
		System.out.println(aa);
		request.setAttribute("search", aa);

		RequestDispatcher dispatcher=request.getRequestDispatcher("/views/book/BookInfoSearch.jsp");
		dispatcher.forward(request, response);
	}


	private void searchbTitle(HttpServletRequest request,
			HttpServletResponse response, Vector<BookBean> vector,
			String search1, String search2, String aa) throws ServletException,
			IOException {
		
		int count=0;
		for (int i = 0; i < vector.size(); i++) {
			if(vector.elementAt(i).getbTitle().equals(search2)){
				count++;
			}else{
			
			}		
		}
		String[][] sResult = new String[count][6];
		for (int i = 0; i < vector.size(); i++) {
			if(vector.elementAt(i).getbTitle().equals(search2)){
					sResult[i][0]=""+(i+1);
					sResult[i][1]=vector.elementAt(i).getbTitle();
					sResult[i][2]=vector.elementAt(i).getAuthor();
					sResult[i][3]=vector.elementAt(i).getPublisher();
					sResult[i][4]=vector.elementAt(i).getSerialNo();
					sResult[i][5]="인기도(빌림수) 미구현(이걸로목록정렬)";
				/*aa+="  "+(count)+"/   "+vector.elementAt(i).getbTitle();
				aa+="/  "+vector.elementAt(i).getAuthor();
				aa+="/  "+vector.elementAt(i).getPublisher();
				aa+="/  "+vector.elementAt(i).getSerialNo();
				aa+="\n";*/
			}else{
			if(i == vector.size()-1 && aa.equals("검색분류"+search1+"로"+search2+" 을 검색한 내용"+"\n no.\t 책 제목 \t\t\t\t\t 저자명 \t\t 출판사 \t\t 식별번호 \n")){
				aa="검색분류"+search1+"로"+search2+"를 검색한 결과 없습니다.";
				request.setAttribute("search", aa);
				}
			}		
		}
		
		System.out.println(aa);
		request.setAttribute("search", sResult);

		RequestDispatcher dispatcher=request.getRequestDispatcher("/views/book/BookInfoSearch.jsp");
		dispatcher.forward(request, response);
	}


	private void searchSerialNo(HttpServletRequest request,
			HttpServletResponse response, Vector<BookBean> vector,
			String search1, String search2, String aa) throws ServletException,
			IOException {
		int count=0;
		for (int i = 0; i < vector.size(); i++) {
			if(vector.elementAt(i).getSerialNo().equals(search2)){
				aa+="  "+(count)+"/   "+vector.elementAt(i).getbTitle();
				aa+="/  "+vector.elementAt(i).getAuthor();
				aa+="/  "+vector.elementAt(i).getPublisher();
				aa+="/  "+vector.elementAt(i).getSerialNo();
				/*a+=""+(i+1)+"\t"+map.get("식별번호");*/
				aa+="\n";
			}else{
				if(i == vector.size()-1 && aa.equals("검색분류"+search1+"로"+search2+" 을 검색한 내용"+"\n no.\t 책 제목 \t\t\t\t\t 저자명 \t\t 출판사 \t\t 식별번호 \n")){
					aa="검색분류"+search1+"로"+search2+"를 검색한 결과 없습니다.";
				}
			}
		}
		System.out.println(aa);
		request.setAttribute("search", aa);

		RequestDispatcher dispatcher=request.getRequestDispatcher("/views/book/BookInfoSearch.jsp");
		dispatcher.forward(request, response);
	}


}
