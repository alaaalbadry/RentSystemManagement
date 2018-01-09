package controller;



import dao.ILoginDAO;
import dao.impl.LoginDAOImpl;
import model.UserModel;

public class LoginController {
	
	ILoginDAO loginDAO=new LoginDAOImpl();
	
	 public boolean loginAdmin(UserModel userModel )  {
		   
			try {
				return	loginDAO.getLoginData(userModel);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
			   
		   }

}
