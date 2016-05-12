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
import java.awt.Button;

public class StaffMenu extends JFrame {
	
	private StaffController sctr = new StaffController ();

	private JPanel contentPane;
	private JTextField txtf_Name;
	private JTextField txtf_StaffId;
	private JTextField txtf_Type;
	private JTextField txtf_Password;
	private JTextField txtf_Email;
	private JTextField txtf_WorkPhoneNumber;
	private JTextField txtf_PersonalPhoneNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffMenu frame = new StaffMenu();
					frame.setVisible(true);
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
		setBounds(100, 100, 500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtf_Name = new JTextField();
		txtf_Name.setBounds(176, 8, 127, 20);
		contentPane.add(txtf_Name);
		txtf_Name.setColumns(10);
		
		txtf_StaffId = new JTextField();
		txtf_StaffId.setBounds(176, 39, 127, 20);
		contentPane.add(txtf_StaffId);
		txtf_StaffId.setColumns(10);
		
		txtf_Type = new JTextField();
		txtf_Type.setBounds(176, 70, 127, 20);
		contentPane.add(txtf_Type);
		txtf_Type.setColumns(10);
		
		txtf_Password = new JTextField();
		txtf_Password.setBounds(176, 101, 127, 20);
		contentPane.add(txtf_Password);
		txtf_Password.setColumns(10);
		
		txtf_Email = new JTextField();
		txtf_Email.setBounds(176, 132, 127, 20);
		contentPane.add(txtf_Email);
		txtf_Email.setColumns(10);
		
		txtf_WorkPhoneNumber = new JTextField();
		txtf_WorkPhoneNumber.setBounds(176, 172, 127, 20);
		contentPane.add(txtf_WorkPhoneNumber);
		txtf_WorkPhoneNumber.setColumns(10);
		
		txtf_PersonalPhoneNumber = new JTextField();
		txtf_PersonalPhoneNumber.setBounds(176, 221, 127, 20);
		contentPane.add(txtf_PersonalPhoneNumber);
		txtf_PersonalPhoneNumber.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(22, 17, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(22, 42, 77, 14);
		contentPane.add(lblId);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(22, 73, 77, 14);
		contentPane.add(lblType);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(22, 104, 77, 17);
		contentPane.add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(22, 135, 77, 14);
		contentPane.add(lblEmail);
		
		JLabel lblWorkPhoneNumber = new JLabel("Work phone number");
		lblWorkPhoneNumber.setBounds(22, 166, 121, 33);
		contentPane.add(lblWorkPhoneNumber);
		
		JLabel lblPersonalPhoneNumber = new JLabel("Personal phone number");
		lblPersonalPhoneNumber.setBounds(22, 212, 121, 38);
		contentPane.add(lblPersonalPhoneNumber);
		
		JButton btnFindStaffByName = new JButton("Find Staff By Name");
		btnFindStaffByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				findStaffByName();
				
			}
		});
		btnFindStaffByName.setBounds(327, 17, 147, 51);
		contentPane.add(btnFindStaffByName);
		
		JButton btnFindStaffByID = new JButton("Find Staff By ID");
		btnFindStaffByID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findStaffByID();
			}
		});
		btnFindStaffByID.setBounds(327, 101, 147, 51);
		contentPane.add(btnFindStaffByID);
		
		JButton btnCreateStaff = new JButton("Create Staff");
		btnCreateStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createStaff();
			}
		});
		btnCreateStaff.setBounds(327, 192, 147, 49);
		contentPane.add(btnCreateStaff);
	}

	private void findStaffByName(){
		String input = txtf_Name.getText();
		Staff staff = sctr.findStaffByName(input);
		if(staff!= null){
		txtf_Name.setText(""+staff.getName());
		txtf_StaffId.setText(""+staff.getStaffID());
		txtf_Type.setText(""+staff.getStaffType());
		txtf_Password.setText(""+staff.getPassword());
		txtf_Email.setText(""+staff.getEmail());
		txtf_PersonalPhoneNumber.setText(""+staff.getPersonalPhoneNumber());
		txtf_WorkPhoneNumber.setText(""+staff.getWorkPhoneNumber());
		}
	}
	
	private void findStaffByID(){
		String input = txtf_StaffId.getText();
		Staff staff = sctr.findStaffByID(Integer.parseInt(input));
		if(staff!= null){
			txtf_Name.setText(""+staff.getName());
			txtf_StaffId.setText(""+staff.getStaffID());
			txtf_Type.setText(""+staff.getStaffType());
			txtf_Password.setText(""+staff.getPassword());
			txtf_Email.setText(""+staff.getEmail());
			txtf_PersonalPhoneNumber.setText(""+staff.getPersonalPhoneNumber());
			txtf_WorkPhoneNumber.setText(""+staff.getWorkPhoneNumber());
		}
	}
	private void createStaff(){
		sctr.createStaff(txtf_Name.getText(),Integer.parseInt(txtf_StaffId.getText()), txtf_Type.getText(), txtf_Password.getText(), txtf_Email.getText(), txtf_PersonalPhoneNumber.getText(), txtf_WorkPhoneNumber.getText() );
	}
}
