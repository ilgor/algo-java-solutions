import java.util.Arrays;

public class Stack
{
  private String[] stackArray;
  private int size = 0;
  private int top = 0;

  public Stack(int passedInSize)
  {
    size = passedInSize;
    stackArray = new String[size];
    Arrays.fill(stackArray, "-1");
  } // end of constructor

  // *****************************************************
  
  public void push(String input)
  {
    if (top + 1 < size)
    {
      stackArray[top] = input;
      System.out.println("PUSHED: " + stackArray[top]);
      top++;
      display();
    }
  } // end of push
  
  // *****************************************************
  
  public void pushAll(String input)
  {
    String[] m = input.split(" ");
    
    if (top + m.length < size)
    {
      for (int i=0; i<m.length; i++)
      {
        push(m[i]);
      }
    }
  } // end of pushAll
  
  // *****************************************************
  
  public void pop()
  {
    if (top != 0)
    {
      top--;
      System.out.println("POPED: " + stackArray[top]);
      stackArray[top]  = "-1";
      //display();
    }
    else
    {
      System.out.println("Stack has no element");
    }
    display();
  } // end of pop
  
  // *****************************************************
  
  public void popAll()
  {
    while(top > 0)
    {
      pop(); 
    }
  } // end of popAll
  
  public String peep()
  {
    if (top != 0)
    {
       return stackArray[top-1]; 
    }
    else
    {
       System.out.println("Stack has no element");
      return "-1";
    }
  } // end of peep
  
  // *****************************************************
  
  public void display()
  {
     for (int i=0; i<size; i++)
     {
	System.out.print("-----");
     }
     System.out.print("\n| ");
     for (int i=0; i<size; i++)
     {
       if (!stackArray[i].equals("-1"))
	System.out.print(stackArray[i] + " | ");
       else
        System.out.print("   | ");
     }
     System.out.print("\n");
     for (int i=0; i<size; i++)
     {
	System.out.print("-----");
     }
    System.out.print("\n");
  } // end of display
  
  // *****************************************************
  
  public static void main(String[] args)
  {
    Stack stack = new Stack(10);
    stack.push("5");
    stack.push("4");
    stack.pop();
    stack.push("9");
    stack.pushAll("1 2 3 4 5");
    stack.popAll();
  } // end of main
} // end of class
