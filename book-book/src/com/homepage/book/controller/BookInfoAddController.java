package com.homepage.book.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homepage.book.beans.BookBean;
import com.homepage.book.dao.BookDAO;
import com.homepage.book.impl.ServiceCreateImpl;
import com.homepage.book.service.ServiceCreate;

/**
 * Servlet implementation class BookInfoAddController
 */
@WebServlet("/book/BookInfoAdd.soso")
public class BookInfoAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		Date date=new Date();
		SimpleDateFormat Sdate = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시mm분ss초");
		
		String bTitle=request.getParameter("책제목").trim().replaceAll(" ", "");
		String imgAddr=request.getParameter("이미지주소").trim().replaceAll(" ", "");//파일명만 값이 들어와야 한다.
		String author=request.getParameter("저자명").trim().replaceAll(" ", "");
		String publisher=request.getParameter("출판사").trim().replaceAll(" ", "");
		String pressDate=request.getParameter("출판일");
		String bGroup=request.getParameter("1차분류")+"/"+request.getParameter("2차분류")+"/"+request.getParameter("3차분류");
		//KDC부분에 대한 기능구현은 아직 프론트단에서 덜 되었기 때문에.. 일단 SKIP입니다..
		
		
		ServiceCreate sc = new ServiceCreateImpl();
		String serialNo=sc.bookSerialNumberGenerator(bGroup,bTitle,author);
		
		BookBean bb= new BookBean();
		
		bb.setbTitle(bTitle);
		bb.setbPicture(imgAddr);
		bb.setAuthor(author);
		bb.setPublisher(publisher);
		bb.setPressDate(pressDate);
		bb.setEntrada(Sdate.format(date));
		bb.setbGroup(bGroup);
		bb.setbGroupCode(sc.tobGroupBybGroupCodeFomater(bGroup));
		
		BookDAO dao= BookDAO.getInstance();
		
		dao.setBookInfoAddtion(bb);
		//KDC부분에 대한 기능구현은 아직 프론트단에서 덜 되었기 때문에.. 일단 SKIP입니다..
		
		request.setAttribute("일련번호", ""+serialNo);
		
		request.setAttribute("책제목", ""+bTitle);
		request.setAttribute("저자명", ""+author);
		request.setAttribute("출판사", ""+publisher);
		request.setAttribute("출판일", ""+pressDate);
		request.setAttribute("책분류코드", sc.tobGroupBybGroupCodeFomater(bGroup));
		request.setAttribute("책분류", ""+bGroup);
		request.setAttribute("입고일", ""+Sdate.format(date));
		
		System.out.println("일련번호"+serialNo);
		System.out.println("책제목"+bTitle);
		System.out.println("저자명"+author);
		System.out.println("출판사"+publisher);
		System.out.println("출판일"+pressDate);
		System.out.println("책분류"+bGroup);
		System.out.println("입고일"+Sdate.format(date));
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/book/BookInfoAdd.jsp");
		dispatcher.forward(request, response);
	}



}
