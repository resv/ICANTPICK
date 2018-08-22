package ICANTPICK.MainEntryPoint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ICANTPICK.DAO.OracleConnection;
import ICANTPICK.Models.UserInfo;

public class TestRunner {

	
//----------------MAIN CALLER HERE----------------------------------	
	public static void main(String[] args) throws SQLException {
		vgetUserByEmail("akim456@gmail.com");
	}

//METHOD FOR getUserByEmail() - WORKS!	
	public static UserInfo vgetUserByEmail(String email) throws SQLException {
		UserInfo user_info = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		
		try {
			conn = OracleConnection.getConnection();
			String sql = "SELECT * FROM USERINFO\r\n WHERE EMAIL =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			result = ps.executeQuery();
			
			user_info = new UserInfo();
			
			if (result.next()) {
				user_info.setUser_id(result.getInt(1));
				user_info.setUsername(result.getString(2));
				user_info.setEmail(result.getString(3));
				user_info.setLvl(result.getInt(5));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (result != null) {
				result.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return user_info;
	}
	
}
