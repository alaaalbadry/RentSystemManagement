package controller;

import java.util.List;

import dao.IAccountDAO;
import dao.impl.AccountDAOImpl;
import model.AccountModel;
import model.UserModel;

public class AccountController  {
	
	IAccountDAO accountDAO=new AccountDAOImpl();
	
	
	public void addAccount(AccountModel accountModel) throws Exception  {
		validate(accountModel);
		accountDAO.createAccount(accountModel);
	}
	String email_pattern = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	String phone_pattern="^0/d(?:-/d{3}){3}/d$";
	private boolean validate(AccountModel accountModel) throws Exception {
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
	
	public void editAccount(AccountModel accountModel) throws Exception  {
		validate(accountModel);
		accountDAO.updateAccount(accountModel);
	}
	
	public boolean deleteAccount(String nId)   {
		
		try {
			return  accountDAO.deleteAccountByNID(nId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		}
	public AccountModel getAccountByNID(String nId) throws Exception  {
		
		 return   accountDAO.getAccountByNID(nId);
				
			}
	public List<AccountModel> getAllAccounts() {
		return accountDAO.getAllAccounts();
	}
   public boolean loginAdmin(UserModel userModel )  {
	   
	try {
		return	accountDAO.getLoginData(userModel);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
	   
   }
}