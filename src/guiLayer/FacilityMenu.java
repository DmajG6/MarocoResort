package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FacilityMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textF_FacilityID;
	private JTextField textF_Type;
	private JTextField textF_Price;
	private JTextField textF_InstructorPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacilityMenu frame = new FacilityMenu();
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
	public FacilityMenu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFacility = new JLabel("Facility");
		lblFacility.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFacility.setBounds(195, 0, 53, 49);
		contentPane.add(lblFacility);
		
		textF_FacilityID = new JTextField();
		textF_FacilityID.setBounds(66, 82, 86, 20);
		contentPane.add(textF_FacilityID);
		textF_FacilityID.setColumns(10);
		
		JLabel lblFacilityid = new JLabel("FacilityID");
		lblFacilityid.setBounds(10, 85, 46, 14);
		contentPane.add(lblFacilityid);
		
		JButton btn_Create_Facility = new JButton("Create");
		btn_Create_Facility.setBounds(24, 40, 89, 23);
		contentPane.add(btn_Create_Facility);
		
		JButton btn_MainMenu = new JButton("Main Menu");
		btn_MainMenu.setBounds(321, 40, 89, 23);
		contentPane.add(btn_MainMenu);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(10, 116, 46, 14);
		contentPane.add(lblType);
		
		textF_Type = new JTextField();
		textF_Type.setBounds(66, 113, 86, 20);
		contentPane.add(textF_Type);
		textF_Type.setColumns(10);
		
		textF_Price = new JTextField();
		textF_Price.setBounds(66, 144, 86, 20);
		contentPane.add(textF_Price);
		textF_Price.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(10, 147, 46, 14);
		contentPane.add(lblPrice);
		
		textF_InstructorPrice = new JTextField();
		textF_InstructorPrice.setBounds(66, 175, 86, 20);
		contentPane.add(textF_InstructorPrice);
		textF_InstructorPrice.setColumns(10);
		
		JLabel lblInstPrice = new JLabel("In. Price");
		lblInstPrice.setBounds(10, 181, 46, 14);
		contentPane.add(lblInstPrice);
		
		JButton btnFind = new JButton("Find");
		btnFind.setBounds(123, 40, 89, 23);
		contentPane.add(btnFind);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(222, 40, 89, 23);
		contentPane.add(btnDelete);
	}
}
