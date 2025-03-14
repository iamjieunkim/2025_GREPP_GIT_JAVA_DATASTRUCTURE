package io.jieun.stack;

import io.jieun.Collection;

public class Stack1<E> implements Collection<E> {

    private Object[] elements = {};

    public void push(E e) {

        Object[] temp = new Object[elements.length + 1];

        for(int i=0; i< elements.length; i++){
            temp[i] = elements[i];
        }

        temp[elements.length] = e;
        elements = temp;


    }

    @SuppressWarnings("all")
    public E pop() {

        Object[] temp = new Object[elements.length - 1];
        E target = (E)elements[elements.length - 1];

        for (int i=0; i< elements.length; i++){
            temp[i] = elements[i];
        }
        elements = temp;

        return target;
    }

    //젤 위에 있는거 반환해줘야 되서 만든 것
    public E top() {
        return (E)elements[elements.length - 1];
    }

    //이 add는 stack에서 생각하는 push랑 똑같다.
    @Override
    public void add(E e) {
        push(e);
    }

    @Override
    public void remove(E e) {
        if(top().equals(e)){
            pop();
        }
    }

    @Override
    public boolean isEmpty() {
        return elements.length == 0;
    }

    @Override
    public int size() {
        return elements.length;
    }

    public void print(){
        for (Object element : elements) {
            System.out.println(element+" ");
        }
        System.out.println();
    }

    @Override
    public boolean contains(E e) {

        for(int i=0; i< elements.length; i++){
            if(elements[i].equals(e)){
                return true;
            }
        }
        return false;
    }



}
