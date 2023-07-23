package title2.collections.array;

public class Queue<T> {

  int initialCapacity = 5;
  GenericArray<T> collection = new GenericArray<>(initialCapacity);

  public void queue(T element) {
    collection.add(element);
  }

  public T dequeue() {
    return collection.delete(0);
  }

  public void findAll() {
    for(int i = 0; i < collection.getLength(); i++) {
      T actualElement = (T) collection.findByIndex(i);
      System.out.println(actualElement);
    }
  }

}
