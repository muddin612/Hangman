import java.util.Arrays;
import java.util.Scanner;
public class Hangman_Templet {
	
	private String[] Word_Array;
	private char[] found;
	private int num;
	private String correctWord;
	
	public Hangman_Templet() {
		String words = "Superman,AntMan,Aquaman,Atom,Batgirl,Avengers,brown,contradict,daughter,summer,momentous,work,disobey,attack,coast,tart,move,unruly,forgive,dazzling,favour,dispensable";
		Word_Array = words.split(",");
		num = (int)(Math.random()* Word_Array.length);
		found = print_Hidden_Letters(Word_Array[num]);
		correctWord = Word_Array[num];

		
	}
	private char[] print_Hidden_Letters(String word) {
		char[] hidden_Word = new char[word.length()];
		for(int x = 0; x < word.length(); x++) {
			if(word.equals(" "))
				hidden_Word[x] = '-';
			else
				hidden_Word[x] =  '*';
		}
 return hidden_Word;
	}
	private void checkLetter(char letter) {
		String word = Word_Array[num].toLowerCase();
		letter = Character.toLowerCase(letter);
		for(int x = 0; x < word.length(); x++) {
			if(word.charAt(x) == letter) {
				found[x] = letter;
				
			}
			 
		}
		
		
	
		
	}
	public void Play() {
		
		String word = String.valueOf(found);
		word = new String(found);
		Scanner in = new Scanner(System.in);
		System.out.println(Arrays.toString(found));
		boolean end = true;
		int ctr = 0;
		while(word.indexOf("*") != -1 || end) {
			System.out.println("What letter would you like to guess?");
			char guess = in.next().charAt(0); 
			checkLetter(guess);
			System.out.println(Arrays.toString(found));
			word = new String(found);
			ctr++;
			if((ctr-1) % 3 == 0) {
			System.out.println("Would you like to guess the word?");
			String foundWord = in.nextLine(); 
			if(foundWord.equalsIgnoreCase(correctWord))
				end = false;
			}
		}
		
		
	}
	
}
