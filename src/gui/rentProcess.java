package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

import javax.swing.LayoutStyle.ComponentPlacement;


import controller.RentProcessController;
import dto.RentProcessDTO;
import model.AccountModel;
import model.ProductModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class rentProcess {

	public JFrame frmRentProcess;
	private JTextField NatIDText;
	private JTextField TypeText;
	private JTextField SDText;
	private JTextField QuantityText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rentProcess window = new rentProcess();
					window.frmRentProcess.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public rentProcess() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmRentProcess = new JFrame();
		frmRentProcess.setTitle("Rent Process");
		frmRentProcess.setBounds(100, 100, 623, 377);
		frmRentProcess.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel lblNatid = new JLabel("NID :");
		
		NatIDText = new JTextField("");
		NatIDText.setColumns(10);
		
		JLabel lblType = new JLabel("Product Type :");
		
		TypeText = new JTextField("");
		TypeText.setColumns(10);
		
		JLabel lblSd = new JLabel("Duration :");
		
		SDText = new JTextField("");
		SDText.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		
		QuantityText = new JTextField("");
		QuantityText.setColumns(10);
		
		JButton btnSave = new JButton("save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RentProcessController rentProcessController=new RentProcessController();
				AccountModel accountModel= new AccountModel();
				accountModel.setNatID(NatIDText.getText());
				ProductModel productModel=new ProductModel();
				productModel.setProductType(TypeText.getText());
				RentProcessDTO  rentProcessDTO=new RentProcessDTO();
				 int jml = Integer.parseInt(SDText.getText());
		           rentProcessDTO.setSDRent(jml);
				int jml2=Integer.parseInt(QuantityText.getText());
				rentProcessDTO.setQuantity(jml2);
				try {
				Double total=	rentProcessController.RentProcess( rentProcessDTO, accountModel.getNatID(), productModel.getProductType());
					JOptionPane.showMessageDialog(null, "Rent Processed Successfully The total payed ammount ="+total+" EGP");
					} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Enter correctData");
					JOptionPane.showMessageDialog(null, e.getMessage());
					
				}
				
			}
		});
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmRentProcess.setVisible(false);
			}
		});
		
		JLabel lblHours = new JLabel("Hours");
		
		GroupLayout groupLayout = new GroupLayout(frmRentProcess.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNatid)
						.addComponent(lblType)
						.addComponent(lblSd)
						.addComponent(lblQuantity)
						.addComponent(btnSave))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancel)
						.addComponent(QuantityText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(NatIDText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(TypeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(SDText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblHours)))
					.addContainerGap(278, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNatid)
						.addComponent(NatIDText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblType)
						.addComponent(TypeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSd)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(SDText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblHours)))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantity)
						.addComponent(QuantityText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnCancel))
					.addGap(22))
		);
		frmRentProcess.getContentPane().setLayout(groupLayout);
	}
}
