import java.util.*;

public class SpellChecker {
    private Set<String> dictionary;

    public SpellChecker(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    public List<String> checkSpelling(String input) {
        if (dictionary.contains(input)) {
            return List.of(input);
        }

        List<String> corrections = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (i < input.length() - 1) {
                String swapped = swapCharacters(input, i, i + 1);
                if (dictionary.contains(swapped)) {
                    corrections.add(swapped);
                }
            }

            for (char c = 'a'; c <= 'z'; c++) {
                String inserted = insertCharacter(input, i, c);
                if (dictionary.contains(inserted)) {
                    corrections.add(inserted);
                }
            }

            String deleted = deleteCharacter(input, i);
            if (dictionary.contains(deleted)) {
                corrections.add(deleted);
            }

            for (char c = 'a'; c <= 'z'; c++) {
                String replaced = replaceCharacter(input, i, c);
                if (dictionary.contains(replaced)) {
                    corrections.add(replaced);
                }
            }
        }

        return corrections;
    }

    private String swapCharacters(String input, int i, int j) {
        char[] chars = input.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    private String insertCharacter(String input, int i, char c) {
        return input.substring(0, i) + c + input.substring(i);
    }

    private String deleteCharacter(String input, int i) {
        return input.substring(0, i) + input.substring(i + 1);
    }

    private String replaceCharacter(String input, int i, char c) {
        return input.substring(0, i) + c + input.substring(i + 1);
    }

    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("hello");
        dictionary.add("world");
        dictionary.add("java");
        dictionary.add("code");

        SpellChecker spellChecker = new SpellChecker(dictionary);

        System.out.println(spellChecker.checkSpelling("helo"));
        System.out.println(spellChecker.checkSpelling("wrold"));
        System.out.println(spellChecker.checkSpelling("jaba"));
        System.out.println(spellChecker.checkSpelling("coda"));
        System.out.println(spellChecker.checkSpelling("happy"));
    }
}