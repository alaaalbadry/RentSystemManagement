package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IRentProcessDAO;
import dto.RentDataProductDTO;
import dto.RentProcessDTO;
import model.ProductModel;

public class RentProcessDAOImpl implements IRentProcessDAO {
	
	Connection connection;
	PreparedStatement stmt;

	 AccountDAOImpl accountDAO=new AccountDAOImpl();
	@Override
	public List<RentDataProductDTO> getAvailableProducItems(String productType)throws Exception{
		List<RentDataProductDTO> list=new ArrayList<RentDataProductDTO>();
			try{
		connection = accountDAO.getConnection();
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
			 dataProductDTO.setQR_CODE(rs.getString("QR_CODE"));
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
try {	connection=accountDAO.getConnection();
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
@Override
public ProductModel getProductData(String productType)throws Exception{
	try{
	connection = accountDAO.getConnection();
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
try {	connection=accountDAO.getConnection();
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
	

public boolean checkRentAccount(String accountNatID)throws Exception {

connection = accountDAO.getConnection();
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
connection = accountDAO.getConnection();
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


public ArrayList<RentProcessDTO> getReceipt(String accountNatID){

ArrayList<RentProcessDTO> list=new ArrayList<RentProcessDTO>();
//AccountModel accountModel=new AccountModel();
try {
	connection = accountDAO.getConnection();
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




}
