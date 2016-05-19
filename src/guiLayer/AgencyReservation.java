package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
	@author TomKuric<tomkuric@gmail.com>
	May 18, 2016 - 2:17:50 PM
*/

public class AgencyReservation extends JFrame {

	private JPanel contentPane;
	private JTextField textF_ArrivalDate;
	private JTextField textF_DepartureDate;
	private JTextField textFAgencyID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgencyReservation frame = new AgencyReservation();
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
	public AgencyReservation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArrivalDate = new JLabel("Arrival Date");
		lblArrivalDate.setBounds(10, 11, 65, 14);
		contentPane.add(lblArrivalDate);
		
		textF_ArrivalDate = new JTextField();
		textF_ArrivalDate.setBounds(73, 8, 86, 20);
		contentPane.add(textF_ArrivalDate);
		textF_ArrivalDate.setColumns(10);
		
		JLabel lblDepartureDate = new JLabel("Dep. Date");
		lblDepartureDate.setBounds(10, 39, 65, 14);
		contentPane.add(lblDepartureDate);
		
		textF_DepartureDate = new JTextField();
		textF_DepartureDate.setColumns(10);
		textF_DepartureDate.setBounds(73, 36, 86, 20);
		contentPane.add(textF_DepartureDate);
		
		JLabel lblAgencyid = new JLabel("AgencyID");
		lblAgencyid.setBounds(335, 11, 54, 14);
		contentPane.add(lblAgencyid);
		
		textFAgencyID = new JTextField();
		textFAgencyID.setBounds(315, 25, 86, 20);
		contentPane.add(textFAgencyID);
		textFAgencyID.setColumns(10);
	}
}
