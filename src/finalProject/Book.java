package finalProject;
public class Book extends Thing implements  BookInterface  {
    private String name;
    private String author;
    private int num;

    public Book(String name, String author, int num) {
        this.name = name;
        this.author = author;
        this.num = num;
    }

    public String get_name() {
        return name;
    }

    public String get_author() {
        return author;
    }

    public int get_num() {
        return num;
    }

    public void numPlus() {
        this.num++;
    }

    public void numMinus() {
        this.num--;
    }

    public void set_name(String name)
    {
        this.name = name;
    }

    public void set_author(String author)
    {
        this.author = author;
    }

    public void set_num(int num)
    {
        this.num = num;
    }


    @Override
    public String toString() {
        return "Book [name=" + name + ", author=" + author + ", num=" + num + "]";
    }
}
