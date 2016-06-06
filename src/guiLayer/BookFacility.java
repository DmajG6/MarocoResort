package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelLayer.*;
import controlLayer.*;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ItemEvent;
import java.awt.Color;


public class BookFacility extends JFrame {

	private JPanel contentPane;
	private Customer customer;
	private Button book;
	private FacilityController facilityController = new FacilityController();
	private JTextField dateTime;
	private String chosenDateTime = null;
	private Facility chosenFacility = null;
	private int type;
	private Choice chooseType;
	private LinkedList<Facility> facilities = new LinkedList<Facility>();
	private Choice chooseFacility;
	private ActivityBookingController actCtr = new ActivityBookingController();
	private FacilityController facCtr = new FacilityController();
	private JTextField numberCust;
	private Staff chosenStaff;
	private Button add;
	private LinkedList<Customer> customersInBooking = new LinkedList<Customer>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookFacility frame = new BookFacility(new Customer(), 1);
					frame.dispose();
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
	public BookFacility(Customer customer, int type) {
		this.customer = customer;
		this.type = type;
		
		facilities = facCtr.getAllFacilities();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseType = new JLabel("Choose Type");
		lblChooseType.setBounds(10, 25, 95, 21);
		contentPane.add(lblChooseType);
		
		JLabel lblChooseFacility = new JLabel("Choose Facility");
		lblChooseFacility.setBounds(10, 58, 104, 27);
		contentPane.add(lblChooseFacility);
		
		Checkbox checkbox = new Checkbox("Would you like to have an instructor?");
		checkbox.setBounds(10, 89, 256, 22);
		contentPane.add(checkbox);
		
		
		chooseType = new Choice();
		chooseType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				fillChoiceFacility();
			}
		});
		facilities = facilityController.getAllFacilities();
		LinkedList<String> temp = new LinkedList<>();
			
		chooseType.setBounds(112, 25, 86, 27);
		contentPane.add(chooseType);
		
		chooseFacility = new Choice();
		chooseFacility.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				facilityChosen();
			}
		});
		chooseFacility.setBounds(120, 56, 76, 27);
		contentPane.add(chooseFacility);
		chooseFacility.setEnabled(false);
		
		fillChoiceType();
		
		add = new Button("Add to wishlist");
		add.setEnabled(false);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addWish();
			}
		});
		
		add.setBounds(332, 173, 86, 22);
		contentPane.add(add);
		
		Button exit = new Button("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitPressed();
			}
		});
		
		exit.setBounds(65, 212, 50, 22);
		contentPane.add(exit);
		
		book = new Button("Book");
		book.setEnabled(false);
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  addBooking();
			}
		});
		
		book.setBounds(252, 212, 50, 22);
		contentPane.add(book);
		
		JLabel note = new JLabel("Note: Instructor can be booked for the next day");
		note.setBounds(30, 117, 316, 14);
		contentPane.add(note);
		
		JButton btnTime = new JButton("Time");
		btnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getTime();
			}
		});
		btnTime.setBounds(321, 29, 97, 25);
		contentPane.add(btnTime);
		
		dateTime = new JTextField();
		dateTime.setEditable(false);
		dateTime.setBounds(204, 30, 116, 22);
		contentPane.add(dateTime);
		dateTime.setColumns(10);
		
		JLabel lblNumberOfCustomers = new JLabel("Number of Customers that reserved this:");
		lblNumberOfCustomers.setBounds(30, 151, 316, 16);
		contentPane.add(lblNumberOfCustomers);
		
		numberCust = new JTextField();
		numberCust.setEditable(false);
		numberCust.setBounds(204, 173, 116, 22);
		contentPane.add(numberCust);
		numberCust.setColumns(10);
	}
	
	
	private void fillChoiceType(){
		
		LinkedList<String> types = new LinkedList<String>();
		
		for (Facility facility : facilities) {
			if(!types.contains(facility.getType())){
				types.add(facility.getType());
				chooseType.add(facility.getType());
			}
		}
	}
	
	private void fillChoiceFacility(){
		
		chooseFacility.setEnabled(true);
		
		if(chooseFacility.getItemCount() != 0){
			chooseFacility.removeAll();
		}
		
		for (Facility facility : facilities) {
			if(facility.getType().equals(chooseType.getSelectedItem())){
				chooseFacility.add(facility.getType()+" "+facility.getFacilityID());
			}
		}
		
	}

	private void addBooking() {
		
		if(checkTimeBounds()){
		
			ActivityBooking activityBooking = new ActivityBooking(chosenFacility, chosenStaff, chosenDateTime, customer, 0);
		
			actCtr.createActivityBooking(activityBooking);
		
		}
	}

	private void addWish() {
		
		ActivityBooking activityBooking = new ActivityBooking(chosenFacility, chosenStaff, chosenDateTime, customer, (customersInBooking.size()+1));
		
		actCtr.createActivityBooking(activityBooking);
		
		
	}
	
	private void getTime(){
		new ActivityDateTime(this, 1);
		this.setEnabled(false);
	}
	
	public void setTime(String newDateTime){
		this.chosenDateTime = newDateTime;
		dateTime.setText(chosenDateTime);
		checkBoth();
		checkTime();
	}
	
	private void checkBoth(){
		if((chosenDateTime!=null)&&(chosenFacility!=null)){
			bothSelected();
		}
	}
	
	private void bothSelected(){
		customersInBooking = actCtr.getCustomersInBooking(chosenFacility.getFacilityID(), chosenDateTime);
		if(customersInBooking.size() == 0){
			facilityFree();
		}else{
			numberCust.setText(""+customersInBooking.size());
			facilityTaken();
		}
	}
	
	private void exitPressed(){
		new LogInMenu();
		this.dispose();
	}

	private void facilityChosen(){
		for(Facility fac: facilities){
			if(chooseFacility.getSelectedItem().equals(fac.getType()+" "+fac.getFacilityID())){
				chosenFacility = fac;
				checkBoth();
				break;
			}
		}
	}
	
	private void facilityFree(){
		book.setEnabled(true);
	}
	
	private void facilityTaken(){
		add.setEnabled(true);
	}
	
	private void checkTime(){
		
	}
	
	private boolean checkTimeBounds(){
		boolean valueToReturn = true;
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		Calendar cal = Calendar.getInstance();
	
		String currentDate = df.format(cal.getTime());
		
		if(chosenDateTime.substring(0, 8).equals(currentDate.substring(0, 8))){
			if(Integer.parseInt(chosenDateTime.substring(9, 11)) >= Integer.parseInt(currentDate.substring(9, 11))-1){
				if(type == 2){
					valueToReturn = false;
				} else if(Integer.parseInt(chosenDateTime.substring(9, 11)) >= Integer.parseInt(currentDate.substring(9, 11))){
					valueToReturn = false;
				}
			}
		}
		
		if(chosenDateTime.substring(0, 2).equals(currentDate.substring(0, 2))&&currentDate.substring(6, 8).equals(currentDate.substring(6, 8))){
			if(Integer.parseInt(chosenDateTime.substring(3, 5)) <= Integer.parseInt(currentDate.substring(3, 5)) - 7 ){
				valueToReturn = false;
			}
		}
		
		
		return valueToReturn;
	}
}
