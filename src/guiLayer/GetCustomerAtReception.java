package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controlLayer.CustomerController;
import modelLayer.Customer;
import modelLayer.Staff;
import java.awt.Color;

/**
	May 30, 2016 - 1:00:43 PM
*/

public class GetCustomerAtReception extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JLabel lblStatus;
	private CustomerController cusCtr = new CustomerController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetCustomerAtReception frame = new GetCustomerAtReception(new Staff());
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
	public GetCustomerAtReception(Staff staff) {
		setTitle("Program - Find Customer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 151);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtId.setBounds(12, 30, 312, 45);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JButton btnFindCustomer = new JButton("Find Customer");
		btnFindCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				findCustomerPressed();
			}
		});
		btnFindCustomer.setBounds(327, 29, 197, 46);
		contentPane.add(btnFindCustomer);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(68, 75, 224, 16);

		lblStatus.setVisible(false);
		contentPane.add(lblStatus);
		
		JLabel lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setBounds(12, 13, 81, 16);
		contentPane.add(lblCustomerId);
	}
	
	private void findCustomerPressed(){
		int checkID = Integer.parseInt(txtId.getText());
		Customer customer = cusCtr.findCustomerByID(checkID);
		if(customer != null){
			new BookingMenu(customer, 1).setVisible(true);
			this.dispose();
		}else{
			lblStatus.setText("Customer not found");
			lblStatus.setVisible(true);
		}
	}
}
