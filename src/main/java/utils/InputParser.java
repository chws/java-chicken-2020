package utils;

public class InputParser {
    public static int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("입력은 숫자만");
        }
    }
}
