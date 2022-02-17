package Dbms;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Driver;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.border.LineBorder;

public class Login extends JFrame  {

	private JPanel contentPane;
	private JTextField txtCreate;
	private JPasswordField passwordField;
    public Connection conn;
    int flag=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setUndecorated(true);
		setType(Type.POPUP);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(500,370);
		setLocationRelativeTo(null);		
		
		
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);*/
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBackground(new Color(0, 51, 255));
		lblUsername.setForeground(new Color(0, 51, 255));
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 13));
		lblUsername.setBounds(271, 99, 89, 14);
		contentPane.add(lblUsername);
		
		txtCreate = new JTextField();
		txtCreate.setToolTipText("Create a  Username");
		txtCreate.setForeground(Color.BLACK);
		txtCreate.setBorder(null);
		txtCreate.setBackground(Color.WHITE);
		txtCreate.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCreate.setBounds(271, 118, 205, 23);
		contentPane.add(txtCreate);
		txtCreate.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 51, 255));
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPassword.setBounds(271, 156, 95, 14);
		contentPane.add(lblPassword);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("I accept the terms and conditions");
		chckbxNewCheckBox.setFocusable(false);
		chckbxNewCheckBox.setToolTipText("PLEASE ACCEPT");
		chckbxNewCheckBox.setForeground(new Color(0, 51, 255));
		chckbxNewCheckBox.setHideActionText(true);
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setFont(new Font("Arial", Font.ITALIC, 12));
		chckbxNewCheckBox.setBounds(267, 216, 205, 23);
		contentPane.add(chckbxNewCheckBox);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 12));
		passwordField.setBounds(271, 176, 205, 23);
		contentPane.add(passwordField);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.setFocusable(false);
		btnSignUp.setBorder(UIManager.getBorder("Button.border"));
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(new Color(0, 204, 51));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Signup();
			}
		});
		btnSignUp.setFont(new Font("Arial", Font.BOLD, 14));
		btnSignUp.setBounds(329, 335, 95, 23);
		contentPane.add(btnSignUp);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFocusable(false);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setToolTipText("CLICK HERE TO LOGIN");
		btnLogin.setBackground(new Color(0, 102, 255));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			
		{
				
				if(chckbxNewCheckBox.isSelected())
				{
				String pass=String.valueOf(passwordField.getPassword());
				String user=txtCreate.getText();
				conn = Drivers.myconn();
				try
				{
				
			    	Statement stmt = conn.createStatement();
			    	ResultSet rs= stmt.executeQuery("select * from user");
			    	while(rs.next()){
			    		if(rs.getString("username").equals(user) && rs.getString("password").equals(pass))
			    		{	
			    			dispose();
			    			new Mainwindow();
			    			flag=1;
			    		
			    		}
			    	}
				}
			    		catch(Exception e1)
						{
							System.out.println(e1);
						}
			    	
			    			
			    		if(flag==0) 
			    		{
			    				getToolkit().beep();
								JOptionPane.showMessageDialog(Login.this, "Invalid Username and Password","Warning",JOptionPane.WARNING_MESSAGE);
								passwordField.setText(null);
								txtCreate.setText(null);
								
							}
			    		
			    	}
				
		
			else
			{
				getToolkit().beep();
				JOptionPane.showMessageDialog(Login.this, "PLEASE AGREE THE TERMS AND CONDITIONS","Warning",JOptionPane.WARNING_MESSAGE);
			}
		}
		});
	
		
		
		btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
		btnLogin.setBounds(271, 257, 205, 29);
		contentPane.add(btnLogin);
		
		JButton btnX = new JButton("X");
		btnX.setToolTipText("EXIT");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnX.setFocusable(false);
		btnX.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnX.setForeground(Color.WHITE);
		btnX.setBorder(null);
		btnX.setBackground(new Color(0, 102, 255));
		btnX.setBounds(477, 0, 23, 23);
		contentPane.add(btnX);
		
		JLabel lblLogin = new JLabel("Login page");
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 18));
		lblLogin.setBounds(197, 36, 105, 29);
		contentPane.add(lblLogin);
		
		JLabel lblNewUser = new JLabel("New user ? Register now");
		lblNewUser.setForeground(new Color(0, 51, 255));
		lblNewUser.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewUser.setBounds(307, 310, 142, 14);
		contentPane.add(lblNewUser);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBorder(new LineBorder(Color.BLUE));
		separator.setBackground(Color.BLUE);
		separator.setBounds(271, 140, 205, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLUE);
		separator_1.setBorder(new LineBorder(new Color(0, 0, 255)));
		separator_1.setBackground(Color.BLUE);
		separator_1.setBounds(271, 197, 205, 3);
		contentPane.add(separator_1);
		
		JLabel label = new JLabel("");
		label.setToolTipText("Cricket Player Statistics Database");
		label.setBackground(new Color(255, 255, 255));
		label.setBounds(66, 94, 150, 200);
		Image img=new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		label.setIcon(new ImageIcon(img));
		contentPane.add(label);
	}
}
	
