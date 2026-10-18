class Solution {
    int last;

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];

        last = stones.length - 1;
        int size = stones.length;

        // Build max heap
        makeHeap(stones, size / 2 - 1);

        while (last > 0) {
            int pop1 = pop(stones, last--);
            int pop2 = pop(stones, last--);

            if (pop1 != pop2) {
                insert(stones, ++last, pop1 - pop2);
            }
        }

        return last == 0 ? stones[0] : 0;
    }

    // Build max heap using bottom-up heapification
    private void makeHeap(int arr[], int parent) {
        while (parent >= 0) {
            int left = parent * 2 + 1;
            int right = parent * 2 + 2;
            int large = parent;

            if (left < arr.length && arr[left] > arr[large])
                large = left;

            if (right < arr.length && arr[right] > arr[large])
                large = right;

            if (parent != large) {
                swap(arr, parent, large);
                heapifyDown(arr, arr.length, large);
            }

            parent--;
        }
    }

    // Restore max heap after removing the root
    private void heapifyDown(int arr[], int size, int parent) {
        while (true) {
            int left = parent * 2 + 1;
            int right = parent * 2 + 2;
            int large = parent;

            if (left < size && arr[left] > arr[large])
                large = left;

            if (right < size && arr[right] > arr[large])
                large = right;

            if (parent != large) {
                swap(arr, parent, large);
                parent = large;
            } else {
                break;
            }
        }
    }

    private int pop(int stones[], int last) {
        int val = stones[0];

        swap(stones, last, 0);

        // The extracted element is at index last.
        // The remaining heap has size last.
        heapifyDown(stones, last, 0);

        return val;
    }

    private void insert(int stones[], int last, int val) {
        stones[last] = val;

        while (last != 0) {
            int parent = (last - 1) / 2;

            if (stones[parent] < stones[last]) {
                swap(stones, parent, last);
                last = parent;
            } else {
                break;
            }
        }
    }

    private void swap(int arr[], int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}