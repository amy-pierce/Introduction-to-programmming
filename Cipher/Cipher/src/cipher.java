
import java.util.Random;
import java.util.Scanner;
public class cipher {
	public static void main(String[] args) {
		Scanner inputScanner=new Scanner(System.in);
		boolean finished=false;
		while(!finished) {
			System.out.print
			("enter a please enter a phrase containing plain text characters (or type 'quit')");
			if(inputScanner.hasNextLine()) {
				char random[]= createCipher();
				String myNewString="abcdefghijklmnopqrstuvwxyz ";
				char newalphabet[] = myNewString.toCharArray();
				if(inputScanner.hasNextInt()) {
					System.err.printf
					( "\rError, please enter plain text characters(eg.hello world)or type 'quit'");
					finished=true;
				}
				else if(inputScanner.hasNext("quit")) {
					System.out.print("goodbye!");
					finished=true;
				}
				else {
					String phrase=inputScanner.nextLine();
					String encryption=encrypt(phrase,newalphabet,random);
					System.out.println(encryption);
					String decryption=(decrypt(encryption,newalphabet,random));
					System.out.println(decryption);
					finished=false;
				}
			}
		}
	}
	public static String encrypt(String phrase,char alphabet[], char random[]) {
		char[]phraseArray=phrase.toCharArray();
		System.out.print("The encrypted text is: ");
		int i=0;
		int j=0;
		while(i<alphabet.length&&j<phraseArray.length) {
			if(phraseArray[j]==alphabet[i]) {
				phraseArray[j]=random[i];
				j++;
				i=0;
			}
			else {
				i++;
			}
		}
		String string = new String( phraseArray ); 
		return string;
	}
	public static String decrypt(String phrase,char alphabet[], char random[]) {
		System.out.print("The decrypted text is: ");
		char[]phraseArray=phrase.toCharArray();
		int i=0;
		int j=0;
		while(i<random.length&&j<phraseArray.length) {
			if(phraseArray[j]==random[i]) {
				phraseArray[j]=alphabet[i];
				j++;
				i=0;
			}
			else {
				i++;
			}
		}
		String string = new String( phraseArray ); 
		return string;
	}
	public static char[] createCipher(){
		String myString="abcdefghijklmnopqrstuvwxyz ";
		char alphabet[] = myString.toCharArray();
		char[]randomArray=alphabet;
		if (randomArray!=null)
		{
			Random generator = new Random();
			for (int i=0; i<randomArray.length; i++ )
			{
				int j = generator.nextInt(randomArray.length);
				char temp = randomArray[i];
				randomArray[i] = alphabet[j];
				randomArray[j] = temp;
			}
		}
		return randomArray;
	}
}
