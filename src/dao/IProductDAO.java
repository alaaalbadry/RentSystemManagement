package dao;

import java.util.List;

import model.ProductModel;

public interface IProductDAO {
	
	
	//CRUD
		public boolean createProduct(ProductModel productModel) throws Exception;
		public boolean updateProduct(ProductModel productModel)throws Exception;
		public boolean deleteProductByID(int productID,ProductModel productModel)throws Exception;
		public ProductModel getProductByID(ProductModel productModel)throws Exception;//search
		public List<ProductModel> getAllProducts() throws Exception;
		public int getProductID(ProductModel productModel) throws Exception;
	
}
