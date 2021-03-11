import java.util.*;

class NodeComparator implements Comparator<Node> { 
  public int compare(Node n1, Node n2) { 
    Integer imp1 = n1.getImportance(); 
    Integer imp2 = n2.getImportance();   
    return imp2.compareTo(imp1); 
  } 
} 

public class HeapsPQ {
  PriorityQueue <Node> PQ;

  public HeapsPQ() {
    PQ = new PriorityQueue<Node>(new NodeComparator());
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
    PQ.add(data);
  }

  public Node poll() {
    if(PQ.isEmpty()) {
      System.out.println("Priority Queue is Empty");
      return null;
    }
    else 
      return PQ.poll();
  }

  public void print() {
    System.out.println("Contents:");
    if (!PQ.isEmpty()) {
      for (Node n : PQ) {
        System.out.println(n);
      }
    }
    else System.out.println("Empty. Synchronize or add new node.");
  }


}