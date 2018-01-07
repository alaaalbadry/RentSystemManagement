package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


import controller.ProductController;

import model.ProductModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class AllProduct {

	public JFrame frmAllProduct;
	private JTable table;
	private ProductController productController=new ProductController();
	ArrayList<ProductModel> productList=new ArrayList<ProductModel>();
	

	private JFrame editProductFrame;
	private JTextField ProductIDText;
	private JTextField ProductTypeText;
	private JTextField ProductPriceText;
	private JTextField DescriptionText;
	
	public JFrame AddProductFrm;
	private JTextField productTypeText;
	private JTextField productPriceText;
	private JTextField productDescriptionText;
	private JTextField productQuantityText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllProduct window = new AllProduct();
					window.frmAllProduct.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public AllProduct() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	public void initialize() throws Exception {
		frmAllProduct = new JFrame();
		frmAllProduct.setTitle("All Product");
		frmAllProduct.setBounds(100, 100, 674, 442);
		frmAllProduct.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JButton btnAddNewProduct = new JButton("New Product");
		btnAddNewProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				initializeAddProductFrm();
				AddProductFrm.setVisible(true);
				
			}
		});
		
		JButton btnEdit = new JButton("Edit Product");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductModel productModel= new ProductModel();
				int jml=Integer.parseInt((String)table.getValueAt(table.getSelectedRow(),0)); 
			    productModel.setProductId(jml);	
				productModel.setProductType((String)table.getModel().getValueAt( table.getSelectedRow(),1));
				double jml1=Double.parseDouble((String)table.getValueAt(table.getSelectedRow(),2)); 
				productModel.setProductprice(jml1);	
				productModel.setProductDescription((String)table.getModel().getValueAt( table.getSelectedRow(),3));
		
				try {
					initializeEditFrame(productModel);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				editProductFrame.setVisible(true);
			}
		});
		
		JButton btnDelete = new JButton("Delete Product");
		btnDelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				 
				try {
					initializeDeleteFrame();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
		});	
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frmAllProduct.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(108, Short.MAX_VALUE)
					.addComponent(btnAddNewProduct)
					.addGap(59)
					.addComponent(btnEdit)
					.addGap(54)
					.addComponent(btnDelete)
					.addGap(114))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 592, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(34, Short.MAX_VALUE))
		);///////////////
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddNewProduct)
						.addComponent(btnEdit)
						.addComponent(btnDelete))
					.addGap(22))
		);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		fillDataModel();
		
		scrollPane.setViewportView(table);
		frmAllProduct.getContentPane().setLayout(groupLayout);
		
	}
	public void fillDataModel() throws Exception {
		  DefaultTableModel dtm = new DefaultTableModel();
	List<ProductModel>	list = productController.getAllProducts();
		dtm.setColumnIdentifiers(new String[] {
				"ProductID", "ProductType", "ProductPrice", "ProductDescription"
			});
		for(ProductModel productModel:list)
		{
			
			String jml=Integer.toString(productModel.getProductId());
			String jml1=Double.toString(productModel.getProductprice());
			//String jml2=Integer.toString(productModel.getProductQuantity());
			
			
			dtm.addRow(new String[] {jml,productModel.getProductType(),jml1,productModel.getProductDescription()});
		}
		  table.setModel(dtm);
	}
	private void initializeEditFrame(ProductModel productModel) throws Exception {
		 editProductFrame = new JFrame();
		 editProductFrame.setTitle("Edit Product");
		editProductFrame.setBounds(100, 100, 519, 350);
		editProductFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	
		ProductController c=new ProductController();
		JLabel lblProductID = new JLabel("ProductID:");
		String jml=String.valueOf(productModel.getProductId());
		ProductIDText = new JTextField(jml);
		ProductIDText.setColumns(20);
		
		ProductIDText.setEnabled(false);
		JLabel lblProductType = new JLabel("ProductType:");
		ProductTypeText = new JTextField(productModel.getProductType());
		ProductTypeText.setColumns(20);
		JLabel lblProductPrice = new JLabel("ProductPrice:");
		String jml1=String.valueOf(productModel.getProductprice());
		ProductPriceText = new JTextField(jml1);
		ProductPriceText.setColumns(20);
		
		JLabel lblDescription = new JLabel("Description");
	    DescriptionText = new JTextField(productModel.getProductDescription());
		DescriptionText.setColumns(20);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editProductFrame.setVisible(false);
			}});
		JButton btnSave = new JButton("save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductModel p=new ProductModel();
				
				int jml=Integer.parseInt(ProductIDText.getText());
				p.setProductId(jml);
				p.setProductType(ProductTypeText.getText());
				double jml1=Double.parseDouble(ProductPriceText.getText());
				p.setProductprice(jml1);
				p.setProductDescription(DescriptionText.getText());
				
				try {
					c.editProduct(p);
					JOptionPane.showMessageDialog(null, "Account Eddited  Successfully");
					editProductFrame.setVisible(false);
					fillDataModel();
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,e1);
				}
				
			}
			
		});
		GroupLayout groupLayout = new GroupLayout(editProductFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(149, Short.MAX_VALUE)
					.addComponent(btnCancel)
					.addGap(54)
					.addComponent(btnSave)
					.addGap(130))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProductID)
						.addComponent(lblProductType)
						.addComponent(lblDescription)
						.addComponent(lblProductPrice))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(DescriptionText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ProductIDText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ProductTypeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ProductPriceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(218, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProductID)
						.addComponent(ProductIDText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblProductType)
						.addComponent(ProductTypeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ProductPriceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProductPrice))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(DescriptionText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescription))
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnCancel))
					.addGap(7))
		);
		editProductFrame.getContentPane().setLayout(groupLayout);
}
	public ArrayList<ProductModel> getProductList() {
		return productList;
	}

	/**
	 * @param accountList the accountList to set
	 */
	public void setProductList(ArrayList<ProductModel> productList) {
		this.productList = productList;
	}
	private void initializeDeleteFrame() throws Exception  {
		
		  if(table.getSelectedRow()>0) {
			  ProductController c=new ProductController();
			  ProductModel p=new ProductModel();
			  
			 int jml=Integer.parseInt((String)table.getValueAt(table.getSelectedRow(),0));   
				  p.setProductId(jml);
	        		if(c.deleteProduct( p.getProductId(),p)) {
						JOptionPane.showMessageDialog(null, "Product Deleted Successfully");
					
							fillDataModel();
					
						
					}else {
					JOptionPane.showMessageDialog(null, "Product Deleted Failed");
					}
		  }
	}
	
	public void initializeAddProductFrm() {
			AddProductFrm = new JFrame();
		AddProductFrm.setTitle("Add New Product");
		AddProductFrm.setBounds(100, 100, 450, 300);
		AddProductFrm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel lblProductType = new JLabel("Product Type :");
		
		productTypeText = new JTextField("");
		productTypeText.setColumns(10);
		
		JLabel lblProductPrice = new JLabel("Product Price :");
		
		productPriceText = new JTextField("");
		productPriceText.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description :");
		
		productDescriptionText = new JTextField("");
		productDescriptionText.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		
		productQuantityText = new JTextField("");
		productQuantityText.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProductController productController=new ProductController();
				ProductModel productModel=new ProductModel();
				productModel.setProductType(productTypeText.getText());
				 double jml = Double.parseDouble(productPriceText.getText());
				productModel.setProductprice(jml);
				
				productModel.setProductDescription(productDescriptionText.getText());
				
				 int jml1 = Integer.parseInt(productQuantityText.getText());
				 productModel.setProductQuantity(jml1);
				
					try {
						productController.addProduct(productModel);
						JOptionPane.showMessageDialog(null, "Product Added Successfully");
						AddProductFrm.setVisible(false);
						fillDataModel();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null,e1);
					}
					
				
				 
				 
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddProductFrm.setVisible(false);
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(AddProductFrm.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(257, Short.MAX_VALUE)
					.addComponent(btnCancel)
					.addGap(18)
					.addComponent(btnSave)
					.addGap(25))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDescription)
						.addComponent(lblProductType)
						.addComponent(lblProductPrice)
						.addComponent(lblQuantity))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(productPriceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(productTypeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addComponent(productQuantityText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(productDescriptionText, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProductType)
						.addComponent(productTypeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProductPrice)
						.addComponent(productPriceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDescription)
						.addComponent(productDescriptionText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(productQuantityText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSave)
								.addComponent(btnCancel)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(lblQuantity)))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		AddProductFrm.getContentPane().setLayout(groupLayout);
	}

}
