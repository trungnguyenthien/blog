
```swift

import Foundation

extension Array {
    /**
     `Array` của ngôn ngữ swift cung cấp các hàm xử lý sau:
     - sorted:  trả về một mảng mới chứa các phần tử của mảng ban đầu, được sắp xếp theo thứ tự mặc định hoặc theo tiêu chí do người dùng cung cấp.
     - first: trả về phần tử đầu tiên của mảng, nếu mảng không rỗng; ngược lại, trả về nil.
     - filter: trả về một mảng mới chứa các phần tử thỏa mãn điều kiện do người dùng cung cấp thông qua một closure.
     - flatMap: Trả về một mảng mới bằng cách áp dụng closure lên từng phần tử của mảng và làm phẳng (flatten) kết quả.
     */
    
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
    
    /**
     Returns the elements in the current array that are not in the other array.
     
     - Parameter other: The array to compare against.
     - Returns: A new array containing elements that are in the current array but not in the other array.
     */
    func difference(other: [Element]) -> [Element] where Element: Hashable {
        let set = Set(other)
        return self.filter { !set.contains($0) }
    }
    
    /**
     Returns the common elements between the current array and the other array.
     
     - Parameter other: The array to intersect with.
     - Returns: A new array containing elements that are present in both the current array and the other array.
     */
    func intersection(other: [Element]) -> [Element] where Element: Hashable {
        let set = Set(other)
        return self.filter { set.contains($0) }
    }
    
    /**
     Combines the unique elements of the current array and the other array.
     
     - Parameter other: The array to union with.
     - Returns: A new array containing all unique elements from both the current array and the other array.
     */
    func union(other: [Element]) -> [Element] where Element: Hashable {
        return Array(Set(self).union(other))
    }
    
    /**
     Returns elements that are in either the current array or the other array, but not in both.
     
     - Parameter other: The array to perform XOR operation with.
     - Returns: A new array containing elements that are in either the current array or the other array, but not in both.
     */
    func xor(other: [Element]) -> [Element] where Element: Hashable {
        let set1 = Set(self)
        let set2 = Set(other)
        return Array(set1.symmetricDifference(set2))
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
        let list = ["apple", "banana", "cherry", "date", "elderberry"]
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