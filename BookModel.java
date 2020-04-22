
public class BookModel  
{
    private int bid;
    private String bname;
    private String bauthor;

    public BookModel(){}

    public void setBookId(int bid)
    {
        this.bid = bid;
    }
    
    public int getBookId()
    {
        return bid;
    }

    public void setBookName(String bname)
    {
        this.bname = bname;
    }

    public String getBookName()
    {
        return bname;
    }

    public void setBookAuthor(String bauthor)
    {
        this.bauthor = bauthor;
    }

    public String getBookAuthor()
    {
        return bauthor;
    }
}