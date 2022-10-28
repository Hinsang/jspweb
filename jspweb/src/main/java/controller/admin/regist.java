package controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.ProductDao;
import model.dto.ProductDto;

/**
 * Servlet implementation class regist
 */
@WebServlet("/admin/regist")
public class regist extends HttpServlet {
	// 1. 제품 등록 메소드 [ post ] 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 첨부파일이 있을경우 [ 업로드 용 ] */
		MultipartRequest multi = new MultipartRequest(
				request, 
				request.getSession().getServletContext().getRealPath("/admin/pimg") , 
				1024*1024*10,
				"UTF-8", 
				new DefaultFileRenamePolicy() );
		
		String pname = multi.getParameter("pname");			
		String pcomment = multi.getParameter("pcomment");	
		int pprice = Integer.parseInt( multi.getParameter("pprice") ) ;		
		float pdiscount = Float.parseFloat( multi.getParameter("pdiscount") );
		byte pactive = Byte.parseByte( multi.getParameter("pactive") ) ;
		String pimg = multi.getFilesystemName("pimg"); 
		
		int pcno = Integer.parseInt( multi.getParameter("pcno") );
		
		ProductDto dto = new ProductDto( 0 , pname, pcomment, pprice, pdiscount, (byte) pactive , pimg, null, pcno );
			
		boolean result = new ProductDao().setProduct(dto);
		response.getWriter().print(result);
		
	}
	
	// 2. 제품 출력 메소드 [ get ] 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(11111);
		String type = request.getParameter("type");
		
		if(type.equals("1")) {
			
			// 1.전체출력 2.판매중 출력
			String option = request.getParameter("option");
			
			//// 모든 제품 출력 ////
			ArrayList<ProductDto> list  = new ProductDao().getProductlist(option);// DAO 처리 
			JSONArray array = new JSONArray(); 	// LIST -> JSON
			for( int i = 0 ; i<list.size() ; i++ ) {
				JSONObject object  = new JSONObject();
				object.put("pno", list.get(i).getPno() );				
				object.put("pname", list.get(i).getPname() );
				object.put("pcomment", list.get(i).getPcomment() );		
				object.put("pprice", list.get(i).getPprice() );
				object.put("pdiscount", list.get(i).getPdiscount() );	
				object.put("pactive", list.get(i).getPactive() );
				object.put("pimg", list.get(i).getPimg() );				
				object.put("pdate", list.get(i).getPdate() );
				object.put("pcno", list.get(i).getPcno() );			
				array.add(object);
			}
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(array);
		} else if(type.equals("2")) {
			//pno = Integer.parseInt(request.getParameter("pno"));
			int pno = Integer.parseInt(request.getParameter("pno"));
			System.out.println(pno);
			ProductDto dto = new ProductDao().getProduct(pno);
			
			JSONObject object  = new JSONObject();
			object.put("pno", dto.getPno() );				
			object.put("pname", dto.getPname() );
			object.put("pcomment", dto.getPcomment() );		
			object.put("pprice", dto.getPprice() );
			object.put("pdiscount", dto.getPdiscount() );	
			object.put("pactive", dto.getPactive() );
			object.put("pimg", dto.getPimg() );				
			object.put("pdate", dto.getPdate() );
			object.put("pcno", dto.getPcno() );			
			
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(object);
					
		}
		
	}

	/////////////////////// 제품 수정 메소드 ///////////////////////
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MultipartRequest multi = new MultipartRequest(
				request, 
				request.getSession().getServletContext().getRealPath("/admin/pimg") , 
				1024*1024*10,
				"UTF-8", 
				new DefaultFileRenamePolicy() );
		
		int pno = Integer.parseInt(multi.getParameter("pno")); 
		String pname = multi.getParameter("pname");			
		String pcomment = multi.getParameter("pcomment");	
		int pprice = Integer.parseInt( multi.getParameter("pprice") ) ;		
		float pdiscount = Float.parseFloat( multi.getParameter("pdiscount") );
		byte pactive = Byte.parseByte( multi.getParameter("pactive") ) ;		
		String pimg = multi.getFilesystemName("pimg"); 
		int pcno = Integer.parseInt(multi.getParameter("pcno"));  

		System.out.println(pno);
		System.out.println(pname);
		System.out.println(pcomment);
		System.out.println(pprice);
		System.out.println(pdiscount);
		System.out.println(pactive);
		System.out.println(pimg);
		System.out.println(pcno);
		
		// 기존첨부파일 판단
		boolean bfilechange = true;
		ProductDto olddto = new ProductDao().getProduct( pno );
		
		if( pimg == null ) {
			pimg = olddto.getPimg();
			bfilechange = false;
		}
		
		ProductDto dto = new ProductDto( pno , pname, pcomment, pprice, pdiscount, (byte) pactive , pimg, null, pcno );

		boolean result = new ProductDao().updateProduct(dto);
		
		// 4.dao 처리 [ 업데이트 = 새로운 첨부파일 ]
		if( result && bfilechange ) { 
			deletefile( request.getSession() , olddto.getPimg() );
		}
		
		response.getWriter().print(result);
		
	}

	private void deletefile(HttpSession session, String pimg) {
		String deletepath = session.getServletContext().getRealPath("/admin/pimg/"+ pimg );
		File file = new File( deletepath );
		if( file.exists() ) file.delete();
	}

	/////////////////////// 제품 삭제 메소드 ///////////////////////
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno"));
		boolean result = new ProductDao().deleteproduct(pno);
		System.out.println( "삭제야 : " + result );
		response.getWriter().print(result);
	}
	
	
	
	
	
	
	
	
	
	
	
///////////////////////////////////////////////////////////////
	private static final long serialVersionUID = 1L;

    public regist() {
        super();
        // TODO Auto-generated constructor stub
    }

}
