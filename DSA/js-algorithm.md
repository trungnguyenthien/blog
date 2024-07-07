Tôi đang tìm hiểu về thư viện lodash trong javascript, tôi muốn biết sử dụng các hàm sau: sort, reverse, find, filter, flatten, chunk, take, takeRight, slice, group, map, difference, intersection, union, xor.

Hãy viết cho tôi một hàm sample cách sử dụng, mỗi hàm sample cho tôi 2 ví dụ cụ thể, trong sample chỉ cần sử dụng list với kiểu string thôi (không cần tạo kiểu dữ liệu phức tạp). Hãy comment thêm chức năng mỗi hàm lodash sử dụng trong từng sample.

Cuối cùng, gọi các sample trên chạy.

-----

Dưới đây là cách sử dụng các hàm `lodash` trong JavaScript để thực hiện các thao tác như `sort`, `reverse`, `find`, `filter`, `flatten`, `chunk`, `take`, `takeRight`, `slice`, `group`, `map`, `difference`, `intersection`, `union`, và `xor`. Mỗi hàm đều có hai ví dụ cụ thể và có các dòng comment giải thích chức năng của từng hàm.

Trước tiên, bạn cần cài đặt thư viện lodash:

```bash
npm install lodash
```

Sau đó, tạo một file JavaScript (ví dụ `main.js`) và viết mã nguồn như sau:

```javascript
const _ = require('lodash');

function sampleSort() {
  const list = ["banana", "apple", "cherry"];
  
  // Example 1: Sort in ascending order
  const sorted1 = _.sortBy(list);
  console.log("Sort example 1:", sorted1); // Output: ["apple", "banana", "cherry"]

  // Example 2: Sort by length of string
  const sorted2 = _.sortBy(list, [s => s.length]);
  console.log("Sort example 2:", sorted2); // Output: ["apple", "cherry", "banana"]
}

function sampleReverse() {
  const list = ["a", "b", "c", "d"];
  
  // Example 1: Reverse the list
  const reversed1 = _.reverse([...list]);
  console.log("Reverse example 1:", reversed1); // Output: ["d", "c", "b", "a"]

  // Example 2: Reverse a list with different elements
  const reversed2 = _.reverse([...["apple", "banana", "cherry"]]);
  console.log("Reverse example 2:", reversed2); // Output: ["cherry", "banana", "apple"]
}

function sampleFind() {
  const list = ["apple", "banana", "cherry"];
  
  // Example 1: Find the first element that starts with 'b'
  const found1 = _.find(list, s => s.startsWith('b'));
  console.log("Find example 1:", found1); // Output: "banana"

  // Example 2: Find the first element that starts with 'c'
  const found2 = _.find(list, s => s.startsWith('c'));
  console.log("Find example 2:", found2); // Output: "cherry"
}

function sampleFilter() {
  const list = ["apple", "banana", "cherry"];
  
  // Example 1: Filter elements that contain 'a'
  const filtered1 = _.filter(list, s => s.includes('a'));
  console.log("Filter example 1:", filtered1); // Output: ["apple", "banana"]

  // Example 2: Filter elements that contain 'e'
  const filtered2 = _.filter(list, s => s.includes('e'));
  console.log("Filter example 2:", filtered2); // Output: ["apple", "cherry"]
}

function sampleFlatten() {
  const listOfLists = [["a", "b", "c"], ["d", "e", "f"], ["g", "h", "i"]];
  
  // Example 1: Flatten a list of lists
  const flattened1 = _.flatten(listOfLists);
  console.log("Flatten example 1:", flattened1); // Output: ["a", "b", "c", "d", "e", "f", "g", "h", "i"]

  // Example 2: Flatten a list with different elements
  const flattened2 = _.flatten([["apple"], ["banana", "cherry"]]);
  console.log("Flatten example 2:", flattened2); // Output: ["apple", "banana", "cherry"]
}

function sampleChunk() {
  const list = ["a", "b", "c", "d", "e"];
  
  // Example 1: Chunk the list into parts of size 2
  const chunks1 = _.chunk(list, 2);
  console.log("Chunk example 1:", chunks1); // Output: [["a", "b"], ["c", "d"], ["e"]]

  // Example 2: Chunk the list into parts of size 3
  const chunks2 = _.chunk(list, 3);
  console.log("Chunk example 2:", chunks2); // Output: [["a", "b", "c"], ["d", "e"]]
}

function sampleTake() {
  const list = ["a", "b", "c", "d", "e"];
  
  // Example 1: Take the first 2 elements
  const taken1 = _.take(list, 2);
  console.log("Take example 1:", taken1); // Output: ["a", "b"]

  // Example 2: Take the first 4 elements
  const taken2 = _.take(list, 4);
  console.log("Take example 2:", taken2); // Output: ["a", "b", "c", "d"]
}

function sampleTakeRight() {
  const list = ["a", "b", "c", "d", "e"];
  
  // Example 1: Take the last 2 elements
  const takenRight1 = _.takeRight(list, 2);
  console.log("TakeRight example 1:", takenRight1); // Output: ["d", "e"]

  // Example 2: Take the last 3 elements
  const takenRight2 = _.takeRight(list, 3);
  console.log("TakeRight example 2:", takenRight2); // Output: ["c", "d", "e"]
}

function sampleSlice() {
  const list = ["a", "b", "c", "d", "e"];
  
  // Example 1: Slice from index 1 to 3
  const slice1 = _.slice(list, 1, 3);
  console.log("Slice example 1:", slice1); // Output: ["b", "c"]

  // Example 2: Slice from index 2 to 4
  const slice2 = _.slice(list, 2, 4);
  console.log("Slice example 2:", slice2); // Output: ["c", "d"]
}

function sampleGroup() {
  const list = ["apple", "banana", "apricot", "blueberry"];
  
  // Example 1: Group by first character
  const group1 = _.groupBy(list, s => s.charAt(0));
  console.log("Group example 1:", group1); // Output: { a: ["apple", "apricot"], b: ["banana", "blueberry"] }

  // Example 2: Group by length of string
  const group2 = _.groupBy(list, s => s.length);
  console.log("Group example 2:", group2); // Output: { 5: ["apple"], 6: ["banana"], 7: ["apricot"], 9: ["blueberry"] }
}

function sampleMap() {
  const list = ["apple", "banana", "cherry"];
  
  // Example 1: Map to upper case
  const mapped1 = _.map(list, s => s.toUpperCase());
  console.log("Map example 1:", mapped1); // Output: ["APPLE", "BANANA", "CHERRY"]

  // Example 2: Map to length of string
  const mapped2 = _.map(list, s => s.length);
  console.log("Map example 2:", mapped2); // Output: [5, 6, 6]
}

function sampleDifference() {
  const list1 = ["a", "b", "c"];
  const list2 = ["b", "c", "d"];
  
  // Example 1: Difference between list1 and list2
  const diff1 = _.difference(list1, list2);
  console.log("Difference example 1:", diff1); // Output: ["a"]

  // Example 2: Difference between list2 and list1
  const diff2 = _.difference(list2, list1);
  console.log("Difference example 2:", diff2); // Output: ["d"]
}

function sampleIntersection() {
  const list1 = ["a", "b", "c"];
  const list2 = ["b", "c", "d"];
  
  // Example 1: Intersection of list1 and list2
  const intersection1 = _.intersection(list1, list2);
  console.log("Intersection example 1:", intersection1); // Output: ["b", "c"]

  // Example 2: Intersection of list1 with different list
  const intersection2 = _.intersection(list1, ["c", "d", "e"]);
  console.log("Intersection example 2:", intersection2); // Output: ["c"]
}

function sampleUnion() {
  const list1 = ["a", "b", "c"];
  const list2 = ["c", "d", "e"];
  
  // Example 1: Union of list1 and list2
  const union1 = _.union(list1, list2);
  console.log("Union example 1:", union1); // Output: ["a", "b", "c", "d", "e"]

  // Example 2: Union of list1 with different list
  const union2 = _.union(list1, ["d", "e", "f"]);
  console.log("Union example 2:", union2); // Output: ["a", "b", "c", "d", "e", "f"]
}

function sampleXor() {
  const list1 = ["a

", "b", "c"];
  const list2 = ["b", "c", "d"];
  
  // Example 1: XOR of list1 and list2
  const xor1 = _.xor(list1, list2);
  console.log("XOR example 1:", xor1); // Output: ["a", "d"]

  // Example 2: XOR of list1 with different list
  const xor2 = _.xor(list1, ["d", "e", "f"]);
  console.log("XOR example 2:", xor2); // Output: ["a", "b", "c", "d", "e", "f"]
}

// Call all the sample functions to see the output
sampleSort();
sampleReverse();
sampleFind();
sampleFilter();
sampleFlatten();
sampleChunk();
sampleTake();
sampleTakeRight();
sampleSlice();
sampleGroup();
sampleMap();
sampleDifference();
sampleIntersection();
sampleUnion();
sampleXor();
```

