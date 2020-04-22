
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import javax.swing.JOptionPane;

public class BookController implements ActionListener 
{
    private BookModel bookmodel;
    private BookView bookview;
    private Connection con=null;
	private Statement stmt=null;

    BookController(BookModel bookmodel,BookView bookview)
    {
        this.bookmodel = bookmodel;
        this.bookview = bookview;
        this.bookview.addBookListener(this);

		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			this.con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306","root","Harshit27@J");
            System.out.println("connection established");
            this.stmt = this.con.createStatement();
        }
        catch(Exception e)
		{
			System.out.println("Error"+e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        String s = null;
        if(bookview.getLogin(e))
        {
            s = "SELECT username,password FROM librarymanagement.Admin WHERE username = '"+this.bookview.getT_username()+"' and password = '"+this.bookview.getT_password()+"'";
            try{
                ResultSet rs = this.stmt.executeQuery(s);
                if(!rs.next())
                {
                    throw new SQLException();
                }   
                bookview.setStateOfLoginPanel(false);
                bookview.setStateForAll(false, false, false, false, false, false, true, true, true, false, false, false, false, false,true);
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "USER DOESN'T EXISTS!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(bookview.getAddBook(e))
        {
            bookview.setStateForAll(true, true, true, true, true, true, false, false, false, true, false, false, false, false, false);
        }
        else if(bookview.getRemBook(e))
        {
            bookview.setStateForAll(true, false, false, true, false, false, false, false, false, false, false, false, false, true,  false);
        }    
        else if(bookview.getSearchBook(e))
        {
            bookview.setStateForAll(true, false, false, true, false, false, false, false, false, false, false, true, false, false ,false);
        }
        else if(bookview.getLogout(e))
        {
            bookview.setStateForAll(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
            bookview.setStateOfLoginPanel(true);
        }
        else if(bookview.getAdd(e))
        {
            s = "INSERT INTO librarymanagement.book values("+bookview.getT_bid()+",'"+bookview.getT_bname()+"','"+bookview.getT_bauthor()+"');";
            try{
                this.stmt.executeUpdate(s);
                JOptionPane.showMessageDialog(null, "BOOK ADDED SUCCESSFULLY!", "SUCCESS" ,JOptionPane.INFORMATION_MESSAGE);
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "BOOK WITH ENTERED ID ALREADY EXISTS!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            bookview.setStateForAll(false, false, false, false, false, false, true, true, true, false, false, false, false, false, true);
        }
        else if(bookview.getRem(e))
        {
            s = "DELETE FROM librarymanagement.book WHERE id = "+this.bookview.getT_bid();
            try{
                this.stmt.executeUpdate(s);
                JOptionPane.showMessageDialog(null, "REMOVED BOOK SUCCESSFULLY", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                bookview.setStateForAll(false, false, false, false, false, false, true, true, true, false, false, false, false, false, true);
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Can't Remove!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(bookview.getSearch(e))
        {
            s = "SELECT id,name,author FROM librarymanagement.book WHERE id = "+this.bookview.getT_bid();
            try{
                ResultSet rs = this.stmt.executeQuery(s);
                if(!rs.next())
                {
                    throw new SQLException();
                }   
                rs = this.stmt.executeQuery(s);
                while(rs.next())
                {
                    bookview.setT_bid(rs.getInt("id"));
                    bookview.setT_bname(rs.getString("name"));
                    bookview.setT_bauthor(rs.getString("author"));
                }
                bookview.setStateForAll(true, true, true, true, true, true, false, false, false, false, false, false, true, false, false);
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "BOOK WITH ENTERD ID DOESN'T EXIST!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(bookview.getMenu(e))
        {
            bookview.setStateForAll(false, false, false, false, false, false, true, true, true, false, false, false, false, false, true);
        }
        else if(bookview.getSearchAndRem(e))
        {
            s = "SELECT id,name,author FROM librarymanagement.book WHERE id = "+this.bookview.getT_bid();
            try{
                ResultSet rs = this.stmt.executeQuery(s);
                if(!rs.next())
                {
                    throw new SQLException();
                }   
                rs = this.stmt.executeQuery(s);
                while(rs.next())
                {
                    bookview.setT_bid(rs.getInt("id"));
                    bookview.setT_bname(rs.getString("name"));
                    bookview.setT_bauthor(rs.getString("author"));
                }
                bookview.setStateForAll(true, true, true, true, true, true, false, false, false, false, true, false, false, false, false);
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "BOOK WITH ENTERD ID DOESN'T EXIST!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}