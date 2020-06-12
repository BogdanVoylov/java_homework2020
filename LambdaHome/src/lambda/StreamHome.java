package lambda;

import java.math.BigInteger;
import java.nio.file.*;
import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.regex.*;
import java.util.stream.*;

public class StreamHome {
	private static final Pattern IDEN_PATTERN = Pattern.compile("([a-zA-Z][\\_|a-zA-z|0-9]+)");
    public static int sumOdd(IntStream is, int m) {
        int res = is.filter(num -> num > 0 && num % 2 == 0 && num <= m).sum();
        return res;
    }

    public static IntStream bigPrimeDiv(int n) {
        IntStream res = IntStream.iterate(n, x -> x + 1).map(new IntUnaryOperator() {
            @Override
            public int applyAsInt(int num) {
                for (int i = num; i > 0; i--) {
                    if (BigInteger.valueOf(i).isProbablePrime((int) Math.log(i)) && num % i == 0) {
                        return i;
                    }
                }
                return 0;
            }
        });
        return res;
    }

    public static OptionalInt maxPrime(IntStream is, int n) {
        // ... statements
		return is.filter(new IntPredicate() {
			@Override
			public boolean test(int i) {
				return BigInteger.valueOf(i).isProbablePrime((int)Math.log(i)) && i>0 && i>n;
			}
		}).max();
    }
    // .... methods
    // ......
    // ......

    public static Stream<String> allIdens(String word) {
        // ... statements
		List<String> list = new ArrayList<>();
		Matcher matcher = IDEN_PATTERN.matcher(word);
		while (matcher.find()){
			list.add(matcher.group());
		}
        return list.stream();
    }

    public static Optional<String> minIden(String file) {
        try (Stream<String> lines = Files.lines(Paths.get(file))) {
            return lines.flatMap(StreamHome::allIdens).min(new Comparator<String>() {
				@Override
				public int compare(String s, String t1) {
					return s.compareTo(t1);
				}
			});
        } catch (Exception ex) {
            System.out.println("minIden: " + ex.getMessage());
            return Optional.empty();
        }
    }

    public static long cntDistIden(String file) {
        try (Stream<String> lines = Files.lines(Paths.get(file))) {
            return lines.flatMap(StreamHome::allIdens).distinct().count();
        } catch (Exception ex) {
            System.out.println("cntDistIden: " + ex.getMessage());
            return 0;
        }
    }

    // .... methods
    // ......
    // ......
    public static String[] allTypesAuthor(Stream<BookA> library, String aut) {
        // ... statements
		return library.filter(new Predicate<BookA>() {
			@Override
			public boolean test(BookA bookA) {
				return Arrays.stream(bookA.getAuthors()).anyMatch(x->x.equals(aut));
			}
		}).flatMap(b-> Arrays.stream(b.getTypes())).distinct().toArray(size->new String[size]);
    }

    public static long cntAuthor(Stream<BookA> library, String type) {
        // ... statements
		return library.filter(new Predicate<BookA>() {
			@Override
			public boolean test(BookA bookA) {
				return Arrays.stream(bookA.getTypes()).anyMatch(x->x.equals(type));
			}
		}).flatMap(b->Arrays.stream(b.getAuthors())).distinct().count();
    }

    public static OptionalInt maxPagesBook(Stream<BookA> library, String aut, String pub) {
        // ... statements
		return library.filter(new Predicate<BookA>() {
			@Override
			public boolean test(BookA bookA) {
				return Arrays.stream(bookA.getAuthors()).anyMatch(x->x.equals(aut)) && bookA.getPubName().equals(pub);
			}
		}).mapToInt(x->x.getPages()).max();
    }

    // .... methods
    // ......
    // ......
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // ... statements
		BookA bookA = new BookA();
		System.out.println(maxPagesBook(bookA.library(),"Kellsey","Abatis Publishers"));
    }

}
