package finalProject;

import java.util.ArrayList;
import java.util.Scanner;

public class BookCRUD implements BookCRUDInterface {
    ArrayList<Book> list = new ArrayList<Book>();

    public void addBook() {
        int num;
        String name, author;
        Scanner s = new Scanner(System.in);
        System.out.print("Book name > ");
        name = s.nextLine();
        System.out.print("Author > ");
        author = s.nextLine();
        System.out.print("How many? ");
        num = s.nextInt();
        s.nextLine();
        Book new_book = new Book(name, author, num);
        list.add(new_book);
    }

    public void addBook(String bookName, String authorName, int num) {
        Book new_book = new Book(bookName, authorName, num);
        list.add(new_book);
    }

    public void editBook() {
        String name;
        int index = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("What is the book name do you want to return? > ");
        name = s.nextLine();
        Book new_book = find(name);
        if (new_book == null) {
            System.out.println("Our library does not have this book.");
        } else {
            index = findIndex(new_book);
            new_book.numPlus();
            list.set(index, new_book);
        }
    }

    public void listBook() {
        System.out.println("Book Name                          	   Author               Count");
        for (int i = 0; i < list.size(); i++) {
            Book book = list.get(i);
            System.out.printf("%-40.40s %-20.20s %5d\n", book.get_name(), book.get_author(), book.get_num());
        }
    }

    public void deleteBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book Name to Delete: ");
        String bookName = sc.nextLine();
        boolean removed = list.removeIf(book -> book.get_name().equals(bookName));
        if (removed) {
            System.out.println(bookName + " has been deleted.");
        } else {
            System.out.println(bookName + " not found.");
        }
    }

    public void loanBook() {
        String name;
        int index = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("What is the book name do you want to borrow? > ");
        name = s.nextLine();
        Book new_book = find(name);
        if (new_book == null) {
            System.out.println("Our library does not have this book.");
        } else {
            index = findIndex(new_book);
            new_book.numMinus();
            list.set(index, new_book);
        }
    }

    public Book find(String name) {
        for (Book book : list) {
            if (book.get_name().equals(name)) {
                return book;
            }
        }
        return null;
    }

    public int findIndex(Book p) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get_name().equals(p.get_name())) {
                return i;
            }
        }
        return -1;
    }

    public void findBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book Name to Find: ");
        String bookName = sc.nextLine();
        boolean found = false;
        for (Book book : list) {
            if (book.get_name().equals(bookName)) {
                System.out.println(book);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Our library does not have this book.");
        }
    }
}
