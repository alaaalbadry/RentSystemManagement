package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ILoginDAO;
import model.UserModel;

public class LoginDAOImpl implements ILoginDAO {
	
	Connection connection;
	PreparedStatement stmt;

	 AccountDAOImpl accountDAO=new AccountDAOImpl();
	/* (non-Javadoc)
	 * @see dao.IAccountDAO#getLoginData(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean getLoginData(UserModel userModel) throws Exception {
		 connection= accountDAO.getConnection();
		PreparedStatement stmt=connection.prepareStatement("select * from login_admin where user_name =? and user_password =? ");
		stmt.setString(1,userModel.getUsername());
		stmt.setString(2, userModel.getPassword());
		 ResultSet rs=stmt.executeQuery();
			try {
			return rs.isBeforeFirst() ;
	} catch (SQLException e) {
		throw new Exception("username or password is not valide");
	} finally {
	stmt.close();
	connection.close();
}
		}

}
