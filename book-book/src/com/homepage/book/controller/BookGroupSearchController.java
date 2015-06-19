package com.homepage.book.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homepage.book.bean.BookBean;



/**
 * Servlet implementation class BookGroupSearchController
 */
@WebServlet("/book/BookGroupSearch.soso")
public class BookGroupSearchController extends HttpServlet {
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
		String bGroup=request.getParameter("1차분류")+"/"+request.getParameter("2차분류")+"/"+request.getParameter("3차분류");
		String aa="";
		System.out.println("검색을 위한 값 -> "+bGroup);
		int count=0;
		for (int i = 0; i < vector.size(); i++) {
			if(vector.elementAt(i).getbGroup().equals(bGroup)){
				count++;
			}
		}
		String[][] sResult;
		if(count==0){
			aa=""+bGroup+"의 책분류로 검색한 결과가 없습니다.";
			request.setAttribute("search", aa);
		}else{
			sResult = new String[count+1][6];
			sResult[0][0]="no.";
			sResult[0][1]="책 제목";
			sResult[0][2]="책 지은이";
			sResult[0][3]="출판사";
			sResult[0][4]="책식별번호(이거 없애고 하나로 합쳐야 할듯.)";
			sResult[0][5]="인기도(빌림수) 미구현(이걸로목록정렬)";
			int countlist=0;
			for (int i = 0; i < vector.size(); i++) {
				for (int j = 1; j < sResult.length; j++) {
					if(vector.elementAt(i).getbGroup().equals(bGroup)){
						countlist++;
						sResult[countlist][0]=""+countlist;
						sResult[countlist][1]=vector.elementAt(i).getbTitle();
						sResult[countlist][2]=vector.elementAt(i).getAuthor();
						sResult[countlist][3]=vector.elementAt(i).getPublisher();
						sResult[countlist][4]=vector.elementAt(i).getSerialNo();
						sResult[countlist][5]="인기도(빌림수) 미구현(이걸로목록정렬)";
						break;
						
					}
				}
			}
			request.setAttribute("search", sResult);
		}
		request.setAttribute("count", ""+count);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/book/BookGroupSearch.jsp");
		dispatcher.forward(request, response);
	}

}
