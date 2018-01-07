package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controller.LoginController;
import model.UserModel;
import gui.AllAccount;
public class loginAdmin {

	private JFrame frmLoginPage;
	private JTextField usernameText;
	private JPasswordField passwordText;
	private JFrame frmManagementpage;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginAdmin window = new loginAdmin();
					window.frmLoginPage.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginPage = new JFrame();
		frmLoginPage.setTitle("Login Page");
		frmLoginPage.setBounds(100, 100, 580, 399);
		frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsername = new JLabel("username :*");
		
		JLabel lblPassword = new JLabel("Password :*");
		
		usernameText = new JTextField("");
		usernameText.setColumns(20);
		
		passwordText = new JPasswordField("");
		passwordText.setColumns(20);
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserModel u=new UserModel();
				LoginController c=new LoginController();

				u.setUsername(usernameText.getText());
				u.setPassword(String.valueOf(passwordText.getPassword()));
				
				
			
				if(	c.loginAdmin(u))
				{
					JOptionPane.showMessageDialog(null, "you  Login Successfully");
					frmLoginPage.setVisible(false);
					initializeManagementPage();
					frmManagementpage.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "login failed");
						
				}
				
			}});
				
		GroupLayout groupLayout = new GroupLayout(frmLoginPage.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(43, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPassword)
								.addComponent(lblUsername))
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordText)
								.addComponent(usernameText, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(236)
							.addComponent(button)))
					.addContainerGap(182, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(93)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(68)
					.addComponent(button)
					.addContainerGap(72, Short.MAX_VALUE))
		);
		
		frmLoginPage.getContentPane().setLayout(groupLayout);
	}
		
			
private void initializeManagementPage() {
	    frmManagementpage = new JFrame();
	    frmManagementpage.setTitle("Management Page");
		frmManagementpage.setBounds(100, 100, 601, 410);
		frmManagementpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JButton btnRentprocess = new JButton("RENT PROCESS");
			btnRentprocess.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rentProcess rentProcess=new rentProcess();
					rentProcess.initialize();
					rentProcess.frmRentProcess.setVisible(true);
				}
			});
			
			JButton btnAllAccount = new JButton("ALL ACCOUNT");
			btnAllAccount.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AllAccount allAccount=new AllAccount();
					allAccount.initialize();
					allAccount.frame.setVisible(true);
				}
			});
			
			JButton btnAllProduct = new JButton("ALL PROUDUCT");
			btnAllProduct.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						AllProduct allProduct=new AllProduct();
						allProduct.initialize();
						allProduct.frmAllProduct.setVisible(true);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					
				}
			});	
			GroupLayout groupLayout = new GroupLayout(frmManagementpage.getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(187)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btnRentprocess)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnAllAccount, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAllProduct, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addContainerGap(191, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(46)
						.addComponent(btnAllAccount, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnAllProduct, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnRentprocess, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGap(46))
			);
			frmManagementpage.getContentPane().setLayout(groupLayout);
			
		}
}
		
