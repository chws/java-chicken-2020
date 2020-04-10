package view;

import domain.Menu;
import domain.OrderAmount;
import domain.Table;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String TABLE_UNPAID = "└ ₩ ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printTopLine(size);
        printTableNumbers(tables);
        printBottomLine(tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printTopLine(final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(TOP_LINE);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    private static void printBottomLine(final List<Table> tables) {
        for (final Table table : tables) {
            if (table.hasUnpaidOrders()) {
                System.out.println(TABLE_UNPAID);
                continue;
            }
            System.out.println(BOTTOM_LINE);
        }
    }

    public static void printOptions() {
        System.out.println("### 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printOrderHistory(Table table) {
        System.out.println("## 주문내역");
        System.out.println("메뉴\t수량\t금액");
        Map<Menu, OrderAmount> orders = table.getOrders();
        orders.keySet()
                .forEach(menu -> System.out.println(menu.getName() + orders.get(menu) + menu.getPrice()));
    }
}
