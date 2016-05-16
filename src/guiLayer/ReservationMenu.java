package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlLayer.CustomerController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

import controlLayer.*;
import modelLayer.*;

import java.sql.Date;

public class ReservationMenu extends JFrame {
	
	private ReservationOfStayController rosctr = new ReservationOfStayController();

	private JPanel contentPane;
	private JTextField textF_ReservationID;
	private JTextField textF_DurationOfStay;
	private JTextField textF_ArrivalDate;
	private JTextField textF_DepartureDate;
	private JTextField textF_PaymentInfo;
	private JTextField textF_PaymentConfirmation;
	private JTextField textF_DateOfReservation;
	private JTextField textF_Discount;
	private JTextField textF_Price;
	private JTextField textF_Agency;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationMenu frame = new ReservationMenu();
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
	public ReservationMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reservation of Stay");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(129, 11, 177, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ReservationID");
		lblNewLabel_1.setBounds(10, 40, 74, 14);
		contentPane.add(lblNewLabel_1);
		
		textF_ReservationID = new JTextField();
		textF_ReservationID.setBounds(94, 36, 86, 20);
		contentPane.add(textF_ReservationID);
		textF_ReservationID.setColumns(10);
		
		JButton btn_Find_ReservationID = new JButton("Find");
		btn_Find_ReservationID.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				findReservationOfStay();
			}
		});
		btn_Find_ReservationID.setBounds(190, 36, 89, 23);
		contentPane.add(btn_Find_ReservationID);
		
		JButton btn_Create_Reservation = new JButton("Create");
		btn_Create_Reservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createReservationOfStay();
			}
		});
		btn_Create_Reservation.setBounds(289, 36, 89, 23);
		contentPane.add(btn_Create_Reservation);
		
		JLabel lblJhgkh = new JLabel("Duration");
		lblJhgkh.setBounds(10, 70, 46, 14);
		contentPane.add(lblJhgkh);
		
		textF_DurationOfStay = new JTextField();
		textF_DurationOfStay.setBounds(94, 67, 86, 20);
		contentPane.add(textF_DurationOfStay);
		textF_DurationOfStay.setColumns(10);
		
		textF_ArrivalDate = new JTextField();
		textF_ArrivalDate.setText("yyyy-mm-dd");
		textF_ArrivalDate.setBounds(94, 98, 86, 20);
		contentPane.add(textF_ArrivalDate);
		textF_ArrivalDate.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Arrival Date ");
		lblNewLabel_2.setToolTipText("");
		lblNewLabel_2.setBounds(10, 101, 74, 14);
		contentPane.add(lblNewLabel_2);
		
		textF_DepartureDate = new JTextField();
		textF_DepartureDate.setText("yyyy-mm-dd");
		textF_DepartureDate.setBounds(94, 129, 86, 20);
		contentPane.add(textF_DepartureDate);
		textF_DepartureDate.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Departure D.");
		lblNewLabel_3.setBounds(10, 132, 74, 14);
		contentPane.add(lblNewLabel_3);
		
		textF_PaymentInfo = new JTextField();
		textF_PaymentInfo.setBounds(94, 160, 86, 20);
		contentPane.add(textF_PaymentInfo);
		textF_PaymentInfo.setColumns(10);
		
		JLabel lblPaymentInfo = new JLabel("Payment Info");
		lblPaymentInfo.setBounds(10, 163, 74, 14);
		contentPane.add(lblPaymentInfo);
		
		textF_PaymentConfirmation = new JTextField();
		textF_PaymentConfirmation.setBounds(94, 191, 86, 20);
		contentPane.add(textF_PaymentConfirmation);
		textF_PaymentConfirmation.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Payment Conf.");
		lblNewLabel_4.setBounds(10, 194, 74, 14);
		contentPane.add(lblNewLabel_4);
		
		textF_DateOfReservation = new JTextField();
		textF_DateOfReservation.setText("yyyy-mm-dd");
		textF_DateOfReservation.setBounds(94, 222, 86, 20);
		contentPane.add(textF_DateOfReservation);
		textF_DateOfReservation.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Date of Res.");
		lblNewLabel_5.setBounds(10, 225, 74, 14);
		contentPane.add(lblNewLabel_5);
		
		textF_Discount = new JTextField();
		textF_Discount.setBounds(292, 191, 86, 20);
		contentPane.add(textF_Discount);
		textF_Discount.setColumns(10);
		
		JLabel lblDiscount = new JLabel("Discount");
		lblDiscount.setBounds(217, 194, 46, 14);
		contentPane.add(lblDiscount);
		
		textF_Price = new JTextField();
		textF_Price.setBounds(292, 222, 86, 20);
		contentPane.add(textF_Price);
		textF_Price.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(217, 225, 46, 14);
		contentPane.add(lblPrice);
		
		JLabel lblAgency = new JLabel("Agency");
		lblAgency.setBounds(217, 163, 46, 14);
		contentPane.add(lblAgency);
		
		textF_Agency = new JTextField();
		textF_Agency.setBounds(292, 160, 86, 20);
		contentPane.add(textF_Agency);
		textF_Agency.setColumns(10);
	
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenu().setVisible(true);
				ReservationMenu.this.dispose();
			    }
			});
		btnMainMenu.setBounds(10, 0, 89, 23);
		contentPane.add(btnMainMenu);
	}
	
	//dates are missing from here
	private void findReservationOfStay(){
		String input = textF_ReservationID.getText();
		ReservationOfStay reservationOfStay = rosctr.findReservationOfStay(Integer.parseInt(input));
		if(reservationOfStay != null){
			textF_ReservationID.setText("" + reservationOfStay.getReservationID());
			textF_DurationOfStay.setText("" + reservationOfStay.getDurationOfStay());
			textF_PaymentInfo.setText("" + reservationOfStay.getPaymentInfo());
			textF_PaymentConfirmation.setText("" + reservationOfStay.getPaymentConfirmation());
			textF_Discount.setText("" + reservationOfStay.getDiscount());
			textF_Price.setText("" + reservationOfStay.getPrice());
			textF_Agency.setText("" + reservationOfStay.getAgency());
		}
	}
	
	
	//dates will rest for now and this method is not complete 
	private void createReservationOfStay(){		
		rosctr.createReservationOfStay(
				Integer.parseInt(textF_ReservationID.getText()),
				Integer.parseInt(textF_DurationOfStay.getText()),
				textF_PaymentInfo.getText(),
				textF_PaymentConfirmation.getText(),
				Double.parseDouble(textF_Discount.getText()),
				Double.parseDouble(textF_Price.getText()),
				textF_Agency.getText()				
				);
	} 
}
