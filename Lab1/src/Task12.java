import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Task12 {

    public static class Book implements Comparable<Book>{
        private String title;
        private String author;
        private int price;
        private static int edition;
        private Integer isbn;

        public class NameComparator implements Comparator<Book> {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.title.compareTo(o2.title);
            }
        }

        public class AuthorComparator implements Comparator<Book>{
            @Override
            public int compare(Book first, Book second) {
                return first.author.compareTo(second.author);
            }
        }

        public class PriceComparator implements Comparator<Book>{
            @Override
            public int compare(Book first, Book second) {
                return first.price - second.price;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Book book = (Book) o;
            return price == book.price && Objects.equals(title, book.title) && Objects.equals(author, book.author);
        }

        @Override
        public int compareTo(Book book){
            return this.isbn.compareTo(book.isbn);
        }
        @Override
        public int hashCode() {
            return Objects.hash(title, author, price);
        }

        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", price=" + price +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
    public class ProgrammerBook extends Book{
        private String language;
        private int level;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            ProgrammerBook that = (ProgrammerBook) o;
            return level == that.level && Objects.equals(language, that.language);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), language, level);
        }

        @Override
        public String toString() {
            return "ProgrammerBook{" +
                    "language='" + language + '\'' +
                    ", level=" + level +
                    '}';
        }
    }
    public static void main(String[] args){

    }

}
