
```java
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Utility class for various collection operations.
 */
class CollectionUtils {

    /**
     * Sorts a list of elements using a comparator.
     *
     * @param list the list to sort
     * @param comparator the comparator to determine the order of the list
     * @param <T> the type of elements in the list
     * @return a sorted list
     */
    public static <T> List<T> sort(List<T> list, Comparator<T> comparator) {
        return list.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    /**
     * Reverses a list of elements.
     *
     * @param list the list to reverse
     * @param <T> the type of elements in the list
     * @return a reversed list
     */
    public static <T> List<T> reverse(List<T> list) {
        List<T> reversedList = new ArrayList<>(list);
        Collections.reverse(reversedList);
        return reversedList;
    }

    /**
     * Finds the first element matching the predicate.
     *
     * @param list the list to search
     * @param predicate the predicate to apply to each element
     * @param <T> the type of elements in the list
     * @return an Optional containing the first matching element, or an empty Optional if no match is found
     */
    public static <T> Optional<T> find(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .filter(predicate)
                .findFirst();
    }

    /**
     * Filters elements of a list using a predicate.
     *
     * @param list the list to filter
     * @param predicate the predicate to apply to each element
     * @param <T> the type of elements in the list
     * @return a list containing elements that match the predicate
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    /**
     * Flattens a list of lists into a single list.
     *
     * @param list the list of lists to flatten
     * @param <T> the type of elements in the list
     * @return a flattened list
     */
    public static <T> List<T> flatten(List<List<T>> list) {
        return list.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    /**
     * Splits a list into chunks of specified size.
     *
     * @param list the list to be chunked
     * @param chunkSize the size of each chunk
     * @param <T> the type of elements in the list
     * @return a list of lists, where each inner list is a chunk of the original list
     * @throws IllegalArgumentException if chunkSize is less than or equal to 0
     */
    public static <T> List<List<T>> chunk(List<T> list, int chunkSize) {
        if (chunkSize <= 0) {
            throw new IllegalArgumentException("Chunk size must be greater than 0");
        }
        return IntStream.range(0, (list.size() + chunkSize - 1) / chunkSize)
                .mapToObj(i -> list.subList(i * chunkSize, Math.min((i + 1) * chunkSize, list.size())))
                .collect(Collectors.toList());
    }

    /**
     * Takes the first n elements from a list.
     *
     * @param list the list to take elements from
     * @param n the number of elements to take
     * @param <T> the type of elements in the list
     * @return a list containing the first n elements from the original list
     * @throws IllegalArgumentException if n is less than 0
     */
    public static <T> List<T> takeLeft(List<T> list, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of elements to take cannot be negative");
        }
        return list.stream()
                .limit(Math.min(n, list.size()))
                .collect(Collectors.toList());
    }

    /**
     * Takes the last n elements from a list.
     *
     * @param list the list to take elements from
     * @param n the number of elements to take
     * @param <T> the type of elements in the list
     * @return a list containing the last n elements from the original list
     * @throws IllegalArgumentException if n is less than 0
     */
    public static <T> List<T> takeRight(List<T> list, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of elements to take cannot be negative");
        }
        int size = list.size();
        return list.stream()
                .skip(Math.max(0, size - n))
                .collect(Collectors.toList());
    }

    /**
     * Slices a list from start index to end index (exclusive).
     *
     * @param list the list to slice
     * @param start the start index (inclusive)
     * @param end the end index (exclusive)
     * @param <T> the type of elements in the list
     * @return a list containing the elements from start index to end index
     * @throws IndexOutOfBoundsException if start or end are out of bounds
     */
    public static <T> List<T> slice(List<T> list, int start, int end) {
        if (start < 0 || end > list.size() || start > end) {
            throw new IndexOutOfBoundsException("Invalid start or end index");
        }
        return IntStream.range(start, end)
                .mapToObj(list::get)
                .collect(Collectors.toList());
    }

    /**
     * Groups elements of a list by a specified classifier function.
     *
     * @param list the list to group
     * @param groupByFunction the classifier function
     * @param <G> the type of the key
     * @param <T> the type of elements in the list
     * @return a map where the keys are the result of applying the classifier function
     *         and the values are lists of items
     */
    public static <G, T> Map<G, List<T>> group(List<T> list, Function<T, G> groupByFunction) {
        return list.stream()
                .collect(Collectors.groupingBy(groupByFunction));
    }

    /**
     * Maps elements of a list using a specified mapping function.
     *
     * @param list the list to map
     * @param mappingFunction the function to apply to each element
     * @param <T> the type of elements in the input list
     * @param <R> the type of elements in the output list
     * @return a list containing the results of applying the mapping function
     *         to each element of the input list
     */
    public static <T, R> List<R> map(List<T> list, Function<T, R> mappingFunction) {
        return list.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }

    /**
     * Computes the intersection of two lists.
     *
     * @param self the first list
     * @param other the second list
     * @param <T> the type of elements in the lists
     * @return a list containing elements that are present in both input lists
     */
    public static <T> List<T> intersection(List<T> self, List<T> other) {
        Set<T> set2 = new HashSet<>(other);
        return self.stream()
                .filter(set2::contains)
                .collect(Collectors.toList());
    }

    /**
     * Computes the union of two lists.
     *
     * @param list1 the first list
     * @param list2 the second list
     * @param <T> the type of elements in the lists
     * @return a list containing all elements from both input lists, without duplicates
     */
    public static <T> List<T> union(List<T> list1, List<T> list2) {
        return Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Computes the symmetric difference (exclusive or) of two lists.
     *
     * @param list1 the first list
     * @param list2 the second list
     * @param <T> the type of elements in the lists
     * @return a list containing elements that are present in either input list,
     *         but not in both
     */
    public static <T> List<T> xor(List<T> list1, List<T> list2) {
        Set<T> set1 = new HashSet<>(list1);
        Set<T> set2 = new HashSet<>(list2);

        return Stream.concat(
                list1.stream().filter(e -> !set2.contains(e)),
                list2.stream().filter(e -> !set1.contains(e))).collect(Collectors.toList());
    }
}
```

