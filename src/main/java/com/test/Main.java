package com.test;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.test.model.ArabicConverter;
import com.test.model.RomanConverter;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final RomanConverter romanConverter = new RomanConverter();
    private static final ArabicConverter arabicConverter = new ArabicConverter();

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Converter número romano para arábico");
                System.out.println("2. Converter número arábico para romano");
                System.out.println("3. Sair");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                switch (choice) {
                    case 1:
                        convertRomanToArabic();
                        break;
                    case 2:
                        convertArabicToRoman();
                        break;
                    case 3:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Escolha inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.next(); // Limpar o buffer
            }
        }
    }

    private static void convertRomanToArabic() {
        System.out.println("Digite um número romano:");
        String romanNumber = scanner.nextLine().toUpperCase();
        try {
            int arabicNumber = romanConverter.romanToArabic(romanNumber);
            System.out.println("Número arábico: " + arabicNumber);
        } catch (Exception e) {
            System.out.println("Erro ao converter número romano: " + e.getMessage());
        }
    }

    private static void convertArabicToRoman() {
        System.out.println("Digite um número arábico (1-3999):");
        int number = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        try {
            String romanNumber = arabicConverter.arabicToRoman(number);
            System.out.println("Número romano: " + romanNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao converter número arábico: " + e.getMessage());
        }
    }
}
