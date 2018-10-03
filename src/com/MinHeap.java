package com;

import java.util.Arrays;

public class MinHeap {
	private int[] Heap;
	private int size;
	private int maxsize;

	private static final int FRONT = 1;

	public MinHeap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize + 1];
		Heap[0] = Integer.MIN_VALUE;
	}

	private int getRoot() {
		return Heap[1];
	}

	private int leftChild(int pos) {
		return (2 * pos);
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	private boolean isLeaf(int pos) {
		if (pos > (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	private void swap(int fpos, int spos) {
		int tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	private void minHeapify(int pos) {
		if (!isLeaf(pos)) {
			if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
				if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				} else {
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
	}

	public void insert(int element) {
		Heap[++size] = element;
	}

	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(
					" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
			System.out.println();
		}
	}

	public void minHeap() {
		for (int pos = (size / 2); pos >= 1; pos--) {
			minHeapify(pos);
		}
	}

	public int remove() {
		int popped = Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		minHeapify(FRONT);
		return popped;
	}

	public static void main(String... arg) {
		int arr[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int k = 5;
		System.out.println("The Min Heap is ");
		MinHeap minHeap = new MinHeap(k);
		int index = 0;
		for (index = 0; index < k; index++) {
			minHeap.insert(arr[index]);
		}
		minHeap.minHeap();

		for (int i = index; i < arr.length; i++) {
			if (arr[i] > minHeap.getRoot()) {
				minHeap.Heap[1] = arr[i];
				minHeap.minHeap();
			}
		}
		minHeap.print();
		System.out.println(Arrays.toString(minHeap.Heap));
		System.out.println("The Min val is " + minHeap.remove());
	}
}