package Task2JavaLinux.toyshop;

import Task2JavaLinux.toyshop.presenter.Presenter;

public class Main {
    public static void main(String[] args) {
        
        // Service service = new Service("Task2JavaLinux/toyshop/model/Shop.out");
        // service.putToFile(someToyShop);
        // ToyShop ourToyShop = service.loadFromFile();
        // System.out.println(ourToyShop);
        Presenter presenter = new Presenter("Task2JavaLinux/toyshop/model/Shop.out");
        presenter.start();
    }
}
