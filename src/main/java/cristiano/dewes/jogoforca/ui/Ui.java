package cristiano.dewes.jogoforca.ui;

import java.util.Scanner;

import cristiano.dewes.jogoforca.core.InvalidCharacterException;

public class Ui {

	public static void print(Object object) {
		System.out.println(object);
	}

	public static void printNewLine() {
		System.out.println();
	}

	public static char readChar(String text)  throws InvalidCharacterException{
		System.out.println(text + " ");
		String line = null;
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		line = scanner.nextLine();
		
		
		if(line.trim().isEmpty()) {
			throw new InvalidCharacterException("Nenhuma letra foi digitada");
		}
		
		if(line.length() > 1) {
			throw new InvalidCharacterException("Digite apenas uma letra");
		}
		
		char c = line.charAt(0);
		
		if(!Character.isLetter(c)) {
			throw new InvalidCharacterException("'" + c + "' não é uma letra!");
		}
		
		return c;
	}
}
