
import java.awt.event.*;
import javax.swing.*;

public class BookView extends JFrame
{
    private JLabel l_bid,l_bname,l_bauthor,l_username,l_password,l_loginpanel;
    private JTextField t_bid,t_bname,t_bauthor,t_username;
    private JPasswordField t_password; 
    private JButton addbook,rembook,searchbook,add,rem,searchandrem,search,menu,login,logout;

    BookView(String s)
    {
        super(s);
        addbook = new JButton("ADD BOOK");
        rembook = new JButton("REMOVE BOOK");
        searchbook = new JButton("SEARCH BOOK");
        menu = new JButton("MENU");
        l_loginpanel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        l_username = new JLabel("USERNAME");
        l_password = new JLabel("PASSWORD");
        t_username = new JTextField();
        t_password = new JPasswordField();
        login = new JButton("LOGIN");
        logout = new JButton("LOGOUT");
        l_bid = new JLabel("BOOK ID :");
        l_bname = new JLabel("BOOK NAME :");
        l_bauthor = new JLabel("BOOK AUTHOR :");
        t_bid = new JTextField();
        t_bname = new JTextField();
        t_bauthor = new JTextField();
        add = new JButton("ADD BOOK");
        rem = new JButton("REMOVE BOOK");
        search = new JButton("SEARCH BOOK");
        searchandrem = new JButton("SEARCH BOOK");
        menu = new JButton("RETURN TO MENU");
        setLayout(null);
        setSize(400,400);
        l_loginpanel.setBounds(100,50,200,40);
        l_username.setBounds(50,100,130,40);
        l_password.setBounds(50,150,130,40);
        t_username.setBounds(150,100,180,40);
        t_password.setBounds(150,150,180,40);
        login.setBounds(100,200,200,40);
        logout.setBounds(100,200,200,40);
        addbook.setBounds(100,50,200,40);
        rembook.setBounds(100,100,200,40);
        searchbook.setBounds(100,150,200,40);
        l_bid.setBounds(50,50,130,40);
        l_bname.setBounds(50,100,130,40);
        l_bauthor.setBounds(50,150,130,40);
        t_bid.setBounds(200,50,150,40);
        t_bname.setBounds(200,100,150,40);
        t_bauthor.setBounds(200,150,150,40);
        add.setBounds(100,200,200,40);
        rem.setBounds(100,200,200,40);
        searchandrem.setBounds(100,100,200,40);
        search.setBounds(100,100,200,40);
        menu.setBounds(100,200,200,40);
        add(l_loginpanel);
        add(l_username);
        add(l_password);
        add(t_username);
        add(t_password);
        add(login);
        add(l_bid);
        add(l_bname);
        add(l_bauthor);
        add(t_bid);
        add(t_bname);
        add(t_bauthor);
        add(t_password);
        add(addbook);   
        add(rembook);
        add(searchbook);
        add(logout);
        add(rem);
        add(search);
        add(menu);
        add(add);
        add(searchandrem);
        addbook.setVisible(false);
        searchbook.setVisible(false);
        rembook.setVisible(false);
        logout.setVisible(false);
        l_bid.setVisible(false);
        l_bname.setVisible(false);
        l_bauthor.setVisible(false);
        t_bid.setVisible(false);
        t_bname.setVisible(false);
        t_bauthor.setVisible(false);
        add.setVisible(false);
        rem.setVisible(false);
        search.setVisible(false);
        menu.setVisible(false);
        searchandrem.setVisible(false);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getT_username()
    {
        return t_username.getText();
    }

    public String getT_password()
    {
        return String.valueOf(t_password.getPassword());
    }

    public int getT_bid()
    {
        return Integer.parseInt(t_bid.getText());
    }

    public void setT_bid(int bid)
    {
        t_bid.setText(Integer.toString(bid));
    }
    
    public String getT_bname()
    {
        return t_bname.getText();
    }
    
    public void setT_bname(String bname)
    {
        t_bname.setText(bname);
    }

    public String getT_bauthor()
    {
        return t_bauthor.getText();
    }

    public void setT_bauthor(String author)
    {
        t_bauthor.setText(author);
    }

    public void setStateOfLoginPanel(boolean bool)
    {
        this.l_loginpanel.setVisible(bool);
        this.l_username.setVisible(bool);
        this.l_password.setVisible(bool);
        this.t_username.setVisible(bool);
        this.t_password.setVisible(bool);
        this.login.setVisible(bool);
    }

    public void setStateForAll(boolean l_bid,boolean l_bname,boolean l_bauthor,boolean t_bid,boolean t_bname,boolean t_bauthor,
                                boolean addbook,boolean rembook,boolean searchbook,boolean add,boolean rem,boolean search,
                                boolean menu,boolean searchandrem,boolean logout)
    {
        this.l_bid.setVisible(l_bid);
        this.l_bname.setVisible(l_bname);
        this.l_bauthor.setVisible(l_bauthor);
        this.t_bid.setVisible(t_bid);
        this.t_bname.setVisible(t_bname);
        this.t_bauthor.setVisible(t_bauthor);
        this.addbook.setVisible(addbook);
        this.rembook.setVisible(rembook);
        this.searchbook.setVisible(searchbook);
        this.logout.setVisible(logout);
        this.add.setVisible(add);
        this.rem.setVisible(rem);
        this.search.setVisible(search);
        this.menu.setVisible(menu);
        this.searchandrem.setVisible(searchandrem);
    }

    public boolean getLogin(ActionEvent e)
    {   
        return e.getSource() == login;
    }

    public boolean getLogout(ActionEvent e)
    {   
        return e.getSource() == logout;
    }

    public boolean getAddBook(ActionEvent e)
    {   
        return e.getSource() == addbook;
    }

    public boolean getRemBook(ActionEvent e)
    {   
        return e.getSource() == rembook;
    }

    public boolean getSearchBook(ActionEvent e)
    {   
        return e.getSource() == searchbook;
    }

    public boolean getAdd(ActionEvent e)
    {   
        return e.getSource() == add;
    }

    public boolean getRem(ActionEvent e)
    {   
        return e.getSource() == rem;
    }

    public boolean getSearch(ActionEvent e)
    {   
        return e.getSource() == search;
    }

    public boolean getMenu(ActionEvent e)
    {   
        return e.getSource() == menu;
    }

    public boolean getSearchAndRem(ActionEvent e)
    {   
        return e.getSource() == searchandrem;
    }

    void addBookListener(ActionListener listenForButton){
        login.addActionListener(listenForButton);
        logout.addActionListener(listenForButton);
        addbook.addActionListener(listenForButton);
        rembook.addActionListener(listenForButton);
        searchbook.addActionListener(listenForButton);
        add.addActionListener(listenForButton);
        rem.addActionListener(listenForButton);
        search.addActionListener(listenForButton);
        menu.addActionListener(listenForButton);
        searchandrem.addActionListener(listenForButton);
    }
}