package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelLayer.ActivityBooking;
import modelLayer.Customer;
import modelLayer.Facility;
import modelLayer.Staff;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.awt.Choice;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controlLayer.ActivityBookingController;
import controlLayer.FacilityController;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
	May 30, 2016 - 1:14:13 PM
*/

public class GroupSportsMenu extends JFrame {

	private JPanel contentPane;
	private Customer customer;
	private int type;
	private JTextField txtTime;
	private JTextField txtNum;
	private JTable table;
	private String time = null;
	private ActivityBookingController actCtr = new ActivityBookingController();
	private Facility chosenFacility = null;
	private LinkedList<Facility> allFacilities = new LinkedList<Facility>();
	private FacilityController facCtr = new FacilityController();
	private Choice choice;
	private LinkedList<Customer> customersInBooking = new LinkedList<Customer>();
	private DefaultTableModel model;
	private JButton btnCancelReservation;
	private JButton btnJoin;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroupSportsMenu frame = new GroupSportsMenu(new Customer(), 1);
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
	public GroupSportsMenu(Customer customer, int type) {
		setTitle("Group Activity Booking");
		this.type = type;
		this.customer = customer;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 452);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		choice = new Choice();
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				updateChoice();
			}
		});
		choice.setBounds(10, 44, 337, 22);
		contentPane.add(choice);
		
		JLabel lblChooseTypeAnd = new JLabel("Choose type and location:");
		lblChooseTypeAnd.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblChooseTypeAnd.setBounds(47, 13, 261, 25);
		contentPane.add(lblChooseTypeAnd);
		
		JLabel lblChooseDateAnd = new JLabel("Choose date and time:");
		lblChooseDateAnd.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblChooseDateAnd.setBounds(407, 6, 206, 38);
		contentPane.add(lblChooseDateAnd);
		
		txtTime = new JTextField();
		txtTime.setEditable(false);
		txtTime.setBounds(388, 44, 116, 22);
		contentPane.add(txtTime);
		txtTime.setColumns(10);
		
		JButton btnChoose = new JButton("Choose Time");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getTime();
			}
		});
		btnChoose.setBounds(516, 44, 108, 22);
		contentPane.add(btnChoose);
		
		JLabel lblNumberOfPeople = new JLabel("Number of people currently joined:");
		lblNumberOfPeople.setBounds(369, 104, 216, 22);
		contentPane.add(lblNumberOfPeople);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 337, 277);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Country"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		txtNum = new JTextField();
		txtNum.setEditable(false);
		txtNum.setBounds(497, 126, 116, 22);
		contentPane.add(txtNum);
		txtNum.setColumns(10);
		
		btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				joinPressed();
			}
		});
		btnJoin.setEnabled(false);
		btnJoin.setBounds(402, 194, 183, 43);
		contentPane.add(btnJoin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelPressed();
			}
		});
		btnExit.setBounds(402, 302, 183, 43);
		contentPane.add(btnExit);
		
		btnCancelReservation = new JButton("Cancel Reservation");
		btnCancelReservation.setEnabled(false);
		btnCancelReservation.setBounds(402, 250, 183, 43);
		contentPane.add(btnCancelReservation);
		getFacilities();
		
		customer.toString();
		
		model = (DefaultTableModel) table.getModel();
		
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public void setTime(String time){
		this.time = time;
		txtTime.setText(time);
		checkBoth();
	}
	
	private void getTime(){
		new ActivityDateTime(this, 2);
		this.setEnabled(false);
	}

	private void checkBoth(){
		if((time!=null)&&(chosenFacility!=null)){
			getInfo();
		}
	}
	
	private void getInfo(){
		customersInBooking = actCtr.getCustomersInBooking(chosenFacility.getFacilityID(), time);
		for(Customer cus: customersInBooking){
			 model.addRow(new Object[]{cus.getName(), cus.getCountry()});
		}
		txtNum.setText(""+customersInBooking.size());
		if(customersInBooking.contains(customer)){
			btnCancelReservation.setEnabled(true);
			btnJoin.setEnabled(false);
		}else{
			btnJoin.setEnabled(true);
			btnCancelReservation.setEnabled(false);
		}
	}
	
	private void getFacilities(){
		allFacilities = facCtr.getAllFacilities();
		for(Facility fac: allFacilities){
			if((fac.getType().equals("volleyball"))||(fac.getType().equals("handball"))){
				choice.add(fac.getType()+" "+fac.getFacilityID());
			}
		}
	}
	
	private void updateChoice(){
		for(Facility fac: allFacilities){
			if(choice.getSelectedItem().equals(fac.getType()+" "+fac.getFacilityID())){
				chosenFacility = fac;
				checkBoth();
				break;
			}
		}
	}
	
	private void joinPressed(){
		
		actCtr.createActivityBooking(new ActivityBooking(chosenFacility, new Staff(-1), time, customer, (customersInBooking.size()+1)));
		
		System.out.println("toString: "+customer.toString());
		
		model.addRow(new String[]{customer.getName(), customer.getCountry()});
		
		
		btnCancelReservation.setEnabled(true);
		btnJoin.setEnabled(false);
		
	}
	
	private void cancelPressed(){
		customersInBooking.remove(customer);
		
		LinkedList<ActivityBooking> activities = new LinkedList<ActivityBooking>();
		activities = actCtr.getAllActivities();
		
		int removeActivityID = -1;
		
		for(ActivityBooking act: activities){
			if((act.getCustomer().getCustomerID() == customer.getCustomerID())&&(act.getFacility().getFacilityID() == chosenFacility.getFacilityID())&&(act.getStartTime().equals(time))){
				removeActivityID = act.getActivityID();
			}
		}
		
		actCtr.removeBooking(removeActivityID, customer.getCustomerID());
		
		for(int i = 0; i < model.getRowCount(); i++){
			if(model.getValueAt(i, 1).equals(customer.getName())&&model.getValueAt(i, 2).equals(customer.getCountry())){
				model.removeRow(i);
			}
		}
		
		btnJoin.setEnabled(true);
		btnCancelReservation.setEnabled(false);
	}
	
}
