package title2.poo.collections.stack.model;

import title2.poo.collections.collection.model.GenericCollection;

public class Stack<T> {

  int initialCapacity = 5;
  GenericCollection<T> collection = new GenericCollection<>(initialCapacity);

  public void stack(T element){
    collection.insert(element, 0);
  }

  public T unstack(){
    return collection.delete(0);
  }

  public void findAll(){
    for(int i = 0; i < collection.getLength(); i++){
      T actualElement = (T) collection.findByIndex(i);
      System.out.println(actualElement);
    }
  }

}
