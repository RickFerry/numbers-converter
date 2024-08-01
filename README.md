```markdown
# Conversor de Números Romanos e Arábicos

Este projeto implementa um conversor de números romanos para arábicos e vice-versa em Java. Utiliza boas práticas de programação orientada a objetos para garantir código modular e de fácil manutenção.

## Funcionalidades

- Conversão de números romanos para arábicos.
- Conversão de números arábicos para romanos (suporta valores de 1 a 3999).
- Interface de linha de comando para interação com o usuário.

## Estrutura do Projeto

O projeto contém as seguintes classes principais:

- `RomanConverter`: Classe responsável por converter números romanos em números arábicos.
- `ArabicConverter`: Classe responsável por converter números arábicos em números romanos.
- `UserInterface`: Classe que fornece uma interface de linha de comando para interação com o usuário.

## Como Compilar e Executar

### Pré-requisitos

- Java Development Kit (JDK) 8 ou superior.

### Compilação

Para compilar o projeto, abra um terminal na pasta onde estão localizados os arquivos `.java` e execute o seguinte comando:

```bash
javac RomanConverter.java ArabicConverter.java UserInterface.java
```

### Execução

Para executar a aplicação, use o seguinte comando no terminal:

```bash
java UserInterface
```

## Uso

Ao executar a aplicação, você verá o seguinte menu no console:

```
Escolha uma opção:
1. Converter número romano para arábico
2. Converter número arábico para romano
3. Sair
```

Digite o número correspondente à opção desejada e siga as instruções fornecidas.

### Exemplo de Conversão

#### Romano para Arábico

```
Digite um número romano:
MCMXCIV
Número arábico: 1994
```

#### Arábico para Romano

```
Digite um número arábico (1-3999):
1994
Número romano: MCMXCIV
```

## Tratamento de Erros

- O programa verifica se o número arábico está no intervalo permitido (1-3999).
- Entradas inválidas são tratadas com mensagens de erro apropriadas.

## Estrutura do Código

### RomanConverter

```java
public class RomanConverter {
    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public int romanToArabic(String roman) {
        int result = 0;
        int i = 0;
        
        for (int j = 0; j < ROMAN_NUMERALS.length; j++) {
            while (roman.indexOf(ROMAN_NUMERALS[j], i) == i) {
                result += VALUES[j];
                i += ROMAN_NUMERALS[j].length();
            }
        }
        return result;
    }
}
```

### ArabicConverter

```java
public class ArabicConverter {
    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String arabicToRoman(int number) {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("Number out of range (1-3999)");
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < VALUES.length; i++) {
            while (number >= VALUES[i]) {
                result.append(ROMAN_NUMERALS[i]);
                number -= VALUES[i];
            }
        }
        return result.toString();
    }
}
```

### UserInterface

```java
import java.util.InputMismatchException;
import java.util.Scanner;

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
```

## Contribuições

Sinta-se à vontade para contribuir com melhorias para este projeto. Para isso, faça um fork do repositório, crie um branch para suas alterações e envie um pull request.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
```
