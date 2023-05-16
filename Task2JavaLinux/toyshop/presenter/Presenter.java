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
     */
    public Presenter() {
        service = new Service();
        view = new ConsoleView();
    }
    /**
     * запуск программы
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
        view.givingPrize();
        String prizeToy = service.takePrizeToy(listPrizes);
        view.printGivingPrize(prizeToy);
        view.printPrizesList(listPrizes);
        service.putToFile(prizeToy, "text.txt");
        view.endLottery();
    }
}
