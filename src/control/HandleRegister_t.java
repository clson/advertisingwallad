package control;

import model.Register;
import utils.ddd;

import java.sql.PreparedStatement;
import java.sql.SQLException;



public class HandleRegister_t extends ddd {
	public boolean handleRegister(Register register) {
		ConnectDatabase();
		boolean isSuccess=false;
		if (con == null) {
			return false;
		}
		PreparedStatement preSql;
		String sqlStr="insert into register_table values(?,?)";
		int ok=0;
		try {
			preSql=con.prepareStatement(sqlStr);
			preSql.setString(1,register.getId());
			String pw=register.getPassword();
			preSql.setString(2, pw);
			ok=preSql.executeUpdate();
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		if (ok!=0) {
			isSuccess=true;
		}
		return isSuccess;
	}
}
