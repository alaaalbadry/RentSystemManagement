package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controller.AccountController;
import model.UserModel;
import gui.AllAccount;
public class loginAdmin {

	private JFrame frame;
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
	public loginAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
				AccountController c=new AccountController();

				u.setUsername(usernameText.getText());
				u.setPassword(String.valueOf(passwordText.getPassword()));
				
				
			
				if(	c.loginAdmin(u))
				{
					JOptionPane.showMessageDialog(null, "you  Login Successfully");
					frame.setVisible(false);
					initializeManagementPage();
					frmManagementpage.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "login failed");
						
				}
				
			}});
				
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
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
		
		frame.getContentPane().setLayout(groupLayout);
	}
		
			
private void initializeManagementPage() {
			frmManagementpage = new JFrame();
			frmManagementpage.setTitle("ManagementPage");
			frmManagementpage.setBounds(100, 100, 601, 410);
			frmManagementpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JButton btnRentprocess = new JButton("Rent Process");
			btnRentprocess.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rentProcess rentProcess=new rentProcess();
					rentProcess.initialize();
					rentProcess.frmRentProcess.setVisible(true);
				}
			});
			
			JButton btnAllAccount = new JButton("All Account");
			btnAllAccount.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AllAccount allAccount=new AllAccount();
					allAccount.initialize();
					allAccount.frame.setVisible(true);
				}
			});
			
			JButton btnAllProduct = new JButton("All product");
			GroupLayout groupLayout = new GroupLayout(frmManagementpage.getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addContainerGap(141, Short.MAX_VALUE)
						.addComponent(btnAllProduct)
						.addGap(112)
						.addComponent(btnAllAccount)
						.addGap(142))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(203)
						.addComponent(btnRentprocess)
						.addContainerGap(273, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addContainerGap(178, Short.MAX_VALUE)
						.addComponent(btnRentprocess)
						.addGap(160))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(66)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAllAccount)
							.addComponent(btnAllProduct))
						.addContainerGap(272, Short.MAX_VALUE))
			);
			frmManagementpage.getContentPane().setLayout(groupLayout);
			
		}
}
		
