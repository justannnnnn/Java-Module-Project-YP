import java.util.ArrayList;

public class Calculator {
    int guests;
    ArrayList<Product> products = new ArrayList<Product>();
    private class Product{
        String name;
        double price;
        public Product(String n, double p){name = new String(n); price = p;}

        @Override
        public String toString(){
            return name + " - " + price;
        }
    }

    public Calculator(int g){guests = g;}

    public void addProduct(String name, double price){
        products.add(new Product(name, price));
        System.out.println("Товар " + name + " был успешно добавлен!");
    }

    public void printProducts(){
        for (Product product : products){
            System.out.println(product);
        }
        double sum = productsSum();
        System.out.println("Общая сумма равна " + String.format("%.2f", sum) + " " + CalcStringFormater.rubles(sum));
    }

    private double productsSum(){
        double sum = 0;
        for (Product product : products) sum += product.price;
        return sum;
    }

    private double countReceipt() {return productsSum()/guests;}
    public void printResult(){
        System.out.println("Добавленные товары:");
        printProducts();
        double res = countReceipt();
        System.out.println("Каждый должен заплатить " + String.format("%.2f", res) + " " + CalcStringFormater.rubles(res));
    }
}
