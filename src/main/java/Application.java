import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        while (true) {
            OutputView.printOptions();
            int option = InputView.inputOption();
            validateOption(option);
            if (option == 1) {
                addOrder();
            }
            if (option == 2) {
                pay();
            }
            if (option == 3) {
                break;
            }
        }
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }

    private static void validateOption(int option) {
        if (option < 1 || option > 3) {
            throw new IllegalArgumentException("기능은 1, 2, 3 중에 하나입니다");
        }
    }

    private static void addOrder() {

    }

    private static void pay() {

    }
}
