package LGBS;

import java.util.*;

/**
 * Created by Maciek on 2015-12-20.
 */

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to the Recipe v1.0. Author: Cable_Whisperer");
        List<Product> product = new ArrayList<>();
        Scanner sc = new Scanner(System.in).useLocale(Locale.GERMAN); //Locale.German allows to use semicolon with decimals
        Maths maths = new Maths();
        double totalPrice=0;
        String login = Logic.getLogin(sc);

        while (true)
        {
            Menu.printOptions();
            String option = sc.nextLine();
            switch (option)
            {
                case "1":
                    Logic.addProducts(product, sc);
                    break;
                case "2":
                    totalPrice = maths.discount(sc);
                    break;
                case "3":
                    totalPrice = maths.coupon(sc);
                    break;
                case "4":
                    maths.netVatGross();
                    break;
                case "5":
                    Logic.printRecipe(product, totalPrice, login);
                    break;
                case "6":
                    Logic.removeProduct(product, sc);
                    break;
                case "0":
                    Menu.exitApp();
                    break;
                default:
                    System.out.println("Nie ma takiej opcji, wprowadü ponownie: ");
                    break;
            }
        }
    }










}
