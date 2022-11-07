package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.DefaultBoundedRangeModel;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dao.MemberDao;

/**
 * Servlet implementation class write
 */
@WebServlet("/board/write")
public class write extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String mid = (String)request.getSession().getAttribute("mid");
//		int mno = MemberDao.getInstance().getMno(mid);
//		
//		String btitle = request.getParameter("btitle");
//		String bcontent = request.getParameter("bcontent");
//			System.out.println( btitle );
//			System.out.println( bcontent );
//		boolean result = 
//		BoardDao.getInstance().write(btitle, bcontent , mno );
//			System.out.println( result );
		/* js 전송용  */
		//response.getWriter().print(result);
		
		/* form 전송용  */
		//if( result ) { response.sendRedirect("list.jsp");}
		//else {response.sendRedirect("write.jsp");}
		
	}
	
	private static final long serialVersionUID = 1L;
     
    public write() {
        super();
        // TODO Auto-generated constructor stub
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 첨부파일[ cos.jar 라이브러리 필요 ]
			// 1. cos.jar 빌드 추가
			// 2. HttpServletRequest : 첨부파일 지원x [ 소량의 문자만 지원 ]
			// 3. MultipartRequest : 첨부파일 지원o [ 대용량의 문자 가능 ]
				// 첨부파일 : http post메소드 지원
			// new MultipartRequest( 1.요청방식, 2.파일저장경로, 3.최대용량범위, 4.인코딩타입, 5.기타(보안기능) )
				// 1비트( 0 , 1 ) --> 1바이트 ( 01011111 : 8비트 ) --> 1kb ( 1024b ) -> 1mb ( 1024kb ) -> 1gb ( 1024mb )
		
		// 1. 저장 경로 [ 프로젝트 저장 ]
		// String uploadpath = "C:\\Users\\504\\git\\jspweb\\jspweb\\src\\main\\webapp\\upload";
		
		// 현재 배포된 프로젝트의 경로 찾기
		// String uploadpath = request.getSession().getServletContext().getRealPath("/"); // 최상위경로(프로젝트)
		String uploadpath = request.getSession().getServletContext().getRealPath("/upload"); // 최상위경로/upload
		
		System.out.println(uploadpath);
		
		MultipartRequest multi = new MultipartRequest(
					request,	// 요청방식
					uploadpath,	// 저장 경로
					1024 * 1024 * 1024,	// 1MB	[ 1024 : 1kb / 1024*1024 : 1mb / 1024*1024*1024 : 1GB
					"UTF-8",
					new DefaultFileRenamePolicy()	// 5. 업로드된 파일의 이름이 중복일경우 자동으로 이름 변경
				); // 생성자 end
		
		// 3. 해당 저장경로에 첨부파일 업로드가 된다.
		
		// 4. 나머지 데이터를 직접 요청
		String btitle = multi.getParameter("btitle"); // request -> multi
		System.out.println(btitle); // 확인
		String bcontent = multi.getParameter("bcontent");
		System.out.println(bcontent);
		
		// * 어떤파일을 업로드 했는지 db에 저장할 청부파일 경로/이름 호출
		String bfile = multi.getFilesystemName("bfile");
		System.out.println(bfile);
		
		// * 회원아이디 ----> 회원번호
		int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("mid"));
		System.out.println(mno);
		
		// 5. db처리
		boolean result = BoardDao.getInstance().write(btitle, bcontent, mno, bfile);
		
		response.getWriter().print(result);
		
	}

}
