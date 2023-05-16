package Task2JavaLinux.toyshop.view;

import java.util.Map;
import java.util.Scanner;

import Task2JavaLinux.toyshop.model.Toy;
import Task2JavaLinux.toyshop.model.ToyShop;

public class ConsoleView {
    Scanner scan;
    /**
     * конструктор ConsoleView
     */
    public ConsoleView() {
        scan = new Scanner(System.in, "Cp866");
    }
    /**
     * метод оповещения начала работы программы
     */
    public void startConsole() {
        System.out.println("Начало работы программы.");
    }
    /**
     * метод вывода на консоль ассортимента магазина
     * @param tsh - ToyShop магазин игрушек
     */
    public void printShop(ToyShop tsh) {
        System.out.println("В наличии в нашем магазине => ");
        for (Toy item : tsh) {
            System.out.println(item);
        }
    }
    /**
     * метод запуска начала лотереи
     * @return int количество призовых игрушек
     */
    public int startLottery() {
        System.out.println();
        System.out.println("Начинаем нашу лотерею!");
        System.out.println("Введите количество призовых игрушек!");
        int quantToys = scan.nextInt();
        return quantToys;
    }
    /**
     * метод сообщает об окончании лотереи
     */
    public void endLottery() {
        System.out.println("Лотерея окочена!");
    }
    /**
     * метод вывода на консоль списка призовых игрушек
     * @param toyList
     */
    public void printPrizesList(Map<String, Integer> toyList) {
        System.out.println("Список призовых игрушек => ");
        for (var item : toyList.entrySet()) {
            System.out.printf("   игрушка %s - %d шт\n", item.getKey(), item.getValue());
        }
    } 
    /**
     * метод сообщает о выдаче призовой игрушки
     */
    public void givingPrizes() {
        System.out.println();
        System.out.println("Выдача призовой игрушки!");
    }
}
