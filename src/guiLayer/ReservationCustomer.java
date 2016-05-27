package guiLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelLayer.Apartment;
import modelLayer.Customer;
import modelLayer.Staff;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.LinkedList;
import java.awt.Choice;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ReservationCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField IDNumber;
	private JTextField IDType;
	private JTextField address;
	private JTextField Country;
	private JTextField name;
	private Choice choice;
	private LinkedList<Apartment> apartments;
	private LinkedList<String> apartmentsInfo = new LinkedList<String>();
	private Apartment chosenApartment;
	private JTextField txtSpecialNeeds;
	private JTextField phoneNo;
	private JTextField email;
	private ReservationMenu menu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationCustomer frame = new ReservationCustomer(new LinkedList<Apartment>(), new ReservationMenu(new Staff()));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public ReservationCustomer(LinkedList<Apartment> apartments, ReservationMenu menu) {
		setTitle("Private Reservation");
		
		this.menu = menu;
		
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
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCustomer();
			}
		});
		btnAdd.setBounds(119, 179, 97, 25);
		contentPane.add(btnAdd);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitCalled();
			}
		});
		btnExit.setBounds(22, 180, 86, 22);
		contentPane.add(btnExit);
		
		this.apartments = apartments;
		
		choice = new Choice();
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				apartmentChosen();
			}
		});
		choice.setBounds(222, 182, 311, 22);
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
	
	private void addCustomer(){
		
		Customer customer = new Customer();
		customer.setActive("no");
		customer.setCountry(Country.getText());
		customer.setName(name.getText());
		customer.setEmail(email.getText());
		customer.setAddress(address.getText());
		customer.setPhoneNumber(phoneNo.getText());
		customer.setRoomID(chosenApartment.getRoomID());
		customer.setIdType(IDType.getText());
		customer.setIdNumber(IDNumber.getText());
		customer.setSpecialService(txtSpecialNeeds.getText());
		
		menu.setEnabled(true);
		this.dispose();
		menu.addCustomer(customer);
	}
	
	private void exitCalled(){
		menu.setEnabled(true);
		
		this.dispose();
		
	}
}
