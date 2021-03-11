import java.util.*;

public class UserInterface { 
  TaskTree tree = new TaskTree();
  Scanner scan = new Scanner(System.in);
  Pr1orityQueue PQ = new Pr1orityQueue();
  HeapsPQ HPQ = new HeapsPQ(); 

  //Priority Queue Menu
  public void userPriorityQ(){
    System.out.println("\nPriority Queue Functions: ");
    System.out.println("[0] - Print Contents");
    System.out.println("[1] - Synchronize with the Tree");
    System.out.println("[2] - Poll Next Node");
    System.out.println("[3] - Add New Node");
    System.out.println("[4] - Exit");
    int input = -1;
    while (input != 4) {
      input = scan.nextInt();
      if (input == 0) {
        PQ.print();
      }
      else if (input == 1) {
        progressBar();
        System.out.println("Synchronized.." + "        ");
        PQ.treeInput(tree);
      }
      else if (input == 2) {
        System.out.println(PQ.poll());
      }
      else if (input == 3) {
        System.out.println("Enter the task:");
        String text = stringInputUtility();
        System.out.println("Enter the importance [1-10]:");
        Integer imp  = scan.nextInt();
        Node node = new Node(text, imp);
        PQ.add(node);
        System.out.println("Node is added.");
      }
      else {
        System.out.println("Error. Incorrect input.");
      }
    }

  }

  //Heap Prioity Queue Menu
  public void userHeapPriorityQ(){
    System.out.println("\nHeap Priority Queue Functions: ");
    System.out.println("[0] - Print Contents");
    System.out.println("[1] - Synchronize with the Tree");
    System.out.println("[2] - Poll the Root");
    System.out.println("[3] - Add New Node");
    System.out.println("[4] - Exit");
    int input = -1;
    while (input != 4) {
      input = scan.nextInt();
      if (input == 0) {
        HPQ.print();
      }
      else if (input == 1) {
        progressBar();
        System.out.println("Synchronized.." + "        ");
        HPQ.treeInput(tree);
      }
      else if (input == 2) {
        System.out.println(HPQ.poll());
      }
      else if (input == 3) {
        System.out.println("Enter the task:");
        String text = stringInputUtility();
        System.out.println("Enter the importance [1-10]:");
        Integer imp  = scan.nextInt();
        Node node = new Node(text, imp);
        HPQ.add(node);
        System.out.println("Node is added.");
      }
      else {
        System.out.println("Error. Incorrect input.");
      }
    }

  }

  //Add new node
  public Node userAddNode(Node par) {
    System.out.println("Enter the task:");
    String text = stringInputUtility();
    System.out.println("Enter the importance [1-10]:");
    Integer imp  = scan.nextInt();
    Node node = new Node(text, imp);
    tree.addNode(par, node);
    return node;
  }

  //A simple progress bar
  public void progressBar() {
    String st = "";
    for (int x = 0 ; x < 20; x++) {
      st += "#";
      System.out.print(st + "\r"); 
      try {
        Thread.sleep(100);
      }
      catch(InterruptedException ex){
        Thread.currentThread().interrupt();
      } 
    }
  }

  //Utility to add text
  public String stringInputUtility() {
    System.out.println("Type [*] to finish:");
    String st = " ";
    String textinput = scan.next();
    while (!textinput.equals("*")) {
      st += textinput + " ";
      textinput = scan.nextLine();
    }
    return st;
  }

  //Add root
  public void userAddRoot() {
    System.out.println("Enter the root task: ");
    String st = stringInputUtility();
    Node root = new Node(st, 11);
    tree.addRoot(root);
  }

  //Go to children/select child
  public Node userSelectChild(Node n) {
    if (n.children.isEmpty()) {
      System.out.println("Error. No children.");
      return n;
    }
    System.out.println("\nSelect the child [Enter the number]: ");
    int i = 0;
    for(Node no: tree.getChildren(n)){
      System.out.println("[" + i + "]: " + no);
      i++;
    }
    Integer s = scan.nextInt();
    if(s <= i) {
      return n.children.get(s);
    }
    else {
      System.out.println("Error. Incorrect input.");
      return n;
    }
  }

  //Tree Functions Menu
  public void userTreeFun() {
    System.out.println("\nTree Functions: ");
    System.out.println("[1] - Tree Diagram");
    System.out.println("[2] - Tree Size");
    System.out.println("[3] - is Empty");
    System.out.println("[4] - Tasks per Importance level");
    System.out.println("[5] - Exit");
    int input = -1;
    while (input != 5) {
      input = scan.nextInt();
      if (input == 1) {
        tree.printDiagram();
      }
      else if (input == 2) {
        System.out.println(tree.size());
      }
      else if (input == 3) {
        System.out.println(tree.isEmpty());
      }
      else if (input == 4) {
        tree.importancePrinter();
      }
      else System.out.println("Error. Incorrect input.");
    }
  }

  //Delete node
  public void deleteNode(Node n) {
    System.out.println("Are you sure? [Y]es [N]ot");
    String textinput = scan.next();
    if (textinput.equals("Y")) {
      System.out.println("Deleted");
      tree.removeNode(n);
    }
    else {
      return;
    }
  } 

  //Main menu
  public void userInput() {
    Node curnode = null; 
    int input = -1;
    while (input != 8) {
      System.out.println("\nType [number]");
      System.out.println("[0] - Add Root");
      System.out.println("[1] - Add New Child");
      System.out.println("[2] - Go to Parent");
      System.out.println("[3] - Go to Children");
      System.out.println("[4] - Tree Functions");
      System.out.println("[5] - Priority Queue");
      System.out.println("[6] - Heap Priority Queue");
      System.out.println("[7] - Delete Current Node");
      System.out.println("[8] - Quit");
      System.out.println("\nCurrent Node (Position): -> [" + curnode +"]");
      input = scan.nextInt();
      if (input == 0) {
        if (tree.root == null) {
          userAddRoot();
          curnode = tree.root;
        } else System.out.println("Root already exists.");
      }

     else if (input == 1) {
        if (tree.size() != 0) {
          Node n = userAddNode(curnode);
          curnode = n;
        }
        else {
          System.out.println("Tree doesn't exist. Create the root.");
        }
      }

      else if (input == 2) {
        if (curnode == null || curnode == tree.root) {
          System.out.println("Current node parent is null.");
          curnode = tree.root; 
        }
        else
          curnode = curnode.parent;
      }

      else if (input == 3) {
        if (tree.size() != 0 || curnode != null || curnode != null)
          curnode = userSelectChild(curnode);
        else System.out.println("Current node has no children.");
      }

      else if (input == 4) {
        if (tree.size() != 0){
          userTreeFun();
        }
        else {
          System.out.println("Tree doesn't exist. Create the root.");
        }
      }

      else if (input == 5) {
        userPriorityQ();
      }

      else if (input == 6) {
        userHeapPriorityQ();
      }

      else if (input == 7) {
        if (curnode != null && curnode != tree.root)
          deleteNode(curnode);
        else System.out.println("Cannot delete a root or null node.");
          curnode = tree.root;

      }

    }   
  }



}