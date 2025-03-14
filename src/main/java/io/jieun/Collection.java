package io.jieun;
//요소에 타입을 제네릭으로 받아줘야되기 때문에
public interface Collection<E>  {
    //넣어준다.
    void add(E e);
    //삭제한다.
    void remove(E e);

    boolean isEmpty();

    int size();

    //이 원소가 이 자료구조 안에 포함되어 있나요?
    boolean contains(E e);


}
