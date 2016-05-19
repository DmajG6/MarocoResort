package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlLayer.CustomerController;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import controlLayer.*;
import modelLayer.*;

public class AgencyManu extends JFrame {
	
	private AgencyController agnc = new AgencyController();

	private JPanel contentPane;
	private JTextField textF_AgencyID;
	private JTextField textF_Name;
	private JTextField textF_Address;
	private JTextField textF_CVR;
	private JTextField textF_Country;
	private JTextField textF_Email;
	private JTextField textF_Phone;
	private JTextField textF_ExtraInfo;
	private JTextField textF_Discount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgencyManu frame = new AgencyManu();
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
	public AgencyManu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(10, 11, 89, 23);
		contentPane.add(btnMainMenu);
		
		JLabel lblAgencyid = new JLabel("AgencyID");
		lblAgencyid.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAgencyid.setBounds(10, 60, 60, 14);
		contentPane.add(lblAgencyid);
		
		textF_AgencyID = new JTextField();
		textF_AgencyID.setBounds(69, 57, 86, 20);
		contentPane.add(textF_AgencyID);
		textF_AgencyID.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(10, 88, 60, 14);
		contentPane.add(lblName);
		
		textF_Name = new JTextField();
		textF_Name.setColumns(10);
		textF_Name.setBounds(69, 85, 86, 20);
		contentPane.add(textF_Name);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setBounds(10, 113, 60, 14);
		contentPane.add(lblAddress);
		
		textF_Address = new JTextField();
		textF_Address.setColumns(10);
		textF_Address.setBounds(69, 110, 86, 20);
		contentPane.add(textF_Address);
		
		JLabel lblCvr = new JLabel("CVR \u2116");
		lblCvr.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCvr.setBounds(10, 141, 60, 14);
		contentPane.add(lblCvr);
		
		textF_CVR = new JTextField();
		textF_CVR.setColumns(10);
		textF_CVR.setBounds(69, 138, 86, 20);
		contentPane.add(textF_CVR);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCountry.setBounds(10, 169, 60, 14);
		contentPane.add(lblCountry);
		
		textF_Country = new JTextField();
		textF_Country.setColumns(10);
		textF_Country.setBounds(69, 166, 86, 20);
		contentPane.add(textF_Country);
		
		JLabel lblEMail = new JLabel("e - mail");
		lblEMail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEMail.setBounds(10, 200, 60, 14);
		contentPane.add(lblEMail);
		
		textF_Email = new JTextField();
		textF_Email.setColumns(10);
		textF_Email.setBounds(69, 197, 86, 20);
		contentPane.add(textF_Email);
		
		JLabel lblPhone = new JLabel("Phone \u2116");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhone.setBounds(10, 231, 60, 14);
		contentPane.add(lblPhone);
		
		textF_Phone = new JTextField();
		textF_Phone.setBounds(69, 228, 86, 20);
		contentPane.add(textF_Phone);
		textF_Phone.setColumns(10);
		
		JLabel lblExtraInfo = new JLabel("Extra Info");
		lblExtraInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExtraInfo.setBounds(10, 256, 60, 14);
		contentPane.add(lblExtraInfo);
		
		textF_ExtraInfo = new JTextField();
		textF_ExtraInfo.setBounds(69, 256, 86, 20);
		contentPane.add(textF_ExtraInfo);
		textF_ExtraInfo.setColumns(10);
		
		JLabel lblDiscount = new JLabel("Discount");
		lblDiscount.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDiscount.setBounds(10, 284, 60, 14);
		contentPane.add(lblDiscount);
		
		textF_Discount = new JTextField();
		textF_Discount.setBounds(69, 281, 86, 20);
		contentPane.add(textF_Discount);
		textF_Discount.setColumns(10);
		
		JButton btnFind_ID = new JButton("Find");
		btnFind_ID.setBounds(165, 56, 89, 23);
		contentPane.add(btnFind_ID);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(264, 56, 89, 23);
		contentPane.add(btnCreate);
		
		JButton btnFind_Name = new JButton("Find");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findAgencyByName();
			}
		});
		btnFind_Name.setBounds(165, 84, 89, 23);
		contentPane.add(btnFind_Name);
	}
	
	private void findAgencyByName(){
		String input = textF_Name.getText();
		Agency agency = agnc.findAgencyByName(input);
		if(agency!= null){
			textF_AgencyID.setText(""+agency.getAgencyID());
			textF_Name.setText(""+agency.getName());
			textF_Address.setText(""+agency.getAddress());
			textF_CVR.setText(""+agency.getCvrNumber());
			textF_Country.setText(""+agency.getCountry());
			textF_Phone.setText(""+agency.getPhoneNumber());
			textF_ExtraInfo.setText(""+agency.getExtraInfo());
			textF_Discount.setText(""+agency.getDiscount());
		}
	}
}
