

package controller;

import java.util.ArrayList;
import java.util.List;


import dao.IRentProcessDAO;

import dao.impl.RentProcessDAOImpl;
import dto.RentDataProductDTO;
import dto.RentProcessDTO;
import model.ProductModel;

public class RentProcessController {
	public Double RentProcess(RentProcessDTO rentProcessDTO, String accountNatID, String productType) throws Exception {
		IRentProcessDAO RentProcessDAO = new RentProcessDAOImpl();

		//validate(rentProcessDTO);
		if (!RentProcessDAO.checkRentAccount(accountNatID)) 
		{throw new Exception("Account does not exist");}
		
			List<RentDataProductDTO> list = RentProcessDAO.getAvailableProducItems(productType);
			if (rentProcessDTO.getQuantity() > list.size()) 
				{throw new Exception("The product not available");}
				ProductModel model = RentProcessDAO.getProductData(productType);
				Double total=0.0;
					for (int x = 0; x < rentProcessDTO.getQuantity(); x++) {
					if (RentProcessDAO.rentItem(list.get(x).getItem_ID())<=0)
						throw new Exception("Rent Process cann't be complete");
					Double payed= rentProcessDTO.getSDRent() * model.getProductprice();
					total+=payed;
					if (RentProcessDAO.inserRentProcessData(list.get(x).getItem_ID(), accountNatID,
							rentProcessDTO.getSDRent(),payed) <= 0) {
						throw new Exception("Rent Process cann't be complete");
					}
				}
			return total;
		}

	

	public ArrayList<RentProcessDTO> getReceipt(String accountNatID) {
		IRentProcessDAO RentProcessDAO = new RentProcessDAOImpl();

		return RentProcessDAO.getReceipt(accountNatID);

	}

	

}
