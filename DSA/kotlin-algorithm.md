Array trong Kotlin có hầu hết

```kotlin

fun sampleSortedWith() {
    val array = arrayOf("apple", "banana", "cherry", "date", "fig", "grape")

    // Example 1: Sort by natural order
    val sorted1 = array.sortedWith(compareBy { it })
    println("Sorted by natural order: $sorted1")
    // Sorted by natural order: [apple, banana, cherry, date, fig, grape]

    // Example 2: Sort by length of string
    val sorted2 = array.sortedWith(compareBy { it.length })
    println("Sorted by length: $sorted2")
    // Sorted by length: [fig, date, apple, grape, banana, cherry]
}

fun sampleReversed() {
    val array = arrayOf("apple", "banana", "cherry", "date", "fig", "grape")

    // Example 1: Reverse the array
    val reversed1 = array.reversed()
    println("Reversed array: $reversed1")
    // Reversed array: [grape, fig, date, cherry, banana, apple]

    // Example 2: Reverse a sublist
    val reversed2 = array.slice(0..2).reversed()
    println("Reversed sublist: $reversed2")
    // Reversed sublist: [cherry, banana, apple]
}

fun sampleFirstOrNull() {
    val array = arrayOf("apple", "banana", "cherry", "date", "fig", "grape")

    // Example 1: Find first element starting with 'c'
    val first1 = array.firstOrNull { it.startsWith('c') }
    println("First element starting with 'c': $first1")
    // First element starting with 'c': cherry

    // Example 2: Find first element longer than 5 characters
    val first2 = array.firstOrNull { it.length > 5 }
    println("First element longer than 5 characters: $first2")
    // First element longer than 5 characters: banana
}

fun sampleFilter() {
    val array = arrayOf("apple", "banana", "cherry", "date", "fig", "grape")

    // Example 1: Filter elements starting with 'a'
    val filtered1 = array.filter { it.startsWith('a') }
    println("Elements starting with 'a': $filtered1")
    // Elements starting with 'a': [apple]

    // Example 2: Filter elements longer than 4 characters
    val filtered2 = array.filter { it.length > 4 }
    println("Elements longer than 4 characters: $filtered2")
    // Elements longer than 4 characters: [apple, banana, cherry, grape]
}

fun sampleFlatten() {
    val arrayOfArrays = arrayOf(
        arrayOf("apple", "banana"),
        arrayOf("cherry", "date"),
        arrayOf("fig", "grape")
    )

    // Example 1: Flatten the array of arrays
    val flattened = arrayOfArrays.flatten()
    println("Flattened array: $flattened")
    // Flattened array: [apple, banana, cherry, date, fig, grape]
}

fun sampleChunked() {
    val array = arrayOf("apple", "banana", "cherry", "date", "fig", "grape")

    // Example 1: Chunk the array into size of 2
    val chunked1 = array.toList().chunked(2)
    println("Chunked into size 2: $chunked1")
    // Chunked into size 2: [[apple, banana], [cherry, date], [fig, grape]]
    
    // Example 2: Chunk the array into size of 3
    val chunked2 = array.toList().chunked(3)
    println("Chunked into size 3: $chunked2")
    // Chunked into size 3: [[apple, banana, cherry], [date, fig, grape]]
}

fun sampleTake() {
    val array = arrayOf("apple", "banana", "cherry", "date", "fig", "grape")

    // Example 1: Take first 3 elements
    val taken1 = array.take(3)
    println("First 3 elements: $taken1")
    // First 3 elements: [apple, banana, cherry]
    
    // Example 2: Take first 5 elements
    val taken2 = array.take(5)
    println("First 5 elements: $taken2")
    // First 5 elements: [apple, banana, cherry, date, fig]
}

fun sampleTakeLast() {
    val array = arrayOf("apple", "banana", "cherry", "date", "fig", "grape")

    // Example 1: Take last 2 elements
    val takenLast1 = array.takeLast(2)
    println("Last 2 elements: $takenLast1")
    // Last 2 elements: [fig, grape]
    
    // Example 2: Take last 4 elements
    val takenLast2 = array.takeLast(4)
    println("Last 4 elements: $takenLast2")
    // Last 4 elements: [cherry, date, fig, grape]
}

fun sampleSlice() {
    val array = arrayOf("apple", "banana", "cherry", "date", "fig", "grape")

    // Example 1: Slice from index 1 to 4
    val sliced1 = array.slice(1..3)
    println("Slice from index 1 to 3: $sliced1")
    // Slice from index 1 to 3: [banana, cherry, date]

    // Example 2: Slice from index 2 to end
    val sliced2 = array.slice(2 until array.size)
    println("Slice from index 2 to end: $sliced2")
    // Slice from index 2 to end: [cherry, date, fig, grape]
}

fun sampleGroupBy() {
    val array = arrayOf("apple", "banana", "cherry", "date", "fig", "grape")

    // Example 1: Group by first character
    val grouped1 = array.groupBy { it.first() }
    println("Grouped by first character: $grouped1")
    // Grouped by first character: {a=[apple], b=[banana], c=[cherry], d=[date], f=[fig], g=[grape]}

    // Example 2: Group by length
    val grouped2 = array.groupBy { it.length }
    println("Grouped by length: $grouped2")
    // Grouped by length: {5=[apple, grape], 6=[banana, cherry], 4=[date], 3=[fig]}
}

fun sampleMap() {
    val array = arrayOf("apple", "banana", "cherry", "date", "fig", "grape")

    // Example 1: Map to uppercase
    val mapped1 = array.map { it.uppercase() }
    println("Mapped to uppercase: $mapped1")
    // Mapped to uppercase: [APPLE, BANANA, CHERRY, DATE, FIG, GRAPE]
    
    // Example 2: Map to length of each string
    val mapped2 = array.map { it.length }
    println("Mapped to length: $mapped2")
    // Mapped to length: [5, 6, 6, 4, 3, 5]
}

// Call samples
fun main() {
    sampleSortedWith()
    sampleReversed()
    sampleFirstOrNull()
    sampleFilter()
    sampleFlatten()
    sampleChunked()
    sampleTake()
    sampleTakeLast()
    sampleSlice()
    sampleGroupBy()
    sampleMap()
}

```


