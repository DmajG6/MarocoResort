package guiLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controlLayer.*;
import modelLayer.*;
import java.awt.Color;

public class CustomerMenu extends JFrame {

	private CustomerController cstctr = new CustomerController();
	
	private JPanel contentPane;
	private JTextField txtf_ID;
	private JTextField txtf_password;
	private JTextField txtf_name;
	private JTextField txtf_country;
	private JTextField txtf_address;
	private JTextField txtf_phoneNumber;
	private JTextField txtf_email;
	private JTextField txtf_idType;
	private JTextField txtf_idNumber;
	private JTextField txtf_specialService;
	private JTextField txtf_roomID;
	private JTextField txtf_active;
	private Staff staff;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMenu frame = new CustomerMenu(new Staff());
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
	public CustomerMenu(Staff staff) {
		this.staff = staff;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 444);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setBounds(14, 79, 94, 14);
		contentPane.add(lblCustomerId);
		
		txtf_ID = new JTextField();
		txtf_ID.setBounds(139, 75, 116, 22);
		contentPane.add(txtf_ID);
		txtf_ID.setColumns(10);
		
		JButton btnFindByName = new JButton("Find");
		btnFindByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findCustomerByName();
			}
		});
		btnFindByName.setBounds(265, 125, 97, 25);
		contentPane.add(btnFindByName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(32, 108, 117, 16);
		contentPane.add(lblPassword);
		
		txtf_password = new JTextField();
		txtf_password.setBounds(139, 105, 116, 22);
		contentPane.add(txtf_password);
		txtf_password.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(32, 180, 97, 16);
		contentPane.add(lblAddress);
		
		txtf_address = new JTextField();
		txtf_address.setBounds(139, 177, 116, 22);
		contentPane.add(txtf_address);
		txtf_address.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(14, 207, 115, 16);
		contentPane.add(lblPhoneNumber);
		
		txtf_phoneNumber = new JTextField();
		txtf_phoneNumber.setBounds(139, 204, 116, 22);
		contentPane.add(txtf_phoneNumber);
		txtf_phoneNumber.setColumns(10);
		
		txtf_country = new JTextField();
		txtf_country.setBounds(139, 151, 116, 22);
		contentPane.add(txtf_country);
		txtf_country.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(32, 234, 76, 16);
		contentPane.add(lblEmail);
		
		txtf_email = new JTextField();
		txtf_email.setBounds(139, 231, 116, 22);
		contentPane.add(txtf_email);
		txtf_email.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createCustomer();
			}
		});
		btnCreate.setBounds(358, 74, 97, 25);
		contentPane.add(btnCreate);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(32, 130, 92, 14);
		contentPane.add(lblName);
		
		txtf_name = new JTextField();
		txtf_name.setBounds(139, 128, 116, 22);
		contentPane.add(txtf_name);
		txtf_name.setColumns(10);
		
		JLabel lblContry = new JLabel("Country");
		lblContry.setBounds(32, 155, 76, 14);
		contentPane.add(lblContry);
		
		JLabel lblIdType = new JLabel("ID Type");
		lblIdType.setBounds(32, 261, 66, 14);
		contentPane.add(lblIdType);
		
		JLabel lblIdNumber = new JLabel("ID Number");
		lblIdNumber.setBounds(22, 286, 76, 14);
		contentPane.add(lblIdNumber);
		
		txtf_idType = new JTextField();
		txtf_idType.setBounds(139, 258, 116, 20);
		contentPane.add(txtf_idType);
		txtf_idType.setColumns(10);
		
		txtf_idNumber = new JTextField();
		txtf_idNumber.setBounds(139, 283, 116, 20);
		contentPane.add(txtf_idNumber);
		txtf_idNumber.setColumns(10);
		
		JLabel lblSpecialService = new JLabel("Special Service");
		lblSpecialService.setBounds(14, 311, 115, 14);
		contentPane.add(lblSpecialService);
		
		txtf_specialService = new JTextField();
		txtf_specialService.setBounds(139, 308, 116, 20);
		contentPane.add(txtf_specialService);
		txtf_specialService.setColumns(10);
					
		JLabel lblRoomId = new JLabel("Room ID");
		lblRoomId.setBounds(32, 337, 76, 14);
		contentPane.add(lblRoomId);
		
		txtf_roomID = new JTextField();
		txtf_roomID.setBounds(139, 334, 116, 20);
		contentPane.add(txtf_roomID);
		txtf_roomID.setColumns(10);
		
		JLabel lblActive = new JLabel("Active");
		lblActive.setBounds(32, 365, 46, 14);
		contentPane.add(lblActive);
		
		txtf_active = new JTextField();
		txtf_active.setBounds(139, 362, 116, 20);
		contentPane.add(txtf_active);
		txtf_active.setColumns(10);
		
		JButton btnFindByID = new JButton("Find");
		btnFindByID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findCustomerByID();
			}
		});
		btnFindByID.setBounds(265, 75, 89, 23);
		contentPane.add(btnFindByID);
	
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenu(staff).setVisible(true);
				CustomerMenu.this.dispose();
			    }
			});
		btnMainMenu.setBounds(19, 17, 110, 29);
		contentPane.add(btnMainMenu);
	}
	
	private void findCustomerByName(){
		String input = txtf_name.getText();
		Customer customer = cstctr.findCustomerByName(input);
		if(customer!= null){
		txtf_ID.setText(""+customer.getCustomerID());
		txtf_password.setText(""+customer.getPassword());
		txtf_name.setText(""+customer.getName());
		txtf_country.setText(""+customer.getCountry());
		txtf_address.setText(""+customer.getAddress());
		txtf_phoneNumber.setText(""+customer.getPhoneNumber());
		txtf_email.setText(""+customer.getEmail());
		txtf_idType.setText(""+customer.getIdType());
		txtf_idNumber.setText(""+customer.getIdNumber());
		txtf_specialService.setText(""+customer.getSpecialService());
		txtf_roomID.setText(""+customer.getRoomID());
		txtf_active.setText(""+customer.getActive());
		}
	}
		
		private void findCustomerByID(){
			String input = txtf_ID.getText();
			Customer customer = cstctr.findCustomerByID(Integer.parseInt(input));
			if(customer!= null){
			txtf_ID.setText(""+customer.getCustomerID());
			txtf_password.setText(""+customer.getPassword());
			txtf_name.setText(""+customer.getName());
			txtf_country.setText(""+customer.getCountry());
			txtf_address.setText(""+customer.getAddress());
			txtf_phoneNumber.setText(""+customer.getPhoneNumber());
			txtf_email.setText(""+customer.getEmail());
			txtf_idType.setText(""+customer.getIdType());
			txtf_idNumber.setText(""+customer.getIdNumber());
			txtf_specialService.setText(""+customer.getSpecialService());
			txtf_roomID.setText(""+customer.getRoomID());
			txtf_active.setText(""+customer.getActive());
			
			}
	}
	
	private void createCustomer(){
		
		cstctr.createCustomer(Integer.parseInt(txtf_ID.getText()), txtf_password.getText(), txtf_name.getText(), txtf_country.getText(), txtf_address.getText(), txtf_phoneNumber.getText(), txtf_email.getText(), txtf_idType.getText(), txtf_idNumber.getText(),txtf_specialService.getText(), Integer.parseInt(txtf_roomID.getText()),txtf_active.getText());
		
	}
}
