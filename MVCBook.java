
public class MVCBook
{
    public static void main(String[] args) {
        BookModel bookmodel = new BookModel();
        BookView bookview = new BookView("Library");
        BookController bookcontroller = new BookController(bookmodel,bookview);
    }
}