package com;

public class LinkedList {

	private static Node head;

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		int val = 1;
		Node node = new Node(val);
		head = node;
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(5);
		node.next.next.next.next.next = node.next;
		System.out.println(linkedList.findCycleInLinkedList(node));
	}

	public void insertNodeToList(Node node) {
		if (head == null) {
			head = node;
			return;
		}
		if (node.val <= head.val) {
			Node tmp = head;
			head = node;
			node.next = tmp;
		} else {
			Node currentNode = head;
			while (currentNode.val < node.val) {
				currentNode = currentNode.next;
			}
			
		}

	}

	public boolean findCycleInLinkedList(Node node) {
		Node slow = node;
		Node fast = node.next;
		while (slow != fast && slow.next != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				// Print the loop Content.
				Node currentNode = slow.next;
				int counter = 1;
				while (currentNode != fast) {
					currentNode = currentNode.next;
					counter++;
				}
				System.out.println(counter);
				return true;
			}
		}
		return false;
	}
}

class Node {
	int val;
	Node next;

	public Node(int val) {
		this.val = val;
		this.next = null;
	}
}
