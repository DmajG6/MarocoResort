package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import modelLayer.ReservationOfStay;
import modelLayer.Staff;
import controlLayer.ReservationOfStayController;
import java.awt.Color;

/**
	Jun 6, 2016 - 4:59:38 PM
*/

public class FindReservation extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtPrice;
	private JTextField txtArrival;
	private JTextField txtDeparture;
	private JTextField txtAgency;
	private JTextField txtCustomers;
	private ReservationOfStay reservation;
	private ReservationOfStayController resCtr = new ReservationOfStayController();
	private Staff staff;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindReservation frame = new FindReservation(new Staff());
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
	public FindReservation(Staff staff) {
		setTitle("Program - Find Reservation");
		this.staff = staff;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 353);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtID = new JTextField();
		txtID.setBounds(156, 51, 136, 27);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(112, 54, 27, 21);
		contentPane.add(lblId);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(97, 85, 42, 21);
		contentPane.add(lblPrice);
		
		JLabel lblArrivalDate = new JLabel("Arrival date:");
		lblArrivalDate.setBounds(54, 118, 86, 21);
		contentPane.add(lblArrivalDate);
		
		JLabel lblDepartureDate = new JLabel("Departure date:");
		lblDepartureDate.setBounds(25, 156, 114, 21);
		contentPane.add(lblDepartureDate);
		
		JLabel lblCustomers = new JLabel("Number of Customers:");
		lblCustomers.setBounds(0, 233, 153, 21);
		contentPane.add(lblCustomers);
		
		JLabel lblAgency = new JLabel("Agency:");
		lblAgency.setBounds(82, 182, 57, 21);
		contentPane.add(lblAgency);
		
		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setBounds(156, 82, 136, 27);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		txtArrival = new JTextField();
		txtArrival.setEditable(false);
		txtArrival.setBounds(156, 115, 136, 27);
		contentPane.add(txtArrival);
		txtArrival.setColumns(10);
		
		txtDeparture = new JTextField();
		txtDeparture.setEditable(false);
		txtDeparture.setBounds(156, 153, 136, 27);
		contentPane.add(txtDeparture);
		txtDeparture.setColumns(10);
		
		txtAgency = new JTextField();
		txtAgency.setEditable(false);
		txtAgency.setBounds(156, 189, 136, 27);
		contentPane.add(txtAgency);
		txtAgency.setColumns(10);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findPressed();
			}
		});
		btnFind.setBounds(321, 54, 97, 25);
		contentPane.add(btnFind);
		
		txtCustomers = new JTextField();
		txtCustomers.setEditable(false);
		txtCustomers.setBounds(156, 230, 136, 27);
		contentPane.add(txtCustomers);
		txtCustomers.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletePressed();
			}
		});
		btnDelete.setBounds(321, 85, 97, 25);
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitPressed();
			}
		});
		btnExit.setBounds(321, 233, 97, 25);
		contentPane.add(btnExit);
	}
	
	private void findPressed(){
		int findID = Integer.parseInt(txtID.getText());
		reservation = resCtr.findReservationOfStay(findID);
		
		txtCustomers.setText(""+reservation.getCustomers().size());
		txtPrice.setText(""+reservation.getPrice());
		txtAgency.setText(""+reservation.getAgency().getAgencyID());
		txtArrival.setText(reservation.getArrivalDate());
		txtDeparture.setText(reservation.getDepartureDate());
		
	}
	
	private void deletePressed(){
		resCtr.deleteReservationOfStay(reservation.getReservationID());
	}
	
	private void exitPressed(){
		new MainMenu(staff);
		this.dispose();
	}
	
}
