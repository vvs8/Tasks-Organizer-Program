import java.util.*;

public class Pr1orityQueue {
   ArrayList <Node> EnrtyArray;

  public Pr1orityQueue() {
    EnrtyArray = new ArrayList <Node>();
  }

  //Tree input
  public void treeInput(TaskTree tree) {
    nodeInput(tree.root);
  }

  //Node root input
  public void nodeInput(Node n) {
    Stack<Node> nodes = new Stack<>();
    nodes.push(n);
    while (!nodes.isEmpty()) {
      Node curr = nodes.pop();
      if (curr != null) {
        add(curr);
        for(int i = curr.children.size() - 1; i >= 0; i--) {
          nodes.add(curr.children.get(i));
        } 
      }
    }
  }

  public void add(Node data) {
    EnrtyArray.add(data);
    Collections.sort(EnrtyArray, NodeComparator);
  }

  public Node poll() {
    if(EnrtyArray.isEmpty()) {
      System.out.println("Priority Queue is Empty");
      return null;
    }
    else 
      return EnrtyArray.remove(0);
  }

  public void print() {
    System.out.println("Contents:");
    if (!EnrtyArray.isEmpty()) {
      for (Node n : EnrtyArray) {
        System.out.println(n);
      }
    }
    else System.out.println("Empty. Synchronize or add new node.");
  }

  Comparator <Node> NodeComparator = Comparator.comparing(Node::getImportance).reversed();

}