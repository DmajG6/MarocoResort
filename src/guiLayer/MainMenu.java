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
		this.staff = staff;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setBounds(136, 11, 171, 37);
		lblMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblMainMenu);
		
		JButton btnReservationMenu = new JButton("Reservation Menu");
		btnReservationMenu.setBounds(309, 147, 125, 23);
		btnReservationMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.dispose();
				new ReservationMenu(staff).setVisible(true);
			}
		});
		contentPane.add(btnReservationMenu);
		
		
		
		JButton btnCustomerMenu = new JButton("Customer Menu");
		btnCustomerMenu.setBounds(10, 147, 125, 23);
		btnCustomerMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.dispose();
				new CustomerMenu(staff).setVisible(true);
			}
		});
		contentPane.add(btnCustomerMenu);
		
		JButton btnStaffMenu = new JButton("Staff Menu");
		btnStaffMenu.setBounds(10, 181, 125, 23);
		btnStaffMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.dispose();
				new StaffMenu(staff).setVisible(true);
			}
		});
		contentPane.add(btnStaffMenu);
		
		JLabel lblNewLabel = new JLabel("( \u0361\u00B0 \u035C\u0296 \u0361\u00B0)");
		lblNewLabel.setBounds(171, 52, 74, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		JButton FacilityMenu = new JButton("Facility Menu");
		FacilityMenu.setBounds(10, 215, 125, 23);
		FacilityMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				faciltyMenuPressed();
			}
		});
		contentPane.add(FacilityMenu);
		
		JButton FacilityBooking = new JButton("Facility Booking");
		FacilityBooking.setBounds(10, 249, 125, 23);
		FacilityBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facilityBookingPressed();
			}
		});
		contentPane.add(FacilityBooking);
		
		JButton LogOut = new JButton("Log Out");
		LogOut.setBounds(309, 249, 125, 23);
		LogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logOutPressed();
			}
		});
		contentPane.add(LogOut);
		
		JButton btnAgencyMenu = new JButton("Agency Menu");
		btnAgencyMenu.setBounds(309, 181, 125, 23);
		btnAgencyMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				MainMenu.this.dispose();
				new AgencyManu(staff).setVisible(true);
			}
		});
		contentPane.add(btnAgencyMenu);
	}
	
	private void facilityBookingPressed(){
		new FacilityMenu(staff);
		this.dispose();
	}
	private void faciltyMenuPressed(){
		new BookingMenu(staff, 1);
		this.dispose();
	}
	
	private void logOutPressed(){
		new LogInMenu();
		this.dispose();
	}
}
