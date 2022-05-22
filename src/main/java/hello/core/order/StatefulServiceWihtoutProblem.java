package hello.core.order;

public class StatefulServiceWihtoutProblem {
    public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price );

        return price;
    }
}
