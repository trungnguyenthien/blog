```swift
import Foundation

extension Array where Element: Hashable {
    /**
     Returns a new array with all unique elements from the current array, preserving the order of their first occurrence.
     
     This method filters out duplicate elements from the array while maintaining the original order of elements. Only the first occurrence of each element is kept in the resulting array.
     
     - Parameter uniq: A Boolean value that indicates whether to filter out duplicate elements.
     - Returns: An array containing only the unique elements from the original array, in the order they first appeared if `uniq` is true.
     
     Example usage:
     ```swift
     let array = ["apple", "banana", "apple", "cherry", "banana", "date"]
     let uniqueArrayTrue = array.filterUniq(true)
     print(uniqueArrayTrue)  // Output: ["apple", "banana", "cherry", "date"]
     let uniqueArrayFalse = array.filterUniq(false)
     print(uniqueArrayFalse) // Output: ["apple", "banana", "apple", "cherry", "banana", "date"]
     ```
     */
    func filterUniq(_ uniq: Bool) -> [Element] {
        guard uniq else { return self }
        var seen: Set<Element> = []
        return self.filter { element in
            if seen.contains(element) {
                return false
            } else {
                seen.insert(element)
                return true
            }
        }
    }
    
    /**
     Returns the elements in the current array that are not in the other array.
     
     - Parameters:
        - other: The array to compare against.
        - uniq: A Boolean value that indicates whether to filter out duplicate elements in the result.
     - Returns: A new array containing elements that are in the current array but not in the other array.
     
     Example usage:
     ```swift
     let array1 = ["apple", "banana", "cherry", "apple"]
     let array2 = ["banana", "date", "fig", "banana"]
     let differenceArrayTrue = array1.difference(other: array2, uniq: true)
     print(differenceArrayTrue)  // Output: ["apple", "cherry"]
     let differenceArrayFalse = array1.difference(other: array2, uniq: false)
     print(differenceArrayFalse) // Output: ["apple", "cherry", "apple"]
     ```
     */
    func difference(other: [Element], uniq: Bool = false) -> [Element] {
        // Dictionary to count occurrences of each element in `other`
        var elementCount: [Element: Int] = [:]

        // Populate the dictionary with counts of elements in `other`
        for element in other {
            elementCount[element, default: 0] += 1
        }

        // Filter `self` to only include elements not in `other`
        return self.filter { element in
            if let count = elementCount[element], count > 0 {
                elementCount[element] = count - 1
                return false
            }
            return true
        }.filterUniq(uniq)
    }
    
    /**
     Combines the unique elements of the current array and the other array.
     
     - Parameters:
        - other: The array to union with.
        - uniq: A Boolean value that indicates whether to filter out duplicate elements in the result.
     - Returns: A new array containing all unique elements from both the current array and the other array.
     
     Example usage:
     ```swift
     let array1 = ["apple", "banana", "cherry", "apple"]
     let array2 = ["banana", "date", "fig", "banana"]
     let unionArrayTrue = array1.union(other: array2, uniq: true)
     print(unionArrayTrue)  // Output: ["apple", "banana", "cherry", "date", "fig"]
     let unionArrayFalse = array1.union(other: array2, uniq: false)
     print(unionArrayFalse) // Output: ["apple", "banana", "cherry", "apple", "date", "fig"]
     ```
     */
    func union(other: [Element], uniq: Bool = false) -> [Element] {
        var result: [Element] = []
        var seen: [Element: Bool] = [:]

        for element in self {
            if seen[element] == nil {
                result.append(element)
                seen[element] = true
            }
        }

        for element in other {
            if seen[element] == nil {
                result.append(element)
                seen[element] = true
            }
        }

        return result.filterUniq(uniq)
    }
    
    /**
     Returns elements that are in either the current array or the other array, but not in both.
     
     - Parameters:
        - other: The array to perform XOR operation with.
        - uniq: A Boolean value that indicates whether to filter out duplicate elements in the result.
     - Returns: A new array containing elements that are in either the current array or the other array, but not in both.
     
     Example usage:
     ```swift
     let array1 = ["apple", "banana", "cherry", "apple"]
     let array2 = ["banana", "date", "fig", "banana"]
     let xorArrayTrue = array1.xor(other: array2, uniq: true)
     print(xorArrayTrue)  // Output: ["apple", "cherry", "date", "fig"]
     let xorArrayFalse = array1.xor(other: array2, uniq: false)
     print(xorArrayFalse) // Output: ["apple", "cherry", "apple", "date", "fig"]
     ```
     */
    func xor(other: [Element], uniq: Bool = false) -> [Element] {
        var elementCounts: [Element: Int] = [:]
        
        // Count occurrences of elements in self
        for element in self {
            elementCounts[element, default: 0] += 1
        }
        
        // Count occurrences of elements in other
        for element in other {
            elementCounts[element, default: 0] += 1
        }
        
        var result: [Element] = []
        
        // Collect elements that appear exactly once
        for element in self {
            if elementCounts[element] == 1 {
                result.append(element)
            }
        }
        
        for element in other {
            if elementCounts[element] == 1 && !result.contains(element) {
                result.append(element)
            }
        }
        
        return result.filterUniq(uniq)
    }
    
    /**
     Returns the common elements between the current array and the other array.
     
     - Parameters:
        - other: The array to intersect with.
        - uniq: A Boolean value that indicates whether to filter out duplicate elements in the result.
     - Returns: A new array containing elements that are present in both the current array and the other array.
     
     Example usage:
     ```swift
     let array1 = ["apple", "banana", "cherry", "apple"]
     let array2 = ["banana", "date", "fig", "banana"]
     let intersectionArrayTrue = array1.intersection(other: array2, uniq: true)
     print(intersectionArrayTrue)  // Output: ["banana"]
     let intersectionArrayFalse = array1.intersection(other: array2, uniq: false)
     print(intersectionArrayFalse) // Output: ["banana", "banana"]
     ```
     */
    func intersection(other: [Element], uniq: Bool = false) -> [Element] {
        var result: [Element] = []
        var seen: [Element: Int] = [:]

        // Count the occurrences of each element in `other`
        for element in other {
            seen[element, default: 0] += 1
        }

        // Iterate through `self` and add elements to the result if they are in `seen`
        for element in self {
            if let count = seen[element], count > 0 {
                result.append(element)
                seen[element]! -= 1
            }
        }

        return result.filterUniq(uniq)
    }
}

extension Array {
    /**
     Returns a new array with the elements of the original array in reverse order.
     
     - Returns: A new array containing the elements of the original array in reverse order.
     */
    func reversedArray() -> [Element] {
        return Array(self.reversed())
    }
    
    /**
     Splits the array into chunks of the specified size.
     
     - Parameter size: The size of each chunk. Must be greater than 0.
     - Returns: An array of arrays, where each inner array is a chunk of the original array.
     If the size is less than or equal to 0, an empty array is returned.
     */
    func chunked(into size: Int) -> [[Element]] {
        guard size > 0 else { return [] }
        return stride(from: 0, to: self.count, by: size).map {
            Array(self[$0..<Swift.min($0 + size, self.count)])
        }
    }
    
    /**
     Returns a new array containing the first n elements of the original array.
     
     - Parameter n: The number of elements to take from the beginning of the array.
     - Returns: A new array containing the first n elements.
     If n is negative, an empty array is returned.
     */
    func takeFirst(_ n: Int) -> [Element] {
        guard n >= 0 else { return [] }
        return Array(self.prefix(n))
    }
    
    /**
     Returns a new array containing the last n elements of the original array.
     
     - Parameter n: The number of elements to take from the end of the array.
     - Returns: A new array containing the last n elements.
     If n is negative, an empty array is returned.
     */
    func takeLast(_ n: Int) -> [Element] {
        guard n >= 0 else { return [] }
        return Array(self.suffix(n))
    }
    
    /**
     Returns a slice of the array from the start index to the end index.
     
     - Parameters:
     - start: The starting index of the slice (inclusive).
     - end: The ending index of the slice (exclusive).
     - Returns: A new array containing the elements from start to end.
     If start is out of bounds, an empty array is returned.
     If end is greater than the array's count, it will slice to the end of the array.
     */
    func sliced(start: Int, end: Int) -> [Element] {
        guard start >= 0, start < self.count else { return [] }
        let endIndex = end > self.count ? self.count : end
        return Array(self[start..<endIndex])
    }
    
    /**
     Groups the elements of the array based on a key derived from each element.
     
     - Parameter key: A closure that returns a hashable value for each element, used as the grouping key.
     - Returns: A dictionary where the keys are the result of the key closure, and the values are arrays of elements that produced that key.
     */
    func grouped<G: Hashable>(by key: (Element) -> G) -> [G: [Element]] {
        return Dictionary(grouping: self, by: key)
    }
}


class Sample {
    
    func sampleSorted() {
        let list = ["apple", "banana", "cherry", "date", "elderberry"]
        
        // Example 1: Sort in ascending order
        let sorted1 = list.sorted(by: <)
        print("Sorted example 1:", sorted1)
        
        // Example 2: Sort by length of the string
        let sorted2 = list.sorted(by: { $0.count < $1.count })
        print("Sorted example 2:", sorted2)
    }
    
    func sampleReversedArray() {
        let list = ["apple", "banana", "cherry", "date", "elderberry"]
        
        // Example 1: Reverse the array
        let reversed1 = list.reversedArray()
        print("Reversed example 1:", reversed1)
        
        // Example 2: Reverse another array
        let reversed2 = ["kiwi", "lemon", "mango", "nectarine", "orange"].reversedArray()
        print("Reversed example 2:", reversed2)
    }
    
    func sampleFind() {
        let list = ["apple", "banana", "cherry", "date", "elderberry"]
        
        // Example 1: Find the first element that starts with 'b'
        let found1 = list.first(where: { $0.hasPrefix("b") })
        print("Find example 1:", found1 ?? "Not found")
        
        // Example 2: Find the first element that starts with 'e'
        let found2 = list.first(where: { $0.hasPrefix("e") })
        print("Find example 2:", found2 ?? "Not found")
    }
    
    func sampleFilter() {
        let list = ["apple", "banana", "cherry", "date", "elderberry"]
        
        // Example 1: Filter elements that contain 'a'
        let filtered1 = list.filter { $0.contains("a") }
        print("Filter example 1:", filtered1)
        
        // Example 2: Filter elements that contain 'e'
        let filtered2 = list.filter { $0.contains("e") }
        print("Filter example 2:", filtered2)
    }
    
    func sampleFlatMap() {
        let list = [["apple", "banana"], ["cherry", "date"], ["elderberry"]]
        
        // Example 1: Flatten a nested array
        let flattened1 = list.flatMap { $0 }
        print("FlatMap example 1:", flattened1)
        
        // Example 2: Flatten another nested array
        let flattened2 = [["kiwi", "lemon"], ["mango"], ["nectarine", "orange"]].flatMap { $0 }
        print("FlatMap example 2:", flattened2)
    }
    
    func sampleChunked() {
        let list = ["apple", "banana", "cherry", "date", "elderberry"]
        
        // Example 1: Chunk the array into chunks of 2
        let chunked1 = list.chunked(into: 2)
        print("Chunked example 1:", chunked1)
        
        // Example 2: Chunk the array into chunks of 3
        let chunked2 = list.chunked(into: 3)
        print("Chunked example 2:", chunked2)
    }
    
    func sampleTakeFirst() {
        let list = ["apple", "banana", "cherry", "date", "elderberry"]
        
        // Example 1: Take the first 2 elements
        let takenFirst1 = list.takeFirst(2)
        print("TakeFirst example 1:", takenFirst1)
        
        // Example 2: Take the first 4 elements
        let takenFirst2 = list.takeFirst(4)
        print("TakeFirst example 2:", takenFirst2)
    }
    
    func sampleTakeLast() {
        let list = ["apple", "banana", "cherry", "date", "elderberry"]
        
        // Example 1: Take the last 2 elements
        let takenLast1 = list.takeLast(2)
        print("TakeLast example 1:", takenLast1)
        
        // Example 2: Take the last 3 elements
        let takenLast2 = list.takeLast(3)
        print("TakeLast example 2:", takenLast2)
    }
    
    func sampleSliced() {
        let list = ["apple", "banana", "cherry", "date", "elderberry"]
        
        // Example 1: Slice from index 1 to 3
        let sliced1 = list.sliced(start: 1, end: 3)
        print("Sliced example 1:", sliced1)
        
        // Example 2: Slice from index 2 to 5
        let sliced2 = list.sliced(start: 2, end: 5)
        print("Sliced example 2:", sliced2)
    }
    
    func sampleGrouped() {
        let list = ["apple", "banana", "cherry", "date", "elderberry"]
        
        // Example 1: Group by first letter
        let grouped1 = list.grouped(by: { $0.first! })
        print("Grouped example 1:", grouped1)
        
        // Example 2: Group by length of string
        let grouped2 = list.grouped(by: { $0.count })
        print("Grouped example 2:", grouped2)
    }
    
    func sampleDifference() {
        let list = ["apple", "apple", "banana", "cherry", "date", "elderberry"]
        let other = ["banana", "date", "fig"]
        
        // Example 1: Difference with another array
        let difference1 = list.difference(other: other)
        print("Difference example 1:", difference1)
        
        // Example 2: Difference with another array
        let difference2 = list.difference(other: ["cherry", "elderberry", "grape"])
        print("Difference example 2:", difference2)
    }
    
    func sampleIntersection() {
        let list = ["apple", "banana", "cherry", "date", "elderberry"]
        let other = ["banana", "date", "fig"]
        
        // Example 1: Intersection with another array
        let intersection1 = list.intersection(other: other)
        print("Intersection example 1:", intersection1)
        
        // Example 2: Intersection with another array
        let intersection2 = list.intersection(other: ["cherry", "elderberry", "grape"])
        print("Intersection example 2:", intersection2)
    }
    
    func sampleUnion() {
        let list = ["apple", "banana", "cherry", "date", "elderberry"]
        let other = ["banana", "date", "fig"]
        
        // Example 1: Union with another array
        let union1 = list.union(other: other)
        print("Union example 1:", union1)
        
        // Example 2: Union with another array
        let union2 = list.union(other: ["grape", "honeydew", "kiwi"])
        print("Union example 2:", union2)
    }
    
    func sampleXor() {
        let list = ["apple", "banana", "cherry", "date", "elderberry"]
        let other = ["banana", "date", "fig"]
        
        // Example 1: XOR with another array
        let xor1 = list.xor(other: other)
        print("XOR example 1:", xor1)
        
        // Example 2: XOR with another array
        let xor2 = list.xor(other: ["grape", "honeydew", "kiwi"])
        print("XOR example 2:", xor2)
    }
    
    func runAll() {
        sampleSorted()
        sampleReversedArray()
        sampleFind()
        sampleFilter()
        sampleFlatMap()
        sampleChunked()
        sampleTakeFirst()
        sampleTakeLast()
        sampleSliced()
        sampleGrouped()
        sampleDifference()
        sampleIntersection()
        sampleUnion()
        sampleXor()
    }
}

// Chạy tất cả các hàm sample
let sample = Sample()
sample.runAll()

```