package controller;

import java.util.List;

import dao.IAccountDAO;
import dao.impl.AccountDAOImpl;
import model.AccountModel;

import services.Validation;

public class AccountController  {
	
	IAccountDAO accountDAO=new AccountDAOImpl();
	Validation validation=new Validation();
	
	public void addAccount(AccountModel accountModel) throws Exception  {
		validation.AccountValidation(accountModel);
		accountDAO.createAccount(accountModel);
	}
	
	
	public void editAccount(AccountModel accountModel) throws Exception  {
		validation.AccountValidation(accountModel);
		accountDAO.updateAccount(accountModel);
	}
	
	public boolean deleteAccount(String nId)   {
		
		try {
			return  accountDAO.deleteAccountByNID(nId);
		} catch (Exception e) {
			
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

  
}