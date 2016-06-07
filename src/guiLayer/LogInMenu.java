package guiLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import controlLayer.CustomerController;
import controlLayer.LogInControl;
import controlLayer.StaffController;
import modelLayer.Customer;
import modelLayer.Staff;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

/**
	May 18, 2016 - 12:43:59 PM
*/

public class LogInMenu extends JFrame {

	private JPanel contentPane;
	private JTextField ID_Field;
	private LogInControl control = new LogInControl();
	private String password;
	private String idCode;
	private JPasswordField Password;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInMenu frame = new LogInMenu();
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
	public LogInMenu() {
		setTitle("Program - Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Log In");
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setFont(new Font("Tahoma", Font.ITALIC, 50));
		lblLogin.setBounds(199, 13, 205, 111);
		contentPane.add(lblLogin);
		
		ID_Field = new JTextField();
		ID_Field.setBounds(199, 140, 184, 39);
		contentPane.add(ID_Field);
		ID_Field.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setBackground(new Color(255, 255, 255));
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(159, 142, 28, 28);
		contentPane.add(lblId);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(96, 194, 91, 28);
		contentPane.add(lblPassword);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBackground(new Color(204, 255, 204));
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonPressed();
			}
		});
		btnLogIn.setBounds(199, 244, 184, 39);
		contentPane.add(btnLogIn);
		
		Password = new JPasswordField();
		Password.setBounds(199, 192, 184, 39);
		contentPane.add(Password);
	}
	
	private void buttonPressed(){
		password = String.valueOf(Password.getPassword());
		idCode = ID_Field.getText();
		
		switch(control.checkLogIn(idCode, password)){
			case 1:
				StaffController staffCtr = new StaffController();
				Staff staff = staffCtr.findStaffByID(Integer.parseInt(idCode));
				new MainMenu(staff).setEnabled(true);
				this.dispose();
				return;
			case 2:
				CustomerController cusCtr = new CustomerController();
				Customer cust = cusCtr.findCustomerByID(Integer.parseInt(idCode));
				new BookingMenu(cust, 2).setEnabled(true);
				this.dispose();
				return;
			case -1:
				
				//unknown login
				
				return;
			default:
				System.out.println("ButtonPressed() Failed");
		}
		
	}
}
