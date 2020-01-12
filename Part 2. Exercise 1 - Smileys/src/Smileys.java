public class Smileys {

    public static void main(String[] args) {
        printWithSmileys("howdie");
    }


    private static void printWithSmileys(String characterString) {
        System.out.println(topAndBottomSmileys(characterString));
        System.out.println(middleString(characterString));
        System.out.println(topAndBottomSmileys(characterString));
    }


    private static String middleString(String characterString) {
        if (characterString.length() % 2 != 0) {
            return ":)" + characterString + " " + ":)";
        } else {
            return ":)" + characterString + ":)";
        }
    }

    private static String topAndBottomSmileys(String characterString) {
        String smileys = "";
        int numberOfSmiles = middleString(characterString).length() / 2;
        for (int i = 0; i < numberOfSmiles; i++) {
            smileys += ":)";
        }
        return smileys;
    }

}
