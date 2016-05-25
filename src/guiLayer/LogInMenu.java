package guiLayer;

import java.awt.BorderLayout;
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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Log In");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
		lblLogin.setBounds(199, 13, 205, 111);
		contentPane.add(lblLogin);
		
		ID_Field = new JTextField();
		ID_Field.setBounds(199, 140, 184, 39);
		contentPane.add(ID_Field);
		ID_Field.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(159, 142, 28, 28);
		contentPane.add(lblId);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(96, 194, 91, 28);
		contentPane.add(lblPassword);
		
		JButton btnLogIn = new JButton("Log In");
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
		password = Password.getText();
		idCode = ID_Field.getText();
		
		switch(control.checkLogIn(idCode, password)){
			case 1:
				new MainMenu(new StaffController().findStaffByID(Integer.parseInt(idCode)));
				dispose();
				return;
			case 2:
				new BookingMenu(new CustomerController().findCustomerByID(Integer.parseInt(idCode)), 2);
				dispose();
				return;
			case -1:
				
				//unknown login
				
				return;
			default:
				System.out.println("ButtonPressed() Failed");
		}
		
	}
}
