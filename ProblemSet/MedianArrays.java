/* P2. There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
You may assume nums1 and nums2 cannot be both empty. */

import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.List;

public class MedianArrays {
    // Use Priority Queue to sort array
    public int[] QueueSort (List x){
        int[] output = new int[x.size()];
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(x.size());
        for (Object num:x) {
            pQueue.add((Integer) num);
        }
        for (int i=0; i<x.size(); i++) {
            output[i] = pQueue.poll();
        }
        return output;
    }
    // Find the Median of Sorted Array
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List l1 = Arrays.asList(nums1);
        List l2 = Arrays.asList(nums2);
        l1.addAll(l2);

        int[] finalArr = QueueSort(l1);
        int len = finalArr.length;
        if (len%2!=0) {
            return finalArr[((len + 1) / 2) - 1];
        } else {
            return ((finalArr[(len/2)-1])+finalArr[len/2])/2;
        }
    }
}
