public class BinarySearch {

    public static boolean search(int[] array, int searchValue) {
        int beginning = 0;
        int end = array.length - 1;
        int middle = (beginning + end) / 2;

        while (beginning <= end) {
            if (searchValue > array[middle]) {
                beginning = middle + 1;
            } else if (searchValue < array[middle]) {
                end = middle - 1;
            } else if (beginning == end) {
                if (array[beginning] == searchValue) {
                    return true;
                }
            } else {
                return true;
            }
            middle = (beginning + end) / 2;
        }
        return false;
    }

}
