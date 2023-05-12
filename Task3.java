import java.util.NoSuchElementException;

public class ArrayTwoColorDoubleStack<T> implements TwoColorDoubleStack<T> {
    private T[] arr;
    private int red;
    private int blue;

    public ArrayTwoColorDoubleStack(int capacity) {
        arr = (T[]) new Object[capacity];
        red = -1;
        blue = capacity;
    }

    public void pushRed(T item) {
        if (red + 1 < blue) {
            arr[++red] = item;
        } else {
            throw new IllegalStateException("Then Red stack is full");
        }
    }

    public T popRed() {
        if (red >= 0) {
            return arr[red--];
        } else {
            throw new NoSuchElementException("Then Red stack is empty");
        }
    }

    public T peekRed() {
        if (red >= 0) {
            return arr[red];
        } else {
            throw new NoSuchElementException("Red stack is empty");
        }
    }

    public boolean isRedEmpty() {
        return red == -1;
    }

    public int redSize() {
        return red + 1;
    }

    public void pushBlue(T item) {
        if (red + 1 < blue) {
            arr[--blue] = item;
        } else {
            throw new IllegalStateException("Then Blue stack is full");
        }
    }

    public T popBlue() {
        if (blue < arr.length) {
            return arr[blue++];
        } else {
            throw new NoSuchElementException("Then Blue stack is empty");
        }
    }

    public T peekBlue() {
        if (blue < arr.length) {
            return arr[blue];
        } else {
            throw new NoSuchElementException("Blue stack is empty");
        }
    }

    public boolean isBlueEmpty() {
        return blue == arr.length;
    }

    public int blueSize() {
        return arr.length - blue;
    }

    public static void main(String[] args) {
        TwoColorDoubleStack<Integer> stack = new ArrayTwoColorDoubleStack<>(10);

        stack.pushRed(4);
        stack.pushRed(5);
        stack.pushRed(7);

        stack.pushBlue(8);
        stack.pushBlue(9);
        stack.pushBlue(2);

        System.out.println(stack.popRed());
        System.out.println(stack.popRed());

        System.out.println(stack.popBlue());
        System.out.println(stack.popBlue());

        System.out.println(stack.peekRed());
        System.out.println(stack.peekBlue());

        System.out.println(stack.redSize());
        System.out.println(stack.blueSize());
    }
}