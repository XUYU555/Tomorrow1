package Mystack;

import java.util.EmptyStackException;

public class NodeStack<T> {
    public NodeStack() {
    }
    private Node<T> top;

    private class Node<T>
    {
        private T date;
        private Node<T> next;
        public Node() {
        }
        public Node(T date,Node<T> next) {
            this.date = date;
            this.next = next;
        }
    }

    public void push(T date)
    {
        Node<T> newnode=new Node<>(date,top);
        top=newnode;
    }

    public T pop()
    {
        if(top==null)
        {
            throw new EmptyStackException();
        }
        T date=top.date;
        top=top.next;
        return date;
    }

    public T top()
    {
        if(top==null)
        {
            throw new EmptyStackException();
        }
        return top.date;
    }
}
