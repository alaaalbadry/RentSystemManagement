package services;

import model.AccountModel;
import model.ProductModel;

public class Validation {
	
	
	String email_pattern = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	String phone_pattern="^0/d(?:-/d{3}){3}/d$";
	public boolean AccountValidation(AccountModel accountModel) throws Exception {
		if(accountModel.getNatID()==null||accountModel.getNatID().equals(""))
		{
			throw new Exception("Please, Enter National Id");
		}
		if(accountModel.getName()==null||accountModel.getName().equals(""))
		{
			throw new Exception("Please, Enter Name");
		}
		if(accountModel.getPhone()==null||accountModel.getPhone().equals("") && accountModel.getPhone().matches(phone_pattern)) {
			throw new Exception("Please,Enter Phone");
		}
		if(accountModel.getEmail()==null||accountModel.getEmail().equals("") && accountModel.getEmail().matches(email_pattern)) {
			throw new Exception("Please,Enter Email");
		}
		if(accountModel.getAddress()==null||accountModel.getAddress().equals("") ) {
			throw new Exception("Please,Enter Address");
		}
		
		return true;
	}
	public boolean ProductValidation(ProductModel productModel) throws Exception {
		
		if(productModel.getProductType()==null||productModel.getProductType().equals(""))//ask 
		{
			throw new Exception("Please, Enter Product Type");
		}
		if(productModel.getProductprice()==null|| productModel.getProductprice()==0||productModel.getProductprice().equals(""))
		{
			throw new Exception("Please, Enter Product Price");
		}
		if(productModel.getProductDescription()==null||productModel.getProductDescription().equals(""))//ask 
		{
			throw new Exception("Please, Enter Product Description");
		}
		//if(productModel.getProductQuantity()==null||productModel.getProductQuantity()==0||productModel.getProductQuantity().equals(""))//ask if the integer num not take as string so neglect spaces 
	//	{
			//throw new Exception("Please, Enter Product Quantity");
		//}
		
		return true;
	}
	

}
