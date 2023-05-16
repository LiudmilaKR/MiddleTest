package Task2JavaLinux.toyshop.presenter;

import java.util.Map;

import Task2JavaLinux.toyshop.model.Service;
import Task2JavaLinux.toyshop.model.ToyShop;
import Task2JavaLinux.toyshop.view.ConsoleView;

public class Presenter {
    Service service;
    ConsoleView view;

    /**
     * контруктор Presenter
     * @param path - путь к файлу загрузки-выгруки данных .out
     */
    public Presenter(String path) {
        service = new Service(path);
        view = new ConsoleView();
        // this.service = service;
        // this.view = view;
    }

    /**
     * метод запуска программы
     */
    public void start(){
        view.startConsole();
        ToyShop ourShop = service.initialToyShop();
        view.printShop(ourShop);
        int lotteryQuant = view.startLottery();
        Map<String, Integer> listPrizes = service.toysLottery(ourShop, lotteryQuant);
        view.endLottery();
        view.printPrizesList(listPrizes);
        view.printShop(ourShop);
        view.givingPrizes();
    }
}
