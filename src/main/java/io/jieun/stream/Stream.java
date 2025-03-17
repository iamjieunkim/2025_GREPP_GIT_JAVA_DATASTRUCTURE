package io.jieun.stream;

import io.jieun.arratList.List;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Stream<T> {

    //Collection 구현한 자료구조
    //반복자

    //map(Function<T, R>) ->
    //filter() -> Predicate<T>
    //forEach() -> Consumer
    //toList() ->

    <R> Stream<R> map(Function<? super T, ? extends R> mapper);
    Stream<T> filter(Predicate<? super T> predicate);
    void forEach(Consumer<? super T> consumer);

    List<T> toList();
}
