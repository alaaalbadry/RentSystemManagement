package controller;

import java.util.ArrayList;
import java.util.List;

import dao.IAccountDAO;
import dao.impl.AccountDAOImpl;
import dto.RentDataProductDTO;
import dto.RentProcessDTO;
import model.ProductModel;

public class RentProcessController {
	public Double RentProcess(RentProcessDTO rentProcessDTO, String accountNatID, String productType) throws Exception {
		IAccountDAO accountDAO = new AccountDAOImpl();

		// validate(rentProcessDTO);
		if (!accountDAO.checkRentAccount(accountNatID)) 
		{throw new Exception("Account does not exist");}
		
			List<RentDataProductDTO> list = accountDAO.getAvailableProducItems(productType);
			if (rentProcessDTO.getQuantity() > list.size()) 
				{throw new Exception("The product not available");}
				ProductModel model = accountDAO.getProductData(productType);
				Double total=0.0;
					for (int x = 0; x < rentProcessDTO.getQuantity(); x++) {
					if (accountDAO.rentItem(list.get(x).getItem_ID())<=0)
						throw new Exception("Rent Process cann't be complete");
					Double payed= rentProcessDTO.getSDRent() * model.getProductprice();
					total+=payed;
					if (accountDAO.inserRentProcessData(list.get(x).getItem_ID(), accountNatID,
							rentProcessDTO.getSDRent(),payed) <= 0) {
						throw new Exception("Rent Process cann't be complete");
					}
				}
			return total;
		}

	

	public ArrayList<RentProcessDTO> getReceipt(String accountNatID) {
		IAccountDAO accountDAO = new AccountDAOImpl();

		return accountDAO.getReceipt(accountNatID);

	}

	// private boolean validate(RentProcessDTO rentProcessDTO) throws Exception {

	// if(rentProcessDTO.getSDRent()==null||rentProcessDTO.getEDRent()==(""))
	// {
	// throw new Exception("Please, Enter SDRent");
	// }
	// if(rentProcessDTO.getEDRent()==null||rentProcessDTO.getEDRent().equals(""))
	// {
	// throw new Exception("Please, Enter EDRent");
	// }

	// return true;
	// }

}
