package Mystack;
import java.util.Arrays;
import java.util.Vector;

public class MyStack<T> extends Vector<T>{

    public MyStack() {
    }

    public T push(T obj)
    {
        addElement(obj);
        return obj;
    }

    public synchronized T pop()
    {
        T obj=this.top();
        removeElementAt(elementCount-1);
        return obj;
    }

    public T top()
    {
        return elementAt(elementCount-1);
    }

    @Override
    public String toString() {
        return "MyStack{" +
                 Arrays.toString(elementData) +
                '}';
    }
}
