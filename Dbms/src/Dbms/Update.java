package Dbms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

public class Update extends Addplayer {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField;
	public Connection Conn9;
	@SuppressWarnings("rawtypes")
	public JComboBox comboBox;
	

	
	public Update() {
		setTitle("UPDATE PLAYER");
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
		
		
		JLabel lblEnterPlayerName = new JLabel("PLAYER NAME");
		lblEnterPlayerName.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 15));
		lblEnterPlayerName.setBounds(38, 143, 121, 14);
		contentPane.add(lblEnterPlayerName);
		
		JLabel lblPlayerId = new JLabel("PLAYER ID");
		lblPlayerId.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 15));
		lblPlayerId.setBounds(38, 88, 121, 14);
		contentPane.add(lblPlayerId);
		
		final JTextField textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Simplified Arabic Fixed", Font.PLAIN, 15));
		textField_1.setBounds(188, 85, 180, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 15));
		lblGender.setBounds(38, 200, 94, 14);
		contentPane.add(lblGender);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Simplified Arabic Fixed", Font.PLAIN, 15));
		textField_2.setBounds(188, 197, 180, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 15));
		lblAge.setBounds(38, 258, 46, 14);
		contentPane.add(lblAge);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Simplified Arabic Fixed", Font.PLAIN, 15));
		textField_3.setBounds(188, 255, 180, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblHeight = new JLabel("HEIGHT");
		lblHeight.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 15));
		lblHeight.setBounds(38, 318, 94, 14);
		contentPane.add(lblHeight);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Simplified Arabic Fixed", Font.PLAIN, 15));
		textField_4.setBounds(188, 315, 180, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ROLE");
		lblNewLabel.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(38, 380, 60, 14);
		contentPane.add(lblNewLabel);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Simplified Arabic Fixed", Font.PLAIN, 15));
		textField_5.setBounds(188, 377, 180, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblCountry = new JLabel("COUNTRY");
		lblCountry.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 15));
		lblCountry.setBounds(38, 445, 81, 14);
		contentPane.add(lblCountry);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Simplified Arabic Fixed", Font.PLAIN, 15));
		textField_6.setBounds(188, 440, 180, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		

		JButton btnSubmit = new JButton("UPDATE");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					String bname=(String) comboBox.getSelectedItem();
					String name=textField.getText();
					String gender = textField_2.getText();;
					String age= textField_3.getText();;
					String height=textField_4.getText();;
					String role=textField_5.getText();;
					String country=textField_6.getText();;
					
					if(name.equals(""))
					{
						getToolkit().beep();
						JOptionPane.showMessageDialog(null, "PLAYER NAME CANNOT BE EMPTY","Info",JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
					
						Conn9 = Drivers.myconn();	
						
				    	PreparedStatement smt=Conn9.prepareStatement("update player set pname=?,gender=?,age=?,height=?,role=?,country=? where pname=?");
				    			   
		     					   smt.setString(1, name);
		     					   smt.setString(2, gender);
		     					   smt.setString(3, age);
		     					   smt.setString(4, height);
		     					   smt.setString(5, role);
		     					   smt.setString(6, country);
		     					   smt.setString(7, bname);
		     					   smt.executeUpdate();
		     					   
		     					  JOptionPane.showMessageDialog(null,"PLAYER DETAILS UPDATED","Info",JOptionPane.INFORMATION_MESSAGE);
		     					  dispose();
		     					  new Mainwindow();	
					}	
				}
				catch(SQLException e9){
						JOptionPane.showMessageDialog(null, e9);	
					}
			}
		});
		
		btnSubmit.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		btnSubmit.setBounds(348, 527, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				try {
					new Mainwindow();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBack.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		btnBack.setBounds(249, 527, 89, 23);
		contentPane.add(btnBack);
		
		
		textField = new JTextField();
		textField.setFont(new Font("Simplified Arabic Fixed", Font.PLAIN, 15));
		textField.setBounds(188, 140, 180, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSelectPlayer = new JLabel("SELECT PLAYER");
		lblSelectPlayer.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 15));
		lblSelectPlayer.setBounds(38, 26, 140, 14);
		contentPane.add(lblSelectPlayer);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 60, 437, 2);
		contentPane.add(separator);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tmp=(String) comboBox.getSelectedItem();
				try{
				Conn9 = Drivers.myconn();	
				Statement stmt1 = Conn9.createStatement();
				PreparedStatement pst = Conn9.prepareStatement("select * from player where pname = ? ");
				pst.setString(1, tmp);
			  	ResultSet rs=pst.executeQuery();
			  	while(rs.next())
			  	{
			  		String id=rs.getString("pid");
			  		textField_1.setText(id);
			  		String name=rs.getString("pname");
			  		textField.setText(name);
			  		String gender=rs.getString("gender");
			  		textField_2.setText(gender);
			  		String age=rs.getString("age");
			  		textField_3.setText(age);
			  		String height=rs.getString("height");
			  		textField_4.setText(height);
			  		String role=rs.getString("role");
			  		textField_5.setText(role);
			  		String country=rs.getString("country");
			  		textField_6.setText(country);
			  		
			  	}
			  		
				}
				catch(SQLException e11)
				{
					e11.printStackTrace();
				}
			}
		});

		comboBox.setMaximumRowCount(20);
		comboBox.setToolTipText("SELECT PLAYER");
		comboBox.setFont(new Font("Simplified Arabic Fixed", Font.PLAIN, 15));
		comboBox.setBounds(188, 23, 180, 20);
		contentPane.add(comboBox);
	
		try{
			Conn9 = Drivers.myconn();	
			Statement stmt2 = Conn9.createStatement();
			
			ResultSet rs= stmt2.executeQuery("select pname from player");
			comboBox.addItem("");
			while(rs.next())
			{
				String name = rs.getString("pname").toString();
				comboBox.addItem(name);
				
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	
		
	
}
}