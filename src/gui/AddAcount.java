package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.AccountController;
import model.AccountModel;
public class AddAcount {

	private JFrame frame;
	private JTextField NatIDText;
	private JTextField NameText;
	private JTextField PhoneText;
	private JTextField EmailText;
	private JTextField AddressText;
	private	AllAccount allAccount;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAcount window = new AddAcount(null);
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
	public AddAcount(AllAccount account) {
		initialize();
		this.allAccount=account;
		this.frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 519, 350);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	
	
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
			frame.setVisible(false);
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
					frame.setVisible(false);
					allAccount.fillDataModel();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
				
			}
			
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
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
		frame.getContentPane().setLayout(groupLayout);
	}
}
