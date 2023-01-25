package title2.poo.collections.collection.model;

public class GenericCollection<T> {

  private Object dataArray[] = null;
  private int length = 0;

  public GenericCollection(int initialCapacity) {
    this.dataArray = new Object[initialCapacity];
  }

  public T findByIndex(int index){
    return (T) dataArray[index];
  }

  public int getLength(){
    return length;
  }

  public void insert(T object , int index)
  {
    if (this.length == this.dataArray.length) {
      Object aux[] = dataArray;
      dataArray = new Object[dataArray.length * 2];
      for(int j = 0; j < length; j++) {
        dataArray[j] = aux[j];
      }
      aux = null;
    }

    for(int j = length - 1; j >= index; j--) {
      dataArray[j + 1]= dataArray[j];
    }

    dataArray[index] = object;
    length++;
  }

  public int find(T object) {
    int i = 0;
    for(; i < length && !dataArray[i].equals(object); i++);
    return i < length ? i : -1;
  }

  public void add(T object) {
    this.insert(object, this.length);
  }

  @SuppressWarnings ("unchecked")
  public T delete(int index) {
    Object aux = dataArray[index];
    for(int j = index; j < length - 1; j++) {
      dataArray[j] = dataArray[j+1];
    }
    length--;
    return (T) aux;
  }

}
