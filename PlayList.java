import java.util.NoSuchElementException;

public class PlayList{

	private Node first;
	private Node last;
	private int size;
	
	public PlayList(){
		first = null;
		last = null;
		size = 0;
	}
	
	public void add(Song songIn){ //add song in order
		Node newNode = new Node(songIn);
		
		//deal with empty
		if(first == null && last == null){
			first = newNode;
			last = newNode;
			//System.out.println("Enter if on adding");
			size++;
			
		}
		
		//highest frequenc comes first in the list
		else if(first.data.compareTo(newNode.data) > 0){ // if it is more than the first value, then add at the front
			newNode.next = first;
			first.prev = newNode;
			first = newNode;
			//System.out.println("Enter else if on adding");
			size++;
		}
		
		else{
			//System.out.println("Enter else on adding");
			Node current = first;
			while(current != null && current.data.compareTo(newNode.data) <= 0) {//if it is less than, add it after that value
				current = current.next;
			}

			if(current != null){ // add in the middle if not null
				newNode.prev = current.prev;
				newNode.next = current;
				current.prev.next = newNode;
				current.prev = newNode;
				size++;
				
			}
			else{//add at the and if null
				newNode.prev = last;
				last.next = newNode;
				last = newNode; 
				size++;
			}
			
			
		}
	}
			
		
	
	public int getNumSongs(){
		return size;
	}
	
	public Song[] getReversedList(){
		Song[] reversed = new Song[size];
		//using tail
		
		if(last == null){
		
			reversed = null;
		}
		
		else{
			Node tail = last;
			int pos = 0;
			while(tail != null && pos < size){
				reversed[pos] = tail.data;
				pos++;
				tail = tail.prev;
			}
		}
		
		return reversed;	
	}
	
	
	public void print(){
		//normal print
		Node current = first;
		if(current == null){
			System.out.println("List is empty");
		}
		else{
			while(current != null){
				System.out.println(current.data.toString() + " ");
				current = current.next;
			}
		}
		
		System.out.println();
		
	}
	
	
	public void remove(Song songIn) throws NoSuchElementException{
		Node removeNode = new Node(songIn);
		Node current = first;
		
		if(first.data == removeNode.data){
			first = first.next;
			if(first != null){
				first.prev = null;
				size--;
			}
			
		}
		
		else if(last.data == removeNode.data){
			last = last.prev;
			
			if(last != null){
				last.next =null;
				size--;
			}
		}
		else{
			while(current != null){
				if(current.data == removeNode.data){
					current.prev.next = current.next;
					if(current.next != null){
					current.next.prev = current.prev;
					size--;
					}
				}
				
				current = current.next;
			}
			
			if(current == null){
				throw new NoSuchElementException("There is no such element in the list");
			}
		}
	}

	//inner class used for PlayList
	private class Node{
	
		public Song data;
		public Node next;
		public Node prev;
		
		public Node(Song dataIn){
			data = dataIn;
			next = null;
			prev = null;
		}
	}
}

