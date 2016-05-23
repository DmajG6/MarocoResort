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
		setBounds(100, 100, 727, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenu().setVisible(true);
				ReservationMenu.this.dispose();
			    }
			});
		btnMainMenu.setBounds(12, 13, 108, 23);
		contentPane.add(btnMainMenu);
		
		JButton btnArrivalDate = new JButton("Arrival Date");
		btnArrivalDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getArrivalDate();
			}
		});
		btnArrivalDate.setBounds(217, 68, 125, 25);
		contentPane.add(btnArrivalDate);
		
		JButton btnDepartureDate = new JButton("Departure Date");
		btnDepartureDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDepartureDate();
			}
		});
		btnDepartureDate.setBounds(217, 106, 125, 25);
		contentPane.add(btnDepartureDate);
		
		ArrivalDate = new JTextField();
		ArrivalDate.setEditable(false);
		ArrivalDate.setBounds(101, 68, 116, 23);
		contentPane.add(ArrivalDate);
		ArrivalDate.setColumns(10);
		
		DepartureDate = new JTextField();
		DepartureDate.setEditable(false);
		DepartureDate.setBounds(101, 107, 116, 22);
		contentPane.add(DepartureDate);
		DepartureDate.setColumns(10);
		
		JLabel lblNumberOfFree = new JLabel("Number of free rooms during selected period:");
		lblNumberOfFree.setBounds(408, 72, 270, 16);
		contentPane.add(lblNumberOfFree);
		
		JLabel lblSingle = new JLabel("Single:");
		lblSingle.setBounds(437, 109, 56, 16);
		contentPane.add(lblSingle);
		
		JLabel lblFamily = new JLabel("Family:");
		lblFamily.setBounds(437, 138, 56, 16);
		contentPane.add(lblFamily);
		
		JButton btnBookingThroughAgency = new JButton("Booking Through Agency");
		btnBookingThroughAgency.setBounds(101, 322, 205, 25);
		contentPane.add(btnBookingThroughAgency);
		
		JButton btnPrivateBooking = new JButton("Private Booking");
		btnPrivateBooking.setBounds(394, 322, 205, 25);
		contentPane.add(btnPrivateBooking);
		
		freeSingleRooms = new JTextField();
		freeSingleRooms.setEditable(false);
		freeSingleRooms.setBounds(497, 106, 116, 22);
		contentPane.add(freeSingleRooms);
		freeSingleRooms.setColumns(10);
		
		freeFamilyRooms = new JTextField();
		freeFamilyRooms.setEditable(false);
		freeFamilyRooms.setBounds(497, 138, 116, 22);
		contentPane.add(freeFamilyRooms);
		freeFamilyRooms.setColumns(10);
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
	
}