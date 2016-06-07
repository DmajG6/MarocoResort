package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlLayer.CustomerController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

import controlLayer.*;
import modelLayer.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.awt.Choice;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Button;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;

public class ReservationMenu extends JFrame {
	
	private ApartmentController apCtr = new ApartmentController();
	
	private Staff loggedInStaff;
	private JPanel contentPane;
	private JTextField ArrivalDate;
	private JTextField DepartureDate;
	private JTextField freeSingleRooms;
	private JTextField freeFamilyRooms;
	private String arrivalDate = null;
	private String departureDate = null;
	private LinkedList<Apartment> apartments = new LinkedList<Apartment>();
	private JTextField staffText;
	private JTextField numberOfDaysTXT;
	private JTextField priceTxt;
	private JTable table;
	private AgencyController ageCtr = new AgencyController();
	private LinkedList<Agency> agencies = new LinkedList<Agency>();
	private Choice choiceAgency;
	private Agency selectedAgency;
	private LinkedList<Customer> customers = new LinkedList<Customer>();
	private double price = 0;
	private LinkedList<Apartment> usedApartments = new LinkedList<Apartment>();
	private int numberOfDays = 0;
	private DefaultTableModel model;
	private ReservationOfStayController resCtr = new ReservationOfStayController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationMenu frame = new ReservationMenu(new Staff());
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
	public ReservationMenu(Staff staff) {
		this.loggedInStaff = staff;
		setTitle("Program - Reservation of Stay");
		loggedInStaff = staff;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1017, 643);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnArrivalDate = new JButton("Arrival Date");
		btnArrivalDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getArrivalDate();
			}
		});
		btnArrivalDate.setBounds(306, 13, 125, 25);
		contentPane.add(btnArrivalDate);
		
		JButton btnDepartureDate = new JButton("Departure Date");
		btnDepartureDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDepartureDate();
			}
		});
		btnDepartureDate.setBounds(564, 13, 125, 25);
		contentPane.add(btnDepartureDate);
		
		ArrivalDate = new JTextField();
		ArrivalDate.setEditable(false);
		ArrivalDate.setBounds(190, 13, 116, 23);
		contentPane.add(ArrivalDate);
		ArrivalDate.setColumns(10);
		
		DepartureDate = new JTextField();
		DepartureDate.setEditable(false);
		DepartureDate.setBounds(448, 14, 116, 22);
		contentPane.add(DepartureDate);
		DepartureDate.setColumns(10);
		
		JLabel lblNumberOfFree = new JLabel("Number of free rooms during selected period:");
		lblNumberOfFree.setBounds(717, 13, 270, 16);
		contentPane.add(lblNumberOfFree);
		
		JLabel lblSingle = new JLabel("Single:");
		lblSingle.setBounds(746, 50, 56, 16);
		contentPane.add(lblSingle);
		
		JLabel lblFamily = new JLabel("Family:");
		lblFamily.setBounds(746, 79, 56, 16);
		contentPane.add(lblFamily);
		
		freeSingleRooms = new JTextField();
		freeSingleRooms.setEditable(false);
		freeSingleRooms.setBounds(806, 47, 116, 22);
		contentPane.add(freeSingleRooms);
		freeSingleRooms.setColumns(10);
		
		freeFamilyRooms = new JTextField();
		freeFamilyRooms.setEditable(false);
		freeFamilyRooms.setBounds(806, 79, 116, 22);
		contentPane.add(freeFamilyRooms);
		freeFamilyRooms.setColumns(10);
		
		JLabel staffLabel = new JLabel("Staff:");
		staffLabel.setBounds(27, 13, 56, 16);
		contentPane.add(staffLabel);
		
		staffText = new JTextField();
		staffText.setEditable(false);
		staffText.setBounds(27, 43, 116, 22);
		contentPane.add(staffText);
		staffText.setColumns(10);
		
		JLabel lblNumberOfDays = new JLabel("Number Of Days:");
		lblNumberOfDays.setBounds(27, 205, 116, 16);
		contentPane.add(lblNumberOfDays);
		
		numberOfDaysTXT = new JTextField();
		numberOfDaysTXT.setEditable(false);
		numberOfDaysTXT.setBounds(27, 234, 116, 22);
		contentPane.add(numberOfDaysTXT);
		numberOfDaysTXT.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(27, 269, 56, 16);
		contentPane.add(lblPrice);
		
		priceTxt = new JTextField();
		priceTxt.setEditable(false);
		priceTxt.setBounds(27, 298, 116, 22);
		contentPane.add(priceTxt);
		priceTxt.setColumns(10);
		
		JLabel lblAgency = new JLabel("Agency:");
		lblAgency.setBounds(30, 139, 56, 16);
		contentPane.add(lblAgency);
		
		choiceAgency = new Choice();
		getAgencies();
		choiceAgency.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				agencySelected();
			}
		});
		choiceAgency.setBounds(27, 170, 119, 23);
		contentPane.add(choiceAgency);
		
		choiceAgency.add("----");
		
		agencySelected();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 121, 784, 462);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(51, 153, 153));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Country", "Address", "Phone Number", "Email", "Room ID", "ID Type", "ID Number", "Special Needs"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addButtonPressed();
			}
		});
		btnAddCustomer.setBounds(190, 96, 150, 25);
		contentPane.add(btnAddCustomer);
		
		JButton btnRemoveCustomer = new JButton("Remove Customer");
		btnRemoveCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeCustomerPressed();
			}
		});
		btnRemoveCustomer.setBounds(345, 96, 150, 25);
		contentPane.add(btnRemoveCustomer);
		
		JButton btnChangeCustomer = new JButton("Change Customer");
		btnChangeCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateCustomer();
			}
		});
		btnChangeCustomer.setBounds(500, 96, 150, 25);
		contentPane.add(btnChangeCustomer);
		
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookPressed();
			}
		});
		btnBook.setBounds(35, 488, 97, 25);
		contentPane.add(btnBook);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitPressed();
			}
		});
		btnExit.setBounds(35, 526, 97, 25);
		contentPane.add(btnExit);
		
		staffText.setText(loggedInStaff.getName());
		
		
		model = (DefaultTableModel) table.getModel();
	}
	
	private void getArrivalDate(){
		new ReservationOfStayDate(this, 1);
	}
	
	private void getDepartureDate(){
		new ReservationOfStayDate(this, 2);
	}
	
	private void checkBoth(){
		if((arrivalDate != null)&&(departureDate != null)){
			findAvailableRooms();
		}
	}
	
	private void getNumberOfDays(){
		LinkedList<String> allDays = apCtr.getAllDays(arrivalDate, departureDate);
		numberOfDays = allDays.size();
		numberOfDaysTXT.setText(""+numberOfDays);
	}
	
	private void findAvailableRooms(){
		getNumberOfDays();
		apartments = apCtr.getAllFreeApartmentsForPeriod(arrivalDate, departureDate);
		
		int freeSingle = 0;
		int freeFamily = 0;
		
		for(Apartment ap: apartments){
			if(ap.getType().equals("single")){
				freeSingle++;
			}else if(ap.getType().equals("family")){
				freeFamily++;
			}
		}
		freeSingleRooms.setText(""+freeSingle);
		freeFamilyRooms.setText(""+freeFamily);
	}
	
	public void setArrivalDate(String date){
		this.arrivalDate = date;
		ArrivalDate.setText(arrivalDate);
		checkBoth();
	}
	
	public void setDepartureDate(String date){
		this.departureDate = date;
		DepartureDate.setText(departureDate);
		checkBoth();
	}
	
	private void getAgencies(){
		agencies = ageCtr.getAllAgencys();
		
		for(Agency age: agencies){
			choiceAgency.add(age.getName()+" : "+age.getCountry());
		}
		
	}
	
	private void agencySelected(){
		if(!choiceAgency.getSelectedItem().equals("----")){
			for(Agency age: agencies){
				if((age.getName()+" : "+age.getCountry()).equals(choiceAgency.getSelectedItem())){
					System.out.println(age.getName()+" : "+age.getCountry()+" // "+choiceAgency.getSelectedItem());
					selectedAgency = age;
				}
			}
		}else{
			selectedAgency = new Agency(-1);
		}
	}
	
	public void addCustomer(Customer customer){
		customers.add(customer);
		
		model.addRow(new String[]{customer.getName(), customer.getCountry(), customer.getAddress(), customer.getPhoneNumber(), customer.getEmail(), ""+customer.getRoomID(), customer.getIdType(), customer.getIdNumber(), customer.getSpecialService()});
		
		setPriceAndUsedApartments();
		
		
	}
	
	private void updateCustomer(){
		
		for(int i = 0; i<model.getRowCount(); i++){
			customers.get(i).setName(model.getValueAt(i, 0).toString());
			customers.get(i).setCountry(model.getValueAt(i, 1).toString());
			customers.get(i).setAddress(model.getValueAt(i, 2).toString());
			customers.get(i).setPhoneNumber(model.getValueAt(i, 3).toString());
			customers.get(i).setEmail(model.getValueAt(i, 4).toString());
			customers.get(i).setIdType(model.getValueAt(i, 6).toString());
			customers.get(i).setIdNumber(model.getValueAt(i, 7).toString());
			customers.get(i).setSpecialService(model.getValueAt(i, 8).toString());
		}
		
	}
	
	private void addButtonPressed(){
		new ReservationCustomer(apartments, this);
		this.setEnabled(false);
	}
	
	private void setPriceAndUsedApartments(){
		
		for(int i = 0; i<customers.size(); i++){
			Customer cus = customers.get(i);
			for(int e = 0; e< apartments.size(); e++){
				Apartment apa= apartments.get(e);
				if(apa.getRoomID() == cus.getRoomID()){
					if(!usedApartments.contains(apa)){
						usedApartments.add(apa);
						price += apa.getPrice();
						apartments.remove(apa);
						if(apa.getType().equals("single")){
							freeSingleRooms.setText(""+(Integer.parseInt(freeSingleRooms.getText()) - 1));
						}else if(apa.getType().equals("family")){
							checkFamilyApartmentFullness(apa);
						}
					}
				}
			}
		}
		
		price *= numberOfDays;
		
		price *= (1-selectedAgency.getDiscount());
		
		priceTxt.setText(""+price);
	}
	
	private void checkFamilyApartmentFullness(Apartment apa){
		
			int count = 0;
			
			for(Customer cus: customers){
				if(cus.getRoomID() == apa.getRoomID()){
					count++;
				}
			}
			if(count >= 5){
				apartments.remove(apa);
			}
	}
	
	private void exitPressed(){
		new MainMenu(loggedInStaff);
		this.dispose();
	}
	
	private void bookPressed(){
		
		if(!checkRoomBookingPressed()){
			refreshApartments();
		}else{
			String currentDate = "";
		
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Calendar cal = Calendar.getInstance();
		
			currentDate = df.format(cal.getTime());
		
			resCtr.createReservationOfStay(numberOfDays, arrivalDate, departureDate, "//payment info", "not confirmed", currentDate, selectedAgency.getDiscount(), price, loggedInStaff, customers, selectedAgency);
		}
	}
	
	private boolean checkRoomBookingPressed(){
		LinkedList<Apartment> newApartments = new LinkedList<Apartment>();
		newApartments = apCtr.getAllFreeApartmentsForPeriod(arrivalDate, departureDate);
		
		boolean control = true;
		
		for(Apartment apa: usedApartments){
			if(!newApartments.contains(apa)){
				control = false;
			}
		}
		return control;
		
	}
	
	private void removeCustomerPressed(){
		customers.remove(table.getSelectedRow());
		model.removeRow(table.getSelectedRow());
		setPriceAndUsedApartments();
	}

	private void refreshApartments(){
		LinkedList<Apartment> newApartments = new LinkedList<Apartment>();
		newApartments = apCtr.getAllFreeApartmentsForPeriod(arrivalDate, departureDate);
		
		LinkedList<Integer> badApartments = new LinkedList<Integer>();
		
		for(Apartment apa: usedApartments){
			if(!newApartments.contains(apa)){
				badApartments.add(apa.getRoomID());
			}
		}
		
		for(int i = 0; i<model.getRowCount(); i++){
			if(badApartments.contains(model.getValueAt(i, 5))){
				model.removeRow(i);
			}
		}
	}
}


