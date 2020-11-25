import java.util.Arrays;

public class HybridSort
{

    public static void main(String[] args)
    {
        int[] sortedArray = HybridSort(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] HybridSort(int[] A)
    {
        boolean swapped = true;
        while (swapped)
        {
            swapped = false;
            int smallest = 0;
            for (int i = 0; i < A.length - 1; i++)
            {
                int nextElement = A[i + 1];
                int element = A[i];

                if (element > nextElement)
                {
                    A[i] = nextElement;
                    A[i + 1] = element;
                    swapped = true;
                }

                if (A[i] < A[smallest])
                {
                    smallest = i;
                }
            }

            int smallestSwap = A[0];
            A[0] = A[smallest];
            A[smallest] = smallestSwap;
        }

        return A;
    }

}

