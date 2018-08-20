package ICANTPICK.Interfaces;

import java.sql.SQLException;

import ICANTPICK.Models.User_info;

public interface User_infoDAOi {

	User_info getUserByEmail(String email) throws SQLException;
}
