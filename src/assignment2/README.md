# Custom Data Structures in Java

This project provides a simple implementation of commonly used data structures from scratch in Java without relying on the Java Collections Framework (except for `Iterator` when necessary). It's ideal for learning how underlying data structures work and for practicing object-oriented programming and algorithm design.

## 📦 Project Structure

- **Interfaces**
    - `MyList<T>` – A custom generic list interface defining basic operations (`add`, `remove`, `get`, `size`).

- **Linear Data Structures**
    - `MyArrayList<T>` – Dynamic array implementation.
    - `MyLinkedList<T>` – Singly linked list implementation using a custom node class `MyNode<T>`.
    - `MyStack<T>` – Stack implementation using `MyArrayList` as the underlying structure.
    - `MyQueue<T>` – *(Optional to add)* Queue implementation using either `MyLinkedList` or `MyArrayList`.

- **Non-Linear Data Structures**
    - `MyMinHeap` – Min-heap implementation using `MyArrayList<Integer>` to maintain a priority queue structure.

- **Utilities**
    - `Main` – Contains test cases for all data structures and demonstrates usage of the `clear` method for `MyStack` and `MyMinHeap`.

## 🚀 Features

- Dynamic resizing for array-based structures.
- Node-based memory management for linked lists.
- Stack and heap operations built from scratch (`push`, `pop`, `heapify`, etc).
- Clear separation of interface and implementation.
- Full test suite in the `main` method.

## 🧪 Sample Output

1 2 3 4 5 6
___________________________________________________
1 2 3 4 5 6
______________________________________
3
2
2
Stack size after clear: 0
______________________________________
10
20
2
______________________________________
1
3
3

MinHeap top before clear: 3

MinHeap size after clear: 0


## 🛠 How to Run

1. Clone the repository or copy the files into your local IDE.
2. Make sure your `Main.java` file contains the `main()` method and is in the correct package.
3. Run the `Main` class to test all data structures.

## ✅ To Do

- Implement `MyQueue` class.
- Add iterator support to all custom structures.
- Create unit tests using JUnit for better test coverage.

## 📚 Learning Objectives

- Understand how fundamental data structures operate internally.
- Practice implementing interfaces and generics in Java.
- Develop skills for solving algorithmic problems without built-in collections.

## 📄 License

This project is for educational purposes and is open to contributions and extensions.

---

Feel free to modify the content according to your project or coursework needs!
