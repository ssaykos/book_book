package com.homepage.book.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import oracle.jdbc.OracleDriver;

public class BookJdbcRevised {
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		//String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "book";//나 혼자 다른가?
		String pass = "book";//나 혼자 다른가?

		OracleDriver od = new OracleDriver();
		Properties info = new Properties();

		info.put("user", user);
		info.put("password", pass);

		try {
			conn = od.connect(url, info);
			stmt = conn.createStatement();
			//북테이블 
			rs = stmt.executeQuery("select "
										+ "book.book_title, book.author, book.img_addr, book.press_day, book.entrada, book.book_serial_no, book.publisher, grp.book_group_code, grp.book_group_value, kdc.kdc_code, kdc.kdc_value "
									+ "from "	
										+ "book "
										+ "join book_group grp on book.book_group_code = grp.book_group_code "
										+ "join kdc on book.kdc_code = kdc.kdc_code");

			
			System.out.println("책 제목\t저자\t\t겉표지 이미지주소\t\t\t\t\t\t\t프레스데이(?)\t\t엔트라다(?)\t\t\t일련번호\t출판사\t\t분류코드\t분류\t\t\t\t\tKDC코드\tKDC");
			while (rs.next()) {
				String bookTitle = "", author = "", imgAddr = "", pressDay = "", entrada = "", bookSerialNo = "", publisher = "", bookGroupValue = "",bookGroupCode = "", kdcValue = "",kdcCode = "";
				// 수정됨 - 변수이름 : bookGroupCode -> bookGroupValue, kdcCode -> kdcValue
				
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

				System.out.print(bookTitle + "\t\t");
				System.out.print(author + "\t\t");
				System.out.print(imgAddr + "\t");
				System.out.print(pressDay + "\t");
				System.out.print(entrada + "\t");
				System.out.print(bookSerialNo + "\t");
				System.out.print(publisher + "\t");
				System.out.print(bookGroupCode+"\t");
				System.out.print(bookGroupValue + "\t");
				System.out.print(kdcCode + "\t");
				System.out.print(kdcValue + "\t");
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	

}
