package com.homepage.book.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.homepage.book.beans.BookBean;
import com.homepage.book.impl.ServiceCreateImpl;

import oracle.jdbc.OracleDriver;
import com.homepage.util.DBmanager;

/*
 * 2015-07-13
 * 김진선
 * 북 dbc를 대신할 DAO클래스 추가
 */
public class BookDAO {
	public final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public final String DB_USERNAME = "book";
	public final String DB_PASSWORD = "book";
	
	//[패턴] <- 샘께서 설명 하시지 않으셧던 부분..
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	 // 현재는 작동하지 않지만 위 DBmanager 를 걷어내는 순간
    // 작동함. 미리 설정함.
	public Connection getConnection() throws Exception {
        Connection conn = null;
        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
        conn = ds.getConnection();
        return conn;
    }

		// 현재 이 DAO클래스가 여러개 생성되는 것을 방지 하기 위한
		//싱글톤 패턴
		private static BookDAO dao = new BookDAO();

		private BookDAO() {
			conn = DBmanager.getConnection();
		}

		public static BookDAO getInstance() {
			return dao;
		}
		
		//책 빌린 횟수를 조인 하기 위한 메서드 서비스와 임플로 가야 하지만..
		//따로 
		public String rCntJoin(String bookSerialNo) {
			
			//이 아래부터 트라이 파이널까지는 그냥 조인을 위한 문법이다.. 
			//알아서 익히든 설명하든..ㅠ_ㅠ;
			
			
			//[패턴]
//			OracleDriver od = new OracleDriver();
//			Properties info = new Properties();
			
			//[패턴]
//			info.put("user", DB_USERNAME);
//			info.put("password", DB_PASSWORD);
			String sql="select count(*) COUNTER from Rent r where R.STATE='3' and R.BOOK_SERIAL_NO='"+bookSerialNo+"'";
			String rentcount="";
			try {
				//[패턴]
				conn = DBmanager.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					rentcount= rs.getString("COUNTER");
					System.out.println(rentcount);
				}
				//[패턴]
			
			} catch(Exception ex) {
				ex.printStackTrace();
			} 
			
