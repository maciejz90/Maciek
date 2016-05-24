package LGBS;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Maciek on 2016-05-04.
 */
public class Maths
{
    private static double totalPrice=0;
    private double coupon=0;
    private double discount=0;

    public double getDiscount()
    {
        return discount;
    }

    public void setDiscount(double discount)
    {
        this.discount = discount;
    }

    public double getCoupon()
    {
        return coupon;
    }

    public void setCoupon(double coupon)
    {
        this.coupon = coupon;
    }

    public static double getTotalPrice()
    {
        return totalPrice;
    }

    public static void setTotalPrice(double totalPrice)
    {
        Maths.totalPrice = totalPrice;
    }

    public double round(double value, int places)
    {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void netVatGross()
    {
        double totalPrice = getTotalPrice();
        System.out.println("Wartoœæ netto:");
        System.out.println(round((totalPrice * 0.77), 2));
        System.out.println("VAT:");
        System.out.println(round(totalPrice * 0.23, 2));
        System.out.println("Wartoœæ brutto:");
        System.out.println(round(totalPrice, 2));
    }

    public double coupon(Scanner sc)
    {
        double num = 0;
        if (getCoupon() == 0)
        {
            num = getTotalPrice();
            System.out.println("Podaj wielkoœæ bonu:");
            try
            {
                double coupon = round(sc.nextDouble(), 2);
                sc.nextLine();
                setCoupon(coupon);
                System.out.println("Kwota przed dodaniem bonu:");
                System.out.println(num);
                System.out.println("Kwota po dodaniu bonu:");
                num = round(num - coupon, 2);
                System.out.println(num);
                setTotalPrice(num);
            } catch (InputMismatchException e)
            {
                System.out.println("B³¹d podczas wprowadzania danych! Powtórz ostatni wpis.");
            }
        } else
        {
            System.out.println("Bon zosta³ ju¿ dodany!");
        }
        return num;
    }

    public double discount(Scanner sc)
    {
        double num = 0;
        if (getDiscount() == 0)
        {
            num = getTotalPrice();
            System.out.println("Podaj zni¿kê w %:");
            try
            {
                double discount = round(sc.nextDouble(), 2);
                sc.nextLine();
                setDiscount(discount);
                System.out.println("Kwota przed zni¿k¹:");
                System.out.println(num);
                System.out.println("Kwota po zni¿ce:");
                num = round(num * (1 - discount / 100), 2);
                System.out.println(num);
                setTotalPrice(num);
            } catch (InputMismatchException e)
            {
                System.out.println("B³¹d podczas wprowadzania danych! Powtórz ostatni wpis.");
            }
        } else
        {
            System.out.println("Zni¿ka zosta³a ju¿ naliczona!");
        }
        return num;
    }
}