SAMPLE

```java


public class Main {

    public static void sampleChunk() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

        // Example 1
        List<List<String>> chunks1 = CollectionUtils.chunk(list, 3);
        System.out.println("Chunk example 1: " + chunks1);

        // Example 2
        List<List<String>> chunks2 = CollectionUtils.chunk(list, 2);
        System.out.println("Chunk example 2: " + chunks2);
        //Chunk example 1: [[a, b, c], [d, e, f], [g]]
        //Chunk example 2: [[a, b], [c, d], [e, f], [g]]
    }

    public static void sampleTakeLeft() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");

        // Example 1
        List<String> left1 = CollectionUtils.takeLeft(list, 3);
        System.out.println("TakeLeft example 1: " + left1);

        // Example 2
        List<String> left2 = CollectionUtils.takeLeft(list, 0);
        System.out.println("TakeLeft example 2: " + left2);

        //TakeLeft example 1: [a, b, c]
        //TakeLeft example 2: []
    }

    public static void sampleTakeRight() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");

        // Example 1
        List<String> right1 = CollectionUtils.takeRight(list, 2);
        System.out.println("TakeRight example 1: " + right1);

        // Example 2
        List<String> right2 = CollectionUtils.takeRight(list, 5);
        System.out.println("TakeRight example 2: " + right2);

        //TakeRight example 1: [d, e]
        //TakeRight example 2: [a, b, c, d, e]
    }

    public static void sampleSlice() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");

        // Example 1
        List<String> slice1 = CollectionUtils.slice(list, 1, 4);
        System.out.println("Slice example 1: " + slice1);

        // Example 2
        List<String> slice2 = CollectionUtils.slice(list, 0, 3);
        System.out.println("Slice example 2: " + slice2);

        //Slice example 1: [b, c, d]
        //Slice example 2: [a, b, c]
    }

    public static void sampleGroup() {
        List<String> list = Arrays.asList("apple", "banana", "apricot", "blueberry");

        // Example 1
        Map<Character, List<String>> group1 = CollectionUtils.group(list, s -> s.charAt(0));
        System.out.println("Group example 1: " + group1);

        // Example 2
        Map<Integer, List<String>> group2 = CollectionUtils.group(list, String::length);
        System.out.println("Group example 2: " + group2);

        //Group example 1: {a=[apple, apricot], b=[banana, blueberry]}
        //Group example 2: {5=[apple], 6=[banana], 7=[apricot], 9=[blueberry]}
    }

    public static void sampleMap() {
        List<String> list = Arrays.asList("apple", "banana", "cherry");

        // Example 1
        List<String> mapped1 = CollectionUtils.map(list, String::toUpperCase);
        System.out.println("Map example 1: " + mapped1);

        // Example 2
        List<Integer> mapped2 = CollectionUtils.map(list, String::length);
        System.out.println("Map example 2: " + mapped2);

        //Map example 1: [APPLE, BANANA, CHERRY]
        //Map example 2: [5, 6, 6]
    }

    public static void sampleIntersection() {
        List<String> list1 = Arrays.asList("a", "b", "c", "d");
        List<String> list2 = Arrays.asList("c", "d", "e", "f");

        // Example 1
        List<String> intersection1 = CollectionUtils.intersection(list1, list2);
        System.out.println("Intersection example 1: " + intersection1);

        // Example 2
        List<String> list3 = Arrays.asList("x", "y", "z");
        List<String> intersection2 = CollectionUtils.intersection(list1, list3);
        System.out.println("Intersection example 2: " + intersection2);

        //Intersection example 1: [c, d]
        //Intersection example 2: []
    }

    public static void sampleUnion() {
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("c", "d", "e");

        // Example 1
        List<String> union1 = CollectionUtils.union(list1, list2);
        System.out.println("Union example 1: " + union1);

        // Example 2
        List<String> list3 = Arrays.asList("x", "y", "z");
        List<String> union2 = CollectionUtils.union(list1, list3);
        System.out.println("Union example 2: " + union2);

        //Union example 1: [a, b, c, d, e]
        //Union example 2: [a, b, c, x, y, z]
    }

    public static void sampleXor() {
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("b", "c", "d");

        // Example 1
        List<String> xor1 = CollectionUtils.xor(list1, list2);
        System.out.println("XOR example 1: " + xor1);

        // Example 2
        List<String> list3 = Arrays.asList("x", "y", "z");
        List<String> xor2 = CollectionUtils.xor(list1, list3);
        System.out.println("XOR example 2: " + xor2);

        //XOR example 1: [a, d]
        //XOR example 2: [a, b, c, x, y, z]
    }

    public static void sampleSort() {
        List<String> list = Arrays.asList("banana", "apple", "cherry");

        // Example 1: Sort by natural order
        List<String> sorted1 = CollectionUtils.sort(list, Comparator.naturalOrder());
        System.out.println("Sort example 1: " + sorted1);

        // Example 2: Sort by length, then by natural order
        List<String> sorted2 = CollectionUtils.sort(list, Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println("Sort example 2: " + sorted2);

        //Sort example 1: [apple, banana, cherry]
        //Sort example 2: [apple, banana, cherry]
    }

    public static void sampleReverse() {
        List<String> list = Arrays.asList("a", "b", "c", "d");

        // Example 1
        List<String> reversed1 = CollectionUtils.reverse(list);
        System.out.println("Reverse example 1: " + reversed1);

        // Example 2
        List<String> reversed2 = CollectionUtils.reverse(Collections.emptyList());
        System.out.println("Reverse example 2: " + reversed2);

        //Reverse example 1: [d, c, b, a]
        //Reverse example 2: []
    }

    public static void sampleFind() {
        List<String> list = Arrays.asList("apple", "banana", "cherry");

        // Example 1
        Optional<String> found1 = CollectionUtils.find(list, s -> s.startsWith("b"));
        System.out.println("Find example 1: " + found1.orElse("Not found"));

        // Example 2
        Optional<String> found2 = CollectionUtils.find(list, s -> s.startsWith("z"));
        System.out.println("Find example 2: " + found2.orElse("Not found"));

        //Find example 1: banana
        //Find example 2: Not found
    }

    public static void sampleFilter() {
        List<String> list = Arrays.asList("apple", "banana", "cherry");

        // Example 1
        List<String> filtered1 = CollectionUtils.filter(list, s -> s.length() > 5);
        System.out.println("Filter example 1: " + filtered1);

        // Example 2
        List<String> filtered2 = CollectionUtils.filter(list, s -> s.contains("e"));
        System.out.println("Filter example 2: " + filtered2);

        //Filter example 1: [banana, cherry]
        //Filter example 2: [apple, cherry]
    }

    public static void sampleFlatten() {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("a", "b", "c"),
                Arrays.asList("d", "e", "f"),
                Arrays.asList("g", "h", "i")
        );

        // Example 1
        List<String> flattened1 = CollectionUtils.flatten(listOfLists);
        System.out.println("Flatten example 1: " + flattened1);

        // Example 2
        List<String> flattened2 = CollectionUtils.flatten(Collections.singletonList(Arrays.asList("x", "y", "z")));
        System.out.println("Flatten example 2: " + flattened2);

        //Flatten example 1: [a, b, c, d, e, f, g, h, i]
        //Flatten example 2: [x, y, z]
    }

    public static void main(String[] args) {
        sampleChunk();
        sampleTakeLeft();
        sampleTakeRight();
        sampleSlice();
        sampleGroup();
        sampleMap();
        sampleIntersection();
        sampleUnion();
        sampleXor();
        sampleSort();
        sampleReverse();
        sampleFind();
        sampleFilter();
        sampleFlatten();
    }
}

```