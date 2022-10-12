package model.dao;

import java.util.ArrayList;

import model.dto.MemberDto;

public class MemberDao extends Dao {
	// 0. 싱글톤 객체 선언 [ 공유 메모리 ] 
	private static MemberDao mdao = new MemberDao();
	public static MemberDao getInstance() { return mdao;}
	
	//1. 회원가입 메소드 
	public boolean signup( MemberDto dto ) {
		String sql ="insert into"
				+ " member( mid ,mpassword,"
				+ "mname,mphone,"
				+ "memail,maddress)"
				+ " values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getMid() );
			ps.setString( 2 , dto.getMpassword() );
			ps.setString( 3 , dto.getMname() );
			ps.setString( 4 , dto.getMphone() );
			ps.setString( 5 , dto.getMemail() );
			ps.setString( 6 , dto.getMaddress() );
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);}
		return false; 	
	} // 회원가입 end 
	
	// 2. 로그인 메소드 
	public int login( String id , String password) {
		String sql = "select * from member where mid = ?"; // 아이디 검증
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , id );
			rs = ps.executeQuery();
			if( rs.next() ) { // 만약에 다음 레코드가 존재하면
				sql = "select * from member where mid = ? and mpassword = ?"; // 패스워드 검증
				ps = con.prepareStatement(sql);
				ps.setString(1, rs.getString(2)); // 첫번째 select 찾은 데이터를 첫번째 ? 대입
				ps.setString(2, password);
				rs = ps.executeQuery();
				if( rs.next() ) {
					return 1; // 로그인 성공 뜻
				}
				return 2; // 패스워드가 틀렸다는 뜻
			}
		}catch (Exception e) { System.out.println(e); }
		return 0; // 아이디 없다는 뜻
	}
	
	public String findid(String mname, String memail) {
		
		String sql = "select * from member "
				+ "where mname = ? and memail = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mname);
			ps.setString(2, memail);
			rs = ps.executeQuery();
			if(rs.next()) return rs.getString(2);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// 비밀번호찾기 [ 임시 비밀번호 발급 여부 판단 ]
	public boolean findpassword(String mid, String memail) {
		
		String sql = "select * from member "
				+ "where mid = ? and memail = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, memail);
			rs = ps.executeQuery();
			if(rs.next()) return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	// 임시 비밀번호 업데이트
	public boolean passwordchange(String mid, String randstr) {
		String sql = "update member set mpassword = ?"
				+ " where mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, randstr);
			ps.setString(2, mid);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	// 회원정보 호출
	public MemberDto getinfo( String mid ) {
		MemberDto dto = null;
		String sql = "select * from member where mid = ?";		
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if( rs.next() ) {
				
				// 풀 생성자
				dto = new MemberDto(
						rs.getInt(1), rs.getString(2), null, 
						rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7),
						rs.getString(8), rs.getInt(9)
						);
				
				// 빈 생성자
//				dto = new MemberDto();
//				dto.setMno( rs.getInt(1) );
//				dto.setMid( rs.getString(2) );
//				// 패스워드 제외
//				dto.setMname( rs.getString(4) );
//				dto.setMphone( rs.getString(5) );
//				dto.setMemail( rs.getString(6) );
//				dto.setMaddress( rs.getString(7) );
//				dto.setMdate( rs.getString(8) );
//				dto.setMpoint( rs.getInt(9) );
				return dto;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return dto;
	}
	
	// 모든 회원 호출
	public ArrayList<MemberDto> getinfolist() {
		ArrayList<MemberDto> list = new ArrayList<>();
		String sql = "select * from member";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				MemberDto dto = new MemberDto(
						rs.getInt(1), rs.getString(2), null, 
						rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7),
						rs.getString(8), rs.getInt(9)
						);
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	// 회원탈퇴
	public boolean delete( String mid, String mpassword ) {
		String sql = "delete from member where mid = ? and mpassword = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpassword);
			int count = ps.executeUpdate(); // 삭제 레코드 수 반환
			if(count == 1) {
				return true;
				// 삭제된 리코드가 1개이면 성공
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	// 아이디 중복체크
	public boolean idcheck( String mid ) {
		String sql = "select * from member where mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	// 이메일 중복체크
	public boolean emailcheck( String memail ) {
		String sql = "select * from member where memail = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memail);
			ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	// 회원정보 수정
	
	public boolean update(String mid, String mname) {
		String sql = "update member set mname = ? where mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mname);
			ps.setString(2, mid);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println();
		}
		return false;
	}
	
}






















