public class ReversingAStringStringBuilder {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("Krasi");

        builder.reverse();

        System.out.println(builder.toString());
    }
}
