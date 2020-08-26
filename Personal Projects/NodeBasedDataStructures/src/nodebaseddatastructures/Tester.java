package nodebaseddatastructures;
import java.io.InputStream;
import java.util.Scanner;


public class Tester 
{

	public static void main(String[] args) 
	{
		// TODO 
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Give me a noun");
		String noun1 = scanner.nextLine(); 
		
		System.out.println("Give me a verb");
		String verb1 = scanner.nextLine();
		
		System.out.println("Give me a color");
		String color1 = scanner.nextLine();
		
		System.out.println("Give me another noun");
		String noun2 = scanner.nextLine();
		
		System.out.println("Give me an adjective");
		String adj1 = scanner.nextLine();
		
		System.out.println("Give me another color");
		String color2 = scanner.nextLine();
		
		System.out.println("Give me another color");
		String color3 = scanner.nextLine();
		
		System.out.println("Give me another noun");
		String noun3 = scanner.nextLine();
		
		System.out.println("Give me another verb");
		String verb2 = scanner.nextLine();
		
		System.out.println("Give me another color");
		String color4 = scanner.nextLine();
		
		System.out.println("Give me another color");
		String color5 = scanner.nextLine();
		
		System.out.println("Give me a number");
		int num1 = scanner.nextInt();
		
		System.out.println("Give me a nationality");
		String nationality = scanner.nextLine();
		
		String madLib = String.format("Every year in %s, people celebrate Irish heritage by %s the color %s."
				+ " Some people wear hats with a %s on them."
				+ " Others wear %s %s ties, or %s colored %s,and pins that say \" %s me, I'm Irish!\" are popular."
				+ " The color %s is associated with St.Patrick's Day partly because Irelands nickname is \"The %s Isle\","
				+ " and also because of the %d leaf %s, a symbol of  %s luck.", noun1, verb1, color1, noun2, adj1, color2, color3,
																				noun3, verb2, color4, color5, num1, nationality);
		
		//System.out.println("Fifi" + "'s initials are " + 'F' + 'T');
	}

}
