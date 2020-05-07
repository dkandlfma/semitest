package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class InsertMemberServlet
 */
@WebServlet("/insert.me")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 한글이 있을 경우 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		// 2. 전송 값을 꺼내서(request주머니 안에 있는 값들을 name값으로 뽑아내기)
		//	   변수에 저장 및 객체에 저장
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		String[] irr = request.getParameterValues("interest");
		
		String interest = "";
		if(irr != null) {
			for(int i = 0 ; i < irr.length ; i++) {
				if(i !=irr.length - 1) {
					interest += irr[i] + ",";
				} else {
					interest += irr[i];
				}
			}
		}
		
		Member member = new Member(userId, userPwd, userName, phone, email, address, interest);
		int result = new MemberService().insertMember(member);
		
		String page = "";
		if(result>0) {
//			System.out.println("회원가입 성공!");
			
			page = "views/common/successPage.jsp";
			request.setAttribute("msg", "회원가입성공!!");
		}else {
//			System.out.println("회원가입 실패");
			
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "회원가입실패!!");
		}
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
