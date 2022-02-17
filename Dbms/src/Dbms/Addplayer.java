package Dbms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class Addplayer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Connection conn6;
	public JRadioButton rdbtnMale;
	public JRadioButton rdbtnFemale;
	public JComboBox comboBox_5;
	private JTextField textField_2;
	private JTextField textField_3;
	public String age;
	

	@SuppressWarnings("unchecked")
	public Addplayer() {
		setUndecorated(true);
		setTitle("ADD PLAYER");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		setSize(310,600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonGroup bg=new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 127, 310, 473);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterPlayerName = new JLabel("Player name");
		lblEnterPlayerName.setBounds(21, 12, 121, 14);
		panel.add(lblEnterPlayerName);
		lblEnterPlayerName.setForeground(Color.BLACK);
		lblEnterPlayerName.setFont(new Font("Arial", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setBounds(21, 30, 267, 20);
		panel.add(textField);
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.WHITE);
		textField.setText("");
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setColumns(10);
		
		JLabel lblPlayerId = new JLabel("Player ID");
		lblPlayerId.setBounds(21, 61, 121, 14);
		panel.add(lblPlayerId);
		lblPlayerId.setForeground(Color.BLACK);
		lblPlayerId.setFont(new Font("Arial", Font.BOLD, 12));
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setBounds(21, 79, 267, 20);
		panel.add(textField_1);
		textField_1.setForeground(Color.BLACK);
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_1.setColumns(10);
		

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(21, 113, 72, 14);
		panel.add(lblGender);
		lblGender.setForeground(Color.BLACK);
		lblGender.setFont(new Font("Arial", Font.BOLD, 12));
		
				rdbtnMale = new JRadioButton("MALE");
				rdbtnMale.setOpaque(false);
				rdbtnMale.setBounds(21, 130, 64, 23);
				panel.add(rdbtnMale);
				rdbtnMale.setForeground(new Color(0, 0, 0));
				rdbtnMale.setBackground(new Color(255, 255, 255));
				rdbtnMale.setFont(new Font("Arial", Font.PLAIN, 11));
				rdbtnMale.setSelected(true);
				bg.add(rdbtnMale);
				
				rdbtnFemale = new JRadioButton("FEMALE");
				rdbtnFemale.setOpaque(false);
				rdbtnFemale.setBounds(86, 130, 79, 23);
				panel.add(rdbtnFemale);
				rdbtnFemale.setForeground(new Color(0, 0, 0));
				rdbtnFemale.setBackground(new Color(255, 255, 255));
				rdbtnFemale.setFont(new Font("Arial", Font.PLAIN, 11));
				bg.add(rdbtnFemale);
				
				JLabel lblAge = new JLabel("Date of birth");
				lblAge.setBounds(21, 167, 140, 14);
				panel.add(lblAge);
				lblAge.setForeground(Color.BLACK);
				lblAge.setFont(new Font("Arial", Font.BOLD, 12));
				

				JComboBox comboBox_3 = new JComboBox();
				comboBox_3.setBounds(21, 185, 43, 20);
				panel.add(comboBox_3);
				for(int k=1;k<=31;k++)
				{
					comboBox_3.addItem(k);
				}
				
				comboBox_3.setForeground(Color.BLACK);
				comboBox_3.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
				comboBox_3.setToolTipText("DATE");
				comboBox_3.setMaximumRowCount(31);
				comboBox_3.setFont(new Font("Arial", Font.PLAIN, 13));
				
				comboBox_3.setSelectedItem(lblAge);
				
				JComboBox comboBox_4 = new JComboBox();
				comboBox_4.setBounds(87, 185, 53, 20);
				panel.add(comboBox_4);
				
				comboBox_4.setForeground(Color.BLACK);
				comboBox_4.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
				comboBox_4.setMaximumRowCount(12);
				comboBox_4.addItem("JAN");
				comboBox_4.addItem("FEB");
				comboBox_4.addItem("MAR");
				comboBox_4.addItem("APR");
				comboBox_4.addItem("MAY");
				comboBox_4.addItem("JUN");
				comboBox_4.addItem("JUL");
				comboBox_4.addItem("AUG");
				comboBox_4.addItem("SEP");
				comboBox_4.addItem("OCT");
				comboBox_4.addItem("NOV");
				comboBox_4.addItem("DEC");
				comboBox_4.setFont(new Font("Arial", Font.PLAIN, 12));
				comboBox_4.setToolTipText("MONTH");
				comboBox_4.setSelectedItem(lblAge);
				
				comboBox_5 = new JComboBox();
				comboBox_5.setBorder(null);
				comboBox_5.setBounds(161, 185, 64, 20);
				panel.add(comboBox_5);
				for(int j=1970;j<=2017;j++)
				{
					comboBox_5.addItem(j);
				}
				
				comboBox_5.setForeground(Color.BLACK);
				comboBox_5.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
				
				comboBox_5.setToolTipText("YEAR");
				comboBox_5.setFont(new Font("Arial", Font.PLAIN, 12));
				comboBox_5.setMaximumRowCount(40);
				comboBox_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String age=getage().toString();
						textField_3.setText(age);
					}
				});
				
				comboBox_5.setSelectedItem(lblAge);
				
				textField_3 = new JTextField();
				textField_3.setBorder(null);
				textField_3.setBounds(235, 216, 53, 20);
				panel.add(textField_3);
				textField_3.setForeground(new Color(0, 51, 255));
				textField_3.setBackground(Color.WHITE);
				textField_3.setEditable(false);
				textField_3.setToolTipText("PLAYER AGE");
				textField_3.setFont(new Font("Arial", Font.PLAIN, 15));
				textField_3.setColumns(10);
				
				
				
				JLabel lblHeight = new JLabel("Height");
				lblHeight.setBounds(21, 241, 72, 14);
				panel.add(lblHeight);
				lblHeight.setForeground(Color.BLACK);
				lblHeight.setFont(new Font("Arial", Font.BOLD, 12));
				
				final JComboBox comboBox = new JComboBox();
				comboBox.setBorder(null);
				comboBox.setBounds(21, 259, 267, 20);
				panel.add(comboBox);
				comboBox.setForeground(Color.BLACK);
				comboBox.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
				comboBox.setMaximumRowCount(3);
				comboBox.addItem("5");
				comboBox.addItem("6");
				comboBox.addItem("7");
				comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
				comboBox.setSelectedItem(lblHeight);
				
				JLabel lblRole = new JLabel("Role");
				lblRole.setBounds(21, 295, 58, 14);
				panel.add(lblRole);
				lblRole.setForeground(Color.BLACK);
				lblRole.setFont(new Font("Arial", Font.BOLD, 12));
				
				@SuppressWarnings("rawtypes")
				final JComboBox comboBox_1 = new JComboBox();
				comboBox_1.setBorder(null);
				comboBox_1.setBounds(21, 313, 267, 20);
				panel.add(comboBox_1);
				comboBox_1.setForeground(Color.BLACK);
				comboBox_1.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
				comboBox_1.setMaximumRowCount(5);
				comboBox_1.addItem("BATSMAN");
				comboBox_1.addItem("BOWLER");
				comboBox_1.addItem("ALL-ROUNDER");
				comboBox_1.addItem("CAPTAIN");
				comboBox_1.addItem("WICKET KEEPER");
				comboBox_1.addItem("EXTRA PLAYER");
				comboBox_1.setFont(new Font("Arial", Font.PLAIN, 12));
				comboBox_1.setSelectedItem(lblRole);
				
				JLabel lblCountry = new JLabel("Country");
				lblCountry.setBounds(21, 350, 72, 14);
				panel.add(lblCountry);
				lblCountry.setForeground(Color.BLACK);
				lblCountry.setFont(new Font("Arial", Font.BOLD, 12));
				comboBox_1.setSelectedItem(lblCountry);
				
				@SuppressWarnings("rawtypes")
				final JComboBox comboBox_2 = new JComboBox();
				comboBox_2.setBorder(null);
				comboBox_2.setBounds(21, 368, 267, 20);
				panel.add(comboBox_2);
				comboBox_2.setForeground(Color.BLACK);
				comboBox_2.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
				comboBox_2.setMaximumRowCount(10);
				comboBox_2.addItem("INDIA");
				comboBox_2.addItem("AUSTRALIA");
				comboBox_2.addItem("BANGLADESH");
				comboBox_2.addItem("ENGLAND");
				comboBox_2.addItem("NEW ZEALAND");
				comboBox_2.addItem("PAKISTAN");
				comboBox_2.addItem("SOUTH AFRICA");
				comboBox_2.addItem("SRI LANKA");
				comboBox_2.addItem("WEST INDIES");
				comboBox_2.setFont(new Font("Arial", Font.PLAIN, 12));
				
					JButton btnSubmit = new JButton("SAVE");
					btnSubmit.setIcon(new ImageIcon(Addplayer.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
					btnSubmit.setBounds(190, 439, 98, 23);
					panel.add(btnSubmit);
					btnSubmit.setFocusable(false);
					btnSubmit.setBackground(new Color(0, 102, 255));
					btnSubmit.setForeground(new Color(255, 255, 255));
					btnSubmit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							try{
							String name=textField.getText();
							String id=textField_1.getText();
							String gender = getname();
							age= getage();
							String height=(String) comboBox.getSelectedItem();
							String role=(String) comboBox_1.getSelectedItem();
							String country=(String) comboBox_2.getSelectedItem();
							
							if(name.equals(""))
							{
								getToolkit().beep();
								JOptionPane.showMessageDialog(null, "PLAYER NAME CANNOT BE EMPTY","Info",JOptionPane.INFORMATION_MESSAGE);
							}
							else
							{
								
								conn6 = Drivers.myconn();	
						    	Statement stmt1 = conn6.createStatement();
						    	ResultSet rs6=stmt1.executeQuery("select * from player");
						    	while(rs6.next())
						    	{
						    		if(rs6.getString("pid").equals(id) || rs6.getString("pname").equals(name))
						    		{
						    			getToolkit().beep();
						    			JOptionPane.showMessageDialog(null, "PLAYER NAME ALREADY EXIST","Info",JOptionPane.INFORMATION_MESSAGE);
						    			break;
						    		}
						    		else
						    		{
						    			 PreparedStatement smt=conn6.prepareStatement("insert into player(pid,pname,gender,age,height,role,country) values(?,?,?,?,?,?,?)");
						    			   smt.setString(1, id);
	     					   smt.setString(2, name);
	     					   smt.setString(3, gender);
	     					   smt.setString(4, age);
	     					   smt.setString(5, height);
	     					   smt.setString(6, role);
	     					   smt.setString(7, country);
	     					   smt.executeUpdate();
	     					   
	     					  getToolkit().beep();
	     					  JOptionPane.showMessageDialog(null,"NEW PLAYER ADDED","Info",JOptionPane.INFORMATION_MESSAGE);
	     					  dispose();
	     					  new Mainwindow();	
						    		}
						    		
						    	}
								}
							}
							catch(SQLException e9){
									e9.printStackTrace();
							}
							
						}
					});
					btnSubmit.setFont(new Font("Arial", Font.BOLD, 14));
					
					JLabel lblAge_1 = new JLabel("Age");
					lblAge_1.setForeground(new Color(0, 51, 255));
					lblAge_1.setFont(new Font("Arial", Font.BOLD, 12));
					lblAge_1.setBorder(null);
					lblAge_1.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
					lblAge_1.setBounds(203, 219, 32, 14);
					panel.add(lblAge_1);
					
					JLabel lblAddPlayer = new JLabel("Add Player");
					lblAddPlayer.setFont(new Font("Arial", Font.BOLD, 15));
					lblAddPlayer.setForeground(new Color(255, 255, 255));
					lblAddPlayer.setBounds(77, 65, 90, 21);
					lblAddPlayer.setBackground(new Color(0, 51, 255));
					contentPane.add(lblAddPlayer);
					
					JButton btnX = new JButton("X");
					btnX.setBounds(287, 0, 23, 23);
					contentPane.add(btnX);
					btnX.setToolTipText("EXIT");
					btnX.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();
						}
					});
					btnX.setFocusable(false);
					btnX.setFont(new Font("Tahoma", Font.BOLD, 13));
					btnX.setForeground(new Color(255, 255, 255));
					btnX.setBorder(null);
					btnX.setBackground(new Color(0, 102, 255));
					
					JLabel label_1 = new JLabel("");
					label_1.setBounds(17, 34, 69, 70);
					Image img=new ImageIcon(this.getClass().getResource("/addd.png")).getImage();
					label_1.setIcon(new ImageIcon(img));
					contentPane.add(label_1);
					
					
					
	
	}
	public String getage() {
		int year= (int) comboBox_5.getSelectedItem();
		int s=2017-year;
		String t=Integer.toString(s);
		return t;
		
	}
	public String getname(){
		if(rdbtnMale.isSelected()){
			return "MALE";
		}else{
			return "FEMALE";
		}
	}
	}

