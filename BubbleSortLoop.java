public class BubbleSortLoop
{
    public static void main(String[] args)
    {
        int array[] = { 16, 1, 5, 2, 5, 3 };

        System.out.print("Befor bubble sort: ");
        for (int element : array)
        {
            System.out.print(element + " ");
        }

        bubbleSort(array);

        System.out.print("\nAfter bubble sort: ");
        for (int element : array)
        {
            System.out.print(element + " ");
        }
    } // end of main
    
    // **************************************************
    
    static void bubbleSort(int[] array)
    {
        int size = array.length;
        int temp;

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size - 1 - i; j++)
            {
                if (array[j] > array[j + 1])
                {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            } // end of inner for
        } // end of outer for
    } // end of bubbleSort
} // end of class
