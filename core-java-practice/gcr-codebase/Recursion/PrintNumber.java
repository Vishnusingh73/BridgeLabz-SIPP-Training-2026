class Solution {

    void printNto1(int n) {
        if (n == 0) {
            return; 
        }

        System.out.print(n + " ");
        printNto1(n - 1); 
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.printNto1(5);
    }
}