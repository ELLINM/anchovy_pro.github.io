//index2

package Example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertMember")
public class index2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id=req.getParameter("userId");
		String pw=req.getParameter("userPw");
		String name=req.getParameter("userName");
		String address=req.getParameter("userAd");
		
		req.setAttribute("userId", id);
		req.setAttribute("userPw", pw);
		req.setAttribute("userName", name);
		req.setAttribute("userAd", address);
		
		RequestDispatcher rd=req.getRequestDispatcher("index2.jsp");
		rd.forward(req, resp); 
	}
	
}
