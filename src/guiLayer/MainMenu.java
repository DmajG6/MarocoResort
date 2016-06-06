package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelLayer.Staff;
import java.awt.Color;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	
	private Staff staff;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu(new Staff());
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
	public MainMenu(Staff staff) {
		this.setVisible(true);
		
		this.staff = staff;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 387);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setForeground(new Color(255, 255, 255));
		lblMainMenu.setBounds(136, 11, 171, 37);
		lblMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblMainMenu);
		
		JButton btnReservationMenu = new JButton("Reservation Menu");
		btnReservationMenu.setBounds(263, 136, 171, 35);
		btnReservationMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.dispose();
				new ReservationMenu(staff).setVisible(true);
			}
		});
		contentPane.add(btnReservationMenu);
		
		
		
		JButton btnCustomerMenu = new JButton("Customer Menu");
		btnCustomerMenu.setBounds(10, 81, 146, 37);
		btnCustomerMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.dispose();
				new CustomerMenu(staff).setVisible(true);
			}
		});
		contentPane.add(btnCustomerMenu);
		
		JButton btnStaffMenu = new JButton("Staff Menu");
		btnStaffMenu.setBounds(10, 135, 146, 37);
		btnStaffMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.dispose();
				new StaffMenu(staff).setVisible(true);
			}
		});
		contentPane.add(btnStaffMenu);
		
		JButton FacilityMenu = new JButton("Facility Menu");
		FacilityMenu.setBounds(10, 189, 146, 37);
		FacilityMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				faciltyMenuPressed();
			}
		});
		contentPane.add(FacilityMenu);
		
		JButton FacilityBooking = new JButton("Facility Booking");
		FacilityBooking.setBounds(10, 237, 146, 37);
		FacilityBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facilityBookingPressed();
			}
		});
		contentPane.add(FacilityBooking);
		
		JButton LogOut = new JButton("Log Out");
		LogOut.setBounds(301, 303, 113, 23);
		LogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logOutPressed();
			}
		});
		contentPane.add(LogOut);
		
		JButton btnAgencyMenu = new JButton("Agency Menu");
		btnAgencyMenu.setBounds(263, 190, 171, 35);
		btnAgencyMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				MainMenu.this.dispose();
				new AgencyManu(staff).setVisible(true);
			}
		});
		contentPane.add(btnAgencyMenu);
		
		JButton btnCheckInout = new JButton("Check In/Out");
		btnCheckInout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkInOutPressed();
			}
		});
		btnCheckInout.setBounds(263, 237, 171, 37);
		contentPane.add(btnCheckInout);
		
		JButton FindButton = new JButton("Find Reservation");
		FindButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findPressed();
			}
		});
		FindButton.setBounds(263, 80, 171, 38);
		contentPane.add(FindButton);
		
	}
	
	private void facilityBookingPressed(){
		new GetCustomerAtReception(staff).setVisible(true);
		this.dispose();
	}
	private void faciltyMenuPressed(){
		new FacilityMenu(staff).setVisible(true);
		this.dispose();
	}
	
	private void logOutPressed(){
		new LogInMenu();
		this.dispose();
	}
	
	private void checkInOutPressed(){
		new CheckInOut(staff);
		this.dispose();
	}
	
	private void findPressed(){
		new FindReservation(staff).setVisible(true);;
		this.dispose();
	}
}
