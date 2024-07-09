# CÂU #1
Cho `input` là array number, sử dụng thuật toán nào để phân thành 2 mảng số chẵn và lẻ.

```js
input = [1, 2, 3, 4, 5, 6]

// Kết quả
output = {
  odd: [1, 3, 5],
  even: [2, 4, 6]
}
```

### ĐÁP ÁN
```
A. sort
B. filter
C. group ✅
D. map
```

----
# CÂU #2
Cho `input` là array number, sử dụng thuật toán nào để tạo array `output` mới với mỗi phần tử bằng x2 giá trị của từng phần tử trong array `input`.

```js
input = [1, 2, 3, 4, 5, 6]

// Kết quả
output = [2, 4, 6, 8, 10, 12]
```
### ĐÁP ÁN
```
A. sort
B. filter
C. group 
D. map ✅
```
---
# CÂU #3
Cho `input` là array number, sử dụng thuật toán nào để phân thành nhiều array nhỏ, mỗi array có 2 phần tử.

```js
input = [1, 2, 3, 4, 5, 6]

// Kết quả
output = [
  [1, 2], 
  [3, 4], 
  [5, 6]
]
```

### ĐÁP ÁN
```
A. chunk ✅
B. flatten
C. group 
D. map
```

---
# CÂU #4
Cho 2 array `input` và `exclude`, sử dụng thuật toán nào để array `output` chỉ chứa các phần tử thuộc `input` nhưng không thuộc `exclude`.

```js
input = [1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
exclude = [2, 4, 6, 8, 10]

// Kết quả
output = [ 1, 1, 3, 5, 7, 9 ]
```

### ĐÁP ÁN
```
A. intersection 
B. filter ✅
C. difference ✅
D. xor
```
----
# CÂU #5
Cho 2 array `number1` và `number2`, sử dụng thuật toán nào để array `output` chứa tất cả các giá trị duy nhất từ 2 array đã cho. 

```js
numbers1 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
numbers2 = [5, 6, 7, 8, 9, 10, 11, 12, 13, 14];

// Kết quả
output = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
```
### ĐÁP ÁN
```
A. difference 
B. intersection
C. xor 
D. union ✅
```
---
# CÂU #6
Cho 2 array `number1` và `number2`, sử dụng thuật toán nào để array `output` chứa các giá trị giống nhau trong cả 2 array đã cho.


```js
numbers1 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
numbers2 = [5, 6, 7, 8, 9, 10, 11, 12, 13, 14];

// Kết quả
output = [5, 6, 7, 8, 9, 10]
```

### ĐÁP ÁN
```
A. difference 
B. intersection ✅
C. xor 
D. union 
```
---
# CÂU #7
Cho 2 array `number1` và `number2`, sử dụng thuật toán nào để array `output` chứa các giá trị duy nhất xuất hiện ở một trong hai các array đã cho.

```js
numbers1 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
numbers2 = [5, 6, 7, 8, 9, 10, 11, 12, 13, 14];

// Kết quả
output = [1, 2, 3, 4, 11, 12, 13, 14]
```
### ĐÁP ÁN
```
A. difference 
B. intersection 
C. xor ✅
D. union 
```
---
# Câu #8
Cho array `input` chứa một số phần tử trùng nhau, sử dụng thuật toán nào để khử các phần tử trùng nhau.

```js
input = [1, 1, 2, 3, 4, 6, 6, 7, 8, 9, 10];
// Input có 2 cặp {1, 1} và {6, 6}.
// Kết quả khử trùng
output = [
  1, 2, 3, 4, 6,
  7, 8, 9, 10
]
```
### ĐÁP ÁN
```
A. difference trên cùng 1 array
B. intersection trên cùng 1 array
C. xor trên cùng 1 array
D. union trên cùng 1 array ✅
```
---
# Câu #9
Cho array `input` là một mảng lồng, sử dụng thuật toán nào để làm phẳng array lồng nhau xuống một mức độ sâu.

```js
input = [1, [2, 3], [4, [5, 6]], [7, 8], 9, [10]];

// Kết quả
output = [1, 2, 3, 4, [5, 6], 7, 8, 9, 10]
```
### ĐÁP ÁN
```
A. chunk 
B. flatten ✅
C. group 
D. map
```
---
# Câu #10
Trong các thuật toán dưới đây, thuật toán nào sau khi xử lý xong sẽ không có phần trử trùng nhau trong array

### ĐÁP ÁN
```
A. difference 
B. intersection 
C. xor
D. union 
```