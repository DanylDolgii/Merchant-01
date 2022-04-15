package app;

import java.util.Scanner;

public class App {

    static String merchantName;
    static String email;
    static String phone;
    static String productName;
    static int quantity;
    static double price;
    static String roundBonus;
    static ProductA product;
    static MerchantA merchantA;
    static String infoMerchant;
    static String infoProduct;

    public static void main(String[] args) {
        initVars();
        showData(processData());
    }

    private static void initVars() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Имя продавца: ");
        merchantName = scanner.nextLine();
        System.out.print("Почта: ");
        email = scanner.nextLine();
        System.out.print("Номер телефона: ");
        phone = scanner.nextLine();
        System.out.print("Наименование товара: ");
        productName = scanner.nextLine();
        System.out.print("Количество(шт.): ");
        quantity = scanner.nextInt();
        System.out.print("Цена(за 1 шт.): ");
        price = scanner.nextDouble();
    }

    private static String processData() {
        merchantA = new MerchantA(merchantName, phone, email);
        infoMerchant = merchantA.infoMerchant();
        product = new ProductA(productName, quantity, price);
        infoProduct = product.infoProduct();
        double sales = product.calcSales(quantity, price);
        roundBonus = Rounder.roundValue(merchantA.calcBonus(sales));
        return infoMerchant + infoProduct + "\nБонус (грн.): " + roundBonus;
    }

    private static void showData(String output) {
        System.out.println(output);
    }
}
