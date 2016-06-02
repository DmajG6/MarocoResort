package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelLayer.Customer;
import modelLayer.Staff;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		this.customer = customer;
		this.type = type;
		buildWindow();
	}
	
	private void buildWindow(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookingMenu = new JLabel("Booking Menu");
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
		
		JButton btnTours = new JButton("Tours");
		btnTours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toursPressed();
			}
		});
		btnTours.setBounds(74, 159, 141, 25);
		contentPane.add(btnTours);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitPressed();
			}
		});
		btnExit.setBounds(74, 226, 141, 25);
		contentPane.add(btnExit);
		
	}

	private void bookFacilityPressed(){
		new BookFacility(customer, type).setVisible(true);
		this.dispose();
	}
	
	private void groupSportsPressed(){
		new GroupSportsMenu(customer, type).setVisible(true);
		this.dispose();
	}
	
	private void toursPressed(){
		new TourMenu(customer, type).setVisible(true);
		this.dispose();
	}
	
	private void exitPressed(){
		new LogInMenu().setVisible(true);
		this.dispose();
	}
}