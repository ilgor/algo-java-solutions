public class BinarySearchLoop
{
  public static void main(String... k)
  {
    int array[] = { 15, 16, 18 };

    int lookingFor = 17;
    int begin = 0;
    int end = array.length - 1;

    System.out.println(binarySearch(array, lookingFor, begin, end));
  } // end of main
  
  //***************************************************************
  
  static int binarySearch(int[] array, int key, int begin, int end)
  {
    while (begin <= end)
    {
      int middle = (begin + end) / 2;

      if (key == array[middle])
      {
          return middle;
      } 
      else if (key > array[middle])
      {
          begin = middle + 1;
      } 
      else
      {
          end = middle - 1;
      }
    } // end of while
    return -1;
  } // end of binarySearch
} // end of class
