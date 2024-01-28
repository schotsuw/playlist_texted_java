import java.util.NoSuchElementException;

public class PlayListDriver{
	
	public static void main(String[] args){
		
		Song s1 = new Song(1, "Beyonce", "America has a problem");
		Song s2 = new Song(2, "Metro", "Trance");
		Song s3 = new Song(2, "Nicki Minaj", "Bussin");
		Song s4 = new Song(4, "SZA", "Low");
		Song s5 = new Song(5, "The Weeknd", "After Hours");
		Song s6 = new Song(6, "Doja cat", "Woman");
		Song s7 = new Song(7, "Megan Thee Stallion", "Body");
		Song s8 = new Song(8, "Bad Bunny", "la Romana");
		
		PlayList gym = new PlayList();
		System.out.println("Add an unsorted list");
		
		gym.add(s3);
		gym.add(s1);
		gym.add(s4);
		gym.add(s2);
		gym.add(s8);
		gym.add(s7);
		
		
		gym.print();

		System.out.println("Remove Beyonce");//start work
		gym.remove(s1);
		gym.print();
		
		System.out.println("Remove Nicki Minaj");
		gym.remove(s2);
		gym.print();
		
		System.out.println("Remove Badbunny");//end work
		gym.remove(s8);
		gym.print();

		System.out.println();
		
		try{ 
			System.out.println("Remove Ariana");
			gym.remove(s6);
			
		}
		catch(NoSuchElementException nse){
			System.out.println(nse.getMessage());
			System.out.println();
			
		}
		
		System.out.println("Add The Weekdn");
		gym.add(s5);
		gym.print();
		
		System.out.println("Add Doja cat");
		gym.add(s6);
		gym.print();
		
		
		Song[] arrayRev = gym.getReversedList();
		//System.out.println(arrayRev.length);
		System.out.println("\nPrint the reversed order by an array\n");
		
		for(Song s : arrayRev){
			if(s != null){
			System.out.println(s.toString());
			}
		}
		
		System.out.println("\nNumber of items in the list\n" + gym.getNumSongs());
		
		
			
			
		
		
	}
}


