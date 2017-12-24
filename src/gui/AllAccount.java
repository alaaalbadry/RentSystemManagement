package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.AccountController;
import model.AccountModel;

public class AllAccount {

	 public JFrame frame;
	ArrayList<AccountModel> accountList=new ArrayList<AccountModel>();
	private JScrollPane scrollPane;
	private AccountController accountController=new AccountController();
	private JTable table;
	private JFrame addAccountFrame;
	private JFrame editAccountFrame;
	private JTextField NatIDText;
	private JTextField NameText;
	private JTextField PhoneText;
	private JTextField EmailText;
	private JTextField AddressText;
	private JButton btnEditAccount;
	private JButton btnDeleteAccount;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllAccount window = new AllAccount();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AllAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	 public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 732, 503);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JButton btnAddNewAccount = new JButton("New Account");
		btnAddNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				initializeAddFrame();
				addAccountFrame.setVisible(true);	
				//call the add initialize method 
				}
		});
		
		scrollPane = new JScrollPane();
		
		btnEditAccount = new JButton("Edit Account");
		btnEditAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountModel accountModel= new AccountModel();
			    accountModel.setNatID((String)table.getModel().getValueAt( table.getSelectedRow(),0));	
				accountModel.setName((String)table.getModel().getValueAt( table.getSelectedRow(),1));	
				accountModel.setPhone((String)table.getModel().getValueAt( table.getSelectedRow(),2));	
				accountModel.setEmail((String)table.getModel().getValueAt( table.getSelectedRow(),3));
				accountModel.setAddress((String) table.getModel().getValueAt( table.getSelectedRow(),4));
				
				initializeEditFrame(accountModel);
				editAccountFrame.setVisible(true);
			}
		});
		
		btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent arg0) {
				 
				initializeDeleteFrame();
				
				}
		});	
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(118, Short.MAX_VALUE)
					.addComponent(btnAddNewAccount)
					.addGap(33)
					.addComponent(btnEditAccount)
					.addGap(26)
					.addComponent(btnDeleteAccount)
					.addGap(236))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 665, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddNewAccount)
						.addComponent(btnEditAccount)
						.addComponent(btnDeleteAccount))
					.addGap(58))
		);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		fillDataModel();
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public void fillDataModel() {
		  DefaultTableModel dtm = new DefaultTableModel();
	List<AccountModel>	list = accountController.getAllAccounts();
		dtm.setColumnIdentifiers(new String[] {
				"National Id", "Name", "Phone", "Email", "Adress"
			});
		for(AccountModel accountModel:list)
		{
			dtm.addRow(new String[] {accountModel.getNatID(),accountModel.getName(),accountModel.getPhone(),accountModel.getEmail(),accountModel.getAddress()});
		}
		  table.setModel(dtm);
	
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeDeleteFrame() {
		
		  if(table.getSelectedRow()>0) {
			  AccountController c=new AccountController();
			  AccountModel m=new AccountModel();
			  
				  m.setNatID((String) table.getValueAt(table.getSelectedRow(),0));
	        		if(c.deleteAccount( m.getNatID())) {
						JOptionPane.showMessageDialog(null, "Account Deleted Successfully");
						fillDataModel();
					}else {
					JOptionPane.showMessageDialog(null, "Account Deleted Failed");
					}
		  }
	}
	private void initializeAddFrame() {
		addAccountFrame = new JFrame();
		addAccountFrame.setBounds(100, 100, 519, 350);
		addAccountFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	
	
		JLabel lblNatid = new JLabel("NatID:");
		NatIDText = new JTextField("");
		NatIDText.setColumns(20);
		
		JLabel lblName = new JLabel("Name:");
		NameText = new JTextField("");
		NameText.setColumns(20);
		JLabel lblPhone = new JLabel("phone:");
		PhoneText = new JTextField("");
		PhoneText.setColumns(20);
		
		JLabel lblAddress = new JLabel("address:");
		EmailText = new JTextField("");
		EmailText.setColumns(20);
		JLabel lblEmail = new JLabel("email:");
		
		
		AddressText = new JTextField("");
		AddressText.setColumns(20);
		
		JButton btnSave = new JButton("save");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAccountFrame.setVisible(false);
			}});
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountModel m=new AccountModel();
				AccountController c=new AccountController();
				
				m.setNatID(NatIDText.getText());
				m.setName(NameText.getText());
				m.setPhone(PhoneText.getText());
				m.setEmail(EmailText.getText());
				m.setAddress(AddressText.getText());
				try {
					c.addAccount(m);
					JOptionPane.showMessageDialog(null, "Account Created Successfully");
					addAccountFrame.setVisible(false);
					fillDataModel();
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,e1);
				}
				
			}
			
		});
		GroupLayout groupLayout = new GroupLayout(addAccountFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPhone)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNatid)
											.addComponent(lblName)
											.addComponent(lblEmail))
										.addGap(78))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnCancel)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addComponent(lblAddress))
							.addGap(7)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(AddressText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(NatIDText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(PhoneText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(NameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnSave, Alignment.TRAILING))
								.addComponent(EmailText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(232, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNatid)
						.addComponent(NatIDText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(NameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhone)
						.addComponent(PhoneText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(EmailText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(AddressText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnCancel))
					.addGap(25))
		);
		addAccountFrame.getContentPane().setLayout(groupLayout);
	}

	private void initializeEditFrame(AccountModel accountModel) {
		editAccountFrame = new JFrame();
		editAccountFrame.setBounds(100, 100, 519, 350);
		editAccountFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	
	
		JLabel lblNatid = new JLabel("NatID:");
		NatIDText = new JTextField(accountModel.getNatID());
		NatIDText.setColumns(20);
		NatIDText.setEditable(false);
		NatIDText.setEnabled(false);
		JLabel lblName = new JLabel("Name:");
		NameText = new JTextField(accountModel.getName());
		NameText.setColumns(20);
		JLabel lblPhone = new JLabel("phone:");
		PhoneText = new JTextField(accountModel.getPhone());
		PhoneText.setColumns(20);
		
		JLabel lblAddress = new JLabel("address:");
		EmailText = new JTextField(accountModel.getEmail());
		EmailText.setColumns(20);
		JLabel lblEmail = new JLabel("email:");
		
		
		AddressText = new JTextField(accountModel.getAddress());
		AddressText.setColumns(20);
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editAccountFrame.setVisible(false);
			}});
		JButton btnSave = new JButton("save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountModel m=new AccountModel();
				AccountController c=new AccountController();
				
				m.setNatID(NatIDText.getText());
				m.setName(NameText.getText());
				m.setPhone(PhoneText.getText());
				m.setEmail(EmailText.getText());
				m.setAddress(AddressText.getText());
				try {
					c.editAccount(m);
					JOptionPane.showMessageDialog(null, "Account Eddited  Successfully");
					editAccountFrame.setVisible(false);
					fillDataModel();
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,e1);
				}
				
			}
			
		});
		GroupLayout groupLayout = new GroupLayout(editAccountFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPhone)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNatid)
											.addComponent(lblName)
											.addComponent(lblEmail))
										.addGap(78))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnCancel)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addComponent(lblAddress))
							.addGap(7)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(AddressText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(NatIDText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(PhoneText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(NameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnSave, Alignment.TRAILING))
								.addComponent(EmailText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(232, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNatid)
						.addComponent(NatIDText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(NameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhone)
						.addComponent(PhoneText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(EmailText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(AddressText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnCancel))
					.addGap(25))
		);
		editAccountFrame.getContentPane().setLayout(groupLayout);
	}

	/**
	 * @return the accountList
	 */
	public ArrayList<AccountModel> getAccountList() {
		return accountList;
	}

	/**
	 * @param accountList the accountList to set
	 */
	public void setAccountList(ArrayList<AccountModel> accountList) {
		this.accountList = accountList;
	}
}
