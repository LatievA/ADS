package assignment2;

public class MyLinkedList<T> implements MyList<T> {
    private class MyNode<E> {
        E data;
        MyNode<E> next;
        MyNode<E> prev;

        public MyNode(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T element) {
        if (hasCycle()) {
            throw new IllegalStateException("Cycle detected in the list. Cannot perform operation.");
        }
        MyNode<T> newNode = new MyNode<>(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null; // list is now empty
        } else if (index == size - 1) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            MyNode<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        MyNode<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current.data;
    }

    public int size() {
        return size;
    }

    private boolean hasCycle() {
        MyNode<T> slow = head;
        MyNode<T> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }

}
