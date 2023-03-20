import java.time.Year;
import java.util.*;

public class Tester {

    public static <T extends Comparable<T>> int upDownOrNeither(T t1, T t2, T t3, T t4) {
        int compare1 = t1.compareTo(t2);
        int compare2 = t2.compareTo(t3);
        int compare3 = t3.compareTo(t4);

        if (compare1 < 0 && compare2 < 0 && compare3 < 0) {
            return -1; // up
        } else if (compare1 > 0 && compare2 > 0 && compare3 > 0) {
            return 1; // down
        } else {
            return 0; // neither
        }
    }

    public static <T> List<T> rmDupsPreservingOrder(List<T> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    public static void main(String[] args) {
        // Test upDownOrNeither method
        System.out.println(upDownOrNeither("a", "d", "b", "g")); // (neither) should print 0
        System.out.println(upDownOrNeither(2.3, 3.4, 4.5, 5.6)); // (up/increasing) should print -1
        System.out.println(upDownOrNeither(5, 3, 2, 1)); // (down/decreasing) should print 1

        System.out.println(upDownOrNeither('c', 'd', 'h', 'i')); // (up) should print -1
        System.out.println(upDownOrNeither('c', 'd', 'h', 'a')); // (neither) should print 0
        System.out.println(upDownOrNeither(
                Year.of(2002), Year.of(2001), Year.of(2000),
                Year.of(1990))); // (down) should print 1

        // Test Book class
        Book b1 = new Book("Title1", Year.of(2000));
        Book b2 = new Book("Title2", Year.of(2005));
        Book b3 = new Book("Title3", Year.of(2000));

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        System.out.println("b1 equals b2? " + b1.equals(b2));
        System.out.println("b1 equals b3? " + b1.equals(b3));

        List<Book> books = List.of(b1, b2, b3, b2, b1);
        System.out.println("Books: " + books);
        List<Book> uniqueBooks = rmDupsPreservingOrder(books);
        System.out.println("Unique Books: " + uniqueBooks);
    }
}

