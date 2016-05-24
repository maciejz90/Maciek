package LGBS;

/**
 * Created by Maciek on 2016-05-04.
 */
public class Menu
{
    public static void printOptions()
    {
        System.out.println("Wybierz opcjê: ");
        System.out.println("1 - dodaj produkt");
        System.out.println("2 - dodaj znizke/upust/rabat");
        System.out.println("3 - dodaj bon");
        System.out.println("4 - wyznacz netto/brutto/vat");
        System.out.println("5 - wyœwietl produkty");
        System.out.println("6 - usuñ produkt");
        System.out.println("0 - wyjdŸ z programu ");
    }
    public static void exitApp()
    {
        System.out.println("Do widzenia!");
        System.exit(0);
    }
}
