import java.util.ArrayList;

public class Heap {
    private ArrayList<Integer> heapArray = new ArrayList<>();

    public Heap(int[] elements) {
        for (int element: elements) {
            this.heapArray.add(element);
        }
    }

    public void percolateUp(int index) {
        if (index > 0) {
            int position = index + 1;
            int parentPosition = position / 2;
            int parentIndex = parentPosition - 1;
            while ((parentIndex >= 0) && (this.heapArray.get(parentIndex) > this.heapArray.get(index))) {
                int temp = this.heapArray.get(parentIndex);
                this.heapArray.set(parentIndex, this.heapArray.get(index));
                this.heapArray.set(index, temp);
                position = parentPosition;
                parentPosition = position / 2;
                index = position - 1;
                parentIndex = parentPosition - 1;
            }
        }
    } // O(logn)

    public void percolateDown(int index) {
        int size = this.heapArray.size();
        int position = index + 1;
        int leftChild = position * 2;
        int leftIndex = leftChild - 1;
        int rightChild = leftChild + 1;
        int rightIndex = rightChild - 1;
        while (leftChild <= size) {
            if (leftChild == size) {
                if (this.heapArray.get(index) > this.heapArray.get(leftIndex)) {
                    int temp = this.heapArray.get(index);
                    this.heapArray.set(index, this.heapArray.get(leftIndex));
                    this.heapArray.set(leftIndex, temp);
                }
                break;
            }
            else {
                if ((this.heapArray.get(index) > this.heapArray.get(leftIndex)) && (this.heapArray.get(leftIndex) > this.heapArray.get(rightIndex))) {
                    int temp = this.heapArray.get(index);
                    this.heapArray.set(index, this.heapArray.get(rightIndex));
                    this.heapArray.set(rightIndex, temp);
                    position = rightChild;
                    index = position - 1;
                    leftChild = position * 2;
                    leftIndex = leftChild - 1;
                    rightChild = leftChild + 1;
                    rightIndex = rightChild - 1;
                }
                else if ((this.heapArray.get(index) > this.heapArray.get(rightIndex)) && (this.heapArray.get(rightIndex) > this.heapArray.get(leftIndex))) {
                    int temp = this.heapArray.get(index);
                    this.heapArray.set(index, this.heapArray.get(leftIndex));
                    this.heapArray.set(leftIndex, temp);
                    position = leftChild;
                    index = position - 1;
                    leftChild = position * 2;
                    leftIndex = leftChild - 1;
                    rightChild = leftChild + 1;
                    rightIndex = rightChild - 1;
                }
                else if (this.heapArray.get(index) > this.heapArray.get(leftIndex)) {
                    int temp = this.heapArray.get(index);
                    this.heapArray.set(index, this.heapArray.get(leftIndex));
                    this.heapArray.set(leftIndex, temp);
                    position = leftChild;
                    index = position - 1;
                    leftChild = position * 2;
                    leftIndex = leftChild - 1;
                    rightChild = leftChild + 1;
                    rightIndex = rightChild - 1;
                }
                else if (this.heapArray.get(index) > this.heapArray.get(rightIndex)) {
                    int temp = this.heapArray.get(index);
                    this.heapArray.set(index, this.heapArray.get(rightIndex));
                    this.heapArray.set(rightIndex, temp);
                    position = rightChild;
                    index = position - 1;
                    leftChild = position * 2;
                    leftIndex = leftChild - 1;
                    rightChild = leftChild + 1;
                    rightIndex = rightChild - 1;
                }
                else {
                    break;
                }
            }
        }
    } // O(logn)

    public void insert(int element) {
        this.heapArray.add(element);
        int index = this.heapArray.size() - 1;
        this.percolateUp(index);
    } // Based on percolateUp -> O(logn)

    public void heapify() {
        int size = this.heapArray.size();
        for (int i = size - 1; i >= 0; i--) {
            this.percolateDown(i);
        }
    } // Based on percolateDown -> O(n)

    public int extractMin() {
        int size = this.heapArray.size();
        if (size == 1) {
            return this.heapArray.remove(0);
        }
        else {
            int min = this.heapArray.get(0);
            int last = this.heapArray.remove(size - 1);
            this.heapArray.set(0, last);
            this.percolateDown(0);
            return min;
        }
    } // Based on percolateDown -> O(logn)

    public ArrayList<Integer> sort() {
        int size = this.heapArray.size();
        ArrayList<Integer> output = new ArrayList<>();
        int minVal;
        for (int i = 0; i < size; i++) {
            minVal = this.extractMin();
            output.add(minVal);
        }
        return output;
    } // Based on extractMin -> O(nlogn)

    public void show() {
        for (int element: this.heapArray) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Heap minHeap = new Heap(new int[]{9, 14, 5, 16, 11, 3, 15, 8, 6, 13});
        minHeap.show();
        minHeap.heapify();
        minHeap.show();
        minHeap.insert(10);
        minHeap.show();
    }
}
