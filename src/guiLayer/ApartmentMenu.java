package guiLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controlLayer.*;
import modelLayer.*;
import java.awt.Font;

public class ApartmentMenu extends JFrame {

	private ApartmentController aptctr = new ApartmentController();
	
	private JPanel contentPane;
	private JTextField txtf_roomID;
	private JTextField txtf_type;
	private JTextField txtf_price;
	private JTextField txtf_floor;
	private JTextField txtf_customer;
	private JTextField txtf_specialNeeds;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApartmentMenu frame = new ApartmentMenu();
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
	public ApartmentMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRoomID = new JLabel("Room ID");
		lblRoomID.setBounds(32, 79, 76, 14);
		contentPane.add(lblRoomID);
		
		txtf_roomID = new JTextField();
		txtf_roomID.setBounds(139, 75, 116, 22);
		contentPane.add(txtf_roomID);
		txtf_roomID.setColumns(10);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(32, 104, 117, 16);
		contentPane.add(lblType);
		
		txtf_type = new JTextField();
		txtf_type.setBounds(139, 101, 116, 22);
		contentPane.add(txtf_type);
		txtf_type.setColumns(10);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setBounds(32, 180, 97, 16);
		contentPane.add(lblCustomer);
		
		txtf_customer = new JTextField();
		txtf_customer.setBounds(139, 177, 116, 22);
		contentPane.add(txtf_customer);
		txtf_customer.setColumns(10);
		
		JLabel lblSpecialNeeds = new JLabel("Special Needs");
		lblSpecialNeeds.setBounds(32, 207, 76, 16);
		contentPane.add(lblSpecialNeeds);
		
		txtf_specialNeeds = new JTextField();
		txtf_specialNeeds.setBounds(139, 204, 116, 22);
		contentPane.add(txtf_specialNeeds);
		txtf_specialNeeds.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createApartment();
			}
		});
		btnCreate.setBounds(358, 74, 97, 25);
		contentPane.add(btnCreate);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(32, 130, 92, 14);
		contentPane.add(lblPrice);
		
		txtf_price = new JTextField();
		txtf_price.setBounds(139, 128, 116, 22);
		contentPane.add(txtf_price);
		txtf_price.setColumns(10);
		
		JLabel lblFloor = new JLabel("Floor");
		lblFloor.setBounds(32, 155, 76, 14);
		contentPane.add(lblFloor);
		
		txtf_floor = new JTextField();
		txtf_floor.setBounds(139, 152, 116, 20);
		contentPane.add(txtf_floor);
		txtf_floor.setColumns(10);
		
				
		JButton btnFindByRoomID = new JButton("Find");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findApartmentByRoomID();
			}
		});
		btnFindByRoomID.setBounds(265, 75, 89, 23);
		contentPane.add(btnFindByRoomID);
		
		JLabel lblApartmentMenu = new JLabel("Apartment Menu");
		lblApartmentMenu.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblApartmentMenu.setBounds(97, 11, 265, 33);
		contentPane.add(lblApartmentMenu);
	}
		
		private void findApartmentByRoomID(){
			String input = txtf_roomID.getText();
			Apartment apartment = aptctr.findApartmentByRoomID(Integer.parseInt(input));
			if(apartment!= null){
			txtf_roomID.setText(""+apartment.getRoomID());
			txtf_type.setText(""+apartment.getType());
			txtf_price.setText(""+apartment.getPrice());
			txtf_floor.setText(""+apartment.getFloor());
			txtf_customer.setText(""+apartment.getCustomer());
			txtf_specialNeeds.setText(""+apartment.getSpecialNeeds());
				
			}
	}
	
	private void createApartment(){
		
		aptctr.createApartment(Integer.parseInt(txtf_roomID.getText()), txtf_type.getText(), Double.parseDouble(txtf_price.getText()), Integer.parseInt(txtf_floor.getText()),txtf_customer.getText(), txtf_specialNeeds.getText());
		
	}
}