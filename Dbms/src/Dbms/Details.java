package Dbms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Details extends JFrame
 {
    JFrame jf=new JFrame();
    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
 	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

  public Details()
  {
    jf.getContentPane().setLayout(null);

    scrlPane.setBounds(0,0,994,501);
    jf.getContentPane().add(scrlPane);
    tabGrid.setFont(new Font ("Times New Roman",0,15));

    model.addColumn("ID");model.addColumn("NAME");model.addColumn("GENDER");model.addColumn("AGE");
  	model.addColumn("HEIGHT");model.addColumn("ROLE");model.addColumn("COUNTRY");

  		int r = 0;
     try
     {

     	Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","QWERTY");
		System.out.println("Connected to database.");
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery("select * from player");
          while(rs.next())
            {
            	model.insertRow(r++,new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});

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


    jf.setTitle("PLAYER DETAILS");
    jf.setSize(1000,600);
	jf.setLocation(190,50);
	jf.setResizable(false);
    jf.getContentPane().setBackground(Color.WHITE);
    
    JButton btnHome = new JButton("HOME");
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
    	new Details();
    }
}
