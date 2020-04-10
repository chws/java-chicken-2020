package view;

import domain.Table;
import utils.InputParser;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return InputParser.parse(scanner.nextLine());
    }

    public static int inputOption() {
        System.out.println("## 원하는 기능을 선택하세요");
        return InputParser.parse(scanner.nextLine());
    }

    public static int inputMenu() {
        System.out.println("## 등록할 메뉴를 선택하세요");
        return InputParser.parse(scanner.nextLine());
    }

    public static int inputOrderAmount() {
        System.out.println("## 메뉴의 수량을 입력하세요");
        return InputParser.parse(scanner.nextLine());
    }

    public static int inputMethodOfPayment(Table table) {
        System.out.println("## " + table.getNumber() + "번 테이블의 결제를 진행합니다");
        System.out.println("## 신용 카드는 1번, 현금은 2번");
        return InputParser.parse(scanner.nextLine());
    }
}