```kotlin

fun <T> Array<T>.intersection(other: Array<T>): List<T> {
    return this.intersect(other.toSet()).toList()
}

fun <T> Array<T>.union(other: Array<T>): List<T> {
    return this.union(other.toSet()).toList()
}

fun <T> Array<T>.xor(other: Array<T>): List<T> {
    val set1 = this.toSet()
    val set2 = other.toSet()
    return set1.symmetricDifference(set2).toList()
}

fun <T> Array<T>.difference(other: Array<T>): List<T> {
    return this.toSet().subtract(other.toSet()).toList()
}

fun <T> Set<T>.symmetricDifference(other: Set<T>): Set<T> {
    return (this union other) subtract (this intersect other)
}

fun sampleIntersection() {
    val array1 = arrayOf("apple", "banana", "cherry", "date", "fig", "grape")
    val array2 = arrayOf("banana", "cherry", "date", "elderberry", "fig")

    // Example 1: Intersection of array1 and array2
    val intersection1 = array1.intersection(array2)
    println("Intersection of array1 and array2: $intersection1")

    // Example 2: Intersection of array1 and a subset of array2
    val intersection2 = array1.intersection(arrayOf("cherry", "fig", "grape"))
    println("Intersection of array1 and a subset of array2: $intersection2")
}

fun sampleUnion() {
    val array1 = arrayOf("apple", "banana", "cherry", "date", "fig", "grape")
    val array2 = arrayOf("banana", "cherry", "date", "elderberry", "fig")

    // Example 1: Union of array1 and array2
    val union1 = array1.union(array2)
    println("Union of array1 and array2: $union1")

    // Example 2: Union of array1 and a subset of array2
    val union2 = array1.union(arrayOf("kiwi", "lemon", "melon"))
    println("Union of array1 and a subset of array2: $union2")
}

fun sampleXor() {
    val array1 = arrayOf("apple", "banana", "cherry", "date", "fig", "grape")
    val array2 = arrayOf("banana", "cherry", "date", "elderberry", "fig")

    // Example 1: XOR of array1 and array2
    val xor1 = array1.xor(array2)
    println("XOR of array1 and array2: $xor1")

    // Example 2: XOR of array1 and a subset of array2
    val xor2 = array1.xor(arrayOf("apple", "kiwi", "grape"))
    println("XOR of array1 and a subset of array2: $xor2")
}

fun sampleDifference() {
    val array1 = arrayOf("apple", "banana", "cherry", "date", "fig", "grape")
    val array2 = arrayOf("banana", "cherry", "date", "elderberry", "fig")

    // Example 1: Difference of array1 and array2
    val difference1 = array1.difference(array2)
    println("Difference of array1 and array2: $difference1")

    // Example 2: Difference of array1 and a subset of array2
    val difference2 = array1.difference(arrayOf("cherry", "fig", "grape"))
    println("Difference of array1 and a subset of array2: $difference2")
}

// Call samples
fun main() {
    sampleIntersection()
    sampleUnion()
    sampleXor()
    sampleDifference()
}

```