package LGBS;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Maciek on 2016-05-04.
 */
public class Logic
{
    private static boolean run = true;

    public static void removeProduct(List<Product> product, Scanner sc)
    {
        System.out.println("Wybierz, kt�ry produkt chcesz usun��.");
        product.forEach(System.out::println);
        System.out.println("Podaj nr produktu: ");
        product.remove(sc.nextInt() - 1);
        sc.nextLine();
        for (int i = 0; i < product.size(); i++)
        {
            product.get(i).setIndex(i + 1);
        }
        System.out.println("Produkt zosta� usuni�ty!");
    }

    public static String getLogin(Scanner sc)
    {
        System.out.println("Podaj sw�j numer kasjera: ");
        String login = sc.nextLine();
        System.out.println("Witaj " + login);
        return login;
    }

    public static void addProducts(List<Product> product, Scanner sc)
    {
        if (run == true)
        {
            Maths calc = new Maths();
            System.out.println("Podawaj kolejno: nazw� produktu, ilo�� i cen� detaliczn�.");
            System.out.println("Aby zakonczy� dodawanie produkt�w w polu nazwy wpisz cyfr� zero ('0') lub 'exit'");
            System.out.println("Po wyj�ciu z menu dodawania produkt�w paragon zostanie zamkni�ty!");
            while (true)
            {
                String name = null;
                double quantity = 0;
                double pricePerUnit = 0;
                try
                {
                    name = sc.nextLine();
                    if (name.equals("0") || name.equals("exit"))
                    {
                        Logic.run = false;
                        break;
                    }
                    quantity = sc.nextDouble();
                    sc.nextLine();
                    pricePerUnit = sc.nextDouble();
                    sc.nextLine();

                    product.add(new Product(product.size() + 1, name, calc.round(quantity, 2), calc.round(pricePerUnit, 2)));
                    System.out.println("Product added: " + "\n" + product.get(product.size() - 1));
                } catch (InputMismatchException e)
                {
                    System.out.println("Error! Please repeat your last product.");
                    sc.nextLine();
                }
            }
            double num = 0;
            for (Product p : product)
            {
                num += p.getPrice();
            }
            Maths.setTotalPrice(num);
            System.out.println("Total: " + num);
        }
        else
        {
            System.out.println("You have already added products to the recipe!");

        }
    }

    public static void printRecipe(List<Product> product, double totalPrice, String login)
    {
        Maths maths = new Maths();
        product.forEach(System.out::println);
        System.out.println("Kwota do zap�aty: " + Maths.getTotalPrice());
        if (maths.getCoupon() != 0)
        {
            System.out.println("Uwzgl�dniono bon o warto�ci: " + maths.getCoupon() + " z�.");
        }
        if (maths.getDiscount() != 0)
        {
            System.out.println("Rachunek obni�ono o" + maths.getDiscount() + "%.");
        }
        System.out.println("Rachunek utworzony przez kasjera nr: " + login);
    }
}
