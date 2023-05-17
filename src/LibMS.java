import java.util.Arrays;

class Library{
        String [] availableBooks = new String[100];
        String [] issuedBooks = new String[100];
        int numAvailableBooks = 0;
        int numIssuedBooks = 0;

        //adding books
        void addBook(String book) {
            this.availableBooks[this.numAvailableBooks] = book;
            this.numAvailableBooks++;
            System.out.printf("%s has been added", book);
            System.out.println();
        }

        //Showing available books
        void showAvailableBooks(){
            System.out.println("The available books are: ");
            for (String book : this.availableBooks){
                if(book == null){
                    continue;
                }
                System.out.println("* " + book);
            }
        }

        void issueBook(String book){
            for(int i = 0; i<this.availableBooks.length; i++){
                if(book == this.availableBooks[i]){
                    System.out.println(book + " has been issued");
                }
            }
        }
}

public class LibMS  {
    public static void main(String[] args) {

    Library lib = new Library();
    for (String book : Arrays.asList("Summer Love","Saya", "karnali Blues", "Docha"))
        lib.addBook(book);
    lib.showAvailableBooks();

    lib.issueBook("Summer Love");


    }
}

