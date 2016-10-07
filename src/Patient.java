import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.ButtonGroup;

public class Patient {

	private JFrame frmPatient;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient window = new Patient();
					window.frmPatient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Patient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPatient = new JFrame();
		frmPatient.getContentPane().setBackground(Color.BLACK);
		frmPatient.setTitle("Patient");
		frmPatient.setBounds(100, 100, 450, 300);
		frmPatient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblPersonalHealthMangement = new JLabel("Personal Health Mangement");
		lblPersonalHealthMangement.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalHealthMangement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPersonalHealthMangement.setBackground(Color.BLACK);
		lblPersonalHealthMangement.setForeground(Color.RED);
		frmPatient.getContentPane().add(lblPersonalHealthMangement, BorderLayout.NORTH);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.BLACK);
		frmPatient.getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(new MigLayout("", "[][][][][][grow][][]", "[][][][][][][][]"));
		
		JLabel lblUid = new JLabel("UID");
		lblUid.setForeground(Color.WHITE);
		lblUid.setBackground(Color.BLACK);
		desktopPane.add(lblUid, "cell 3 0");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		desktopPane.add(lblNewLabel, "cell 5 0");
		
		JLabel lblNewLabel_7 = new JLabel("    ");
		lblNewLabel_7.setBackground(Color.BLACK);
		desktopPane.add(lblNewLabel_7, "cell 6 0");
		
		JLabel lblNewLabel_6 = new JLabel("     ");
		lblNewLabel_6.setBackground(Color.BLACK);
		desktopPane.add(lblNewLabel_6, "cell 7 0");
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBackground(Color.BLACK);
		lblDob.setForeground(Color.WHITE);
		desktopPane.add(lblDob, "cell 3 1");
		
		textField = new JTextField();
		desktopPane.add(textField, "cell 5 1,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(Color.WHITE);
		desktopPane.add(lblNewLabel_1, "cell 3 2");
		
		textField_1 = new JTextField();
		desktopPane.add(textField_1, "cell 5 2,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.BLACK);
		desktopPane.add(lblNewLabel_2, "cell 3 3");
		
		textField_2 = new JTextField();
		desktopPane.add(textField_2, "cell 5 3,growx");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setForeground(Color.WHITE);
		desktopPane.add(lblNewLabel_3, "cell 3 4");
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setForeground(Color.WHITE);
		rdbtnMale.setBackground(Color.BLACK);
		desktopPane.add(rdbtnMale, "flowx,cell 5 4");
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBackground(Color.BLACK);
		lblCategory.setForeground(Color.WHITE);
		desktopPane.add(lblCategory, "cell 3 5");
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBackground(Color.BLACK);
		desktopPane.add(lblNewLabel_5, "cell 5 5");
		
		JLabel lblNewLabel_4 = new JLabel("      ");
		lblNewLabel_4.setBackground(Color.BLACK);
		desktopPane.add(lblNewLabel_4, "cell 3 6");
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setForeground(Color.WHITE);
		rdbtnFemale.setBackground(Color.BLACK);
		desktopPane.add(rdbtnFemale, "cell 5 4");
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUpdate.setForeground(Color.BLUE);
		desktopPane.add(btnUpdate, "cell 4 7");
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(Color.BLACK);
		frmPatient.getContentPane().add(desktopPane_1, BorderLayout.SOUTH);
		desktopPane_1.setLayout(new MigLayout("", "[][][][][][][grow][][grow]", "[][grow][][]"));
		
		JLabel lblDiagnoses = new JLabel("Diagnose/s");
		lblDiagnoses.setForeground(Color.WHITE);
		lblDiagnoses.setBackground(Color.BLACK);
		desktopPane_1.add(lblDiagnoses, "cell 3 1");
		
		JList list = new JList();
		list.setForeground(Color.WHITE);
		list.setBackground(Color.BLACK);
		desktopPane_1.add(list, "cell 5 1 3 1,grow");
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUpdate_1.setForeground(Color.BLUE);
		desktopPane_1.add(btnUpdate_1, "cell 4 2");
		
		JDesktopPane desktopPane_2 = new JDesktopPane();
		desktopPane_2.setBackground(Color.BLACK);
		frmPatient.getContentPane().add(desktopPane_2, BorderLayout.SOUTH);
		
		JDesktopPane desktopPane_3 = new JDesktopPane();
		desktopPane_3.setBackground(Color.BLACK);
		frmPatient.getContentPane().add(desktopPane_3, BorderLayout.WEST);
		
		JDesktopPane desktopPane_4 = new JDesktopPane();
		desktopPane_4.setBackground(Color.BLACK);
		frmPatient.getContentPane().add(desktopPane_4, BorderLayout.EAST);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLACK);
		frmPatient.setJMenuBar(menuBar);
		
		JMenuItem mntmProfile = new JMenuItem("Profile");
		mntmProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPatient.remove(desktopPane);
				frmPatient.remove(desktopPane_1);
				frmPatient.remove(desktopPane_2);
				frmPatient.remove(desktopPane_3);
				frmPatient.remove(desktopPane_4);
				frmPatient.getContentPane().add(desktopPane, BorderLayout.CENTER);
				desktopPane_1.setVisible(false);
				desktopPane_2.setVisible(false);
				desktopPane_3.setVisible(false);
				desktopPane_4.setVisible(false);
				desktopPane.setVisible(true);

			}
		});
		mntmProfile.setForeground(Color.WHITE);
		mntmProfile.setBackground(Color.BLACK);
		mntmProfile.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mntmProfile);
		
		JMenuItem mntmDiagnoses = new JMenuItem("Diagnoses");
		mntmDiagnoses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPatient.remove(desktopPane);
				frmPatient.remove(desktopPane_1);
				frmPatient.remove(desktopPane_2);
				frmPatient.remove(desktopPane_3);
				frmPatient.remove(desktopPane_4);
				frmPatient.getContentPane().add(desktopPane_1, BorderLayout.CENTER);
				desktopPane.setVisible(false);
				desktopPane_2.setVisible(false);
				desktopPane_3.setVisible(false);
				desktopPane_4.setVisible(false);
				desktopPane_1.setVisible(true);

			}
		});
		mntmDiagnoses.setBackground(Color.BLACK);
		mntmDiagnoses.setForeground(Color.WHITE);
		mntmDiagnoses.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mntmDiagnoses);
		
		JMenuItem mntmAlerts = new JMenuItem("Health");
		mntmAlerts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPatient.remove(desktopPane);
				frmPatient.remove(desktopPane_1);
				frmPatient.remove(desktopPane_2);
				frmPatient.remove(desktopPane_3);
				frmPatient.remove(desktopPane_4);
				frmPatient.getContentPane().add(desktopPane_2, BorderLayout.CENTER);
				desktopPane.setVisible(false);
				desktopPane_1.setVisible(false);
				desktopPane_3.setVisible(false);
				desktopPane_4.setVisible(false);
				desktopPane_2.setVisible(true);

			}
		});
		mntmAlerts.setForeground(Color.WHITE);
		mntmAlerts.setBackground(Color.BLACK);
		mntmAlerts.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mntmAlerts);
		
		JMenuItem mntmAlerts_1 = new JMenuItem("Alerts");
		mntmAlerts_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPatient.remove(desktopPane);
				frmPatient.remove(desktopPane_1);
				frmPatient.remove(desktopPane_2);
				frmPatient.remove(desktopPane_3);
				frmPatient.remove(desktopPane_4);
				frmPatient.getContentPane().add(desktopPane_3, BorderLayout.CENTER);
				desktopPane.setVisible(false);
				desktopPane_1.setVisible(false);
				desktopPane_2.setVisible(false);
				desktopPane_4.setVisible(false);
				desktopPane_3.setVisible(true);

			}
		});
		mntmAlerts_1.setBackground(Color.BLACK);
		mntmAlerts_1.setForeground(Color.WHITE);
		mntmAlerts_1.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mntmAlerts_1);
		
		JMenuItem mntmHealthSupporter = new JMenuItem("Supporter");
		mntmHealthSupporter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPatient.remove(desktopPane);
				frmPatient.remove(desktopPane_1);
				frmPatient.remove(desktopPane_2);
				frmPatient.remove(desktopPane_3);
				frmPatient.remove(desktopPane_4);
				frmPatient.getContentPane().add(desktopPane_4, BorderLayout.CENTER);
				desktopPane.setVisible(false);
				desktopPane_1.setVisible(false);
				desktopPane_2.setVisible(false);
				desktopPane_3.setVisible(false);
				desktopPane_4.setVisible(true);
			}
		});
		mntmHealthSupporter.setForeground(Color.WHITE);
		mntmHealthSupporter.setBackground(Color.BLACK);
		mntmHealthSupporter.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mntmHealthSupporter);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.setBackground(Color.BLACK);
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmLogout.setForeground(Color.RED);
		mntmLogout.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mntmLogout);
	}

}
