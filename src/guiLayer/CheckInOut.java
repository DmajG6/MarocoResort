package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

import modelLayer.Customer;
import modelLayer.Staff;
import controlLayer.CustomerController;
import java.awt.Color;


/**
	May 20, 2016 - 11:18:41 AM
*/

public class CheckInOut extends JFrame {

	private JPanel contentPane;
	private JTextField customerID;
	private JTextField name;
	private JTextField status;
	private Customer customer = null;
	private CustomerController cusctr = new CustomerController();
	private JButton btnCheckInout;
	private JTextField NewPass;
	private JLabel lblNewPassword;
	private Staff staff = null;
	private JButton btnExit;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckInOut frame = new CheckInOut(new Staff());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/** 
	 * Create the frame.
	 */
	public CheckInOut(Staff staff) {
		setTitle("Program - Check In/Out");
		this.staff = staff;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 361);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCheckInout = new JLabel("Check In/Out");
		lblCheckInout.setForeground(new Color(255, 255, 255));
		lblCheckInout.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckInout.setFont(new Font("Tahoma", Font.ITALIC, 44));
		lblCheckInout.setBounds(63, 13, 404, 84);
		contentPane.add(lblCheckInout);
		
		customerID = new JTextField();
		customerID.setBounds(147, 147, 116, 22);
		contentPane.add(customerID);
		customerID.setColumns(10);
		
		JButton btnFindCustomer = new JButton("Find Customer");
		btnFindCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				findCustomerByID();
			}
		});
		btnFindCustomer.setBounds(284, 146, 116, 25);
		contentPane.add(btnFindCustomer);
		
		JLabel lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setBounds(49, 150, 96, 16);
		contentPane.add(lblCustomerId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(100, 182, 45, 16);
		contentPane.add(lblName);
		
		JLabel lblCheckedIn = new JLabel("Checked In:");
		lblCheckedIn.setBounds(63, 222, 76, 16);
		contentPane.add(lblCheckedIn);
		
		name = new JTextField();
		name.setBounds(147, 179, 116, 22);
		contentPane.add(name);
		name.setColumns(10);
		
		status = new JTextField();
		status.setEditable(false);
		status.setBounds(147, 219, 116, 22);
		contentPane.add(status);
		status.setColumns(10);
		
		JButton btnFindCustomerName = new JButton("Find Customer");
		btnFindCustomerName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findCustomerByName();
			}
		});
		btnFindCustomerName.setBounds(284, 178, 116, 25);
		contentPane.add(btnFindCustomerName);
		
		btnCheckInout = new JButton("Check In/Out");
		btnCheckInout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkInOut();
			}
		});
		btnCheckInout.setEnabled(false);
		btnCheckInout.setBounds(288, 211, 116, 39);
		contentPane.add(btnCheckInout);
		
		lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setEnabled(false);
		lblNewPassword.setBounds(30, 266, 116, 16);
		contentPane.add(lblNewPassword);
		
		NewPass = new JTextField();
		NewPass.setEnabled(false);
		NewPass.setEditable(false);
		NewPass.setBounds(147, 263, 116, 22);
		contentPane.add(NewPass);
		NewPass.setColumns(10);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exitPressed();
			}
		});
		btnExit.setBounds(303, 262, 97, 25);
		contentPane.add(btnExit);
	}
	
	private void findCustomerByID(){
		customer = cusctr.findCustomerByID(Integer.parseInt(customerID.getText()));
		activateButton();
		name.setText(customer.getName());
	}
	
	private void findCustomerByName(){
		customer = cusctr.findCustomerByName(name.getText());
		activateButton();
		customerID.setText(""+customer.getCustomerID());
	}
	
	private void activateButton(){
		if(customer != null){
			btnCheckInout.setEnabled(true);
		}
	}
	
	private void checkInOut(){
		if(customer.getPassword().equals(null)){
			String newPassword = "";
			Random rand = new Random();
			for(int i = 0; i < 6; i++){
				newPassword += ""+rand.nextInt(10);
			}
			System.out.println("Password: "+newPassword);
			cusctr.setNewPassword(newPassword, customer);
			lblNewPassword.setEnabled(true);
			NewPass.setEnabled(true);
			NewPass.setText(newPassword);
		}
		cusctr.checkInOut(customer.getCustomerID(), !customer.getActive().equals("yes"));
	}
	
	private void exitPressed(){
		new MainMenu(staff);
		this.dispose();
	}
}
