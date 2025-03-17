package io.jieun.arratList;

//list가 e값을 받았고 arraylist에 e값을 넘겨준다.
public class ArrayList1<E> implements List<E> {

    private Object[] elements = {};

    @Override
    public void add(E e) {

        Object[] temp = new Object[elements.length + 1];

        for(int i = 0; i < elements.length; i++) {
            temp[i] = elements[i];
        }

        //길이랑 index는 동일하지 않기 때문에
        temp[elements.length] = e;
        elements = temp;

    }

    @Override
    public void add(int index, E e) {
        //[1,2,3,4]
        //[1,2,5,]
        Object[] temp = new Object[elements.length + 1];

        for(int i=0, j=0; i< temp.length; i++){
            if(i==index){
                temp[i] = e;
            }else{
                temp[i] = elements[j++];
            }
        }

        elements = temp;


    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E)elements[index];
    }

    @Override
    public E set(int index, E e) {
        //1.원래 있던 값을 반환하고자 함
        Object origin = elements[index];
        elements[index] = e;
        return e;
    }

    @Override
    public E remove(int index) {
        // elements의 길이를 유동적으로 바꾸겠다.
        //[1,2,3,4,5]
        //[1,2,4,5]이런식으로 중간의 값이 빠질떄 어떻게 할래?
        //인덱스에서 하나를 지웠다는건 => 배열의 길이가 하나 짧아졌다는 것
        Object[] temp = new Object[elements.length - 1];

        E target = get(index);
        for(int i=0, j=0; i< elements.length; i++){
            if(i==index){
                continue;
            }
            temp[j++] = elements[i];
        }

        elements = temp;

        return target;
    }

    @Override
    public boolean contains(E e) {

        for(int i=0; i<elements.length; i++){
            if(elements[i].equals(e)){
                return true;
            }
        }

        return false;
    }

    @Override
    public void remove(E e) {

        if(!contains(e)){
            return;
        }

        Object[] temp = new Object[elements.length - 1];
        //하나만 삭제하기 위해서 깃발을 하나 만들었다.
        boolean flag = false;

        for(int i=0, j=0; i< elements.length; i++){

            if( !flag && elements[i].equals(e)){
                flag = true;
                continue;
            }

            temp[j++] = elements[i];

        }
        elements = temp;

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
        for(int i=0; i<elements.length; i++){
            System.out.print(elements[i]+" ");
        }
        System.out.println();
    }
}
