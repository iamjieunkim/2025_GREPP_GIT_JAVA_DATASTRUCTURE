package io.jieun.arratList;

import io.jieun.Collection;

public interface List<E> extends Collection<E> {

    //어디 index에 어떤 값을 추가 할 수 있다.
    void add(int index, E e);

    //특정 위치(index)에 있는 값을 꺼낼떄에는 List<E>에 있는 값이 여야 한다.
     E get(int index);

     //특정 위치(index)있는 값을 제거 하려면 삭제된 친구 List<E>를 반환하겠다.
     E remove(int index);

     //CRUD
    //수정- 몇번째(index)요소에 있는 것을 e값으로 바꾸겠다.
    E set(int index, E e);

}
