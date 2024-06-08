package finalProject;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        int menu, quit = 0;
        String filename = "book.txt";
        Scanner in = null;
        String input;
        String bookName;
        String authorName;
        int num;
        String[] list;
        BookCRUD manager = new BookCRUD();
        try {
            in = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println(filename + " is not found.");
            System.exit(0);
        }
        while (in.hasNextLine()) {
            input = in.nextLine();
            list = input.split("-");
            if (list.length == 3) {
                bookName = list[0];
                authorName = list[1];
                num = Integer.parseInt(list[2]);

                manager.addBook(bookName, authorName, num);
            } else {
                System.out.println("Invalid line format: " + input);
            }
        }
        System.out.println("Welcome to the henry's library!");
        Scanner s = new Scanner(System.in);
        PrintWriter out = null;
        while (true) {
            System.out.println("");
            System.out.println("****** MENU ******");
            System.out.println("1. Add a Book");
            System.out.println("2. Return a Book");
            System.out.println("3. BookList");
            System.out.println("4. Delete a Book");
            System.out.println("5. Loan a Book");
            System.out.println("6. Find Book");
            System.out.println("0. Exit");
            System.out.println("");
            System.out.print("Choose Menu : ");
            
            if (s.hasNextInt()) {
                menu = s.nextInt();
                s.nextLine();
                switch (menu) {
                    case 1:
                        manager.addBook();
                        break;
                    case 2:
                        manager.editBook();
                        break;
                    case 3:
                        manager.listBook();
                        break;
                    case 4:
                        manager.deleteBook();
                        break;
                    case 5:
                        manager.loanBook();
                        break;
                    case 6:
                        manager.findBook();
                        break;
                    case 0:
                        System.out.println("Bye!");
                        quit = 1;
                        break;
                    default:
                        System.out.println("Invalid menu choice.");
                }
                if (quit == 1) break;
            } else {
                System.out.println("Please enter a valid number.");
                s.next();
            }
        }
        
        try {
            out = new PrintWriter(filename);
        } catch (FileNotFoundException e) {
            System.out.println(filename + " is not found!");
        }
        for (int i = 0; i < manager.list.size(); i++) {
            out.println(manager.list.get(i).get_author() + "-" + manager.list.get(i).get_name() + "-" + manager.list.get(i).get_num());
        }
        in.close();
        out.close();
        s.close();
    }
}
