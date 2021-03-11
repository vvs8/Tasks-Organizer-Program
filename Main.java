import java.util.*;

class Main {
  public static void main(String[] args) {
    /*
    Node root = new Node("Open up in the morning", 11);
    Node n1 = new Node("Collect litter", 5);
    Node n2 = new Node("Direct visitors", 8);
    Node n3 = new Node("Plant saplings", 8);
    Node n4 = new Node("Report smoke", 10);
    Node n5 = new Node("Record Wildlife", 7);
    Node n6 = new Node("Clean the forestey", 2);
    Node n7 = new Node("Clean the lobby", 1);

    TaskTree tree = new TaskTree();
    tree.addRoot(root);

    tree.addNode(root, n1);
    tree.addNode(root, n2);
    tree.addNode(root, n3);

    tree.addNode(n1, n4);
    tree.addNode(n1, n5);
    tree.addNode(n2, n6);
    tree.addNode(n6, n7);

    
    System.out.println(tree.getRoot());
    System.out.println(tree.getParent(n4));
    System.out.println(tree.getChildren(root));

    //tree.removeNode(n1);
    System.out.println(tree.getChildren(root));
    System.out.println(tree.getParent(root));

    tree.importancePrinter();
    System.out.println(tree.size());

    //tree.traverse(root);


    PriorityQueue PQ = new PriorityQueue();
    PQ.treeInput(tree);
    System.out.println(PQ.poll());
    System.out.println(PQ.poll());
    System.out.println(PQ.poll());
    System.out.println(PQ.poll());


  
    tree.printDiagram();
    */

    UserInterface UI = new UserInterface();
    UI.userInput();
  }
}