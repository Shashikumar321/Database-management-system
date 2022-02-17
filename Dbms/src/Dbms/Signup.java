package Dbms;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.PreparedStatement;
import java.sql.Statement;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public Connection conn;
	int flag=0;

	public Signup() {
		setUndecorated(true);
		setTitle("REGISTER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,370);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setFocusable(false);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSignUp = new JLabel("Sign up");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSignUp.setBounds(197, 36, 105, 29);
		contentPane.add(lblSignUp);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(0, 51, 255));
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 13));
		lblUsername.setBounds(271, 99, 89, 14);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setText("");
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setBounds(271, 118, 205, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setForeground(new Color(0, 51, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setBounds(271, 156, 95, 14);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setText("");
		textField_1.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_1.setBounds(271, 176, 205, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblReenterPassword = new JLabel("Reenter Password");
		lblReenterPassword.setForeground(new Color(0, 51, 255));
		lblReenterPassword.setFont(new Font("Arial", Font.PLAIN, 13));
		lblReenterPassword.setBounds(271, 213, 125, 14);
		contentPane.add(lblReenterPassword);
		
		textField_2 = new JTextField();
		textField_2.setBorder(null);
		textField_2.setText("");
		textField_2.setFont(new Font("Arial", Font.BOLD, 15));
		textField_2.setBounds(271, 231, 205, 23);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSignup = new JButton("SUBMIT");
		btnSignup.setBorder(UIManager.getBorder("Button.border"));
		btnSignup.setFocusable(false);
		btnSignup.setForeground(Color.WHITE);
		btnSignup.setBackground(new Color(0, 102, 255));
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try{
					String usersu=textField.getText();
					String passsu=textField_1.getText();
					String repasssu=textField_2.getText();
					if(usersu.equals("") || passsu.equals("") ||repasssu.equals(""))
		    		{
						  JOptionPane.showMessageDialog(null,"username or password is empty","Warning",JOptionPane.WARNING_MESSAGE);	 
		    		}	
					else
					{
					conn = Drivers.myconn();	
			    	Statement stmt1 = conn.createStatement();
			    	ResultSet rs1=stmt1.executeQuery("select * from user");
			    	while(rs1.next())
			    	{
                        if(rs1.getString("username").equals(usersu))
                        {
                       	 JOptionPane.showMessageDialog(null,"Username already Exists","Info",JOptionPane.INFORMATION_MESSAGE);
                           flag = 1;
                           textField.setText("");
                           textField_1.setText("");
                           textField_2.setText("");
                           break;
                        }
                        else if(flag==0 && passsu.equals(repasssu)){
     					   PreparedStatement smt=conn.prepareStatement("insert into user(username,password) values(?,?)");
     					   smt.setString(1, usersu);
     					   smt.setString(2, repasssu);
     					   smt.executeUpdate();
     					  JOptionPane.showMessageDialog(null,"Sign up Successful","Info",JOptionPane.INFORMATION_MESSAGE);
     					  dispose();
     					  new Mainwindow();	
     					  break;
                        }
                        
                        else if (flag==0 && !(passsu.equals(repasssu))) {
      					  JOptionPane.showMessageDialog(Signup.this,"Retyped password incorrect","Warning",JOptionPane.WARNING_MESSAGE);
      					  textField_2.setText("");
      					  break;
      				  }

			    	}
				}
				}
				catch(SQLException e5)
				{
					e5.printStackTrace();
				}
			}
		});
		btnSignup.setFont(new Font("Arial", Font.BOLD, 13));
		btnSignup.setBounds(271, 285, 205, 29);
		contentPane.add(btnSignup);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(0, 102, 255));
		btnNewButton.setBounds(477, 0, 23, 23);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(Color.BLUE));
		separator.setBackground(Color.BLUE);
		separator.setForeground(Color.BLUE);
		separator.setBounds(271, 139, 205, 3);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLUE);
		separator_1.setBorder(new LineBorder(Color.BLUE));
		separator_1.setBackground(Color.BLUE);
		separator_1.setBounds(271, 198, 205, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBorder(new LineBorder(Color.BLUE));
		separator_2.setForeground(Color.BLUE);
		separator_2.setBackground(Color.BLUE);
		separator_2.setBounds(271, 253, 205, 2);
		contentPane.add(separator_2);
		
		JLabel label = new JLabel("");
		label.setBounds(58, 94, 150, 200);
		Image img=new ImageIcon(this.getClass().getResource("/signup.png")).getImage();
		label.setIcon(new ImageIcon(img));
		contentPane.add(label);
	}

}
