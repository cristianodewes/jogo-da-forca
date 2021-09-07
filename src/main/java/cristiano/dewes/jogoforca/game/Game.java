package cristiano.dewes.jogoforca.game;

import java.util.HashSet;
import java.util.Set;

import cristiano.dewes.jogoforca.core.Dictionary;
import cristiano.dewes.jogoforca.core.InvalidCharacterException;
import cristiano.dewes.jogoforca.core.Word;
import cristiano.dewes.jogoforca.ui.Ui;

public class Game {

	private static final int MAX_ERRORS = 5;

	public void start() {

		Ui.print("Bom vindo ao Jogo da Forca!");

		Dictionary dictionary = Dictionary.getInstance();

		Word word = dictionary.nextWord();

		Ui.print("A palavra tem " + word.size() + " letras");

		Set<Character> usedChars = new HashSet<>();
		int errorCount = 0;

		while (true) {
			Ui.print(word);
			Ui.printNewLine();
			char c;

			try {
				c = Ui.readChar("Digite uma letra: ");

				if (usedChars.contains(c)) {
					throw new InvalidCharacterException("Essa letra ja foi utilizada!");
				}

				usedChars.add(c);

				if (word.hasChar(c)) {
					Ui.print("Você acertou uma letra!");
				} else {
					errorCount++;

					if (errorCount < MAX_ERRORS) {
						Ui.print("Voce errou! Voce ainda pode errar " + (MAX_ERRORS - errorCount) + " vez(es)");
					}
					
				}
				
				Ui.printNewLine();
				
				if(word.dicovered()) {
					Ui.print("Parabéns! Voce acertou a palavra completa : " + word.getOriginalWord());
					Ui.print("FIM FO JOGO!");
					break;
				}
				
				if(errorCount == MAX_ERRORS) {
					Ui.print("Voce perdeu o jogo! A palavra completa era : " + word.getOriginalWord());
					Ui.print("FIM FO JOGO!");
				}

			} catch (InvalidCharacterException e) {
				Ui.print("ERRO: " + e.getMessage());
				Ui.printNewLine();
			}
		}
	}

}
