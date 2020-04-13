public class Main {

    public static void main(String[] args) {

        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 4785, 5454, 1, 54};
        System.out.println(build(t));

    }

    public static String build(int[] t) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        sb.append("{\n");
        for (int i = 0; i < t.length; i++) {
            if (count % 4 == 0 && i + 1 != t.length) {
                sb.append(t[i] + ", \n");
            } else {
                sb.append(t[i] + ",");
            }
            count++;
        }
        return sb.delete(sb.length() - 1, sb.length()).append("\n}").toString();

    }
}
