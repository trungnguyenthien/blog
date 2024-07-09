

## sort(self_array, func_compare)

Sắp xếp mảng theo phương pháp so sánh của `func_compare`

```js

self_array = ["apple", "orange", "banana", "pear", "grape", "cherry", "strawberry", "kiwi", "mango", "blueberry"]

/* Sắp xếp theo alphabet ↓↓↓ */

sorted_array = ["apple", "banana", "blueberry", "cherry", "grape", "kiwi", "mango", "orange", "pear", "strawberry"]


```



## reverse(self_array)

Đảo ngược thứ tự các phần tử trong mảng `self_array`.

```js

self_array = ["apple", "orange", "banana", "pear", "grape", "cherry", "strawberry", "kiwi", "mango", "blueberry"]

/* Đảo thứ tự array trên ↓↓↓ */

reversed_array = ["blueberry", "mango", "kiwi", "strawberry", "cherry", "grape", "pear", "banana", "orange", "apple"]

```



## find(self_array, func_valid) & filter(self_array, func_valid)

find: Trả về phần tử đầu tiên thỏa mãn điều kiện trong `func_valid`

filter: Trả về mảng mới chứa tất cả phần tử thỏa mãn điều kiện trong  `func_valid`

```js

self_array = ["apple", "orange", "banana", "pear", "grape", "cherry", "strawberry", "kiwi", "mango", "blueberry"]

/* FIND ELEMENT HAS 'e' CHARACTER ↓↓↓ */
found_result = find(self_array, valid) // => "apple"

/* FILTER ELEMENTs HAS 'e' CHARACTER ↓↓↓ */

filtered_array = ["apple", "pear", "grape", "cherry", "strawberry", "blueberry"]

```


```js

self_array = ["apple", "orange", "banana", "pear", "grape", "cherry", "strawberry", "kiwi", "mango", "blueberry"];

/* FIND ELEMENT HAS 'e' CHARACTER ↓↓↓ */
found_result = "apple"

/* FILTER ELEMENTs HAS 'e' CHARACTER ↓↓↓ */
filtered_array = ["apple", "pear", "grape", "cherry", "strawberry", "blueberry"]

```

## flatten(self_array)

Làm phẳng mảng lồng nhau (một cấp).

```js

self_array = [
  ["apple", "orange"], 
  ["banana", "pear"], 
  ["grape"], 
  ["cherry", "strawberry"], 
  ["kiwi", "mango", "blueberry"]
]

/* Làm phẳng array trên ↓↓↓ */
flatten_array = ["apple", "orange", "banana", "pear", "grape", "cherry", "strawberry", "kiwi", "mango", "blueberry"]

```



## chunk(self_array, n)
Tạo một mảng các phần tử được chia thành các nhóm có độ dài bằng `size`. Nếu `array` không thể chia đều, nhóm cuối cùng sẽ chứa các phần tử còn lại.

```js

self_array = ["apple", "orange", "banana", "pear", "grape", "cherry", "strawberry", "kiwi", "mango", "blueberry"]

/* Chia nhỏ thành nhiều Array với độ dài là '3' ↓↓↓ */
chunked_array = [
	["apple", "orange", "banana"], 
	["pear", "grape", "cherry"], 
	["strawberry", "kiwi", "mango"], 
  ["blueberry"] // Array cuối có số phần tử ít hơn nếu không chia đều.
 ]
 
```



## takeLeft(self_array, n), takeRight(self_array, n), slice(self_array, n)

take: Lấy n phần tử đầu tiên của mảng. 

takeRight: Lấy n phần tử cuối cùng của mảng. 

slice: Trích xuất một phần của mảng.

```js

self_array = [
  "0_apple", "1_orange", "2_banana", 
  "3_pear", "4_grape", "5_cherry", 
  "6_strawberry", "7_kiwi", "8_mango", 
  "9_blueberry"
]

// TakeFirst(3) => ["0_apple", "1_orange", "2_banana"]
// TakeLast(3)  => ["7_kiwi", "8_mango", "9_blueberry"]
// Slice(2, 5) 	=> ["2_banana", "3_pear", "4_grape"]

```



## group

Nhóm các phần tử của mảng theo tiêu chí.

```js

self_array = ["Alice", "Aaron", "Bob", "Charlie", "Catherine", "Carl", "David", "Daniel", "Diana", "Dorothy"]

/* Nhóm các phần tử có chữ ký tự đầu giống nhau ↓↓↓ */
grouped_result = {
  A: ["Alice", "Aaron"],          						// 2 name bắt đầu bằng "A"
  B: ["Bob"],                     						// 1 name bắt đầu bằng "B"
  C: ["Charlie", "Catherine", "Carl"],  			// 3 name bắt đầu bằng "C"
  D: ["David", "Daniel", "Diana", "Dorothy"]  // 4 name bắt đầu bằng "D"
}

```


## map(self_array, func_map)

Tạo mảng mới từ việc xử lý các phần tử trong mảng hiện tại thông qua hàm `func_map`.

```js

self_array = ["apple", "banana", "cherry", "date", "fig", "grape"]

/* Map thành array mới, mỗi phần từ của array mới 
 là chiều dài của các phần tử ở vị trí tương ứng của array hiện tại 
 ↓↓↓ */
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

<img src="https://p.ipic.vip/rqgnvk.jpg" alt="img" style="zoom:50%;" />


```js

self_array = ["apple", "banana", "cherry", "date", "fig", "grape", "kiwi", "lemon"];
other_array = ["banana", "cherry", "elderberry", "fig", "grapefruit", "kiwi", "lime", "mango"];

self_xor_other = ["apple", "date", "grape", "lemon", "elderberry", "grapefruit", "lime", "mango"]

self_union_with_other = [
  "apple", "banana", "cherry", "date", "fig", "grape", 
  "kiwi", "lemon", "elderberry", "grapefruit", "lime", "mango"
]

self_intersecion_with_other = ["banana", "cherry", "fig", "kiwi"]

self_difference_with_other = ["apple", "date", "grape", "lemon"]]

self_union_with_other = ["apple", "banana", "cherry", "date", "fig", "grape", "kiwi", "lemon", "elderberry", "grapefruit", "lime", "mango"]
self_xor_other = ["apple", "date", "grape", "lemon", "elderberry", "grapefruit", "lime", "mango"]
```