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
                if(book == null) break;
                System.out.println("* " + book);
            }
        }

        //issuing book

        void issueBook(String book){
            boolean issued = false;
            for(String bo: this.issuedBooks) {
                if (book .equals(bo)){
                    System.out.println("books has already been issued please come after 5 days");
                    issued = true;
                }
            }
            if(!issued) {
                boolean found = false;
                for (int i = 0; i < this.availableBooks.length; i++) {
                    if (book .equals(this.availableBooks[i])) {

                        //remove the book from available books
                        for (int j = i; j < this.availableBooks.length - 1; j++) {
                            this.availableBooks[j] = this.availableBooks[j + 1];
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
                if (!found) {
                    System.out.println("Book not available in the library");
                }
            }
        }

        //showing issued book
        void showIssuedBook(){
            for(String book : this.issuedBooks){
                if(book == null){
                    break;
                }
                System.out.println("* "+  book);
            }
        }

        //returning book
        void returnBook(String book){
            boolean identify = false;
            for(int i = 0; i<this.issuedBooks.length;i++){
                if(book == this.issuedBooks[i]){
                    System.out.println("thankyou for returning the book");
                    for(int j = i; j < this.issuedBooks.length-1; j++){
                        this.issuedBooks[j] = this.issuedBooks[j+1];
                    }
                this.numIssuedBooks--;
                this.availableBooks[this.numAvailableBooks] = book;
                this.numAvailableBooks++;

                identify = true;
                break;
                }
            }
            if(!identify){
                System.out.println("Book not belong to this library");
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
    lib.issueBook("Saya");
    lib.issueBook("Saya");
    lib.issueBook("Docha");
    lib.showIssuedBook();
    lib.returnBook("Saya");
    lib.showAvailableBooks();
    System.out.println(lib.numIssuedBooks);


    }
}

