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
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JTextField;


public class BookFacility extends JFrame {

	private JPanel contentPane;
	private Customer customer;
	private Button book;
	private FacilityController facilityController = new FacilityController();
	private JTextField dateTime;
	private String chosenDateTime = null;
	private Facility chosenFacility = null;
	private int type;
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
		
		facilityController = new FacilityController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseType = new JLabel("Choose Type");
		lblChooseType.setBounds(10, 25, 76, 14);
		contentPane.add(lblChooseType);
		
		JLabel lblChooseFacility = new JLabel("Choose Facility");
		lblChooseFacility.setBounds(10, 50, 76, 14);
		contentPane.add(lblChooseFacility);
		
		Checkbox checkbox = new Checkbox("Would you like an instructor?");
		checkbox.setBounds(10, 89, 193, 22);
		contentPane.add(checkbox);
		
		JLabel lblAvailability = new JLabel("Availability");
		lblAvailability.setBounds(117, 169, 57, 14);
		contentPane.add(lblAvailability);
		
		
		Choice chooseType = new Choice();
		LinkedList<Facility> tempValues = facilityController.getAllFacilities();
		LinkedList<String> temp = new LinkedList<>();
		
		for (Facility facility : tempValues) {			
			boolean found = false;
			for (String chType: temp ){
				if(chType.equals(facility.getType())){
					found=true;
				}
			}
			if(!found){				
				temp.add(facility.getType());
				chooseType.add(facility.getType());
			}
		}
				
		chooseType.setBounds(111, 19, 75, 20);
		contentPane.add(chooseType);
		
		Choice chooseFacility = new Choice();
		LinkedList<Facility> values = facilityController.getAllFacilities();
		LinkedList<Integer> val = new LinkedList<>();
		
		for (Facility facility : tempValues) {			
			boolean found = false;
			for (Integer chID: val ){
				if(chID.equals(facility.getFacilityID())){
					found=true;
				}
			}
			if(!found){				
				val.add(facility.getFacilityID());
				chooseFacility.add(""+facility.getFacilityID());
			}
		}
	
		chooseFacility.setBounds(111, 50, 75, 20);
		contentPane.add(chooseFacility);
		
		Button add = new Button("Add to wishlist");
		add.setEnabled(false);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addWish();
			}
		});
		
		add.setBounds(292, 161, 86, 22);
		contentPane.add(add);
		
		Button exit = new Button("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			
			}
		});
		
		exit.setBounds(65, 212, 50, 22);
		contentPane.add(exit);
		
		book = new Button("Book");
		book.setEnabled(false);
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  exitPressed();
			
			}
		});
		
		book.setBounds(252, 212, 50, 22);
		contentPane.add(book);
		
		JLabel check= new JLabel("...");
		
		check.setBounds(40, 169, 46, 14);
		contentPane.add(check);
		
		JLabel note = new JLabel("Note:  Instructor will be booked for the next day");
		note.setBounds(56, 117, 290, 14);
		contentPane.add(note);
		
		JButton btnTime = new JButton("Time");
		btnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getTime();
			}
		});
		btnTime.setBounds(323, 20, 97, 25);
		contentPane.add(btnTime);
		
		dateTime = new JTextField();
		dateTime.setEditable(false);
		dateTime.setBounds(204, 21, 116, 22);
		contentPane.add(dateTime);
		dateTime.setColumns(10);
	}

	private void addBooking() {
		
	}

	private void addWish() {
		
	}
	
	private void getTime(){
		new ActivityDateTime(this, 1);
		this.setEnabled(false);
	}
	
	public void setTime(String newDateTime){
		this.chosenDateTime = newDateTime;
		dateTime.setText(chosenDateTime);
		checkBoth();
	}
	
	private void checkBoth(){
		if((chosenDateTime!=null)&&(chosenFacility!=null)){
			bothSelected();
		}
	}
	
	private void bothSelected(){
		
	}
	
	private void exitPressed(){
		new LogInMenu();
		this.dispose();
	}
}
