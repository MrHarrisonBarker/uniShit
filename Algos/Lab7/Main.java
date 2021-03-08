import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String args[])
    {
//        List<Integer> id = new ArrayList<>();
//        for (int i = 0; i < 11342; i ++) {
//            id.add(i);
//        }
        List<Integer> nums = Arrays.asList(35, 85, 83, 70, 90, 17, 14);
//        ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(32,84,14,91,85,39,63,95));
        Heap heap = new Heap(nums,true);
//        heap.extractMax();
//        heap.array = nums;
//        heap.buildMaxHeap();
        heap.extractMax();
        heap.extractMax();
        heap.extractMax();
        System.out.println(heap.array);
//        heap.array = null;
//        var sortedArray = heap.sort();
//        Heap heap = new Heap(nums,true);
//
//        heap.extractMax();
    }
}
