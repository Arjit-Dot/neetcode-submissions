class Solution {
    private class Node {
        int dist;
        int index;
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] out = new int[k][points[0].length];
        Node[] maxHeap = new Node[k];
        
        // Phase 1: Fill the heap strictly to capacity K
        for (int i = 0; i < k; i++) {
            maxHeap[i] = new Node();
            maxHeap[i].dist = calDist(points[i]);
            maxHeap[i].index = i;
            heapifyUp(maxHeap, i);
        }
        
        // Phase 2: Process remaining points, replacing the root if a closer point is found
        for (int i = k; i < points.length; i++) {
            int currentDist = calDist(points[i]);
            if (currentDist < maxHeap[0].dist) {
                maxHeap[0].dist = currentDist;
                maxHeap[0].index = i;
                heapifyDown(maxHeap, 0, k); // Sink the new smaller value down
            }
        }
        
        // Phase 3: Populate the output array (fixed the out[0] overwrite bug!)
        for (int i = 0; i < k; i++) {
            out[i] = points[maxHeap[i].index];
        }
        
        return out;
    }

    private void heapifyUp(Node[] heap, int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            // MAX-HEAP: If the child is LARGER than the parent, swap them up
            if (heap[index].dist > heap[parent].dist) {
                swap(heap, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(Node[] heap, int index, int size) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        // Find the absolute largest distance among the parent and its two children
        if (left < size && heap[left].dist > heap[largest].dist) {
            largest = left;
        }
        if (right < size && heap[right].dist > heap[largest].dist) {
            largest = right;
        }

        // If the parent wasn't the largest, swap with the largest child and keep sinking
        if (largest != index) {
            swap(heap, index, largest);
            heapifyDown(heap, largest, size);
        }
    }

    private int calDist(int[] arr) {
        int x = arr[0];
        int y = arr[1];
        return x * x + y * y;
    }

    private void swap(Node[] arr, int l, int r) {
        Node temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}