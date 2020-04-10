import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();
        run(tables, menus);
    }

    private static void run(List<Table> tables, List<Menu> menus) {
        while (true) {
            OutputView.printOptions();
            int option = InputView.inputOption();
            validateOption(option);
            if (option == 1) {
                addOrder(tables, menus);
            }
            if (option == 2) {
                pay(tables);
            }
            if (option == 3) {
                break;
            }
        }
    }

    private static void validateOption(int option) {
        if (option < 1 || option > 3) {
            throw new IllegalArgumentException("기능은 1, 2, 3 중에 하나입니다");
        }
    }

    private static void addOrder(List<Table> tables, List<Menu> menus) {
        OutputView.printTables(tables);
        final Table table = TableRepository.of(InputView.inputTableNumber());

        OutputView.printMenus(menus);
        final Menu menu = MenuRepository.of(InputView.inputMenu());
        final OrderAmount orderAmount = new OrderAmount(InputView.inputOrderAmount());

        table.addOrder(menu, orderAmount);
    }

    private static void pay(List<Table> tables) {
        OutputView.printTables(tables);
        final Table table = TableRepository.of(InputView.inputTableNumber());
        OutputView.printOrderHistory(table);

        final MethodOfPayment methodOfPayment = MethodOfPayment.of(InputView.inputMethodOfPayment(table));

    }
}
