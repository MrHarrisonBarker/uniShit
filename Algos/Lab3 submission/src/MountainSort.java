import java.util.Arrays;

public class MountainSort
{
    public static void main(String[] args)
    {
        int[] A = {34, 12, 7, 43, 55, 41, 97, 28, 2, 62};

        System.out.println("Original array: " + Arrays.toString(A));
        System.out.println();

        A = MountainSort(A);

        System.out.println();
        System.out.println("Array sorted: " + Arrays.toString(A));
    }

    public static int[] MountainSort(int[] A)
    {
        int[] bottom = new int[A.length / 2];
        int[] top = new int[A.length / 2];

        // copy the two halves into seperate arrays
        System.arraycopy(A, 0, bottom, 0, bottom.length);
        System.arraycopy(A, bottom.length, top, 0, top.length);

        bottom = CountingSort(bottom, true);
        top = CountingSort(top, false);

        // copy the two sorted halves back into the original array
        System.arraycopy(bottom, 0, A, 0, bottom.length);
        System.arraycopy(top, 0, A, top.length, top.length);

        return A;
    }

    private static int[] CountingSort(int A[], boolean isAscending)
    {
        int size = A.length;
        int[] output = new int[size + 1];

        int max = A[0];
        for (int i = 1; i < size; i++)
        {
            if (A[i] > max)
                max = A[i];
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i)
        {
            count[i] = 0;
        }

        for (int i = 0; i < size; i++)
        {
            count[A[i]]++;
        }

        for (int i = 1; i <= max; i++)
        {
            count[i] += count[i - 1];
        }

        for (int i = size - 1; i >= 0; i--)
        {
            output[count[A[i]] - 1] = A[i];
            count[A[i]]--;
        }


        if (isAscending)
        {
            for (int i = 0; i < size; i++)
            {
                A[i] = output[i];
            }
        } else
        {
            for (int i = 0; i < size; i++)
            {
                A[(size - 1) - i] = output[i];
            }
        }

        return A;

    }
}
