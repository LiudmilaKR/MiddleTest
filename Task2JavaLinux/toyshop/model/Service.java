package Task2JavaLinux.toyshop.model;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Service {
    /**
     * path - путь к файлу загрузки-выгруки данных .out
     */
    String path;

    /**
     * конструкцтор Service
     * @param path - путь к файлу загрузки-выгруки данных .out
     */
    public Service(String path) {
        this.path = path;
        // this.ts = ts;
    }
    /**
     * метод проведения лотереи
     * @param tsh - ToyShop магазин игрушек
     * @param lotteryQuant - количество
     * @return Map<String, Integer> список призовых игрушек для выдачи
     */
    public Map<String, Integer> toysLottery(ToyShop tsh, int lotteryQuant) {
        Map<String, Integer> lotteryMap = new HashMap<>();
        for (int i = 0; i < lotteryQuant; i++) {
            int shosenToyIndex = (int) (Math.random() * tsh.shopSize());
            String key = "id=" + tsh.getToy(shosenToyIndex).getIdToy() + " " + tsh.getToy(shosenToyIndex).getNameToy();
            if (lotteryMap.containsKey(key)) lotteryMap.put(key, lotteryMap.get(key) + 1);
            else lotteryMap.put(key, 1);
            tsh.removeToy(tsh.getToy(shosenToyIndex));
        }
        // System.out.println(lotteryMap);
        return lotteryMap;
    }
    /**
     * метод получения призовой игрушки
     * @param ll - Map<String, Integer> список призовых игрушек для выдачи
     */
    public void takePrizeToy(Map<String, Integer> ll) {

    }

    /**
     * метод инициализации магазина игрушек
     * @return ToyShop магазин игрушек
     */
    public ToyShop initialToyShop() {
        ToyShop someToyShop = new ToyShop();
        someToyShop.addToy(new Toy(109, "Поросёнок", 5));
        someToyShop.addToy(new Toy(110, "Слоненок", 3));
        someToyShop.addToy(new Toy(111, "Черепашка", 8));
        someToyShop.addToy(new Toy(112, "Жирафик", 11));
        someToyShop.addToy(new Toy(113, "Котёнок",41));
        someToyShop.addToy(new Toy(114, "Львенок", 35));
        someToyShop.addToy(new Toy(115, "Собачка", 23));
        someToyShop.addToy(new Toy(116, "Уточка", 15));
        someToyShop.addToy(new Toy(117, "Енот", 27));
        return someToyShop;
    }

    /**
     * метод загрузки данных в файл .out
     * @param ser - Serializable объект (в данном случае ToyShop)
     */
    public void putToFile(Serializable ser) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(ser);
            oos.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    /**
     * метод выгрузки данных из файла .out
     * @return ToyShop магазин игрушек
     */
    public ToyShop loadFromFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            // Object ft = ois.readObject();
            ToyShop ft = (ToyShop)ois.readObject();
            ois.close();
            return ft;
        } catch (Exception e) {
            return null;
        }
    }
}
