package assignment2;

public class MyStack<T> {
    private MyList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(T element) {
        list.add(element);
    }

    public T pop() {
        if (list.size() == 0) throw new RuntimeException("Stack is empty");
        T element = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return element;
    }

    public T peek() {
        if (list.size() == 0) throw new RuntimeException("Stack is empty");
        return list.get(list.size() - 1);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}

