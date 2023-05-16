package Task2JavaLinux.toyshop.model;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {
    
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
            if (tsh.getToy(shosenToyIndex).getQuantToy() > 0) {
                String key = "id=" + tsh.getToy(shosenToyIndex).getIdToy() + " " + tsh.getToy(shosenToyIndex).getNameToy();
                if (lotteryMap.containsKey(key)) lotteryMap.put(key, lotteryMap.get(key) + 1);
                else lotteryMap.put(key, 1);
                tsh.removeToy(tsh.getToy(shosenToyIndex));
            } else i--;
        }
        return lotteryMap;
    }
    /**
     * метод получения призовой игрушки из списка призовых игрушек
     * @param ll - Map<String, Integer> список призовых игрушек для выдачи, уменьшается на выданную игрушку
     */
    public String takePrizeToy(Map<String, Integer> ll) {
        List<String> prizeList = new ArrayList<>();
        for (String item : ll.keySet()) {
            prizeList.add(item);
        }
        int chosenIndex = (int) (Math.random() * prizeList.size());
        String temp = "";
        for (Map.Entry<String, Integer> ent : ll.entrySet()) {
            if (ent.getKey().equals(prizeList.get(chosenIndex))) ll.put(ent.getKey(), ent.getValue() - 1);

        }
        for (Map.Entry<String, Integer> it : ll.entrySet()) {
            if (it.getValue() == 0) temp = it.getKey();
        }
        ll.remove(temp);
        return prizeList.get(chosenIndex);
    }
    /**
     * метод инициализации магазина игрушек
     * @return ToyShop магазин игрушек
     */
    public ToyShop initialToyShop() {
        ToyShop someToyShop = new ToyShop();
        someToyShop.addToy(new Toy(109, "Поросёнок", 15));
        someToyShop.addToy(new Toy(110, "Слоненок", 31));
        someToyShop.addToy(new Toy(111, "Черепашка", 18));
        someToyShop.addToy(new Toy(112, "Жирафик", 11));
        someToyShop.addToy(new Toy(113, "Котёнок",41));
        someToyShop.addToy(new Toy(114, "Львенок", 35));
        someToyShop.addToy(new Toy(115, "Собачка", 23));
        someToyShop.addToy(new Toy(116, "Уточка", 15));
        someToyShop.addToy(new Toy(117, "Енот", 27));
        return someToyShop;
    }
    /**
     * метод добавления выданной призовой игрушки в текстовый файл
     * @param pt - выданная призовая игрушка
     * @param path - путь файлу
     */
    public void putToFile (String pt, String path) {
        try {
            FileWriter fw = new FileWriter(new File(path), false);
            fw.append("Призовая игрушка => \n");
            fw.append(pt);
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
