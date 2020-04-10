package view;

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
}
