/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class App {
    public static String player1;
    public static String player2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter player 1:");
        player1 = sc.next();
        System.out.println("Enter player 2:");
        player2 = sc.next();
        //MyFrame myFrame =
        MyFrame myFrame = new MyFrame();
        sc.close();
    }
    
}
