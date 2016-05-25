package guiLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelLayer.Apartment;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.LinkedList;
import java.awt.Choice;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class ReservationCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField IDNumber;
	private JTextField IDType;
	private JTextField address;
	private JTextField Country;
	private JTextField name;
	private String arrivalDate;
	private String departureDate;
	private Choice choice;
	private LinkedList<Apartment> apartments;
	private LinkedList<String> apartmentsInfo = new LinkedList<String>();
	private Apartment chosenApartment;
	private JTextField txtSpecialNeeds;
	private JTextField phoneNo;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationCustomer frame = new ReservationCustomer("25-01-2016", "26-02-2016", new LinkedList<Apartment>());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public ReservationCustomer(String arrivalDate, String departureDate, LinkedList<Apartment> apartments) {
		setTitle("Private Reservation");
		
		this.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(34, 39, 44, 16);
		contentPane.add(lblName);
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setBounds(22, 68, 56, 16);
		contentPane.add(lblCountry);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(22, 97, 56, 16);
		contentPane.add(lblAddress);
		
		JLabel lblIdtype = new JLabel("IdType:");
		lblIdtype.setBounds(332, 33, 62, 16);
		contentPane.add(lblIdtype);
		
		JLabel lblIdNumber = new JLabel("ID number:");
		lblIdNumber.setBounds(312, 62, 82, 16);
		contentPane.add(lblIdNumber);
		
		JLabel lblChooseARoom = new JLabel("Choose A Room:");
		lblChooseARoom.setBounds(270, 153, 102, 16);
		contentPane.add(lblChooseARoom);
		
		IDNumber = new JTextField();
		IDNumber.setBounds(406, 62, 116, 22);
		contentPane.add(IDNumber);
		IDNumber.setColumns(10);
		
		IDType = new JTextField();
		IDType.setBounds(406, 33, 116, 22);
		contentPane.add(IDType);
		IDType.setColumns(10);
		
		address = new JTextField();
		address.setBounds(112, 94, 116, 22);
		contentPane.add(address);
		address.setColumns(10);
		
		Country = new JTextField();
		Country.setBounds(112, 65, 116, 22);
		contentPane.add(Country);
		Country.setColumns(10);
		
		name = new JTextField();
		name.setBounds(112, 36, 116, 22);
		contentPane.add(name);
		name.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(119, 179, 97, 25);
		contentPane.add(btnAdd);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(22, 180, 86, 22);
		contentPane.add(btnExit);
		
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.apartments = apartments;
		
		choice = new Choice();
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				apartmentChosen();
			}
		});
		choice.setBounds(244, 182, 278, 22);
		contentPane.add(choice);
		
		JLabel lblSpecialNeeds = new JLabel("Special Needs:");
		lblSpecialNeeds.setBounds(22, 126, 85, 16);
		contentPane.add(lblSpecialNeeds);
		
		txtSpecialNeeds = new JTextField();
		txtSpecialNeeds.setBounds(109, 123, 121, 45);
		contentPane.add(txtSpecialNeeds);
		txtSpecialNeeds.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(343, 123, 39, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(291, 97, 90, 16);
		contentPane.add(lblPhoneNumber);
		
		phoneNo = new JTextField();
		phoneNo.setBounds(406, 94, 116, 22);
		contentPane.add(phoneNo);
		phoneNo.setColumns(10);
		
		email = new JTextField();
		email.setBounds(406, 123, 116, 22);
		contentPane.add(email);
		email.setColumns(10);
		
		apartmentsInfo();
		
		for(String info: apartmentsInfo){
			choice.add(info);
		}
		
		//apartmentChosen();
	}
	
	private void apartmentsInfo(){
		for(Apartment apa: apartments){
			String info = "Room ID: "+apa.getRoomID()+"; Floor: "+apa.getFloor()+"; "+ "Type: ";
			if(apa.getType().equals("single")){
				info = info + "Single";
			}else if(apa.getType().equals("family")){
				info = info + "Family";
			}
			info = info +"; Price: "+apa.getPrice();
			apartmentsInfo.add(info);
		}
	}
	
	private void apartmentChosen(){
		for(Apartment apa: apartments){
			if(apa.getRoomID() == Integer.parseInt(choice.getSelectedItem().substring(9, 12))){
				chosenApartment = apa;
			}
		}
	}
}
