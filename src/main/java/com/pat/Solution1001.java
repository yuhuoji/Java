package com.pat;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Solution1001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();

        int sum = a + b;

        DecimalFormat formatter = new DecimalFormat("#,###");
        String formattedSum = formatter.format(sum);

        System.out.println(formattedSum);
    }
}
