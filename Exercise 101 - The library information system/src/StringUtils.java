public class StringUtils {

    public static boolean included(String word, String searched) {
        searched = searched.trim().toLowerCase();
        if (word.contains(searched) || word.toLowerCase().contains(searched)) {
            return true;
        }
        return false;
    }
}
