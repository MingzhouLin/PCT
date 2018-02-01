package io.scanner;

import java.io.File;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("data.txt"));
        scanner.useDelimiter("\\s+");
        int width = scanner.nextInt();
        int height = scanner.nextInt();

//        for (int i = 0; i < width * height; i++) {
//            String item = io.scanner.next();
//            System.out.println(item);
//        }

        for (int i = 0; i < height; i++) {
            String item1 = scanner.next();
            String item2 = scanner.next();
            String item3 = scanner.next();
            System.out.println(item1 + item2 + item3);
        }

        scanner.close();
    }
}
