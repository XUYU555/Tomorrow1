package Mystack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void push() {
        MyStack<String> ms=new MyStack<>();
        ms.push("String");
        ms.push("Integer");
        ms.push("boolean");
        assertEquals("boolean",ms.pop());
        assertEquals("Integer",ms.pop());
        assertEquals("String",ms.pop());
    }

    @Test
    void size() {
        MyStack<Integer> ms=new MyStack<>();
        ms.push(123);
        assertEquals(1,ms.size());
        ms.push(456);
        assertEquals(2,ms.size());
        ms.push(789);
        assertEquals(3,ms.size());
    }

    @Test
    void pop() {
        MyStack<Student> ms=new MyStack<>();
        ms.push(new Student("zhangsan",23));
        ms.push(new Student("lisi",24));
        ms.push(new Student("wangwu",25));
        ms.push(new Student("qianliu",26));
        assertEquals(new Student("qianliu",26),ms.pop());
        assertEquals(new Student("wangwu",25),ms.pop());
        assertEquals(new Student("lisi",24),ms.pop());
        assertEquals(new Student("zhangsan",23),ms.pop());
    }
}