package io.jieun.deque;

import io.jieun.Collection;
import io.jieun.linkedList.LinkedList;

public class Deque1<E> implements Collection<E> {

    private final LinkedList<E> elements;

    public Deque1() {
        this.elements = new LinkedList<>();
    }

    public void offer(E e){
        elements.addFirst(e);
    }

    public void push(E e){
        elements.addLast(e);
    }

    public E pop(){
        return isEmpty() ? null : elements.removeLast();
    }

    public E poll() {
        return isEmpty() ? null : elements.removeFirst();
    }

    public E peek() {
        return isEmpty()? null : elements.get(elements.size() - 1);
    }


    @Override
    public void add(E e) {
        push(e);
    }

    @Override
    public void remove(E e) {
        if(peek().equals(e)){
            poll();
        }
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean contains(E e) {
        return elements.contains(e);
    }

    public void print(){
        this.elements.traverse();
    }
}
