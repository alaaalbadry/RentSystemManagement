package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dao.IProductDAO;

import model.ProductModel;

public class ProductDAOImpl implements IProductDAO {
	Connection connection;
	PreparedStatement stmt;
	
	@Override
	public boolean createProduct(ProductModel productModel) throws Exception {
		
		AccountDAOImpl accountDAO=new AccountDAOImpl();
		connection = accountDAO.getConnection();
		
		  stmt = connection.prepareStatement("insert into product (productType,productPrice,description) values(?,?,?)");
		try {
			stmt.setString(1, productModel.getProductType());
			stmt.setDouble(2, productModel.getProductprice());
			stmt.setString(3, productModel.getProductDescription());
			if( stmt.executeUpdate() > 0) {
			try {
				createItem(productModel);
			} catch (SQLException e) {
				throw new Exception("Item Data exist before");
			} 
			
			}
         
		} catch (SQLException e) {
			throw new Exception("Account Data exist before");
		} finally {
			
			stmt.close();
			connection.close();
		}
		return true;
	}
	

	@Override
	public boolean updateProduct(ProductModel productModel) throws Exception {
		AccountDAOImpl accountDAO=new AccountDAOImpl();
		connection = accountDAO.getConnection();
		
		PreparedStatement stmt = connection.prepareStatement("update Product set  productType=? , productPrice=?, description=?  where productID=?  ");
	
		//how to get productID from product table 
		stmt.setString(1, productModel.getProductType());
		stmt.setDouble(2, productModel.getProductprice());
		stmt.setString(3, productModel.getProductDescription());
		stmt.setInt(4, productModel.getProductId());
		//getProductID(productModel)
		try {
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			throw new Exception("no rows affected ");
		} finally {
		stmt.close();
		connection.close();
	 
	}
	}

	@Override
	public boolean deleteProductByID(int productID,ProductModel productModel) throws Exception {
		AccountDAOImpl accountDAO=new AccountDAOImpl();
		connection = accountDAO.getConnection();
		PreparedStatement stmt = connection.prepareStatement("delete from product where productID=?");
		stmt.setInt(1, getProductID(productModel));
		try {
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			throw new Exception("Product Id not Exist");
		} finally {
		stmt.close();
		connection.close();
	}
	}

	@Override
	public ProductModel getProductByID(ProductModel productModel) throws Exception {
		AccountDAOImpl accountDAO=new AccountDAOImpl();
		connection = accountDAO.getConnection();
		
		PreparedStatement stmt = connection.prepareStatement("select * from product where productID=?");
		stmt.setInt(1, getProductID(productModel));
		ResultSet rs= stmt.executeQuery();
		new ProductModel();
		while (rs.next()) {
			productModel.setProductId(rs.getInt("productID"));
			productModel.setProductType(rs.getString("productType"));
			productModel.setProductprice(rs.getDouble("productPrice"));
			productModel.setProductDescription(rs.getString("description"));
		       }
		stmt.close();
		connection.close();
		return productModel;
	}

@Override
public List<ProductModel> getAllProducts() throws Exception {
		AccountDAOImpl accountDAO=new AccountDAOImpl();
		ArrayList<ProductModel> list = new ArrayList<ProductModel>();
		try {
		connection = accountDAO.getConnection();
		stmt = connection.prepareStatement("select * from product");
		ResultSet rs = stmt.executeQuery();
while (rs.next()) {
	ProductModel productModel = new ProductModel();
	productModel.setProductId(rs.getInt("productID"));
	productModel.setProductType(rs.getString("productType"));
	productModel.setProductprice(rs.getDouble("productPrice"));
	productModel.setProductDescription(rs.getString("description"));
	list.add(productModel);
}
		} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		list= new ArrayList<ProductModel>();//why created here
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
	


//// method's to service in update and create product
public boolean createItem(ProductModel productModel) throws Exception {
Integer productID=getProductID(productModel);
		for(int i=0;i<productModel.getProductQuantity();i++) {
			PreparedStatement stmtI = connection.prepareStatement("insert into item (PRODUCT_ID,QR_CODE) values (?,?)  ");
			stmtI.setInt(1, productID);
			Random random = new Random();
			String id = String.format("%04d", random.nextInt(10000));
			stmtI.setString(2,id );
			// ask heba on this point how to get productId from product
			stmtI.executeUpdate();
			
			stmtI.close();
		}
		
		return true;
	}
	public int getProductID(ProductModel productModel) throws Exception {
	 stmt = connection.prepareStatement("select productID from product where productType=?");
		stmt.setString(1, productModel.getProductType());
		ResultSet rs= stmt.executeQuery();
		while (rs.next()) {
			productModel.setProductId(rs.getInt("productID"));
	}
		return productModel.getProductId();	
  }
}
