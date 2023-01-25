package title2.poo.collections.stack;

import title2.poo.collections.stack.model.Stack;

public class StackApplication {

  public static void main(String[] args) {

    Stack<Integer> integerStack = new Stack<>();

    integerStack.stack(1);
    integerStack.stack(2);
    integerStack.stack(3);

    System.out.println("Estado de la pila antes: ");
    integerStack.findAll();

    integerStack.unstack();
    integerStack.stack(4);

    System.out.println("Estado de la pila después: ");
    integerStack.findAll();
  }
}
