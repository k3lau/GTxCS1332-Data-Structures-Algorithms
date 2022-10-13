public class main {

  public static void main(String[] args) {
    System.out.println("Hello, World.");
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    list.addToFront(1);
    list.addToFront(2);
    list.addToFront(3);
    list.addToBack(4);
    list.addToBack(5);
    list.addToFront(7);
    list.printString();
    System.out.println(list.removeFromFront());
    list.printString();
    System.out.println(list.removeFromFront());
    list.printString();
    System.out.println(list.removeFromBack());
    list.printString();
    System.out.println(list.removeFromBack());
    list.printString();
    System.out.println(list.removeFromBack());
    list.printString();
    System.out.println(list.removeFromBack());
    list.printString();
    list.addToBack(5);
    list.printString();
    System.out.println(list.removeFromFront());
    list.printString();
    // Test error
    // System.out.println(list.removeFromFront());
    // System.out.println(list.removeFromBack());
    // list.addToBack(null);
    // list.addToFront(null);
  }
}
