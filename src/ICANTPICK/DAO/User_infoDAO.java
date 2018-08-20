package ICANTPICK.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ICANTPICK.Interfaces.User_infoDAOi;
import ICANTPICK.Models.User_info;

public class User_infoDAO implements User_infoDAOi {

	public User_info getUserByEmail(String email) throws SQLException {
		User_info user_info = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		
		try {
			conn = OracleConnection.getConnection();
			String sql = "SELECT * FROM USER_INFO\r\n WHERE EMAIL =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			result = ps.executeQuery();
			
			user_info = new User_info();
			
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
