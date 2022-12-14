package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDao;
import model.dto.BoardDto;

/**
 * Servlet implementation class delete
 */
@WebServlet("/board/delete")
public class delete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bno = Integer.parseInt(request.getParameter("bno"));

		BoardDto dto = BoardDao.getInstance().getboard(bno);	// 삭제할 게시물정보 호출
		
		boolean result = BoardDao.getInstance().delete(bno);
		if( result ) {
			File file = new File(request.getSession().getServletContext().getRealPath("/upload/"+dto.getBfile()));
			if( file.exists() ) file.delete(); // 해당 경로에 존재하는 파일을 삭제
			// File 클래스
				// 자바 외부에 존재하는 파일 조작/제어 메소드 제공하는 클래스
				// 객체명.length() : 해당 파일의 바이트 길이
				// 객체명.delete() : 해당 파일의 삭제
				// 객체명.exists() : 해당 파일이 존재하면 true / false
		}
		
		response.getWriter().print(result);
		
	}
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
