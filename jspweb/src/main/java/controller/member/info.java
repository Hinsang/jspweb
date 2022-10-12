package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.dao.MemberDao;
import model.dto.MemberDto;

/**
 * Servlet implementation class info
 */
@WebServlet("/member/info")
public class info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청
		String mid = (String)request.getSession().getAttribute("mid");
		// DB
		MemberDto dto = MemberDao.getInstance().getinfo(mid);
		
		// *** JS는 DTO 사용X
			// 1. JS가 이해할 수 있는 형식으로 변경 [ JSON 형식 ]
			// 2. DTO -> JSON 형식 [ JAVA 제공X -> 외부라이브러리 사용 ]
			// 3.
		JSONObject object = new JSONObject();
			object.put("mno", dto.getMno());
			object.put("mid", dto.getMid());
			object.put("mname", dto.getMname());
			object.put("mphone", dto.getMphone());
			object.put("memail", dto.getMemail());
			object.put("maddress", dto.getMaddress());
			object.put("mdate", dto.getMdate());
			object.put("mpoint", dto.getMpoint());
		
		// 응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(object);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
