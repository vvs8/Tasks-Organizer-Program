import java.util.*;

public class Node {
  String task;
  Integer importance;
  
  Node parent;
  LinkedList<Node> children;

  public Node() {
    task = null;
    importance = null;
    parent = null;
    children = null;
  }

  public Node(String task, int importance) {
    this.task = task;
    this.importance = importance;
    children = new LinkedList<Node>();
  }

  //Add a child and set a parent 
  public void addChild(Node par, Node child) {
    par.children.add(child);
    child.parent = par;
  }

  public int getImportance() {
    return importance;
  }

  //To string
  public String toString() {
    return "("+task + " / " + importance +" imp.)";
  }

}