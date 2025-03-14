package io.jieun.linkedList;

import io.jieun.arratList.List;

public class LinkedList<E> implements List<E> {

    //LinkedList는 일반 배열이랑 조금 다르다, 노드가 안에 들어있기 때문에
    private Node<E> head;
    private Node<E> tail;

    private int size = 0;

    public void addFirst(E e){

        Node<E> newNode = new Node<>(e);

        //자료구조가 비어있을 경우
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        } else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;

    }

    //마지막값에 e를 넣어주겠다.
    public void addLast(E e){
        Node<E> newNode = new Node<>(e);

        if(isEmpty()){
            tail = newNode;
            head = newNode;
        }else{
            if(tail!=null){
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode;
            }
        }
        size++;

    }

    @Override
    public void add(int index, E e) {
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }

        if(index==0){
            addFirst(e);
            return;
        }

        if(index==size){
            addLast(e);
            return;
        }

        Node<E> newNode = new Node<>(e);

        Node<E> cur = head;

        for(int i=0; i<index-1; i++){
            cur = cur.next;
        }

        newNode.next = cur.next;
        newNode.prev = cur;

        if( cur.next != null ){
            cur.next.prev = newNode;
        }
        size++;

    }

    @Override
    public E get(int index) {
        //인덱스 검사
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }

        Node<E> cur = head;

        for(int i=0; i<index; i++){
            cur = cur.next;
        }

        return cur.data;

    }

    public E removeFirst(){

        if(isEmpty()){
            throw new RuntimeException("Linked list is empty");
        }

        E removedData = head.data;

        if(head.next != null){
            head.next.prev = null;
            head = head.next;
        }else{
            head = null;
            tail = null;
        }

        size--;
        return removedData;
    }

    public E removeLast(){
        if(isEmpty()){
            throw new RuntimeException("Linked list is empty");
        }

        E removedData = tail.data;

        if(tail.prev != null) {
            tail.prev.next = null;
            tail = tail.prev;
        }else{
            tail = null;
        }

        size--;

        return removedData;
    }

    @Override
    public E remove(int index) {

        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }

        if(index==0){
            return removeFirst();
        }
        if(index==(size-1)){
            return removeLast();
        }

        Node<E> cur = head;

        for(int i=0; i<index; i++){
            cur = cur.next;
        }

        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;


        size--;

        return cur.data;
    }

    @Override
    public E set(int index, E e) {

        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }

        if(isEmpty()){
            throw new RuntimeException("Linked list is empty");
        }

        if(index ==0 ){
            head.data = e;
            return e;
        }

        if(index ==(size-1) ){
            head.data = e;
            return e;
        }

        Node<E> cur = head;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }
        cur.data = e;

        return e;
    }

    @Override
    public void add(E e) {
        addLast(e);
    }

    @Override
    public void remove(E e) { //인덱스 x, 중복된 값이 있을때

        if(isEmpty()){
            throw new RuntimeException("Linked list is empty");
        }

        Node<E> cur = head;
        while(cur != null){
            if(cur.data.equals(e)){

                if(cur==head){
                    removeFirst();
                } else if (cur==tail) {
                    removeLast();
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }

            }
            cur = cur.next;
        }

    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(E e) {
        if(isEmpty()){
            return false;
        }

        Node<E> cur = head;

        while(cur != null){

            if(cur.data.equals(e)){
                return true;
            }

            cur = cur.next;
        }

        return false;
    }

    //출력하는 메소드
    public void traverse(){

        if(isEmpty()){
            System.out.println("자료구조가 비어있습니다.");
            return;
        }

        Node<E> cur = head;

        while(cur != null){
            System.out.println(cur.data+ " ");
            cur = cur.next;
        }


    }

    //이 노드 클래스의 역할을 값을 저장하고 이전이나 다음을 가르키는 포인트를 가지고 있다.
    private static class Node<E>{
        //prev이전과 next다음을 보관할 수 있는 포인터 역할을 한다.
        Node<E> prev;
        Node<E> next;
        E data;

        public Node(E data){
            this.data = data;
        }

    }


}
