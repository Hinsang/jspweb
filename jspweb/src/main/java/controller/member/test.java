package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dao.TestDao;

/**
 * Servlet implementation class test
 */
@WebServlet("/member/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String mid = request.getParameter("mid");
		String memail = request.getParameter("memail");
		
		boolean result = TestDao.getInstance().findpassword(mid, memail);
		String randstr = "";
		
		if(result) {
			Random random = new Random();
			for(int i = 0 ; i<15 ; i++) {
				randstr += (char)(random.nextInt(26) + 97);
			}
			TestDao.getInstance().passwordchange(mid, randstr);
		} else {
			
		}
		
		response.getWriter().print(randstr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
