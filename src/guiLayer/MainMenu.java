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

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMainMenu.setBounds(136, 11, 171, 37);
		contentPane.add(lblMainMenu);
		
		JButton btnReservationMenu = new JButton("Reservation Menu");
		btnReservationMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.dispose();
				new ReservationMenu().setVisible(true);
			}
		});
		btnReservationMenu.setBounds(146, 135, 125, 23);
		contentPane.add(btnReservationMenu);
		
		
		
		JButton btnCustomerMenu = new JButton("Customer Menu");
		btnCustomerMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.dispose();
				new CustomerMenu().setVisible(true);
			}
		});
		btnCustomerMenu.setBounds(146, 165, 125, 23);
		contentPane.add(btnCustomerMenu);
		
		JButton btnStaffMenu = new JButton("Staff Menu");
		btnStaffMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.dispose();
				new StaffMenu().setVisible(true);
			}
		});
		btnStaffMenu.setBounds(146, 195, 125, 23);
		contentPane.add(btnStaffMenu);
		
		JLabel lblNewLabel = new JLabel("( \u0361\u00B0 \u035C\u0296 \u0361\u00B0)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(171, 75, 74, 37);
		contentPane.add(lblNewLabel);
		
		JButton FacilityMenu = new JButton("Facility Menu");
		FacilityMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				faciltyMenuPressed();
			}
		});
		FacilityMenu.setBounds(146, 224, 125, 23);
		contentPane.add(FacilityMenu);
		
		JButton FacilityBooking = new JButton("Facility Booking");
		FacilityBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facilityBookingPressed();
			}
		});
		FacilityBooking.setBounds(146, 253, 125, 23);
		contentPane.add(FacilityBooking);
		
		JButton LogOut = new JButton("Log Out");
		LogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logOutPressed();
			}
		});
		LogOut.setBounds(146, 281, 125, 23);
		contentPane.add(LogOut);
	}
	
	private void facilityBookingPressed(){
		new FacilityMenu();
		this.dispose();
	}
	private void faciltyMenuPressed(){
		new BookingMenu(1);
		this.dispose();
	}
	
	private void logOutPressed(){
		new LogInMenu();
		this.dispose();
	}
}
