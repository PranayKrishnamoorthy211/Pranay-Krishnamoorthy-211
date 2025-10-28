package piglatin;

import java.util.Scanner;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();
        
        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.
        
        return translatedBook;

    }


    public static String translateWord(String input) {
    if (input == null || input.isEmpty()) {
        return "";
    }

    String word = input;
    String punctuation = "";
    while (word.length() > 0 && !Character.isLetter(word.charAt(word.length() - 1))) {
        punctuation = word.charAt(word.length() - 1) + punctuation;
        word = word.substring(0, word.length() - 1);
    }
    
    if (word.isEmpty()) {
        return punctuation;
    }

    boolean[] originalCase = new boolean[word.length()];
    for (int i = 0; i < word.length(); i++) {
        originalCase[i] = Character.isUpperCase(word.charAt(i));
    }
    
    String lowerCaseWord = word.toLowerCase();
    String vowels = "aeiou";
    int firstVowelIndex = -1;
    for (int i = 0; i < lowerCaseWord.length(); i++) {
        char currentChar = lowerCaseWord.charAt(i);
        if (vowels.indexOf(currentChar) != -1 || (currentChar == 'y' && i > 0)) {
            firstVowelIndex = i;
            break;
        }
    }

    String translatedWord;
    if (firstVowelIndex == 0) {
        translatedWord = lowerCaseWord + "ay";
    } else if (firstVowelIndex != -1) {
        String consonants = lowerCaseWord.substring(0, firstVowelIndex);
        String restOfWord = lowerCaseWord.substring(firstVowelIndex);
        translatedWord = restOfWord + consonants + "ay";
    } else {
        translatedWord = lowerCaseWord + "ay";
    }

    StringBuilder finalWord = new StringBuilder(translatedWord.length());
    for (int i = 0; i < translatedWord.length(); i++) {
        if (i < originalCase.length && originalCase[i]) {
            finalWord.append(Character.toUpperCase(translatedWord.charAt(i)));
        } else {
            finalWord.append(translatedWord.charAt(i));
        }
    }

    return finalWord.toString() + punctuation;
}




    public static String translate(String input) {
        input += " ";
        String result = "";
        int prevIndex = -1;

        // Start here first!
        // This is the first place to work.
        //result = input; // delete this line
       

        for (int i = 0; i < input.length(); i++) {
            if (!(Character.isLetter(input.charAt(i)) || input.substring(i, i+1).equals("-")))
            {
                result += translateWord(input.substring(prevIndex + 1, i)) + input.substring(i, i+1);
                prevIndex = i;
            }
        }

        return result.substring(0, result.length()-1);
    }

}
    