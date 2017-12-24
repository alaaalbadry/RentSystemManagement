package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IAccountDAO;
import dto.RentDataProductDTO;
import dto.RentProcessDTO;
import model.AccountModel;
import model.ProductModel;
import model.UserModel;

public class AccountDAOImpl implements IAccountDAO {
	Connection connection;
	PreparedStatement stmt;

	
	private Connection getConnection() throws Exception {// create abstract class and put the method get connection to
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

	/* (non-Javadoc)
	 * @see dao.IAccountDAO#getLoginData(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean getLoginData(UserModel userModel) throws Exception {
		 connection= getConnection();
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
public boolean checkRentAccount(String accountNatID)throws Exception {
	
	connection = getConnection();
	PreparedStatement stmt= connection.prepareStatement("select * from account where NatID=?");
	stmt.setString(1,accountNatID);	
	 ResultSet rs=stmt.executeQuery();
		try {
			return rs.isBeforeFirst() ;
	} catch (SQLException e) {
		throw new Exception("Account not exist");
	} finally {
	stmt.close();
	connection.close();
}
	
}
public int getRentProductData(String productType)throws Exception{
	try{
	connection = getConnection();
	 stmt= connection.prepareStatement("select Count(*) from product_items  where RENT_STATUS=0 && productType =?");
	stmt.setString(1,productType);	
	 ResultSet rs=stmt.executeQuery();
	 while (rs.next()) {
	return	 rs.getInt(0);
		}
				} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return 0;
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
	return 0;
				
		}
@Override
public List<RentDataProductDTO> getAvailableProducItems(String productType)throws Exception{
	List<RentDataProductDTO> list=new ArrayList<RentDataProductDTO>();
		try{
	connection = getConnection();
	list=new ArrayList<RentDataProductDTO>();
	 stmt= connection.prepareStatement("select * from product_items  where RENT_STATUS=0 && productType =?");
	stmt.setString(1,productType);	
	 ResultSet rs=stmt.executeQuery();
	 while (rs.next()) {
		 RentDataProductDTO dataProductDTO=new RentDataProductDTO();
		
		 dataProductDTO.setItem_ID(rs.getInt("ID"));
		 dataProductDTO.setProductID(rs.getInt("productID"));
		 dataProductDTO.setProductPrice(rs.getDouble("productPrice"));
		 dataProductDTO.setProductType(rs.getString("productType"));
		 dataProductDTO.setQR_CODE(rs.getInt("QR_CODE"));
		 dataProductDTO.setRENT_STATUS(rs.getBoolean("RENT_STATUS"));
		 list.add(dataProductDTO);
		}
				} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return list;
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


/* (non-Javadoc)
 * @see dao.IAccountDAO#inserRentProcessData(dto.RentProcessDTO)
 */
@Override
public int inserRentProcessData(Integer itemId,String accountNID,int rentDuration,Double payedPrice)  {
try {	connection=getConnection();
	 stmt=connection.prepareStatement("insert into rent_process_info (rent_duration,payed_price,item_id,account_id) values(?,?,?,?)");
	stmt.setInt(1, rentDuration);
	stmt.setDouble(2, payedPrice);
	stmt.setInt(3, itemId);
	stmt.setString(4, accountNID);
	return stmt.executeUpdate();
	}
catch (Exception e) {
	System.out.println(e);
	return 0;
}
finally {
	try {
		stmt.close();
		connection.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
}
public ArrayList<RentProcessDTO> getReceipt(String accountNatID){
	
	ArrayList<RentProcessDTO> list=new ArrayList<RentProcessDTO>();
	//AccountModel accountModel=new AccountModel();
	try {
		connection = getConnection();
		 stmt = connection.prepareStatement("select  startDate,payed_price,Quantity  from rent_process_info where account_id=?");
		
		stmt.setString(1, accountNatID);
		
		
		ResultSet rs = stmt.executeQuery();
while (rs.next()) {
	RentProcessDTO rentProcessDTO = new RentProcessDTO();
	rentProcessDTO.setSDRent(rs.getInt("startDate"));
	rentProcessDTO.setPayedPrice(rs.getDouble("payed_price"));
	rentProcessDTO.setQuantity(rs.getInt("Quantity"));

	list.add(rentProcessDTO);
}
		} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		list= new ArrayList<RentProcessDTO>();
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

@Override
public ProductModel getProductData(String productType)throws Exception{
	try{
	connection = getConnection();
	 ProductModel model=new ProductModel();
	 stmt= connection.prepareStatement("select * from product  where productType =?");
	stmt.setString(1,productType);	
	 ResultSet rs=stmt.executeQuery();
	 while (rs.next()) {
	model.setProductId(rs.getInt("productID"));
	model.setProductprice(rs.getDouble("productPrice"));
	model.setProductDescription(rs.getString("description"));	
	model.setProductType(productType);
	 }
	 return model;
				} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
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

				
		}



@Override
public int rentItem(Integer itemId)  {
try {	connection=getConnection();
	 stmt=connection.prepareStatement("update  item  set RENT_STATUS =1 where ID=?");
	stmt.setInt(1, itemId);
	return stmt.executeUpdate();
	}
catch (Exception e) {
	System.out.println(e);
	return 0;
}
finally {
	try {
		stmt.close();
		connection.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
}


//	public static void main(String[] args) throws Exception {
//		AccountDAOImpl a = new AccountDAOImpl();
//		AccountModel accountModel = new AccountModel();
//		AccountModel accoutModel = null;
//		accoutModel.setNatID("12345678912345");
//		a.createAccount(accountModel);
//	}
}