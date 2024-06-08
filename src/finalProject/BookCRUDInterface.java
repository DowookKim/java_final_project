package finalProject;

public interface BookCRUDInterface {
	public void addBook();
	public void addBook(String bookName, String authorName,int num);
	public void editBook();
	public void listBook();
	public void deleteBook();
	public void loanBook();
}
