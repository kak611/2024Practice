class DoublyLinkedList<T> implements InterfaceDLL<T> {

	private Link first;
	private Link last;

	public boolean isEmpty() {
		return first == null;
	}


	public void insertFirst(T num) {
    	Link newLink = new Link(num);  // Create a new link with data 'num'
    
    	if (isEmpty()) {  // Check if the list is empty
        	first = newLink;  // If the list is empty, both first and last should point to the new link
        	last = newLink;
    	} else {
        	newLink.next = first;  // The new link should point to the current first node
        	first.prev = newLink;  // Set the previous link of the current first node to the new link
    	}
    
    	first = newLink;  // Set the first pointer to the new link
	}


	public void insertLast(T num) {
    	Link newLink = new Link(num);  // Create a new link with data 'num'
    
    	if (isEmpty()) {  // Check if the list is empty
        	first = newLink;  // If the list is empty, both first and last should point to the new link
        	last = newLink;
    	} else {
        	last.next = newLink;  // The current last node should point to the new node
        	newLink.prev = last;  // The new node's previous pointer should point to the current last node
    	}
    
    	last = newLink;  // Set the last pointer to the new node
	}


	public T deleteFirst() { 
    	if (isEmpty()) return null;  // Check if the list is empty

    	System.out.println("Deleted First element");
    	T tmp = first.val;  // Store the value of the first element

    	if (first.next == null) {  // If there is only one element
        	first = last = null;  // Set both first and last to null (empty list)
    	} else {
        	first = first.next;  // Move first to the next node
        	first.prev = null;  // Set the prev pointer of the new first node to null
    	}

    	return tmp;  // Return the value of the deleted node
	}

	public T deleteLast() { 
    	if (isEmpty()) return null;  // Check if the list is empty

    	System.out.println("Deleted last element");
    	T tmp = last.val;  // Store the value of the last element

    	if (last.prev == null) {  // If there is only one element
        	first = last = null;  // Set both first and last to null (empty list)
    	} else {
        	last = last.prev;  // Move last to the previous node
        	last.next = null;  // Set the next pointer of the new last node to null
    	}

    	return tmp;  // Return the value of the deleted node
	}

	public void insertAfter(T key, T val) {
    	if (isEmpty()) {
        	System.out.println("The list is empty. Insertion cannot be performed.");
        	return;  // Return early if the list is empty
    	}

    	Link curr = first;
    	Link newLink = new Link(val);

    	// Traverse the list to find the node with the key
    	while (curr != null && !curr.val.equals(key)) {
        	curr = curr.next;
    	}

    	if (curr == null) {
        	System.out.println("Key not found!");
        	return;
    	}

    	// If the key is found and the current node is the last node
    	if (curr == last) {
        	curr.next = newLink;
        	newLink.prev = curr;
        	last = newLink;  // Update the last pointer
    	} else {
        	// Insert the new node between curr and curr.next
        	newLink.next = curr.next;
        	newLink.prev = curr;
        	curr.next.prev = newLink;  // Set the previous pointer of the next node
        	curr.next = newLink;  // Update the next pointer of curr
    	}

    	System.out.println("Node inserted after " + key);
	}


	public T delete(T key) {
    	if (isEmpty()) {
        	System.out.println("List is empty. Cannot delete.");
        	return null;
    	}

    	Link curr = first;

    	// Traverse the list to find the node with the key
    	while (curr != null && !curr.val.equals(key)) {
        	curr = curr.next;
    	}

    	// If the key is not found
    	if (curr == null) {
        	System.out.println("Key to be deleted NOT found!");
        	return null;
    	}

    	T tmp = curr.val;  // Store the value of the node to be deleted
    	System.out.println("Deleting key " + tmp + " ...");

    	// Case 1: Deleting the first node
    	if (curr == first) {
        	first = first.next;  // Move the first pointer to the next node
        	if (first != null) {  // If the list is not empty after deletion
            	first.prev = null;  // Update the previous pointer of the new first node
        	} else {
            	last = null;  // If the list is now empty, set the last pointer to null
        	}
    	}
    	// Case 2: Deleting the last node
    	else if (curr == last) {
        	last = last.prev;  // Move the last pointer to the previous node
        	if (last != null) {  // If the list is not empty after deletion
            	last.next = null;  // Update the next pointer of the new last node
        	} else {
            	first = null;  // If the list is now empty, set the first pointer to null
        	}
    	}
    	// Case 3: Deleting a node in the middle
    	else {
        	curr.prev.next = curr.next;  // Update the next pointer of the previous node
        	curr.next.prev = curr.prev;  // Update the prev pointer of the next node
    	}

    	return tmp;  // Return the value of the deleted node
	}


	public void displayForward() {
    	Link curr = first;

    	System.out.print("Displaying Forward: ");
    	if (isEmpty()) {
        	System.out.println("Linkedlist is empty!!");
        	return;
    	}
    
    	while (curr != null) {
        	System.out.print(curr);  // It is assumed that Link class has a proper toString() method
        	curr = curr.next;
    	}
    	System.out.println("");  // Print a newline after displaying the list
	}


	public void displayBackward() {
    	Link curr = last;

    	System.out.print("Displaying Backward: ");
    	if (isEmpty()) {
        	System.out.println("Linkedlist is empty!!");
        	return;
    	}

    	while (curr != null) {
        	System.out.print(curr);  // It is assumed that Link class has a proper toString() method
        	curr = curr.prev;
    	}
    	System.out.println("");  // Print a newline after displaying the list
	}


	class Link {
		private T val;
		private Link next;
		private Link prev;

		public void setNext(Link link) {
			this.next = link;
		}

		public Link getNext() {
			return this.next;
		}

		public void setPrev(Link link) {
			this.prev = link;
		}

		public Link getPrev() {
			return this.prev;
		}
	

		public Link(T val, Link next, Link prev) {
			this.val = val;
			this.next = next;
			this.prev = prev;
		}

		public Link(T val) {
			this(val, null, null);		
		}

		public String toString() {
			return this.val + " ";
		}
	}
}