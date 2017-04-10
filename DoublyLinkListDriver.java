public class DoublyLinkListDriver 
{
  public static void main(String[] args) 
  {
    DoublyLinkedList theList = new DoublyLinkedList();

    theList.insertFirst(22);
    theList.insertFirst(44);
    theList.insertFirst(66);

    theList.insertLast(11);
    theList.insertLast(33);
    theList.insertLast(55);

    System.out.println(theList);

    theList.deleteFirst();
    theList.deleteLast();
    theList.deleteKey(11);

    System.out.println(theList);

    theList.insertAfter(22, 77);
    theList.insertAfter(33, 88);

    System.out.println(theList);
  } // end of main
} // end of DoublyNodeList

/****************************************************
*             class Node
*****************************************************/

class Node 
{
  public int data;
  public Node next;
  public Node prev;

  public Node(int data) 
  {
    this.data = data;
  }

  public String toString() 
  {
    return "{" + data + "} ";
  }
} // end of Node class 

/****************************************************
*             class DoublyNodeedList
*****************************************************/

class DoublyLinkedList 
{
  private Node first;
  private Node last;

  public DoublyLinkedList() 
  {
    first = null;
    last = null;
  } // end of DoubleNodeList
  
  // ****************************************************
  
  public boolean isEmpty() 
  {
    return first == null;
  } // end isEmply
  
  // ****************************************************
  
  public void insertFirst(int data) 
  {
    Node newNode = new Node(data);
    if (isEmpty())
    {
      last = newNode;
    }
    else
    {
      first.prev = newNode;
    }
    newNode.next = first;
    first = newNode;
  } // end of insertFirst
  
  // ****************************************************

  public void insertLast(int data) 
  {
    Node newNode = new Node(data);
    if (isEmpty())
    {
      first = newNode;
    }
    else 
    {
      last.next = newNode;
      newNode.prev = last;
    }
    last = newNode;
  } // end of insertLast

  // ****************************************************
  
  public Node deleteFirst() 
  {
    Node temp = first;
    if (first.next == null)
    {
      last = null;
    }
    else
    {
      first.next.prev = null;
    }
    first = first.next;
    return temp;
  } // end of deleteFirst

  // ****************************************************
  
  public Node deleteLast() 
  {
    Node temp = last;
    if (first.next == null)
    {
      first = null;
    }
    else
    {
      last.prev.next = null;
    }
    last = last.prev;
    return temp;
  } // end of deleteLast 

  // ****************************************************
  
  public boolean insertAfter(int key, int data) 
  {
    Node current = first;
    while (current.data != key) 
    {
      current = current.next;
      if (current == null)
      {
        return false;
      }
    } 
    Node newNode = new Node(data);

    if (current == last) 
    {
      newNode.next = null;
      last = newNode;
    } 
    else 
    {
      newNode.next = current.next;
      current.next.prev = newNode;
    }
    newNode.prev = current;
    current.next = newNode;
    return true;
  } // end of insertAfter

  // ****************************************************
  
  public Node deleteKey(int key) 
  {
    Node current = first;
    while (current.data != key) 
    {
      current = current.next;
      if (current == null)
      {
        return null;
      }
    }
    if (current == first)
    {
      first = current.next;
    }
    else
    {
      current.prev.next = current.next;
    }
    
    if (current == last)
    {
      last = current.prev;
    }
    else
    {
      current.next.prev = current.prev;
    }
    return current;
  } // end of deleteKey
  
  // ****************************************************

  public String toString() 
  {
    String str = "List (first-->last): ";
    Node current = first;
    while (current != null) 
    {
      str += current.toString();
      current = current.next;
    }
    System.out.println("");
    System.out.print("List (last-->first): ");

    current = last;
    while (current != null) 
    {
      str += current.toString();
      current = current.prev;
    }
    return str;
  } // end of toString 
} // end of DoublyListedList

