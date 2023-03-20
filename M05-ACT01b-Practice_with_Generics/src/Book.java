import java.time.Year;
import java.util.Objects;

public class Book implements Comparable<Book> {

    private String title;
    private Year releaseYear;

    public Book(String title, Year releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    @Override
    public int compareTo(Book o) {
        return releaseYear.compareTo(o.releaseYear);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(releaseYear, book.releaseYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseYear);
    }

    @Override
    public String toString() {
        return title + "-" + releaseYear.toString();
    }
}
