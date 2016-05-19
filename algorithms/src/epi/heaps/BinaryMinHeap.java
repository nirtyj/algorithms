package epi.heaps;

import java.util.ArrayList;

public class BinaryMinHeap {
    private ArrayList<Integer> data;

    public BinaryMinHeap(int size) {
          data = new ArrayList<Integer>(size);
    }
    
    public BinaryMinHeap() {
        data = new ArrayList<Integer>();
     }

    public int getMinimum() throws Exception {
          if (isEmpty())
                throw new Exception("Heap is empty");
          else
                return data.get(0);
    }

    public boolean isEmpty() {
          return data.isEmpty();
    }
    
    public Integer getSize(){
    	return data.size();
    }

    public Integer getLevels(){    	
    	return (int) Math.ceil(Math.log(data.size())/Math.log(2));
    }
    public void insert(int value) {   
              data.add(value);
              siftUp(data.size() - 1);
    }    

    private void siftUp(int nodeIndex) {
        int parentIndex, tmp;
        if (nodeIndex != 0) {
              parentIndex = getParentIndex(nodeIndex);
              if (data.get(parentIndex) > data.get(nodeIndex)) {
                    tmp = data.get(parentIndex);
                    data.set(parentIndex, data.get(nodeIndex));
                    data.set(nodeIndex, tmp);
                    siftUp(parentIndex);
              }
        }
    }
  
    private int getLeftChildIndex(int nodeIndex) {
          return 2 * nodeIndex + 1;
    }

    private int getRightChildIndex(int nodeIndex) {
          return 2 * nodeIndex + 2;
    }

    private int getParentIndex(int nodeIndex) {
          return (nodeIndex - 1) / 2;
    }
    
    public int removeMin() throws Exception{
        if (isEmpty())
              throw new Exception("Heap is empty");
        else {        	
        	int min = data.get(0);
            data.set(0, data.remove(data.size()-1));
            siftDown(0);
            return min;
        }
    }

    private void siftDown(int nodeIndex) {
        int leftChildIndex, rightChildIndex, minIndex, tmp;
        leftChildIndex = getLeftChildIndex(nodeIndex);
        rightChildIndex = getRightChildIndex(nodeIndex);
        
        // find the index of node which is less than root
        if (rightChildIndex >= data.size()) {
              if (leftChildIndex >= data.size())
                    return;
              else
                    minIndex = leftChildIndex;
        } else {
              if (data.get(leftChildIndex) <= data.get(rightChildIndex))
                    minIndex = leftChildIndex;
              else
                    minIndex = rightChildIndex;
        }
        
        // swap with the min val index and continue with sifting down the min val index
        if (data.get(nodeIndex) > data.get(minIndex)) {
              tmp = data.get(minIndex);
              data.set(minIndex, data.get(nodeIndex));
              data.set(nodeIndex, tmp);
              siftDown(minIndex);
        }
  }
}
