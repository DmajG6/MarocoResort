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

public class BookingMenu extends JFrame {

	private JPanel contentPane;
	private int type;
	private JTextField txtDropboxhere;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private Staff staff = null;
	private Customer customer = null;
	
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

	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public BookingMenu(Staff staff, int type) {
		this.staff = staff;
		this.type = type;
		buildWindow();
	}

	public BookingMenu(Customer customer, int type){
		this.customer = customer;
		this.type = type;
		buildWindow();
	}
	
	private void buildWindow(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblBookingMenu = new JLabel("Booking Menu");
		lblBookingMenu.setBounds(165, 11, 99, 32);
		lblBookingMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(26, 53, 89, 23);
		
		JRadioButton rdbtnBookInstructor = new JRadioButton("Book Group Facility");
		rdbtnBookInstructor.setBounds(143, 94, 121, 23);
		
		JLabel label_1 = new JLabel("Type");
		label_1.setBounds(15, 127, 46, 14);
		label_1.setVisible(false);
		
		JRadioButton rdbtnBookFacility = new JRadioButton("Book Facility");
		rdbtnBookFacility.setBounds(32, 94, 109, 23);
		
		JLabel label = new JLabel("");
		label.setBounds(5, 149, 28, 7);
		
		JLabel lblFacility = new JLabel("Facility");
		lblFacility.setBounds(15, 149, 46, 14);
		lblFacility.setVisible(false);
		
		JCheckBox chckbx_Instructor = new JCheckBox("Instructor");
		chckbx_Instructor.setBounds(11, 172, 97, 23);
		chckbx_Instructor.setVisible(false);
		
		JRadioButton rdbtnBookTour = new JRadioButton("Book Tour");
		rdbtnBookTour.setBounds(274, 94, 109, 23);
		
		txtDropboxhere = new JTextField();
		txtDropboxhere.setBounds(55, 124, 86, 20);
		txtDropboxhere.setText("DropBoxHere");
		txtDropboxhere.setColumns(10);
		txtDropboxhere.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(55, 146, 86, 20);
		textField.setText("DropBoxHere");
		textField.setColumns(10);
		textField.setVisible(false);
		
		JLabel lblLocations = new JLabel("Locations:");
		lblLocations.setBounds(15, 327, 49, 14);
		lblLocations.setVisible(false);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("loc1(1hour)");
		chckbxNewCheckBox.setBounds(123, 323, 81, 23);
		chckbxNewCheckBox.setVisible(false);
		
		JCheckBox chckbxLochour = new JCheckBox("loc2(2hour)");
		chckbxLochour.setBounds(227, 323, 81, 23);
		chckbxLochour.setVisible(false);
		
		JCheckBox chckbxLochour_1 = new JCheckBox("loc3(3hour)");
		chckbxLochour_1.setBounds(15, 349, 81, 23);
		chckbxLochour_1.setVisible(false);
		
		JCheckBox chckbxLochour_2 = new JCheckBox("loc4(4hour)");
		chckbxLochour_2.setBounds(123, 349, 81, 23);
		chckbxLochour_2.setVisible(false);
		
		JCheckBox chckbxLochour_3 = new JCheckBox("loc5(5hour)");
		chckbxLochour_3.setBounds(227, 349, 81, 23);
		chckbxLochour_3.setVisible(false);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(15, 393, 23, 14);
		lblPrice.setVisible(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(48, 390, 86, 20);
		textField_1.setColumns(10);
		
		JLabel lblTourLength = new JLabel("Tour Length");
		lblTourLength.setBounds(237, 393, 58, 14);
		lblTourLength.setVisible(false);
		
		textField_2 = new JTextField();
		textField_2.setBounds(299, 390, 86, 20);
		textField_2.setColumns(10);
		
		JButton btnBook = new JButton("Book");
		btnBook.setBounds(299, 428, 86, 23);
		contentPane.setLayout(null);
		contentPane.add(lblBookingMenu);
		contentPane.add(btnMainMenu);
		contentPane.add(rdbtnBookInstructor);
		contentPane.add(label_1);
		contentPane.add(rdbtnBookFacility);
		contentPane.add(label);
		contentPane.add(lblFacility);
		contentPane.add(chckbx_Instructor);
		contentPane.add(rdbtnBookTour);
		contentPane.add(txtDropboxhere);
		contentPane.add(textField);
		contentPane.add(lblLocations);
		contentPane.add(chckbxNewCheckBox);
		contentPane.add(chckbxLochour);
		contentPane.add(chckbxLochour_1);
		contentPane.add(chckbxLochour_2);
		contentPane.add(chckbxLochour_3);
		contentPane.add(lblPrice);
		contentPane.add(textField_1);
		contentPane.add(lblTourLength);
		contentPane.add(textField_2);
		contentPane.add(btnBook);
		btnBook.setVisible(false);
		
		JLabel lblPrice_1 = new JLabel("Price");
		lblPrice_1.setBounds(182, 149, 46, 14);
		contentPane.add(lblPrice_1);
		lblPrice_1.setVisible(false);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(210, 146, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnDate = new JButton("Date");
		btnDate.setBounds(175, 225, 89, 23);
		contentPane.add(btnDate);
		btnDate.setVisible(false);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(264, 226, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("Date");
		button.setBounds(15, 428, 89, 23);
		contentPane.add(button);
		button.setVisible(false);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(104, 429, 86, 20);
		contentPane.add(textField_5);
		
	}
	
}