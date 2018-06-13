package users;

import java.sql.*;
import DBConnection.*;

public class UsersDAO {
	DBConnect dbconnect = null;
	String sql="";
	
	public UsersDAO() {
		dbconnect = new DBConnect();
	}
	
	public String Login(String uid, String upw) {
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			sql = "SELECT uname FROM users WHERE uid=? and upw=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setString(2, upw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getString(1);
			}
			
		}catch(Exception e) {
			
		}finally {
			DBClose.close(con,pstmt,rs);
		}
		
		return "";
	}
}