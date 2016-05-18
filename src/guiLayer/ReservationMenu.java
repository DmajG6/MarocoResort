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

public class ReservationMenu extends JFrame {
	
	private ReservationOfStayController rosctr = new ReservationOfStayController();

	private JPanel contentPane;
	private JTextField ArrivalDate;
	private JTextField DepartureDate;
	private JTextField freeSingleRooms;
	private JTextField freeFamilyRooms;

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
			}
		});
		btnArrivalDate.setBounds(394, 13, 125, 25);
		contentPane.add(btnArrivalDate);
		
		JButton btnDepartureDate = new JButton("Departure Date");
		btnDepartureDate.setBounds(394, 51, 125, 25);
		contentPane.add(btnDepartureDate);
		
		ArrivalDate = new JTextField();
		ArrivalDate.setEditable(false);
		ArrivalDate.setBounds(531, 13, 116, 23);
		contentPane.add(ArrivalDate);
		ArrivalDate.setColumns(10);
		
		DepartureDate = new JTextField();
		DepartureDate.setEditable(false);
		DepartureDate.setBounds(531, 52, 116, 22);
		contentPane.add(DepartureDate);
		DepartureDate.setColumns(10);
		
		JLabel lblNumberOfFree = new JLabel("Number of free rooms during selected period:");
		lblNumberOfFree.setBounds(36, 131, 270, 16);
		contentPane.add(lblNumberOfFree);
		
		JLabel lblSingle = new JLabel("Single:");
		lblSingle.setBounds(64, 172, 56, 16);
		contentPane.add(lblSingle);
		
		JLabel lblFamily = new JLabel("Family:");
		lblFamily.setBounds(64, 201, 56, 16);
		contentPane.add(lblFamily);
		
		JButton btnBookingThroughAgency = new JButton("Booking Through Agency");
		btnBookingThroughAgency.setBounds(101, 322, 205, 25);
		contentPane.add(btnBookingThroughAgency);
		
		JButton btnPrivateBooking = new JButton("Private Booking");
		btnPrivateBooking.setBounds(394, 322, 205, 25);
		contentPane.add(btnPrivateBooking);
		
		freeSingleRooms = new JTextField();
		freeSingleRooms.setEditable(false);
		freeSingleRooms.setBounds(124, 169, 116, 22);
		contentPane.add(freeSingleRooms);
		freeSingleRooms.setColumns(10);
		
		freeFamilyRooms = new JTextField();
		freeFamilyRooms.setEditable(false);
		freeFamilyRooms.setBounds(124, 201, 116, 22);
		contentPane.add(freeFamilyRooms);
		freeFamilyRooms.setColumns(10);
	}
}
