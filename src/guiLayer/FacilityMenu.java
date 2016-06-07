package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

import controlLayer.*;
import modelLayer.*;
import java.awt.Color;

public class FacilityMenu extends JFrame {
	
	private FacilityController fac = new FacilityController();

	private JPanel contentPane;
	private JTextField textF_FacilityID;
	private JTextField textF_Type;
	private JTextField textF_InstructorPrice;
	
	private Staff staff;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacilityMenu frame = new FacilityMenu(new Staff());
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
	public FacilityMenu(Staff staff) {
		setTitle("Program - Facility");
		
		this.staff = staff;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFacility = new JLabel("Facility");
		lblFacility.setForeground(new Color(255, 255, 255));
		lblFacility.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFacility.setBounds(195, 0, 53, 49);
		contentPane.add(lblFacility);
		
		textF_FacilityID = new JTextField();
		textF_FacilityID.setBounds(126, 82, 86, 20);
		contentPane.add(textF_FacilityID);
		textF_FacilityID.setColumns(10);
		
		JLabel lblFacilityid = new JLabel("FacilityID");
		lblFacilityid.setBounds(10, 85, 61, 17);
		contentPane.add(lblFacilityid);
		
		JButton btn_Create_Facility = new JButton("Create");
		btn_Create_Facility.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createFacility();
			}
		});
		btn_Create_Facility.setBounds(24, 40, 89, 23);
		contentPane.add(btn_Create_Facility);
		
		JButton btn_MainMenu = new JButton("Main Menu");
		btn_MainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenu(staff).setVisible(true);
				FacilityMenu.this.dispose();
			    }
			});
		btn_MainMenu.setBounds(321, 40, 111, 23);
		contentPane.add(btn_MainMenu);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(10, 116, 46, 17);
		contentPane.add(lblType);
		
		textF_Type = new JTextField();
		textF_Type.setBounds(126, 113, 86, 20);
		contentPane.add(textF_Type);
		textF_Type.setColumns(10);
		
		textF_InstructorPrice = new JTextField();
		textF_InstructorPrice.setBounds(126, 178, 86, 20);
		contentPane.add(textF_InstructorPrice);
		textF_InstructorPrice.setColumns(10);
		
		JLabel lblInstPrice = new JLabel("In. Price");
		lblInstPrice.setBounds(10, 181, 76, 14);
		contentPane.add(lblInstPrice);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findFacilityByID();
			}
		});
		btnFind.setBounds(123, 40, 89, 23);
		contentPane.add(btnFind);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(222, 40, 89, 23);
		contentPane.add(btnDelete);
		}
	
		private void createFacility(){
			fac.createFacility(Integer.parseInt(textF_FacilityID.getText()), 
				textF_Type.getText(),
				Double.parseDouble(textF_InstructorPrice.getText())
				);
		}
		
		private void findFacilityByID(){
			String input = textF_FacilityID.getText();
			Facility facility = fac.findFacilityByFacilityID(Integer.parseInt(input));
			if(facility!= null){
				textF_FacilityID.setText("" + facility.getFacilityID());
				textF_Type.setText("" + facility.getType());
				textF_InstructorPrice.setText("" + facility.getInstructorPrice());
			}
		}
		
		private void deleteFacility(){
			fac.deleteFacility(Integer.parseInt(textF_FacilityID.getText()));//finish this shit//b
		}
}//
