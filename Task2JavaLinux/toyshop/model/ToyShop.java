package Task2JavaLinux.toyshop.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ToyShop implements Iterable<Toy> {
    /**
     * список игрушек
     */
    private List<Toy> toyStore;
    /**
     * конструктор магазина игрушек
     */
    public ToyShop() {
        toyStore = new ArrayList<>();
    }
    /**
     * @param toy - игрушка
     * @return игрушку из магазина с индексом ind
     */
    public Toy getToy(int ind) {
        return toyStore.get(ind);
    }
    /**
     * метод добавление игрушки в ToyShop магазин
     * @param toy - игрушка
     * @return если toy есть в магазине, добавляет количество toy, иначе добавляем toy в магазин, 
     *          и перерасчитываем вероятность выпадения в розыгрыше 1 шт у всех игрушек в магазине
     */
    public boolean addToy(Toy toy) {
        if (toy.getQuantToy() == 0) return false;
        else {
            if (toyStore.contains(toy)) toyStore.get(toyStore.indexOf(toy)).setQuantToy(toyStore.get(toyStore.indexOf(toy)).getQuantToy() + toy.getQuantToy());
            else toyStore.add(toy);
            for (Toy item : toyStore) {
                item.setPToy((item.getQuantToy() * 100.0) / countAllToys());
            }
            return true;
        }
    }
    /**
     * метод подсчета количества всех игрушек в магазине
     * @return общее количество всех игрушек в магазине
     */
    private int countAllToys() {
        int quantAllToys = 0;
        for (Toy item : toyStore) {
            quantAllToys += item.getQuantToy();
        }
        // System.out.println("число всех игрушек=" + quantAllToys);
        return quantAllToys;
    }
    /**
     * метод удаления игрушки из ToyShop магазина
     * @param toy - игрушка
     * @return если toy есть в магазине в количестве 1 - удаляем игрушку из магазина, если - в бОльшем количестве,
     *          уменьшаем количество данной игрушки на единицу, далее - 
     *          перерасчитываем вероятность выпадения в розыгрыше 1 шт у всех игрушек в магазине
     */
    public boolean removeToy(Toy toy) {
        if (toy.getQuantToy() == 0) return false;
        else {
            if (toy.getQuantToy() == 1) toyStore.remove(toy);
            else toy.setQuantToy(toy.getQuantToy() - 1);
            for (Toy item : toyStore) {
                item.setPToy((item.getQuantToy() * 100.0) / countAllToys());
            }
            return true;
        } 
    }
    /**
     * @return размер магазина игрушек (количество позиций)
     */
    public int shopSize() {
        return toyStore.size();
    }
    @Override
    public Iterator<Toy> iterator() {
        Iterator<Toy> itt = new Iterator<Toy>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < shopSize(); //toyStore.size();
            }

            @Override
            public Toy next() {
                return toyStore.get(index++);
            }
        };
        return itt;
    }
}
