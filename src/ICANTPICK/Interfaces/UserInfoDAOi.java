package ICANTPICK.Interfaces;

import java.sql.SQLException;

import ICANTPICK.Models.UserInfo;

public interface UserInfoDAOi {

	UserInfo getUserByEmail(String email) throws SQLException;
}
