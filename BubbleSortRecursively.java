public class BubbleSortRecursively
{
    public static void main(String[] args)
    {
        int array[] = { 16, 1, 5, 2, 5, 3 };

        System.out.print("Befor bubble sort: ");
        for (int element : array)
        {
            System.out.print(element + " ");
        }

        bubbleSort(array, array.length);

        System.out.print("\nAfter bubble sort: ");
        for (int element : array)
        {
            System.out.print(element + " ");
        }
    } // end of main
    
    // **************************************************
    
    static void bubbleSort(int[] array, int size)
    {
        if (size == 0)
        {
            return;
        }

        for (int i = 0; i < size - 1 && array[i] > array[i + 1]; i++)
        {
            int temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }
        bubbleSort(array, size - 1);
    } // end of bubbleSort
} // end of class
