package guiLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelLayer.Customer;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BookingMenu extends JFrame {

	private JPanel contentPane;
	private int type;
	private Customer customer;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingMenu frame = new BookingMenu(new Customer(), 2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public BookingMenu(Customer customer, int type){
		setTitle("Program - Booking Menu");
		this.customer = customer;
		this.type = type;
		
		this.setEnabled(true);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 324);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookingMenu = new JLabel("Booking Menu");
		lblBookingMenu.setForeground(new Color(255, 255, 255));
		lblBookingMenu.setBackground(new Color(255, 255, 255));
		lblBookingMenu.setFont(new Font("Tahoma", Font.ITALIC, 41));
		lblBookingMenu.setBounds(12, 13, 278, 57);
		contentPane.add(lblBookingMenu);
		
		JButton btnBookFacility = new JButton("Book Facility");
		btnBookFacility.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookFacilityPressed();
			}
		});
		btnBookFacility.setBounds(74, 83, 141, 25);
		contentPane.add(btnBookFacility);
		
		JButton btnGroupSports = new JButton("Group Sports");
		btnGroupSports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				groupSportsPressed();
			}
		});
		btnGroupSports.setBounds(74, 121, 141, 25);
		contentPane.add(btnGroupSports);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitPressed();
			}
		});
		btnExit.setBounds(74, 226, 141, 25);
		contentPane.add(btnExit);
		
		System.out.println("toString: "+customer.toString());
	}
	
	private void bookFacilityPressed(){
		new BookFacility(customer, type).setVisible(true);
		this.dispose();
	}
	
	private void groupSportsPressed(){
		new GroupSportsMenu(customer, type).setVisible(true);
		this.dispose();
	}
	
	
	private void exitPressed(){
		new LogInMenu().setVisible(true);
		this.dispose();
	}
}