import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class SignUp {

	JFrame frmSignup;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtMmddyy;
	private JTextField textField_4;
	private JTextField textField_5;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
					window.frmSignUp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignup = new JFrame();
		frmSignup.setTitle("SignUp");
		frmSignup.getContentPane().setBackground(Color.BLACK);
		
		JLabel lblPersonalHealthManager = new JLabel("Personal Health Manager");
		lblPersonalHealthManager.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPersonalHealthManager.setForeground(Color.RED);
		lblPersonalHealthManager.setHorizontalAlignment(SwingConstants.CENTER);
		frmSignup.getContentPane().add(lblPersonalHealthManager, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		frmSignup.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		panel.setLayout(new MigLayout("", "[][][48px][71px][12px][59px][51px]", "[23px][20px][20px][20px][20px][20px][20px][23px][23px]"));
		btnExit.setForeground(Color.RED);
		panel.add(btnExit, "cell 6 0,alignx left,aligny top");
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel, "cell 0 1");
		
		JLabel lblNewLabel_1 = new JLabel("                     ");
		panel.add(lblNewLabel_1, "cell 1 1");
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		panel.add(lblUsername, "cell 2 1,alignx left,aligny center");
		
		textField = new JTextField();
		panel.add(textField, "cell 3 1 3 1,growx,aligny top");
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		panel.add(lblPassword, "cell 2 2,growx,aligny center");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "cell 3 2 3 1,growx,aligny top");
		textField_1.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		panel.add(lblName, "cell 2 3,growx,aligny center");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "cell 3 3 3 1,growx,aligny top");
		textField_2.setColumns(10);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setForeground(Color.WHITE);
		panel.add(lblDob, "cell 2 4,growx,aligny center");
		

		txtMmddyy = new JTextField();
		txtMmddyy.setToolTipText("yyyy-mm-dd");
		txtMmddyy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(txtMmddyy, "cell 3 4 3 1,growx,aligny top");
		txtMmddyy.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		panel.add(lblAddress, "cell 2 5,growx,aligny center");
		
		textField_4 = new JTextField();
		panel.add(textField_4, "cell 3 5 3 1,growx,aligny top");
		textField_4.setColumns(10);
		
		JLabel lblSsn = new JLabel("SSN");
		lblSsn.setForeground(Color.WHITE);
		panel.add(lblSsn, "cell 2 6,growx,aligny center");
		
		textField_5 = new JTextField();
		panel.add(textField_5, "cell 3 6 3 1,growx,aligny top");
		textField_5.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		panel.add(lblGender, "cell 2 7,growx,aligny center");
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBackground(Color.BLACK);
		rdbtnMale.setForeground(Color.WHITE);
		panel.add(rdbtnMale, "cell 3 7,growx,aligny top");
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setForeground(Color.WHITE);
		rdbtnFemale.setBackground(Color.BLACK);
		panel.add(rdbtnFemale, "cell 5 7,alignx left,aligny top");
		
		
		JButton btnLogin = new JButton("SignUp");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(check(textField.getText(),textField_1.getText(),textField_2.getText(),textField_4.getText(),txtMmddyy.getText(),textField_5.getText(),getSelectedButton())==0){
					JOptionPane.showMessageDialog(frmSignup,
						    "Wrong or Unfilled Entry");
				}
				else{
				insertData(textField.getText(),textField_1.getText(),textField_2.getText(),textField_4.getText(),txtMmddyy.getText(),textField_5.getText(),getSelectedButton());
				}
			}

			private int check(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
				// TODO Auto-generated method stub
				if (string==null || string2==null || string3==null|| string4==null ||string5==null||string6==null||string7==null)
				return 0;
				return 1;
			}
			
			private String getSelectedButton()
			{  
			    for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			            AbstractButton button = buttons.nextElement();
			            if (button.isSelected()) {
			                return button.getText();
			            }
			        }
			return null;
			}

			private void insertData(String username, String password, String name, String address, String dob, String ssn, String gender) {
				// TODO Auto-generated method stub
				try{
				ConnectionToOracle con=new ConnectionToOracle();
				 PreparedStatement pstmt = null;
				 Connection c1=con.returnConnection();
				 String query = "INSERT INTO Users(UserId, Name, Gender, Address, Username, Password, Ssn,DOB) Values ( ( select NVL(max(UserId), 0) + 1 from Users),?,?,?,?,?,?,?)";
				 pstmt = c1.prepareStatement(query);
			      pstmt.setString(1, name);
			      //pstmt.setString(2, dob); 
			      pstmt.setString(2, gender);
			      pstmt.setString(3, address);
			      pstmt.setString(4, username);
			      pstmt.setString(5, password);
			      pstmt.setString(6, ssn);
//			      java.util.Date dateofbirth = new java.util.Date();
			      System.out.println(dob);
			      pstmt.setDate(7, java.sql.Date.valueOf(dob));//yyyy-mm-dd
			      //pstmt.setString(7, dob);
			     pstmt.executeUpdate(); 
			       pstmt.close();
				con.connectionClose();
				JOptionPane.showMessageDialog(frmSignup,"SignUp Successful");
				frmSignup.setVisible(false);
				StartMenu.window.frmPersonalHealthManagement.setVisible(true);
				}
				catch(SQLException e){System.out.println("error");}
			}
		});
		btnLogin.setForeground(Color.BLUE);
		panel.add(btnLogin, "cell 3 8,alignx right,aligny top");
		frmSignup.setBounds(100, 100, 450, 339);
		frmSignup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
