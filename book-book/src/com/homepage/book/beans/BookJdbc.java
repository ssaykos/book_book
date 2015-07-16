package com.homepage.book.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import oracle.jdbc.OracleDriver;

/*
 * @author 김진선(ssaykos@naver.com);
 * @date 2015-07-01;
 * @story 책리스트 디비에서 받아오는 파트...?;
 */

public class BookJdbc {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null, rs1 = null ;
		//String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String url = "jdbc:oracle:thin:@192.168.56.1:1521:orcl";
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
			rs = stmt.executeQuery("select * from book");

			while (rs.next()) {
				String bookTitle = "", author = "", imgAddr = "", pressDay = "", entrada = "", bookSerialNo = "", publisher = "", bookGroupCode = "", kdcCode = "";
				bookTitle = rs.getString("BOOK_TITLE");
				author = rs.getString("AUTHOR");
				imgAddr = rs.getString("IMG_ADDR");
				pressDay = rs.getString("PRESS_DAY");
				entrada = rs.getString("ENTRADA");
				bookSerialNo = rs.getString("BOOK_SERIAL_NO");
				publisher = rs.getString("PUBLISHER");
				bookGroupCode = rs.getString("BOOK_GROUP_CODE");
				kdcCode = rs.getString("KDC_CODE");

				System.out.print(bookTitle + "\t");
				System.out.print(author + "\t");
				System.out.print(imgAddr + "\t");
				System.out.print(pressDay + "\t");
				System.out.print(entrada + "\t");
				System.out.print(bookSerialNo + "\t");
				System.out.print(publisher + "\t");
				System.out.print(bookGroupCode + "\t");
				System.out.print(kdcCode + "\t");
				System.out.println();
			}
			System.out.println("book테이블 더미값 모두 출력 완료");
			// book_group과 kdc 테이블
			rs1= stmt.executeQuery("select B.BOOK_GROUP_CODE, B.BOOK_GROUP_VALUE, K.KDC_CODE, K.KDC_VALUE"
					+" from  BOOK_GROUP b join KDC k"
					+" on B.BOOK_GROUP_CODE is not null"
					+" and B.BOOK_GROUP_VALUE is not null"
					+" or K.KDC_CODE is not null"
					+" and K.KDC_VALUE is not null");
			int count=0;
			while (rs1.next()) {
				String bookGroupCode = "", bookGroupValue = "",kdcCode = "", kdcValue = "";
				bookGroupCode = rs1.getString("BOOK_GROUP_CODE");
				bookGroupValue = rs1.getString("BOOK_GROUP_VALUE");
				kdcCode = rs1.getString("KDC_CODE");
				kdcValue = rs1.getString("KDC_VALUE");
				System.out.print(bookGroupCode + "\t");
				System.out.print(bookGroupValue + "\t");
				System.out.print(kdcCode+ "\t");
				System.out.print(kdcValue+ "\t");
				System.out.println();
				System.out.println(++count+"book_group+KDC 테이블 더미값 출력 완료.. 근데.. 조인을 뭔가 잘못한듯하다..=_=;; 10+7은 70 이랭 크크크크크...-_-;; 이건 기태에게 문의를..");
			}
			/*rs1 = stmt.executeQuery("select * from book_group");
			while (rs1.next()) {
				String bookGroupCode = "", bookGroupValue = "";
				bookGroupCode = rs1.getString("BOOK_GROUP_CODE");
				bookGroupValue = rs1.getString("BOOK_GROUP_VALUE");
				System.out.print(bookGroupCode + "\t");
				System.out.print(bookGroupValue + "\t");
				System.out.println();
			}
			System.out.println("book_group테이블 더미값 모두 출력 완료");
			
			rs1 = stmt.executeQuery("select * from KDC");
			while (rs1.next()) {
				String kdcCode = "", kdcValue = "";
				kdcCode = rs1.getString("KDC_CODE");
				kdcValue = rs1.getString("KDC_VALUE");
				System.out.print(kdcCode + "\t");
				System.out.print(kdcValue + "\t");
				System.out.println();
			}
			System.out.println("KDC테이블 더미값 모두 출력 완료");*/
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
