/*    _        _     _  
     /-\  /<  /-\  _/  |-|
    
    Author    : Akash Yadav
    SpaceTime : 20th JAN 2018
*/
import java.util.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Heaps {
	
	public static class Heap{
		
		private ArrayList<Integer> arr;

		//contains maximum size
		private int heapsize;

		public Heap(){
			this.arr = new ArrayList<>();
			this.arr.add(0);
			this.heapsize = 0;
		}

		private void corrrectHeapsize(){
			this.heapsize = this.arr.size() - 1;
		}

		public void addKey(int key){
			this.arr.add(key);
			corrrectHeapsize();
		}
		
		public int returnMax() {
			return this.arr.get(1);
		}
		
		public int removeMax() {
			
			int ans = this.arr.get(1);
			
			//swap arr[first] and  arr[last]
			Collections.swap(this.arr, this.heapsize, 1);
			
			this.arr.remove(this.heapsize);
			
			corrrectHeapsize();
			
			heapify(1);
			
			return ans;
		}
		
		public void increaseKey(int idx, int key) {
			
			if(key <= arr.get(idx)) {
				System.out.println("key not big enough to increase");
				return;
			}
			
			this.arr.set(idx, key);
				
			while( (idx > 1) && (this.arr.get(idx) > this.arr.get(idx/2)) ) {
				
				//swap arr[idx] and arr[parent(i)]
				Collections.swap(this.arr, idx, idx/2);
				
				idx = idx / 2;
				
			}	
		}
		
		
		public void decreaseKey(int idx, int key) {
			
			if(key >= arr.get(idx)) {
				System.out.println("key not small enough to decrease");
				return;
			}
			
			this.arr.set(idx, key);
				
			heapify(idx);
		}		

		public void display(){
			corrrectHeapsize();
			System.out.println("HEAP : " );

			for(int i = 1; i <= this.heapsize; i++)
				System.out.print("" + arr.get(i) + " ");

			System.out.println("\n");
		}

		private void heapify(int i){

			int leftChild = 2*i;
			int rightChild = 2*i + 1;

			int largest = i;

			if( (leftChild <= this.heapsize) && (this.arr.get(leftChild) > this.arr.get(largest)) )
				largest = leftChild;
			
			if( (rightChild <= this.heapsize) && (this.arr.get(rightChild) > this.arr.get(largest)) )
				largest = rightChild;			

			if(largest != i){

				//swap arr[largest] and  arr[i]
				Collections.swap(this.arr, largest , i);

				heapify(largest);
			}
		}


		public void buildMaxHeap(){

			corrrectHeapsize();

			//start from the parent of the last element and go up
			for(int i  = (int)Math.floor(this.heapsize/2) ; i > 0; i--)
				heapify(i);

			corrrectHeapsize();
		}

		public void heapSort(){

			buildMaxHeap();

			int temp = this.heapsize;

			for(int i = temp; i > 0; i--){

				//swap arr[1] and arr[heapsize]
				Collections.swap(this.arr, 1, this.heapsize);

				this.heapsize--;

				heapify(1);
			}
		} 
	}

	public static void main(String[] args) {
	
		Heap H = new Heap();

		for(int i = 1; i <= 10; i++)
			H.addKey(i);
		
		H.display();
		
		H.buildMaxHeap();
		
		H.display();

		//H.heapSort();

		//H.display();
		
		System.out.println("" + H.removeMax());
		
		H.display();
		
	}

}
