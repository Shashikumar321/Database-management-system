package Dbms;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;

public class Rank extends JFrame
 {
    JFrame jf=new JFrame();
    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
 	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    private final JButton btnHome = new JButton("HOME");

  public Rank()
  {
    jf.getContentPane().setLayout(null);

    scrlPane.setBounds(0,0,994,501);
    jf.getContentPane().add(scrlPane);
    tabGrid.setFont(new Font ("Times New Roman",0,15));

    model.addColumn("PLAYER ID");model.addColumn("PLAYER NAME");model.addColumn("ODI RANK");model.addColumn("T20 RANK");
  	model.addColumn("TEST RANK");

  		int r = 0;
     try
     {

     	Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","QWERTY");
		System.out.println("Connected to database.");
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery("select * from rank");
          while(rs.next())
            {
            	model.insertRow(r++,new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});

            }

             con.close();
       }
      catch(SQLException se)
       {
       	  System.out.println(se);
          JOptionPane.showMessageDialog(null,"SQL Error:"+se);
       }
       catch(Exception e)
       {
       	   System.out.println(e);
           JOptionPane.showMessageDialog(null,"Error:"+e);
       }


    jf.setTitle("PLAYER RANK");
    jf.setSize(1000,600);
	jf.setLocation(190,50);
	jf.setResizable(false);
    jf.getContentPane().setBackground(Color.WHITE);
    btnHome.addActionListener(new ActionListener() {
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
    btnHome.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
    btnHome.setBounds(895, 537, 89, 23);
    
    jf.getContentPane().add(btnHome);
    jf.setVisible(true);
  }


  public static void main1(String args[])
    {
    	new Rank();
    }
}
