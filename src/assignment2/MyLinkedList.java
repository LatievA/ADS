package assignment2;

public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> node;
    private int length;

    public MyLinkedList() {
        node = null;
        length = 0;
    }

    public void add(T element) {
        MyNode<T> newNode = new MyNode<>(element);
        if (node == null) {
            node = newNode;
        } else {
            MyNode<T> current = node;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            node = node.next;
        } else {
            MyNode<T> current = node;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        length--;
    }

    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        MyNode<T> current = node;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        return length;
    }
}