			return rentcount;
		}
		public void setBookInfoAddtion(BookBean bean){
			//DateFormat dateFormat = new SimpleDateFormat("yyyy / MM / dd");
			//Date date = new Date();
						
			//[패턴]
			//OracleDriver od = new OracleDriver();
			Properties info = new Properties();
			
			//[패턴]
			info.put("user", DB_USERNAME);
			info.put("password", DB_PASSWORD);
			//ServiceCreateImpl sc = new ServiceCreateImpl();
			String sql="insert into book ( book_title , author , img_addr , press_day , entrada , book_serial_no , publisher , book_group_code , kdc_code ) "
							+"values (? , ? , ? , ?, ?, ? , ? , ? , ? )";
			try {
				pstmt= conn.prepareStatement(sql);
				
				pstmt.setString(1, bean.getbTitle());
				pstmt.setString(2, bean.getAuthor());
				pstmt.setString(3, bean.getbPicture());
				pstmt.setString(4, bean.getPressDate());
				pstmt.setString(5, bean.getEntrada());
				pstmt.setString(6, bean.getSerialNo());
				pstmt.setString(7, bean.getPublisher());
				pstmt.setString(8, bean.getbGroupCode());
				//KDC부분에 대한 기능구현은 아직 프론트단에서 덜 되었기 때문에.. 일단 SKIP입니다..미구현이란 글자가 대신 들어감..
				pstmt.setString(9, "미구현");
				
				//pstmt.executeUpdate();
			}catch(Exception ex){
	            ex.printStackTrace();
	            System.out.println("MemberDAO 에서 에러가 발생 !!");
	        }
					
		}
		//책 분류로 검색을 위한 메서드//(2015/7/16-7시)필드로 빼고 유틸 디비매니저 적용후 알수 없는 런타임에러로..시간상의 이유로 미적용때로 롤빽
		public List<BookBean> getBGSearchList(String bookGroup){
			
			//해당 메소드의 데이터를 담아서 반환시킬 리스트생성
			List<BookBean> list = new ArrayList<BookBean>();
			
			//해당 리스트의 데이터 타입이 DATE인 것의 포멧을 보기 편하게 심플 데이트 포멧으로 양식 변경
			//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			
			//이 아래부터 트라이 파이널까지는 그냥 조인을 위한 문법이다.. 
			//알아서 익히든 설명하든..ㅠ_ㅠ;
			//[패턴] <- 샘께서 설명 하시지 않으셧던 부분..
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			//[패턴]
			OracleDriver od = new OracleDriver();
			Properties info = new Properties();
			
			//[패턴]
			info.put("user", DB_USERNAME);
			info.put("password", DB_PASSWORD);
			ServiceCreateImpl sc = new ServiceCreateImpl();
			String bGroupCode = sc.tobGroupBybGroupCodeFomater(bookGroup);
			
			String sql =  "select B.BOOK_TITLE, B.AUTHOR, B.PRESS_DAY, B.KDC_CODE, B.PUBLISHER, "
					+"B.BOOK_SERIAL_NO, B.IMG_ADDR,B.BOOK_GROUP_CODE, '' \"RENT_COUNT\" "
					+"from book b "
					+"where B.BOOK_GROUP_CODE like '"+bGroupCode+"'";
			
			try {
				//[패턴]
				conn = od.connect(DB_URL, info);
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				int count=0;
				System.out.println("no.\t겉표지 이미지주소\t\t\t\t\t\t\t책 제목\t저자\t\t출판사\t일련번호\t출판일\t\tKDC코드\t인기도");
				while(rs.next()){
					//[패턴]
					String bookTitle = "", author = "", imgAddr = "", pressDay = "", bookSerialNo = "", publisher = "", kdcCode = "", rentcount="";
					bookTitle = rs.getString("BOOK_TITLE");
					author = rs.getString("AUTHOR");
					imgAddr = rs.getString("IMG_ADDR");
					pressDay = rs.getString("PRESS_DAY");
					bookSerialNo = rs.getString("BOOK_SERIAL_NO");
					publisher = rs.getString("PUBLISHER");
					kdcCode = rs.getString("KDC_CODE");
					//rentcount= rs.getString("RENT_COUNT");//여기는 따로 조인해서 값을 가져와야 하기때문에 넣어봐야 의미 없다.
					rentcount= rCntJoin(bookSerialNo);
					
					//데이터 베이스의 모든 데이터를 반환 하기 위해..
					//빈 객체를 만들어 값을 셋팅 후 리스트에 추가하기
					BookBean bean = new BookBean();
					bean.setbTitle(bookTitle);
					bean.setAuthor(author);
					bean.setbPicture(imgAddr);
					//bean.setPressDate(dateFormat.format(dateFormat.parse(pressDay)));
					bean.setPressDate(pressDay);
					bean.setSerialNo(bookSerialNo);
					bean.setPublisher(publisher);
					bean.setbKDCCode(kdcCode);
					bean.setRentCount(Integer.parseInt(rentcount));
					
					list.add(bean);
					//아래는 값이 제대로 넘어오고 있나 확인 하기 위한
					//콘솔창에 찍어보기!
					count++;
					System.out.print(count+"\t");
					System.out.print(imgAddr + "\t");
					System.out.print(bookTitle + "\t\t");
					System.out.print(author + "\t\t");
					System.out.print(publisher + "\t");
					System.out.print(bookSerialNo + "\t");
					System.out.print(pressDay + "\t");
					System.out.print(kdcCode + "\t");
					System.out.print(rentcount+"\t");
					System.out.println();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		
			return list;
		}
		
		//책 이름 검색을 위한 메서드
		public List<BookBean> getBSearchSimpleList(String bTitle){
			
			//해당 메소드의 데이터를 담아서 반환시킬 리스트생성
			List<BookBean> list = new ArrayList<BookBean>();
			
			//해당 리스트의 데이터 타입이 DATE인 것의 포멧을 보기 편하게 심플 데이트 포멧으로 양식 변경
			//DateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");//빈이 데이터 타입에서 스트링 타입으로 변경되었슴..
			
			//이 아래부터 트라이 파이널까지는 그냥 조인을 위한 문법이다.. 
			//알아서 익히든 설명하든..ㅠ_ㅠ;
			
			
			//[패턴]
			OracleDriver od = new OracleDriver();
			Properties info = new Properties();
			
			//[패턴]
			info.put("user", DB_USERNAME);
			info.put("password", DB_PASSWORD);
			
			String sql = "select B.BOOK_TITLE, B.AUTHOR, B.PRESS_DAY, B.KDC_CODE, "
					+"B.BOOK_SERIAL_NO, B.IMG_ADDR, '' \"RENT_COUNT\""
					+"from book b, rent r "
					+"where B.BOOK_TITLE like '%"+bTitle+"%'";// 조인문 완성..
			
			try {
				//[패턴]
				conn = od.connect(DB_URL, info);
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				int count=0;
				System.out.println("no.\t겉표지 이미지주소\t\t\t\t\t\t\t책 제목\t저자\t\t\t출판사\t\t\t일련번호\t\t출판일\t\tKDC코드\t인기도");
				while(rs.next()){
					//[패턴]
					String bookTitle = "", author = "", imgAddr = "", pressDay = "", bookSerialNo = "", publisher = "", kdcCode = "", rentcount="";
					bookTitle = rs.getString("BOOK_TITLE");
					author = rs.getString("AUTHOR");
					imgAddr = rs.getString("IMG_ADDR");
					pressDay = rs.getString("PRESS_DAY");
					bookSerialNo = rs.getString("BOOK_SERIAL_NO");
					publisher = rs.getString("PUBLISHER");
					kdcCode = rs.getString("KDC_CODE");
					//rentcount= rs.getString("RENT_COUNT");//여기는 따로 조인해서 값을 가져와야 하기때문에 넣어봐야 의미 없다.
					rentcount= rCntJoin(bookSerialNo);
					
					//데이터 베이스의 모든 데이터를 반환 하기 위해..
					//빈 객체를 만들어 값을 셋팅 후 리스트에 추가하기
					BookBean bean = new BookBean();
					bean.setbTitle(bookTitle);
					bean.setAuthor(author);
					bean.setbPicture(imgAddr);
					//bean.setPressDate(dateFormat.format(dateFormat.parse(pressDay)));
					bean.setPressDate(pressDay);
					bean.setSerialNo(bookSerialNo);
					bean.setPublisher(publisher);
					bean.setbKDCCode(kdcCode);
					bean.setRentCount(Integer.parseInt(rentcount));
					
					list.add(bean);
					//아래는 값이 제대로 넘어오고 있나 확인 하기 위한
					//콘솔창에 찍어보기!
					count++;
					System.out.print(count+"\t");
					System.out.print(imgAddr + "\t");
					System.out.print(bookTitle + "\t\t");
					System.out.print(author + "\t\t");
					System.out.print(publisher + "\t");
					System.out.print(bookSerialNo + "\t");
					System.out.print(pressDay + "\t");
					System.out.print(kdcCode + "\t");
					System.out.print(rentcount+"\t");
					System.out.println();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			} 
			
			return list;
		}
		
		//일단 기본적으로 모든 더미값을 가져오기 위한 
		//리스트 반환 타입의 메소드 생성
		public List<BookBean> getBookFullList() {
			//해당 리스트의 데이터 타입이 DATE인 것의 포멧을 보기 편하게 심플 데이트 포멧으로 양식 변경
			DateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
			
			//해당 메소드의 데이터를 담아서 반환시킬 리스트생성
			List<BookBean> list = new ArrayList<BookBean>();
			
			//이 아래부터 트라이 파이널까지는 그냥 조인을 위한 문법이다.. 
			//알아서 익히든 설명하든..ㅠ_ㅠ;
			
			
			//[패턴]
			OracleDriver od = new OracleDriver();
			Properties info = new Properties();
			
			//[패턴]
			info.put("user", DB_USERNAME);
			info.put("password", DB_PASSWORD);
			
			//데이터 베이스에서 북 테이블 의 모든 더미값을 받아오는 내용의 
			//쿼리문을 String변수를 생성하여 저장하고..
			String sql = "select "
					+ "book.book_title, book.author, book.img_addr, book.press_day, book.entrada, book.book_serial_no, book.publisher, grp.book_group_code, grp.book_group_value, kdc.kdc_code, kdc.kdc_value '' \"RENT_COUNT\""
				+ "from book "
					+ "join book_group grp on book.book_group_code = grp.book_group_code "
					+ "join kdc on book.kdc_code = kdc.kdc_code";
			try {
				//[패턴]
				conn = od.connect(DB_URL, info);
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				System.out.println("책 제목\t저자\t\t겉표지 이미지주소\t\t\t\t\t\t\t프레스데이(?)\t\t엔트라다(?)\t\t\t일련번호\t출판사\t\t분류코드\t분류\t\t\t\t\tKDC코드\tKDC\t빌린횟수");
				while(rs.next()){
					//[패턴]
					String bookTitle = "", author = "", imgAddr = "", pressDay = "", entrada = "", bookSerialNo = "", publisher = "", bookGroupValue = "",bookGroupCode = "", kdcValue = "",kdcCode = "", rentCount="";
					
					bookTitle = rs.getString("BOOK_TITLE");
					author = rs.getString("AUTHOR");
					imgAddr = rs.getString("IMG_ADDR");
					pressDay = rs.getString("PRESS_DAY");
					entrada = rs.getString("ENTRADA");
					bookSerialNo = rs.getString("BOOK_SERIAL_NO");
					publisher = rs.getString("PUBLISHER");
					bookGroupCode = rs.getString("BOOK_GROUP_CODE");
					bookGroupValue = rs.getString("BOOK_GROUP_VALUE"); // 수정됨 CODE -> VALUE
					kdcCode = rs.getString("KDC_CODE");
					kdcValue = rs.getString("KDC_VALUE"); // 수정됨 CODE -> VALUE
					rentCount=rCntJoin(bookSerialNo);
					
					//데이터 베이스의 모든 데이터를 반환 하기 위해..
					//빈 객체를 만들어 값을 셋팅 후 리스트에 추가하기
					BookBean bean = new BookBean();
					bean.setbTitle(bookTitle);
					bean.setAuthor(author);
					bean.setbPicture(imgAddr);
					bean.setPressDate(dateFormat.format(dateFormat.parse(pressDay)));
					bean.setEntrada(dateFormat.format(dateFormat.parse(entrada)));
					bean.setSerialNo(bookSerialNo);
					bean.setPublisher(publisher);
					bean.setbGroupCode(bookGroupCode);
					bean.setbGroup(bookGroupValue);
					bean.setbKDCCode(kdcCode);
					bean.setbKDC(kdcValue);
					bean.setRentCount(Integer.parseInt(rentCount));
					
					list.add(bean);
					//아래는 값이 제대로 넘어오고 있나 확인 하기 위한
					//콘솔창에 찍어보기!
					System.out.print(bean.getbTitle() + "\t\t");
					System.out.print(bean.getAuthor() + "\t\t");
					System.out.print(bean.getbPicture() + "\t");
					System.out.print(bean.getPressDate() + "\t");
					System.out.print(bean.getEntrada() + "\t");
					System.out.print(bean.getSerialNo() + "\t");
					System.out.print(bean.getPublisher() + "\t");
					System.out.print(bean.getbGroupCode()+"\t");
					System.out.print(bean.getbGroup() + "\t");
					System.out.print(bean.getbKDCCode() + "\t");
					System.out.print(bean.getbKDC() + "\t");
					System.out.println();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			} 
			
			return list;
		}
}
