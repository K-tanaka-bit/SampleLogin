package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Logindao {
	
	public boolean select (String user_id ,String password) throws SQLException , ClassNotFoundException {

	
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user_info WHERE user_id = ? AND password = ? ");){

			pstmt.setString(1, user_id);
			pstmt.setString(2, password);

			ResultSet res = pstmt.executeQuery();

			if(res.next()) {
				return true ;
			}
			
		}return false;
	}
	
	
	public List<String[]> selectname() throws SQLException, ClassNotFoundException {

		List<String[]> nameList = new ArrayList<>();

		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT user_id,name FROM user_info;")) {

			while (res.next()) {
				String[] user = { res.getString("user_id"), res.getString("name") };
				nameList.add(user);
			}

			return nameList;
		}

	}
}

	