package com.homepage.book.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homepage.book.impl.ServiceCreateImpl;
import com.hompage.book.service.ServiceCreate;



/**
 * Servlet implementation class BookInfoAddController
 */
@WebServlet("/lib/BookInfoAdd.lib")
public class BookInfoAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//		Enumeration<String> params = request.getParameterNames();
//		
//		while(params.hasMoreElements()){
//			String paramName = params.nextElement();
//			System.out.println("param : " + paramName + ", value : " + request.getParameter(paramName));
//		}
		Date date=new Date();
		SimpleDateFormat Sdate = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시mm분ss초");
		
		String bTitle=request.getParameter("책제목");
		String author=request.getParameter("저자명");
		String publisher=request.getParameter("출판사");
		String pressDate=request.getParameter("출판일");
		String bGroup=request.getParameter("1차분류")+"/"+request.getParameter("2차분류")+"/"+request.getParameter("3차분류");
		
		ServiceCreate sc = new ServiceCreateImpl();
		String serialNo=sc.bookSerialNumberGenerator(bGroup);
		
		request.setAttribute("일련번호", ""+serialNo+"(참고 - 셋과 맵을 이용해서 자료 수에 따른 나머지 4자리의 숫자표기는 아직 미완성..)");
		
		request.setAttribute("책제목", ""+bTitle);
		request.setAttribute("저자명", ""+author);
		request.setAttribute("출판사", ""+publisher);
		request.setAttribute("출판일", ""+pressDate);
		request.setAttribute("책분류", ""+bGroup);
		request.setAttribute("입고일", ""+Sdate.format(date));
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/book/BookInfoAdd.jsp");
		dispatcher.forward(request, response);
	}



}
