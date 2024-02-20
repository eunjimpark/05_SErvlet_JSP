package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet; //Tomcat이 제공하는 클래스
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExampleServlet1 extends HttpServlet {

	
	//GET방식 요청(method="get"인 form태그 제출) 처리하는 메서드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*매개변수 req, resp
		 * HttpSErvletREquest
		 * -클라이언트 요청 시 자동 생성되는 객체
		 * -요청시 전달된 데이터,
		 * 요청한 클라이언트 정보,
		 * 요청을 유연하게 처리하기 위한 객체 등을 제공
		 *
		 **/
		
		String inputName=req.getParameter("inputName");
		String inputAge =req.getParameter("inputAge");
		
		
		
		System.out.println("[서버]/ex1 요청을 받음");
		
		System.out.println("전달 받은 inputName :"+inputName);
		System.out.println("전달 받은 inputAge :" +inputAge);
		
		//-----------------------------------------------------------------
		
		/*응답 처리*/
		//1)응답하는 문서의 형식과 문자 인코딩 지정
		resp.setContentType("text/html; charset=utf-8");
		
		//2)출력용 스트림얻어오기
		PrintWriter out = resp.getWriter();
		
		//3)스트림을 이용해서 HTML코드 출력하기
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		
		sb.append("<head>");
		sb.append("<title> /ex1응답 페이지 </title>");		
		sb.append("</head>");
		
		sb.append("<body>");
		sb.append(String.format("<h1>%s님의 나이는 %s입니다</h1>",inputName, inputAge));
		sb.append("</body>");
		
		sb.append("</html>");
		
		//sb에 누적된 html코드를 스트링을 이용해서 출력
		out.print(sb.toString());
		
		
		
		
	}

}
