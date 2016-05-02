package guiLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class StaffMenu {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtStaffId;
	private JTextField txtType;
	private JTextField txtPassword;
	private JTextField txtEmail;
	private JTextField txtWorkPhoneNumber;
	private JTextField txtPersonalPhoneNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffMenu window = new StaffMenu();
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
	public StaffMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(176, 11, 127, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtStaffId = new JTextField();
		txtStaffId.setBounds(176, 39, 127, 20);
		frame.getContentPane().add(txtStaffId);
		txtStaffId.setColumns(10);
		
		txtType = new JTextField();
		txtType.setBounds(176, 70, 127, 20);
		frame.getContentPane().add(txtType);
		txtType.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(176, 101, 127, 20);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(176, 132, 127, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtWorkPhoneNumber = new JTextField();
		txtWorkPhoneNumber.setBounds(176, 163, 127, 20);
		frame.getContentPane().add(txtWorkPhoneNumber);
		txtWorkPhoneNumber.setColumns(10);
		
		txtPersonalPhoneNumber = new JTextField();
		txtPersonalPhoneNumber.setBounds(176, 194, 127, 20);
		frame.getContentPane().add(txtPersonalPhoneNumber);
		txtPersonalPhoneNumber.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(22, 17, 77, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(22, 42, 77, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(22, 73, 77, 14);
		frame.getContentPane().add(lblType);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(22, 104, 77, 17);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(22, 135, 77, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblWorkPhoneNumber = new JLabel("Work phone number");
		lblWorkPhoneNumber.setBounds(22, 166, 97, 14);
		frame.getContentPane().add(lblWorkPhoneNumber);
		
		JLabel lblPersonalPhoneNumber = new JLabel("Personal phone number");
		lblPersonalPhoneNumber.setBounds(22, 197, 113, 17);
		frame.getContentPane().add(lblPersonalPhoneNumber);
	}
}
