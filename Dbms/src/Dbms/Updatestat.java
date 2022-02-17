package Dbms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Updatestat extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public Updatestat() {
		setResizable(false);
		setTitle("UPDATE PLAYER STATS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		setSize(463,600);
		setLocation(725,50);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSubmit = new JButton("UPDATE");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnSubmit.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		btnSubmit.setBounds(358, 537, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					new Mainwindow();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBack.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		btnBack.setBounds(257, 537, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblSelectPlayer = new JLabel("SELECT PLAYER");
		lblSelectPlayer.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 15));
		lblSelectPlayer.setBounds(36, 28, 140, 14);
		contentPane.add(lblSelectPlayer);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(20);
		comboBox.setFont(new Font("Simplified Arabic Fixed", Font.PLAIN, 15));
		comboBox.setBounds(188, 23, 180, 20);
		contentPane.add(comboBox);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 54, 437, 14);
		contentPane.add(separator);
		
		JLabel lblPid = new JLabel("PLAYER ID");
		lblPid.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 15));
		lblPid.setBounds(36, 79, 140, 14);
		contentPane.add(lblPid);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Simplified Arabic Fixed", Font.PLAIN, 15));
		textField.setBounds(188, 76, 180, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPlayerName = new JLabel("PLAYER NAME");
		lblPlayerName.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 15));
		lblPlayerName.setBounds(36, 126, 122, 14);
		contentPane.add(lblPlayerName);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Simplified Arabic Fixed", Font.PLAIN, 15));
		textField_1.setBounds(188, 123, 180, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTotalMatches = new JLabel("NO OF MATCHES");
		lblTotalMatches.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 15));
		lblTotalMatches.setBounds(36, 175, 140, 14);
		contentPane.add(lblTotalMatches);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Simplified Arabic Fixed", Font.PLAIN, 15));
		textField_2.setBounds(188, 172, 180, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblRunsScored = new JLabel("RUNS SCORED");
		lblRunsScored.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 15));
		lblRunsScored.setBounds(36, 222, 122, 14);
		contentPane.add(lblRunsScored);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Simplified Arabic Fixed", Font.PLAIN, 15));
		textField_3.setBounds(188, 219, 180, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}
}
