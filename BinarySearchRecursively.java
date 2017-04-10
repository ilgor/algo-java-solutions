public class BinarySearchRecursively
{
    public static void main(String... k)
    {
        int array[] = { 16 };

        int lookingFor = 15;
        int begin = 0;
        int end = array.length - 1;

        System.out.println(binarySearch(array, lookingFor, begin, end));
    } // end of main
    
    // *****************************************************************
    
    static int binarySearch(int[] array, int key, int begin, int end)
    {
        int middle = (begin + end) / 2;

        if (key == array[middle])
        {
            return middle;
        } 
        else if (begin == end)
        {
            return -1;
        } 
        else if (key > array[middle])
        {
            return binarySearch(array, key, middle + 1, end);
        }
        return binarySearch(array, key, begin, middle - 1);
    } // end of binarySearch
} // end of class
