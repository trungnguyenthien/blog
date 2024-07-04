# STATIC ARRAY
Javascript không support static array, tuy nhiên có thể tạo proxy cho kiểu array và ignore các method ảnh hưởng đến kích thước array.

<details>
  <summary>Click me</summary>

```js
function staticArray(size) {
  const array = new Array(size).fill(null);

  return new Proxy(array, {
    set(target, property, value) {
      if (!isNaN(property) && property < size) {
        target[property] = value;
        return true;
      } else if (!isNaN(property)) {
        throw new Error("Cannot add new elements to a static array");
      } else {
        return Reflect.set(target, property, value);
      }
    },
    deleteProperty(target, property) {
      if (!isNaN(property)) {
        throw new Error("Cannot delete elements from a static array");
      } else {
        return Reflect.deleteProperty(target, property);
      }
    },
    get(target, property) {
      if (['push', 'pop', 'shift', 'unshift', 'splice'].includes(property)) {
        throw new Error(`Cannot use method ${property} on a static array`);
      }
      return Reflect.get(target, property);
    }
  });
}

//------------------------------------------------
//------------------------------------------------
const fixedArray = staticArray(5);
fixedArray[0] = 1; // OK
fixedArray[4] = 5; // OK
console.log(fixedArray); // [1, null, null, null, 5]

try {
  fixedArray[5] = 6; // Error: Cannot add new elements to a static array
} catch (e) {
  console.log(e.message);
}

try {
  delete fixedArray[0]; // Error: Cannot delete elements from a static array
} catch (e) {
  console.log(e.message);
}

try {
  fixedArray.push(6); // Error: Cannot use method push on a static array
} catch (e) {
  console.log(e.message);
}

try {
  fixedArray.pop(); // Error: Cannot use method pop on a static array
} catch (e) {
  console.log(e.message);
}

console.log(fixedArray); // [1, null, null, null, 5]

```
</details>

# DYNAMIC ARRAY
Kiểu Array trong Javascript được cài đặt như một Dynamic Array.

# STACK & QUEUE
Kiểu Array trong Javascript cung cấp các phương thức tương đương các phương thức push, pop, dequeue, enqueue của Stack và Queue.
Tuy nhiên nếu muốn việc viết code và đọc code thuận theo thuật toán (sử dụng Stack, Queue) ta có thể wrapper kiểu Array trong class Stack và Queue như sau:

<details>
  <summary>Click me</summary>

```js
class Collection {
  constructor() {
    this.items = [];
  }

  // Kiểm tra collection có rỗng không
  isEmpty() {
    return this.items.length === 0;
  }

  // Trả về kích thước của collection
  size() {
    return this.items.length;
  }

  // In các phần tử trong collection
  print() {
    console.log(this.items.toString());
  }
}

class Stack extends Collection {
  constructor() {
    super();
  }

  // Thêm phần tử vào cuối stack
  push(element) {
    this.items.push(element);
  }

  // Loại bỏ và trả về phần tử ở cuối stack
  pop() {
    if (this.isEmpty()) {
      return null;
    }
    return this.items.pop();
  }

  // Trả về phần tử ở cuối stack mà không loại bỏ nó
  peek() {
    if (this.isEmpty()) {
      return null;
    }
    return this.items[this.items.length - 1];
  }
}

class Queue extends Collection {
  constructor() {
    super();
  }

  // Thêm phần tử vào cuối queue
  enqueue(element) {
    this.items.push(element);
  }

  // Loại bỏ và trả về phần tử ở đầu queue
  dequeue() {
    if (this.isEmpty()) {
      return null;
    }
    return this.items.shift();
  }

  // Trả về phần tử ở đầu queue mà không loại bỏ nó
  front() {
    if (this.isEmpty()) {
      return null;
    }
    return this.items[0];
  }
}

//------------------------------------------------
//------------------------------------------------

// Sử dụng Stack
let stack = new Stack();
stack.push(1);
stack.push(2);
stack.push(3);
stack.print();  // 1,2,3
console.log(stack.pop());  // 3
console.log(stack.peek());  // 2
console.log(stack.isEmpty());  // false
console.log(stack.size());  // 2
stack.print();  // 1,2


// Sử dụng Queue
let queue = new Queue();
queue.enqueue(1);
queue.enqueue(2);
queue.enqueue(3);
queue.print();  // 1,2,3
console.log(queue.dequeue());  // 1
console.log(queue.front());  // 2
console.log(queue.isEmpty());  // false
console.log(queue.size());  // 2
queue.print();  // 2,3
```

