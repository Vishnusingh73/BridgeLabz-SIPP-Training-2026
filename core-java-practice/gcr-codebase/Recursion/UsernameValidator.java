class UsernameValidator {

    static boolean isLowercaseUsername(String username, int index) {
        if (index == username.length()) {
            return true;
        }
        char ch = username.charAt(index);
        if (ch < 'a' || ch > 'z') {
            return false;
        }
        return isLowercaseUsername(username, index + 1);
    }

    public static void main(String[] args) {
        String user1 = "abcdxyz";
        String user2 = "abcD123";

        System.out.println(isLowercaseUsername(user1, 0)); // true
        System.out.println(isLowercaseUsername(user2, 0)); // false
    }
}
