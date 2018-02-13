public class PalindromeChecker {
    public static void main(String[] args) {
        System.out.println(palindromeChecker("Able was I ere I saw Elba"));
    }

    public static boolean palindromeChecker(String text){
        text = text.toLowerCase();
        int left = 0;
        int right = text.length() - 1;

        while(right >= left){
            if (text.charAt(right) != text.charAt(left)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
