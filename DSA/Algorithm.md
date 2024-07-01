

## sort(self_array, func_compare)

Sắp xếp mảng theo phương pháp so sánh của `func_compare`

```js
self_array = ["apple", "orange", "banana", "pear", "grape", "cherry", "strawberry", "kiwi", "mango", "blueberry"]

// SORT `self_array`
sorted_array = ["apple", "banana", "blueberry", "cherry", "grape", "kiwi", "mango", "orange", "pear", "strawberry"]

```



## reverse(self_array)

Đảo ngược thứ tự các phần tử trong mảng `self_array`.

```js
self_array = ["apple", "orange", "banana", "pear", "grape", "cherry", "strawberry", "kiwi", "mango", "blueberry"]

//REVERSE `self_array`
reversed_array = ["blueberry", "mango", "kiwi", "strawberry", "cherry", "grape", "pear", "banana", "orange", "apple"]
```



## find(self_array, func_valid) & filter(self_array, func_valid)

find: Trả về phần tử đầu tiên thỏa mãn điều kiện trong `func_valid`

filter: Trả về mảng mới chứa tất cả phần tử thỏa mãn điều kiện trong  `func_valid`

```js
self_array = ["apple", "orange", "banana", "pear", "grape", "cherry", "strawberry", "kiwi", "mango", "blueberry"];
function valid(element) {
  return element.includes('e')
}
// FIND ELEMENT HAS 'e' CHARACTER: 
found_result = find(self_array, valid) // => "apple"

// FILTER ELEMENTs HAS 'e' CHARACTER: 
filtered_array = filter(self_array, valid) // =>  ["apple", "pear", "grape", "cherry", "strawberry", "blueberry"]
```



## flatten(self_array)

Làm phẳng mảng lồng nhau (một cấp).

```js
self_array = [["apple", "orange"], ["banana", "pear"], ["grape"], ["cherry", "strawberry"], ["kiwi", "mango", "blueberry"]]

// FLATTEN `self_array`
flatten_array = ["apple", "orange", "banana", "pear", "grape", "cherry", "strawberry", "kiwi", "mango", "blueberry"]
```



## chunk(self_array, n)

Chia mảng thành các mảng con có kích thước xác định.

```js
self_array = ["apple", "orange", "banana", "pear", "grape", "cherry", "strawberry", "kiwi", "mango", "blueberry"]

// CHUNK `self_array` WITH CHUNK SIZE IS '3'
chunked_array = [
	["apple", "orange", "banana"], 
	["pear", "grape", "cherry"], 
	["strawberry", "kiwi", "mango"], 
  ["blueberry"]
 ]
 
```



## takeLeft(self_array, n), takeRight(self_array, n), slice(self_array, n)

take: Lấy n phần tử đầu tiên của mảng. 

takeRight: Lấy n phần tử cuối cùng của mảng. 

slice: Trích xuất một phần của mảng.

```js
self_array = ["apple", "orange", "banana", "pear", "grape", "cherry", "strawberry", "kiwi", "mango", "blueberry"]

// TAKE 3 ELEFMENT (FROM LEFT) 	=> ["apple", "orange", "banana"]
// TAKE 3 ELEFMENT (FROM RIGHT) => ["kiwi", "mango", "blueberry"]
// SLICE FROM (INDEX) 2 to < 5 	=> ["banana", "pear", "grape"]
```



## group

Nhóm các phần tử của mảng theo tiêu chí.

```js
self_array = ["Alice", "Aaron", "Bob", "Charlie", "Catherine", "Carl", "David", "Daniel", "Diana", "Dorothy"]

// GROUP `self_array` BY FIRST CHARACTER IN NAME
grouped_result = {
  A: ["Alice", "Aaron"],          						// 2 tên bắt đầu bằng "A"
  B: ["Bob"],                     						// 1 tên bắt đầu bằng "B"
  C: ["Charlie", "Catherine", "Carl"],  			// 3 tên bắt đầu bằng "C"
  D: ["David", "Daniel", "Diana", "Dorothy"]  // 4 tên bắt đầu bằng "D"
}
```



## map(self_array, func_map)

Tạo mảng mới từ việc xử lý các phần tử trong mảng hiện tại thông qua hàm `func_map`.

```js
self_array = ["apple", "banana", "cherry", "date", "fig", "grape"]

// MAP từ self_array thành mảng mới với bằng cách lấy chiều dài mỗi phần tử trong self_array.
map_array = [5, 6, 6, 4, 3, 5]

```

----



## difference(self_array, other_array)

Tạo một mảng gồm các phần tử của `self_array` không có trong `other_array`.


## intersection(self_array, other_array)

Tạo một mảng gồm các phần tử chung duy nhất của tất cả các mảng.

## union(self_array, other_array)

Tạo một mảng gồm tất cả các phần tử duy nhất từ tất cả các mảng.

## xor(self_array, other_array)

Tạo một mảng gồm các phần tử duy nhất trong mỗi mảng, nhưng không phải là phần tử chung của tất cả các mảng.

![img](https://p.ipic.vip/rqgnvk.jpg)


```js
let self_array = ["apple", "banana", "cherry", "date", "fig", "grape", "kiwi", "lemon"];
let other_array = ["banana", "cherry", "elderberry", "fig", "grapefruit", "kiwi", "lime", "mango"];

self_difference_with_other = ["apple", "date", "grape", "lemon"]
self_intersecion_with_other = ["banana", "cherry", "fig", "kiwi"]
self_union_with_other = ["apple", "banana", "cherry", "date", "fig", "grape", "kiwi", "lemon", "elderberry", "grapefruit", "lime", "mango"]
self_xor_other = ["apple", "date", "grape", "lemon", "elderberry", "grapefruit", "lime", "mango"]
```