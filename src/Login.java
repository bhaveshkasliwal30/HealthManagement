import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;

class Login {

	JFrame frmLogin;
	private JTextField textField;
	private final Action action = new SwingAction();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setBackground(Color.BLACK);
		
		JLabel lblPersonalHealthManagement = new JLabel("Personal Health Management");
		lblPersonalHealthManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalHealthManagement.setForeground(Color.RED);
		lblPersonalHealthManagement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmLogin.getContentPane().add(lblPersonalHealthManagement, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("Enter Password");
		panel.setBackground(Color.BLACK);
		frmLogin.getContentPane().add(panel, BorderLayout.EAST);
		panel.setLayout(new MigLayout("", "[][][][][][grow][grow]", "[][][][][][][][]"));
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setAction(action);
		btnExit.setForeground(Color.RED);
		panel.add(btnExit, "cell 6 0,alignx right,aligny baseline");
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		panel.add(lblUsername, "cell 2 1");
		
		textField = new JTextField();
		textField.setToolTipText("Enter Username");
		panel.add(textField, "cell 4 1,growx");
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		panel.add(lblPassword, "cell 2 3");
		
		passwordField = new JPasswordField();
		panel.add(passwordField, "cell 4 3,growx");
		
		JLabel lblLoginAs = new JLabel("Login as");
		lblLoginAs.setForeground(Color.WHITE);
		panel.add(lblLoginAs, "cell 2 5");
		
		JRadioButton rdbtnPatient = new JRadioButton("Patient");
		buttonGroup.add(rdbtnPatient);
		rdbtnPatient.setBackground(Color.BLACK);
		rdbtnPatient.setForeground(Color.WHITE);
		panel.add(rdbtnPatient, "flowx,cell 4 5");
		
		JRadioButton rdbtnHealthSupporter = new JRadioButton("Health Supporter");
		buttonGroup.add(rdbtnHealthSupporter);
		rdbtnHealthSupporter.setBackground(Color.BLACK);
		rdbtnHealthSupporter.setForeground(Color.WHITE);
		panel.add(rdbtnHealthSupporter, "cell 4 5");
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				ConnectionToOracle con=new ConnectionToOracle();
				 PreparedStatement pstmt = null;
				 Connection c1=con.returnConnection();
				 String query = "select username,password from users where username=? and password=?";
				 pstmt = c1.prepareStatement(query);
			      pstmt.setString(1, textField.getText());
			      pstmt.setString(2, String.valueOf(passwordField.getPassword()));
			      //System.out.println(String.valueOf(passwordField.getPassword()));
			      ResultSet rs = pstmt.executeQuery();
			      if(rs.next()==false){
			    	  JOptionPane.showMessageDialog(frmLogin,"Wrong Username/Password");
			      }
			       pstmt.close();
				con.connectionClose();
				}
				catch(SQLException e1){System.out.println("error");}
	
			}
		});
		panel.add(btnLogin, "cell 3 7,aligny center");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Exit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
