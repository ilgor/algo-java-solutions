import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Debugger
{
    static Stack<Character> contanier = new Stack<Character>();

    static void displayError(int index, String line)
    {
        System.out.println(line);
        for (int i = 0; i < index; i++)
        {
            System.err.print(" ");
        }
        System.err.println("^");
    } // end of displayError

    // **********************************************************

    static boolean evaluateLine(String line)
    {
        for (int index = 0; index < line.length(); index++)
        {
            if (line.charAt(index) == '{' || line.charAt(index) == '(' || line.charAt(index) == '[')
            {
                contanier.push(line.charAt(index));
            } else if (!contanier.empty())
            {
                if (line.charAt(index) == '}' && contanier.peek() == '{' || line.charAt(index) == ')' && contanier.peek() == '('
                        || line.charAt(index) == ']' && contanier.peek() == '[')
                {
                    contanier.pop();
                } else if (line.charAt(index) == '}' && contanier.peek() != '{' || line.charAt(index) == ')'
                        && contanier.peek() != '(' || line.charAt(index) == ']' && contanier.peek() != '[')
                {
                    displayError(index, line);
                    return false;
                }
            } else if (contanier.empty() && (line.charAt(index) == '}' || line.charAt(index) == ')' || line.charAt(index) == ']'))
            {
                displayError(index, line);
                return false;
            }
        }
        return true;
    } // end of evaluateLine

    // **********************************************************

    public static void main(String[] args) throws IOException
    {
        Scanner stdIn = new Scanner(System.in);
        BufferedReader in = null;
        String filename;
        String line;
        String temp = "";
        boolean isLineOK = true;

        System.out.print("Please enter file to evaluate: ");
        filename = stdIn.next();
        try
        {
            in = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e)
        {
            System.err.print("Can't open " + filename);
            System.exit(1);
        }
        while ((line = in.readLine()) != null && isLineOK)
        {
            temp = line;
            isLineOK = evaluateLine(line);
        } // end of while

        if (isLineOK && !contanier.empty())
        {
            displayError(temp.length(), temp);
        } else if (isLineOK)
        {
            System.out.println("Everything is properly constructed in " + filename + " file!");
        }
    } // end of main
} // end of class
