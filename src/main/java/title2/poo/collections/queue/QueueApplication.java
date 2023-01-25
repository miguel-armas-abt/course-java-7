package title2.poo.collections.queue;

import title2.poo.collections.queue.model.Queue;

public class QueueApplication {

  public static void main(String[] args) {
    Queue<Integer> integerQueue = new Queue<>();
    integerQueue.queue(1);
    integerQueue.queue(2);
    integerQueue.queue(3);

    System.out.println("Estado de la cola antes: ");
    integerQueue.findAll();

    integerQueue.dequeue();
    integerQueue.queue(4);
    System.out.println("Estado de la cola después: ");
    integerQueue.findAll();
  }
}
