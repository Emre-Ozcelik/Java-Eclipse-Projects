package cp213;

/**
 * @author emre ozcelik ozce7100@mylaurier.ca 210807100
 * @version 2022-09-23
 */
public class Strings {
    // Constants
    public static final String VOWELS = "aeiouAEIOU";

    /**
     * Determines if string is a "palindrome": a word, verse, or sentence (such as
     * "Able was I ere I saw Elba") that reads the same backward or forward. Ignores
     * case, spaces, digits, and punctuation in the string parameter s.
     *
     * @param string a string
     * @return true if string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(final String string) {
        
        String forward = "";
        String backward = "";
        boolean palindrome;

       
        for(int i = 0; i < string.length(); i++) {
            if(Character.isAlphabetic(string.charAt(i))) {
                forward += Character.toLowerCase(string.charAt(i));
            }
        }
        
        for(int j = string.length() -1; j >= 0; j--) {
            if(Character.isAlphabetic(string.charAt(j))){
                backward += Character.toLowerCase(string.charAt(j));
            }
        }
        
        if(forward.equals(backward)) {
            palindrome = true;
        }else {
            palindrome = false;
        }

        return palindrome;
    }

    /**
     * Determines if name is a valid Java variable name. Variables names must start
     * with a letter or an underscore, but cannot be an underscore alone. The rest
     * of the variable name may consist of letters, numbers and underscores.
     *
     * @param name a string to test as a Java variable name
     * @return true if name is a valid Java variable name, false otherwise
     */
    public static boolean isValid(final String name) {

		boolean valid = true;
		if (name.length() > 0) {
			
			Character first = name.charAt(0);
			String underscore = "_";
			if (!Character.isLetter(first)) {
				
				if (name.equals(underscore)) {
					valid = false;
				} else if (Character.isDigit(first)) {
					valid = false;
				}
			}
			
			char b = '_';
			Character u = (b);
			int i = 0;
			int nameLength = name.length();
			while (valid && i < nameLength) {
				Character temp = name.charAt(i);
				if ((!Character.isDigit(temp)) && (!Character.isLetter(temp)) && (!temp.equals(u))) {
					valid = false;
				}

				i++;
			}

		} else {
			valid = false;
		}

		return valid;

	
    }

    /**
     * Converts a word to Pig Latin. The conversion is:
     * <ul>
     * <li>if a word begins with a vowel, add "way" to the end of the word.</li>
     * <li>if the word begins with consonants, move the leading consonants to the
     * end of the word and add "ay" to the end of that. "y" is treated as a
     * consonant if it is the first character in the word, and as a vowel for
     * anywhere else in the word.</li>
     * </ul>
     * Preserve the case of the word - i.e. if the first character of word is
     * upper-case, then the new first character should also be upper case.
     *
     * @param word The string to convert to Pig Latin
     * @return the Pig Latin version of word
     */
    public static String pigLatin(String word) {
        if (VOWELS.indexOf(word.charAt(0)) != -1)
            return word + "way";

        String temp = word.substring(1);
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z')
        {
            char firstCharInUpperCase = Character.toUpperCase(temp.charAt(0));
            var t = new StringBuilder(temp);
            t.setCharAt(0, firstCharInUpperCase);
            temp = t.toString();
        }
        else
        {
            char firstCharInLowerCase = Character.toLowerCase(temp.charAt(0));
            var t = new StringBuilder(temp);
            t.setCharAt(0, firstCharInLowerCase);
            temp = t.toString();
        }

        return temp + Character.toLowerCase(word.charAt(0)) + "ay";
        }
    }

