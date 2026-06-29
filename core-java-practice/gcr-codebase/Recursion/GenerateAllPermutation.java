class Solution {

    static void permutation(String str, String ans) {

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            char current = str.charAt(i);

            String remaining = str.substring(0, i) + str.substring(i + 1);

            permutation(remaining, ans + current);
        }
    }

    public static void main(String[] args) {
        permutation("ABC", "");
    }
}