</details>

# SET
JavaScript cung cấp kiểu dữ liệu `Set` kể từ ES6. 
`Set` là một đối tượng cho phép bạn lưu trữ các giá trị duy nhất, nghĩa là không có hai phần tử nào có thể giống nhau trong một `Set`.

<details>
  <summary>Click me</summary>

```js
let mySet = new Set();
// Thêm phần tử vào Set
mySet.add(1);
mySet.add(2);
mySet.add(3);
mySet.add(1);  // Sẽ không thêm vì 1 đã tồn tại trong Set
console.log(mySet);  // Set { 1, 2, 3 }
// Xóa phần tử khỏi Set
mySet.delete(2);
console.log(mySet);  // Set { 1, 3 }
// Kiểm tra phần tử có tồn tại trong Set
console.log(mySet.has(1));  // true
console.log(mySet.has(2));  // false

// Chuyển Set thành Array
let myArray = Array.from(mySet);
console.log(myArray);  // [1, 2, 3]

// Tạo Set từ Array
let myNewSet = new Set([1, 2, 3, 4, 5]);
console.log(myNewSet);  // Set { 1, 2, 3, 4, 5 }

```
</details>

# DICTIONARY
Javascript hỗ trợ kiểu Map. 

<details>
  <summary>Click me</summary>

```js
// Tạo một Map
let countryCapitals = new Map();

// Thêm các cặp khóa-giá trị vào Map
countryCapitals.set("USA", "Washington, D.C.");
countryCapitals.set("France", "Paris");
countryCapitals.set("Japan", "Tokyo");

// Truy cập giá trị bằng khóa
console.log(countryCapitals.get("USA"));    // Washington, D.C.
console.log(countryCapitals.get("France")); // Paris
console.log(countryCapitals.get("Japan"));  // Tokyo

// Kiểm tra sự tồn tại của khóa
console.log(countryCapitals.has("USA"));    // true
console.log(countryCapitals.has("Germany")); // false

// Xóa một cặp khóa-giá trị
countryCapitals.delete("France");
console.log(countryCapitals);  // Map { 'USA' => 'Washington, D.C.', 'Japan' => 'Tokyo' }

// Trả về kích thước của Map
console.log(countryCapitals.size);  // 2

// Duyệt qua các cặp khóa-giá trị trong Map
countryCapitals.forEach((capital, country) => {
  console.log(`${country}: ${capital}`);
});
// Output:
// USA: Washington, D.C.
// Japan: Tokyo

// Duyệt qua các cặp khóa-giá trị bằng for-of
for (let [country, capital] of countryCapitals) {
  console.log(`${country}: ${capital}`);
}
// Output:
// USA: Washington, D.C.
// Japan: Tokyo

// Xóa tất cả các cặp khóa-giá trị trong Map
countryCapitals.clear();
console.log(countryCapitals);  // Map {}

```

</details>

Nhưng (vì là Javascript nên) không cố định kiểu dữ liệu key-value. Cần chú ý khi code để tránh nhầm lẫn.

<details>
  <summary>Click me</summary>

```js
let map = new Map();

// Sử dụng số làm khóa
map.set(1, "one");

// Sử dụng chuỗi làm khóa
map.set("2", "two");

console.log(map.get(1));    // "one"
console.log(map.get("1"));  // undefined (vì "1" là chuỗi, khác với số 1)

console.log(map.get("2"));  // "two"
console.log(map.get(2));    // undefined (vì 2 là số, khác với chuỗi "2")

```
</details>

# LINKEDLIST

Javascript mặc định không hỗ trợ kiểu LinkedList. Nhưng thấy cũng ít nhu cầu sử dụng.
