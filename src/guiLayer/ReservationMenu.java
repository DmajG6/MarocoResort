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
import java.util.LinkedList;
import java.awt.Choice;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Button;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ReservationMenu extends JFrame {
	
	private FreeApartments available = new FreeApartments();
	
	private JPanel contentPane;
	private JTextField ArrivalDate;
	private JTextField DepartureDate;
	private JTextField freeSingleRooms;
	private JTextField freeFamilyRooms;
	private String arrivalDate = null;
	private String departureDate = null;
	private LinkedList<Apartment> apartments = new LinkedList<Apartment>();
	private JTextField textField;
	private JTextField numberOfDays;
	private JTextField priceTxt;
	private JTable table;
	private AgencyController ageCtr = new AgencyController();
	private LinkedList<Agency> agencies = new LinkedList<Agency>();
	private Choice choiceAgency;
	private Agency selectedAgency;
	private LinkedList<Customer> customers = new LinkedList<Customer>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationMenu frame = new ReservationMenu();
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
	public ReservationMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1017, 643);
		contentPane = new JPanel();
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
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(27, 43, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNumberOfDays = new JLabel("Number Of Days:");
		lblNumberOfDays.setBounds(27, 205, 116, 16);
		contentPane.add(lblNumberOfDays);
		
		numberOfDays = new JTextField();
		numberOfDays.setEditable(false);
		numberOfDays.setBounds(27, 234, 116, 22);
		contentPane.add(numberOfDays);
		numberOfDays.setColumns(10);
		
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
		choiceAgency.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				agencySelected();
			}
		});
		choiceAgency.setBounds(27, 170, 119, 23);
		contentPane.add(choiceAgency);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 121, 784, 462);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Country", "Address", "Phone Number", "Email", "Room ID", "ID Type", "ID Number", "Special Needs"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.setBounds(190, 96, 150, 25);
		contentPane.add(btnAddCustomer);
		
		JButton btnRemoveCustomer = new JButton("Remove Customer");
		btnRemoveCustomer.setBounds(345, 96, 150, 25);
		contentPane.add(btnRemoveCustomer);
		
		JButton btnChangeCustomer = new JButton("Change Customer");
		btnChangeCustomer.setBounds(500, 96, 150, 25);
		contentPane.add(btnChangeCustomer);
		
		JButton btnBook = new JButton("Book");
		btnBook.setBounds(35, 488, 97, 25);
		contentPane.add(btnBook);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(35, 526, 97, 25);
		contentPane.add(btnExit);
		
		getApartments();
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
	
	private void findAvailableRooms(){
		apartments = available.getAllFreeApartmentsForPeriod(arrivalDate, departureDate);
		
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
	
	private void getApartments(){
		agencies = ageCtr.getAllAgencys();
		
		for(Agency age: agencies){
			choiceAgency.add(age.getName()+" : "+age.getCountry());
		}
		
	}
	
	private void agencySelected(){
		for(Agency age: agencies){
			if((age.getName()+" : "+age.getCountry()).equals(choiceAgency.getSelectedItem())){
				selectedAgency = age;
			}
		}
	}
	
	public void addCustomer(Customer customer){
		customers.add(customer);
	}
	
	private void updateCustomer(){
		
	}
}