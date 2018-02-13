public class ReversingAStringWithImplementedMethod {
    public static void main(String[] args) {
        String text = "Krasi e student v Soft Uni i UNWE";

        text = reverseTheCurrentString(text);

        System.out.println(text);
    }


    public static String reverseTheCurrentString(String someString) {
        StringBuilder builder = new StringBuilder();

        for (int i = someString.length() - 1; i >= 0; i--) {
            builder.append(someString.charAt(i));
        }

        return builder.toString();
    }
}
