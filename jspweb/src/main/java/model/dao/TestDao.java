package model.dao;

public class TestDao extends Dao {

	// 싱글톤
	private static TestDao tdao = new TestDao();
	public static TestDao getInstance() {
		return tdao;
	}
	
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

	public boolean passwordchange(String mid, String randstr) {
		String sql = "update member set mpassword = ? where mid = ?";
		
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
	
}
