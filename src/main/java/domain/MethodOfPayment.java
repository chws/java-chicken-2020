package domain;

public enum MethodOfPayment {
    CARD("카드"),
    CASH("현금");

    private String method;

    MethodOfPayment(String method) {
        this.method = method;
    }

    public static MethodOfPayment of(int input) {
        validateMethodOfPaymentInput(input);
        if (input == 1) return CARD;
        return CASH;
    }

    private static void validateMethodOfPaymentInput(int input) {
        if (input < 1 || input > 2) {
            throw new IllegalArgumentException("카드는 1번, 현금은 2번");
        }
    }
}
