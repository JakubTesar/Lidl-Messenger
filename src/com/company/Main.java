package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String name = "";
        String message = "";
        String message2 = "";
        boolean ne = true;

        try {
            BufferedReader br = new BufferedReader(new FileReader("Messeges"));
            String nextLine = br.readLine();
            while (nextLine != null) {
                message2 += nextLine + "\n";
                nextLine = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Nothing new");
        }

        System.out.println("Enter name:");
        name = sc.nextLine();
        System.out.println("----------------");
        System.out.println(message2);
        System.out.println("----------------");
        System.out.println(name + " Enter New Message: ");
        System.out.println("----------------");

        while (ne) {
            message = sc.nextLine();
            if (message.equals("!konec")) {
                break;
            }
            
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("Messeges", true));
                bw.write(name + ": " + message);
                bw.newLine();
                bw.close();

            } catch (IOException e) {
                System.out.println("Shit happends. Try it again later :)");
            }
        }
    }
}
