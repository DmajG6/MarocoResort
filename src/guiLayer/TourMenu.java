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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.awt.Choice;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Button;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class TourMenu extends JFrame {
	
	private ActivityController actCtr = new ActivityController();
	
	private Staff loggedInStaff;
	private JPanel contentPane;
	private JTextField dateTXT;
	private String date = null;
	private JTable table;
	private DefaultTableModel model;
	private JTextField durationTXT;
	private JTextField priceTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TourMenu frame = new TourMenu(new Staff());
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
	public TourMenu(Staff staff) {
		this.loggedInStaff = staff;
		setTitle("Tour");
		loggedInStaff = staff;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1017, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSelect = new JButton("Select\r\n");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDate();
			}
		});
		btnSelect.setBounds(276, 44, 125, 25);
		contentPane.add(btnSelect);
		
		dateTXT = new JTextField();
		dateTXT.setEditable(false);
		dateTXT.setBounds(150, 45, 116, 23);
		contentPane.add(dateTXT);
		dateTXT.setColumns(10);
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(168, 110, 773, 400);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Destination", "Time", "Price", "Yes/No"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, double.class, String.class,
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookPressed();
			}
		});
		btnBook.setBounds(844, 533, 97, 25);
		contentPane.add(btnBook);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitPressed();
			}
		});
		btnExit.setBounds(844, 558, 97, 25);
		contentPane.add(btnExit);
		
		JLabel lblSelectTime = new JLabel("Select Time");
		lblSelectTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectTime.setBounds(74, 47, 85, 14);
		contentPane.add(lblSelectTime);
		

		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(27, 205, 116, 16);
		contentPane.add(lblDuration);
		
		durationTXT = new JTextField();
		durationTXT.setEditable(false);
		durationTXT.setBounds(27, 234, 116, 22);
		contentPane.add(durationTXT);
		durationTXT.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(27, 269, 56, 16);
		contentPane.add(lblPrice);
		
		priceTxt = new JTextField();
		priceTxt.setEditable(false);
		priceTxt.setBounds(27, 298, 116, 22);
		contentPane.add(priceTxt);
		priceTxt.setColumns(10);
		
		model = (DefaultTableModel) table.getModel();
	}
	
}


