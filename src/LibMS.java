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
            boolean found = false;
            for(int i = 0; i<this.availableBooks.length; i++){
                if(book == this.availableBooks[i]){

                    //remove the book from available books
                    for (int j = i; j<this.availableBooks.length-1; j++){
                        this.availableBooks[j] =this.availableBooks[j+1];
                    }
                    this.numAvailableBooks--;

                    //adding book into issued book
                    this.issuedBooks[this.numIssuedBooks] = book;
                    numIssuedBooks++;

                    //notifying the book has been issued
                    System.out.println(book + " has been issued");

                    //found the book?
                    found = true;
                    break;
                }
            }
            if(!found) {
                System.out.println("Book not available in the library");
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
    lib.issueBook("Summer Love");


    }
}

