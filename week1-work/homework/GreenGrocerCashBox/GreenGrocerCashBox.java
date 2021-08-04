/**
 * 
 * @author Guray Kaleli,2021
 * 
 * @return GreenGrocer Cash Box Calculation
 * 
 * */
 
import java.util.*;

public class GreenGrocerCashBox{

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
 
        // show the user the price(per kg) of the products 
        System.out.print("Fruit and per KG price :\n" 
                        +"Pear : 2,14 TL\n"
                        +"Apple : 3,67 TL\n"
                        +"Tomato : 1,11 TL\n"
                        +"Banana : 0,95 TL\n"
                        +"Aubergine : 5,00 TL\n");
       
        // define variables
        double pear, apple, tomato, banana, aubergine;

        double totalPrice;

        // take user shopping basket
        System.out.print("How many kilos of pears do you want to buy? : ");
        pear = scanner.nextDouble();
        pear *= 2.24;

        System.out.print("How many kilos of apples do you want to buy? : ");
        apple = scanner.nextDouble();
        apple *= 3.67;

        System.out.print("How many kilos of tomatos do you want to buy? : ");
        tomato = scanner.nextDouble();
        tomato *= 1.11;

        System.out.print("How many kilos of bananas do you want to buy? : ");
        banana = scanner.nextDouble();
        banana *= 0.95;

        System.out.print("How many kilos of aubergine do you want to buy? : ");
        aubergine = scanner.nextDouble();
        aubergine *= 5.00;

        // calculate and show order price
        totalPrice = pear + apple + tomato + banana + aubergine;

        System.out.println("Total Price : " + totalPrice) + "TL";




    }

}










