package controller;

import java.util.List;

import dao.IProductDAO;
import dao.impl.ProductDAOImpl;

import model.ProductModel;
import services.Validation;

public class ProductController {

	
	IProductDAO productDAO=new ProductDAOImpl();
	Validation validation=new Validation();
	
	public void addProduct(ProductModel productModel) throws Exception  {
		validation.ProductValidation(productModel);
		productDAO.createProduct(productModel);
	}
	public void editProduct(ProductModel productModel) throws Exception  {
		validation.ProductValidation(productModel);
		productDAO.updateProduct( productModel);
	}
	
	public boolean deleteProduct(int productID,ProductModel productModel)   {
		
		try {
			return  productDAO.deleteProductByID(productID,productModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		}
	
	public ProductModel getProductByID(ProductModel productModel) throws Exception  {
		
		 return   productDAO.getProductByID(productModel);
				
			}
	public List<ProductModel> getAllProducts() throws Exception {
		return productDAO.getAllProducts();
	}
	public int getProductID(ProductModel productModel) throws Exception{
		return productDAO.getProductID(productModel);
	}
	
	
	
}
