public class HiddenWord {
    private String hiddenWord;
    public HiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord.toUpperCase();
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public String getHint(String wordGuess) {
        for (int i=0; i<wordGuess.length(); i++) {
            if (Character.isLowerCase(wordGuess.charAt(i))) {
                throw new IllegalArgumentException("Your guess ( " + wordGuess + " ) does not contain all uppercase letters. Your guess must contain all uppercase letters!");
            }
        }

        if (wordGuess.length()!=hiddenWord.length()) {
            throw new IllegalArgumentException ("Your guess ( " + wordGuess + " ) has 7 characters. The hidden word has 9 characters. Your guess must be a word with 9 characters!");
            // throwing this instead of returning a String explicitly shows that an error has occurred
        }

        StringBuilder hintWord = new StringBuilder();

        for (int i=0; i<wordGuess.length(); i++) {
            if (wordGuess.charAt(i)==hiddenWord.charAt(i)) {
               hintWord.append(hiddenWord.charAt(i));
            }
            else if (hiddenWord.contains(wordGuess.charAt(i)+"")) {
                // "" because .contains checks for string not char or can use String.valueOf
                hintWord.append('+');
            }
            else {
                hintWord.append('*');
            }
        }
        return hintWord.toString();
    }


}
