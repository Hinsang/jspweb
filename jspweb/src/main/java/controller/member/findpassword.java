package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.SetCharacterEncodingFilter;

import model.dao.MemberDao;

/**
 * Servlet implementation class findpassword
 */
@WebServlet("/member/findpassword")
public class findpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findpassword() {
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
		
		boolean result = MemberDao.getInstance().findpassword(mid, memail);
		String randstr = "";	// 2. 랜덤 문자를 저장할 문자열[ 임시 비밀번호 ]
			
		// 난수 발생시키면서 임시비밀번호로 교체
		if(result) {
			Random random = new Random(); // 1. 랜덤객체 선언
			for( int i = 0 ; i<15 ; i++) {
				randstr += (char)(random.nextInt(26) + 97); // 숫자 -> 강제형변환 [ 문자로 변환 ]
									// 영소문자[아스키코드] : 97~122
									// random.nextInt(26);	 : 0 ~ 25
									// random.nextInt(26)+97 : 97 ~ 122 (97부터 26개 이범위는 아스키코드로 소문자)
									// (char)(random.nextInt(26)+97) : a ~ z
									// random.nextInt( 개수 )+시작번호
			}
			// 해당 회원의 비밀번호를 임시 비밀번호로 교체[업데이트]
			MemberDao.getInstance().passwordchange(mid, randstr);
			
		} else {
			
		}
		
		response.getWriter().print(randstr); // ajax에게 임시비밀번호 전송
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
