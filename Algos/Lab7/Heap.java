import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Heap
{
    // public for JUnit testing purposes
    public ArrayList<Integer> array = new ArrayList<Integer>();
    public int heap_size;

    public int count = 0;

    public Heap(int size)
    {
        array = new ArrayList<>(size);
        heap_size = size;
    }

    public Heap(List<Integer> source)
    {
        this(source, false);
    }

    public Heap(List<Integer> source, boolean incremental)
    {
        if (source != null)
        {
            if (incremental)
            {

                array = new ArrayList<Integer>(source.size());
                source.forEach(k -> insert(k));

            } else
            {
                array = new ArrayList<Integer>(source);
                buildMaxHeap();
            }
        }
    }

    public static int parent(int index)
    {
        return (int) Math.floor((index - 1) / 2);
    }

    public static int left(int index)
    {
        return (2 * index) + 1;
    }

    public static int right(int index)
    {
        return (2 * index) + 2;
    }

    public void maxHeapify(int i)
    {
        if (heap_size > 0)
        {
            int largest = i;
            int left = left(largest);
            int right = right(largest);

            if (left < heap_size - 1 && array.get(left) > array.get(largest)) largest = left;
            if (right < heap_size - 1 && array.get(right) > array.get(largest)) largest = right;

            if (largest != i)
            {
                swap(largest, i);
                maxHeapify(largest);
            }
        }
    }

    // Swaps the indexes x and y in the array
    private void swap(int x, int y)
    {
        int swapValue = array.get(x);
        array.set(x, array.get(y));
        count ++;
        array.set(y, swapValue);
        count ++;
    }

    public void buildMaxHeap()
    {
        heap_size = array.size();
        count ++;
        for (int j = (int) Math.floor(heap_size / 2); j >= 0; j--)
        {
            maxHeapify(j);
        }
    }

    public void insert(Integer k)
    {
        int pos = heap_size;
        array.add(k);
        count ++;
        heap_size++;
        while (array.get(pos) > array.get(parent(pos)))
        {
            swap(parent(pos), pos);
            pos = parent(pos);
        }
    }

    public Integer maximum()
    {
        Integer currentMax = array.get(0);
        for (Integer i : array)
        {
            currentMax = currentMax > i ? currentMax : i;
        }
        return currentMax;
    }

    public Integer extractMax()
    {
        int max = array.get(0);
        array.set(0, array.get(heap_size - 1));
        count ++;
        array.remove(heap_size - 1);
        heap_size--;
        maxHeapify(0);
        return max;
    }

    public ArrayList<Integer> sort()
    {
        buildMaxHeap();
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        while (heap_size > 0)
        {
            sorted.add(extractMax());
        }
        Collections.reverse(sorted);
        return sorted;
    }
}
