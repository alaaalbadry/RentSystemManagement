package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import dao.IAccountDAO;

import model.AccountModel;



public class AccountDAOImpl implements IAccountDAO {
	Connection connection;
	PreparedStatement stmt;

	
	public Connection getConnection() throws Exception {// create abstract class and put the method get connection to
															// be used in all dao calsses
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_sys", "root", "root");
		} catch (Exception e) {
			throw new Exception("Connection Error ");
		}

	}

	@Override
	public boolean createAccount(AccountModel accountModel) throws Exception {
		Connection  connection = getConnection();

		PreparedStatement  stmt = connection.prepareStatement("insert into Account values(?,?,?,?,?)");
		try {
			stmt.setString(1, accountModel.getNatID());
			stmt.setString(2, accountModel.getName());
			stmt.setString(3, accountModel.getPhone());
			stmt.setString(4, accountModel.getEmail());
			stmt.setString(5, accountModel.getAddress());
			return stmt.executeUpdate() > 0;

		} catch (SQLException e) {
			throw new Exception("Account Data exist before");
		} finally {
			stmt.close();
			connection.close();
		}
	}

	@Override
	public boolean updateAccount(AccountModel accountModel) throws Exception {
		Connection connection = getConnection();

		PreparedStatement stmt = connection
				.prepareStatement("update Account set  Name=? , phone=?,email=? ,address=? where NatID=?  ");
		stmt.setString(1, accountModel.getName());
		stmt.setString(2, accountModel.getPhone());
		stmt.setString(3, accountModel.getEmail());
		stmt.setString(4, accountModel.getAddress());
		stmt.setString(5, accountModel.getNatID());
		try {
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			throw new Exception("Account Data exist before");
		} finally {
		stmt.close();
		connection.close();
	}
	}

	@Override
	public boolean deleteAccountByNID(String accountNatID) throws Exception {
		Connection connection = getConnection();
		PreparedStatement stmt = connection.prepareStatement("delete from Account where NatID=?");
		stmt.setString(1, accountNatID);
		try {
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			throw new Exception("National Id not Exist");
		} finally {
		stmt.close();
		connection.close();
	}
	}

	@Override
	public AccountModel getAccountByNID(String accountNatID) throws Exception {// maybe needed in search
		Connection connection = getConnection();
		PreparedStatement stmt = connection.prepareStatement("select * from Account where NatID=?");
		stmt.setString(1, accountNatID);
		ResultSet rs= stmt.executeQuery();
		AccountModel accountModel=new AccountModel();
		while (rs.next()) {
			accountModel.setNatID(rs.getString("NatID"));
			accountModel.setName(rs.getString("name"));
			accountModel.setPhone(rs.getString("phone"));
			accountModel.setEmail(rs.getString("email"));
			accountModel.setAddress(rs.getString("address"));
		       }
		stmt.close();
		connection.close();
		return accountModel;
	}

	@Override
	public ArrayList<AccountModel> getAllAccounts()  {
		ArrayList<AccountModel> list = new ArrayList<AccountModel>();
			try {
			connection = getConnection();
			stmt = connection.prepareStatement("select * from Account");
			ResultSet rs = stmt.executeQuery();
	while (rs.next()) {
		AccountModel accountModel = new AccountModel();
		accountModel.setNatID(rs.getString("NatID"));
		accountModel.setName(rs.getString("name"));
		accountModel.setPhone(rs.getString("phone"));
		accountModel.setEmail(rs.getString("email"));
		accountModel.setAddress(rs.getString("address"));
		list.add(accountModel);
	}
			} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			list= new ArrayList<AccountModel>();
		}
		finally {
			try {
				stmt.close();
				connection.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				return list;
	}


//	public static void main(String[] args) throws Exception {
//		AccountDAOImpl a = new AccountDAOImpl();
//		AccountModel accountModel = new AccountModel();
//		AccountModel accoutModel = null;
//		accoutModel.setNatID("12345678912345");
//		a.createAccount(accountModel);
//	}
}