### Giải thích

1. **`sampleSort`**: Sử dụng `_.sortBy` để sắp xếp danh sách.
2. **`sampleReverse`**: Sử dụng `_.reverse` để đảo ngược danh sách.
3. **`sampleFind`**: Sử dụng `_.find` để tìm phần tử đầu tiên thỏa mãn điều kiện.
4. **`sampleFilter`**: Sử dụng `_.filter` để lọc các phần tử thỏa mãn điều kiện.
5. **`sampleFlatten`**: Sử dụng `_.flatten` để làm phẳng danh sách các danh sách.
6. **`sampleChunk`**: Sử dụng `_.chunk` để chia danh sách thành các đoạn có kích thước xác định.
7. **`sampleTake`**: Sử dụng `_.take` để lấy n phần tử đầu tiên.
8. **`sampleTakeRight`**: Sử dụng `_.takeRight` để lấy n phần tử cuối cùng.
9. **`sampleSlice`**: Sử dụng `_.slice` để trích xuất một phần của danh sách từ chỉ số bắt đầu đến chỉ số kết thúc.
10. **`sampleGroup`**: Sử dụng `_.groupBy` để nhóm các phần tử theo tiêu chí nhất định.
11. **`sampleMap`**: Sử dụng `_.map` để ánh xạ các phần tử của danh sách.
12. **`sampleDifference`**: Sử dụng `_.difference` để tìm các phần tử có trong danh sách đầu tiên nhưng không có trong danh sách thứ hai.
13. **`sampleIntersection`**: Sử dụng `_.intersection` để tìm các phần tử chung giữa các danh sách.
14. **`sampleUnion`**: Sử dụng `_.union` để hợp nhất các phần tử từ nhiều danh sách, loại bỏ phần tử trùng lặp.
15. **`sampleXor`**: Sử dụng `_.xor` để tìm các phần tử có mặt trong một danh sách nhưng không có mặt trong danh sách kia (phép loại trừ tương đối).

Khi chạy file `main.js`, bạn sẽ thấy kết quả của từng hàm mẫu được in ra, cho thấy cách sử dụng và kết quả của từng hàm lodash.