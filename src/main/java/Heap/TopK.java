package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class TopK {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.add(12);
        pq.add(2);
        pq.add(45);
        pq.add(1);
        pq.add(652);

        System.out.println(pq.peek());

    }
}
