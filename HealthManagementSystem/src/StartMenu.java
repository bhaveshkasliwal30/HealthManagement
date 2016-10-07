import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class StartMenu {

	JFrame frmPersonalHealthManagement;
	static StartMenu window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new StartMenu();
					window.frmPersonalHealthManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPersonalHealthManagement = new JFrame();
		frmPersonalHealthManagement.setTitle("Personal Health Management");
		frmPersonalHealthManagement.getContentPane().setBackground(Color.BLACK);
		frmPersonalHealthManagement.setBounds(100, 100, 450, 300);
		frmPersonalHealthManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPersonalHealthManagement.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblPersonalHealthManagement = new JLabel("Personal Health Management");
		lblPersonalHealthManagement.setForeground(Color.RED);
		lblPersonalHealthManagement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPersonalHealthManagement.setHorizontalAlignment(SwingConstants.CENTER);
		frmPersonalHealthManagement.getContentPane().add(lblPersonalHealthManagement, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		frmPersonalHealthManagement.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.setForeground(Color.BLUE);
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp sup=new SignUp();
				window.frmPersonalHealthManagement.setVisible(false);
				sup.frmSignup.setVisible(true);
			}
		});
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg=new Login();
				window.frmPersonalHealthManagement.setVisible(false);
				lg.frmLogin.setVisible(true);
			}
		});
		panel.add(btnLogin);
		panel.add(btnSignup);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		btnExit.setForeground(Color.RED);
		panel.add(btnExit);
	}
}
