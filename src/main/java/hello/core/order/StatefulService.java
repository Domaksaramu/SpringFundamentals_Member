package hello.core.order;

public class StatefulService {
    private int price;

    public void order(String name, int price){
        System.out.println("name = " + name + " price = " + price );

        this.price = price;
    }
    int getPrice(){
        return this.price;
    }
}
