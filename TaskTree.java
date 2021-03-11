import java.util.*;

public class TaskTree {
  Node root;
  LinkedList <Node> vertices;
  private int size;
  HashMap <Integer, Integer> HM = new HashMap <Integer, Integer>();

  public TaskTree() {
    root = null;
    size = 0;
    vertices = new LinkedList <Node> ();
  }

  //Add root
  public void addRoot(Node r) {
    root = r;
    vertices.addFirst(root);
    size++;
    HM.put(11, 1);
  }

  //Add Node (child) to given parent
  public void addNode(Node parent, Node child) {
    parent.addChild(parent, child);
    vertices.add(child);
    size++;
    
    //HashMap for counting importance levels
    int imp = child.importance;
    if(HM.containsKey(imp)) {
      HM.put(imp, HM.get(imp) + 1);
    }
    else {
      HM.put(imp, 1);
    }
  }
  
  //Remove node, link children to parent, clear node, hashmap
  public Node removeNode(Node n) {
    if (n.children != null) {
      for(Node no: n.children) {
        n.addChild(n.parent, no);
      }
    }
    size--;
    int imp = n.importance;
    HM.put(imp, HM.get(imp) - 1);
    if(HM.get(imp) == 0) {
      HM.remove(imp);
    }
    n.parent.children.remove(n);
    vertices.remove(n);
    n.children.clear();
    n.parent = null;
    n = null;
    return n;
  }

  //Get root
  public Node getRoot() {
    return root;
  }

  //Get parent
  public Node getParent(Node child) {
    return child.parent;
  }

  //Get children
  public LinkedList <Node> getChildren(Node parent) {
    return parent.children;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    if(size == 0) {
      return true;
    }
    else {
      return false;
    }
  }

  //Print all nodes
  public void printer() {
    for(Node n: vertices){
      System.out.println(n);
    }
  }

  //Importance level printer
  public void importancePrinter() {
    HM.entrySet().forEach(entry -> {
      System.out.println( "Level: " + entry.getKey() + "  has => " + entry.getValue() + " task(s)");
    });
  }

  public void traverse(Node n) {
    Stack<Node> nodes = new Stack<>();
    nodes.push(n);
    while (!nodes.isEmpty()) {
      Node curr = nodes.pop();
      if (curr != null) {
        System.out.println(curr + " ");
        for(int i = curr.children.size() - 1; i >= 0; i--) {
          nodes.add(curr.children.get(i));
        } 
      }
    }
  }

  //Diagram Printer
  public void printDiagram() {
    System.out.println("\n*** Tree Diagram ***");
    diagram(root, 0, false);
  }

  //Diagram printing recursive function
  private void diagram(Node n, int depth, boolean isLeaf) {
    if (n == null) 
      return;
    for (int i = 1; i < depth; ++i) 
      System.out.print("\t   ");
    if (n == root)
      System.out.println(n + " <- root");
    else 
      System.out.print("   L___> " + n + "\n");
    int l = 0;
    for (Node i : n.children) {
      l++;
      diagram(i, depth + 1, l == (n.children.size())-1);
    }
  }

  public LinkedList<String> Iterator() {
    LinkedList<String> elements = new LinkedList<String> ();
    Node current;
    int i = 0;
    while (vertices.get(i) != null) {
      current = vertices.get(i);
      elements.add(current.task);
      i++;
    }
    return elements;
  }

}