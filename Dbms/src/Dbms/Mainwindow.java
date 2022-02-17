package Dbms;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.ComponentOrientation;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.ListSelectionModel;

public class Mainwindow extends JFrame {

	private JPanel contentPane;
	public Connection Conn3;
	private JTextField textField;
	public String nameTxt;
	
	public Mainwindow() throws SQLException {
		setUndecorated(true);
		setTitle("HOME");
		setBackground(new Color(204, 204, 51));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		countComponents();
		Toolkit tk=Toolkit.getDefaultToolkit();
		int xsize=(int) tk.getScreenSize().getWidth();
		int ysize=(int) tk.getScreenSize().getHeight();
		setSize(1000,600);
		setLocationRelativeTo(null);
		
		final DefaultListModel DLM = new DefaultListModel();

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		final JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setVisibleRowCount(20);
		list.setBackground(new Color(240, 240, 240));
		list.setForeground(new Color(0, 0, 0));
		list.setFont(new Font("Simplified Arabic Fixed", Font.PLAIN, 16));
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String Selected=list.getSelectedValue().toString();
				textField.setText(Selected);
			}
		});
		list.setBounds(218, 84, 160, 516);
		contentPane.add(list);
		
		
		JButton btnAddPlayer = new JButton("Add player");
		btnAddPlayer.setBackground(new Color(240, 240, 240));
		btnAddPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			new Addplayer();
			}
		});
		btnAddPlayer.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 14));
		btnAddPlayer.setBounds(421, 138, 140, 140);
		contentPane.add(btnAddPlayer);
		
		JButton btnDeletePlayer = new JButton("Delete player");
		btnDeletePlayer.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		btnDeletePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				int index=list.getSelectedIndex();
				DLM.removeElementAt(index);
				
				Conn3 = Drivers.myconn();	
				Statement stmt1 = Conn3.createStatement();
				PreparedStatement pst = Conn3.prepareStatement("delete from player where pname = ?");
			    	pst.setString(1, textField.getText());
			    	pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "PLAYER DELETED");
				
				}
				catch(SQLException e11)
				{
					
				}
			}

		});
		btnDeletePlayer.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 11));
		btnDeletePlayer.setBounds(802, 138, 140, 140);
		contentPane.add(btnDeletePlayer);
		
		JButton btnUpdatePlayer = new JButton("Update player");
		btnUpdatePlayer.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		btnUpdatePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				try{
					new Update();
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, e);
					}
				}
			
		});
		btnUpdatePlayer.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 11));
		btnUpdatePlayer.setBounds(421, 319, 140, 140);
		contentPane.add(btnUpdatePlayer);
		

		JButton btnUpdateStatistics = new JButton("Update stats");
		btnUpdateStatistics.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		btnUpdateStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Updatestat();
			}
		});
		btnUpdateStatistics.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 11));
		btnUpdateStatistics.setBounds(611, 319, 140, 140);
		contentPane.add(btnUpdateStatistics);
		
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Login();
			}
		});
		btnLogout.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		btnLogout.setHideActionText(true);
		btnLogout.setBounds(802, 318, 140, 140);
		contentPane.add(btnLogout);
		
		
		JButton btnPlayers = new JButton("Players");
		btnPlayers.setSelected(true);
		btnPlayers.setFocusable(false);
		btnPlayers.setForeground(new Color(255, 255, 255));
		btnPlayers.setBorder(null);
		btnPlayers.setBackground(new Color(0, 153, 255));
		btnPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				
				
				try{
				Conn3 = Drivers.myconn();	
		    	Statement stmt1 = Conn3.createStatement();
		    	ResultSet rs2=stmt1.executeQuery("select pname from player");
		    	while(rs2.next())
		    	{
				try {
					DLM.addElement(rs2.getString("pname"));
				} catch (SQLException e) {
		
					e.printStackTrace();
				}
				list.setModel(DLM);
		    	}
				}
		    	catch(SQLException e){
		    		e.printStackTrace();
		    	}
			
			}
		});
		btnPlayers.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 15));
		btnPlayers.setBounds(243, 47, 110, 22);
		contentPane.add(btnPlayers);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 255));
		panel.setBounds(0, 0, 190, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JButton btnDetails = new JButton("Details         ");
		btnDetails.setFocusable(false);
		btnDetails.setForeground(new Color(255, 255, 255));
		btnDetails.setBackground(new Color(0, 102, 255));
		btnDetails.setBounds(0, 230, 190, 38);
		panel.add(btnDetails);
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Dbms.Details.main1(null);
				
			}
		});
		btnDetails.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 14));
		
		JButton btnTournament = new JButton("Tournament      ");
		btnTournament.setFocusable(false);
		btnTournament.setForeground(new Color(255, 255, 255));
		btnTournament.setBackground(new Color(0, 102, 255));
		btnTournament.setBounds(0, 267, 190, 38);
		panel.add(btnTournament);
		btnTournament.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Tournament();
			}
		});
		btnTournament.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 14));
		
		JButton btnFixtures = new JButton("Fixtures        ");
		btnFixtures.setFocusable(false);
		btnFixtures.setForeground(new Color(255, 255, 255));
		btnFixtures.setBackground(new Color(0, 102, 255));
		btnFixtures.setBounds(0, 303, 190, 38);
		panel.add(btnFixtures);
		btnFixtures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Fixtures();
			}
		});
		btnFixtures.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 14));
		
		JButton btnRank = new JButton("Rank            ");
		btnRank.setFocusable(false);
		btnRank.setForeground(new Color(255, 255, 255));
		btnRank.setBackground(new Color(0, 102, 255));
		btnRank.setBounds(0, 339, 190, 38);
		panel.add(btnRank);
		btnRank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Rank();
			}
		});
		btnRank.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 14));
		
		JButton btnStatistics = new JButton("Statistics      ");
		btnStatistics.setFocusable(false);
		btnStatistics.setForeground(new Color(255, 255, 255));
		btnStatistics.setBackground(new Color(0, 102, 255));
		btnStatistics.setBounds(0, 376, 190, 38);
		panel.add(btnStatistics);
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Statistics();
			}
		});
		btnStatistics.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 14));
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setForeground(new Color(255, 255, 255));
		textField.setBorder(null);
		textField.setBackground(new Color(0, 102, 255));
		textField.setBounds(10, 108, 180, 26);
		panel.add(textField);
		textField.setFont(new Font("Arial", Font.BOLD, 14));
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(10, 133, 180, 2);
		panel.add(separator);
		
		JLabel lblSelectedPlayer = new JLabel("Selected Player");
		lblSelectedPlayer.setForeground(new Color(255, 255, 255));
		lblSelectedPlayer.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSelectedPlayer.setBounds(10, 90, 100, 14);
		panel.add(lblSelectedPlayer);
		
		JLabel lblHome = new JLabel("HOME");
		lblHome.setIcon(new ImageIcon(Mainwindow.class.getResource("/com/sun/java/swing/plaf/windows/icons/HomeFolder.gif")));
		lblHome.setForeground(new Color(255, 255, 255));
		lblHome.setBackground(new Color(0, 102, 255));
		lblHome.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 19));
		lblHome.setBounds(10, 11, 80, 18);
		panel.add(lblHome);
		
		JButton btnAddStats = new JButton("Add stats");
		btnAddStats.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 14));
		btnAddStats.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		btnAddStats.setBounds(611, 137, 140, 140);
		contentPane.add(btnAddStats);
		
		JButton btnX = new JButton("X");
		btnX.setBackground(new Color(0, 102, 255));
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnX.setFocusable(false);
		btnX.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setBounds(965, 0, 45, 40);
		contentPane.add(btnX);
		
		
		
		
	}
}
