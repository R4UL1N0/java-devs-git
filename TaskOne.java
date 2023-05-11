import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Change {
    public static void newFunction() {}
}

class TaskOne {

    public static void main(String[] args) {

        // START
        Scanner scanner = new Scanner(System.in);

        //TASKS
        triangleType(scanner);
        biggerValue(scanner);
        canVote(scanner);
        password1234(scanner);
        howManyApples(scanner);
        ascendingOrder(scanner);
        polygonSides(scanner);
        biggerNumberFromThree(scanner);
        idealWeight(scanner);


        // END
        scanner.close();
        
    }

    public static void biggerValue(Scanner scanner) {
        System.out.println("Informe um número qualquer");
        String numberOne = scanner.nextLine();

        System.out.println("Informe outro número qualquer");
        String numberTwo = scanner.nextLine();

        try {
            int one = Integer.parseInt(numberOne);
            int two = Integer.parseInt(numberTwo);

            if (one == two) {
                System.out.println("The numbers are the same");
            } else if (one > two){
                System.out.println("First number is greater than the second one");
            } else {
                System.out.println("Second number is greater than the first one");
            }
        } catch (RuntimeException e) {
            System.out.println("ERRO FATAL... REINICIANDO...");
            biggerNumberFromThree(scanner);
        }


    }

    public static void canVote(Scanner scanner) {
        System.out.println("Type the year you were born:");
        String yearString = scanner.nextLine();

        try {
            int year = Integer.parseInt(yearString);

            LocalDate date = LocalDate.of(year, 1, 1);

            LocalDate today = LocalDate.now();
            Period period = Period.between(date, today);

            if (period.getYears() < 18) {
                System.out.println("You cannot vote yet");
            } else {
                System.out.println("Go Vote!!! It's TIME!!!");
            }


        } catch (RuntimeException e) {
            System.out.println("ERRO FATAL... REINICIANDO...");
            canVote(scanner);
        }
    }

    public static void password1234(Scanner scanner) {
        String password = "1234";

        System.out.println("Type the secret password:");
        String attemptedPassword = scanner.nextLine();

        if (password.equals(attemptedPassword)) {
            System.out.println("OPENING THE GATES OF HEAVEN... WAIT A BIT PLEASE...");
        } else {
            System.out.println("ACCESS DENIED");
        }
    }
    
    public static void howManyApples(Scanner scanner) {

        System.out.println("How many apples to you want to buy?");
        String quantityString = scanner.nextLine();

        try {

            int quantity = Integer.parseInt(quantityString);
            float applePrice = quantity < 12 ? 0.30f : 0.25f;

            float total = applePrice * quantity;

            System.out.printf("TOTAL: %.2f", total);

        } catch (RuntimeException e) {
            System.out.println("FATAL ERROR... RESETTING SERVER...");
            howManyApples(scanner);
        }


        
    }

    public static void ascendingOrder(Scanner scanner) {
        System.out.println("Type the first random number");
        String oneString = scanner.nextLine();

        System.out.println("Type the second random number");
        String twoString = scanner.nextLine();

        System.out.println("Type the third random number");
        String threeString = scanner.nextLine();

        try {
            int one = Integer.parseInt(oneString);
            int two = Integer.parseInt(twoString);
            int three = Integer.parseInt(threeString);

            ArrayList<Integer> list = new ArrayList<>();
            list.add(one);
            list.add(two);
            list.add(three);

           Collections.sort(list);

            System.out.println("BEFORE SORT: " + list);

            Collections.sort(list);

            System.out.println("BEFORE SORT: " + list);

        } catch (RuntimeException e) {

            System.out.println("FATAL ERROR");
            ascendingOrder(scanner);
        }


    }

    public static void polygonSides(Scanner scanner) {
        System.out.println("Quantos lados tem o seu polígono?");
        String sidesString = scanner.nextLine();

        try {
            int sides = Integer.parseInt(sidesString);
            String tipo = sides == 3 ? "TRIÂNGULO" : sides == 4 ? "QUADRADO": sides == 5 ? "PENTÁGONO" : sides < 3 ? "" : "MUITOSLÁGONO";

            if (sides < 3) {
                System.out.println("Afffff nem é polígono.....");
            } else {
                System.out.printf("Seu polígono tem %d lados, portando é um %s", sides, tipo);
            }

        } catch (RuntimeException e) {
            System.out.println("Ocorreu um erro, tente novamente.");
            polygonSides(scanner);
        }
    }

        public static void biggerNumberFromThree(Scanner scanner) {
            System.out.println("Type the first random number");
        String oneString = scanner.nextLine();

        System.out.println("Type the second random number");
        String twoString = scanner.nextLine();

        System.out.println("Type the third random number");
        String threeString = scanner.nextLine();

        try {
            int one = Integer.parseInt(oneString);
            int two = Integer.parseInt(twoString);
            int three = Integer.parseInt(threeString);

            ArrayList<Integer> list = new ArrayList<>();
            list.add(one);
            list.add(two);
            list.add(three);

             Integer biggest = 0;

            for (int n: list) {
                if (n > biggest) {
                    biggest = n;
                }
            }

            System.out.printf("I just want to say that... %d IS THE BIGGEST ONE", biggest);

        } catch (RuntimeException e) {

            System.out.println("FATAL ERROR");
            biggerNumberFromThree(scanner);
        }

        }

        public static void idealWeight(Scanner scanner) {



            System.out.println("Qual sua altura?");
            String alturaString = scanner.nextLine();

            System.out.println("Digite 1 se você for HOMEM, 2 se você for MULHER");
            String sexString = scanner.nextLine();
            double idealWeight = 0.0;

            try {
                double altura = Double.parseDouble(alturaString);

                if (sexString.equals("1")) {
                    idealWeight = (72.7 * altura) - 58;
                } else if (sexString.equals("2")) {
                    idealWeight = (62.1 * altura) - 44.7;
                } 

                System.out.printf("Seu peso ideal é: %.2f", idealWeight);
                
            } catch (RuntimeException e) {
                System.out.println("Bugou. Tente novamente.");
                idealWeight(scanner);
            }
        }

        public static void triangleType(Scanner scanner) {

            Set<Integer> listAngles = new HashSet<Integer>();

            System.out.println("Informe os TRÊS ângulos de seu triângulo");

            for (var i = 0; i < 3; i++) {
                System.out.printf("Informe o %xº ângulo\n", i + 1);
                var angleString = scanner.nextLine();

                try {
                    listAngles.add(Integer.parseInt(angleString));
                } catch (RuntimeException e) {
                    System.out.println("Falha ao adicionar ângulos. Tente novamente.");
                    triangleType(scanner);
                }
            }

            if (listAngles.size() == 1) {
                System.out.println("Seu triângulo é um EQUILÁTERO");
            } else if (listAngles.size() == 2) {
                System.out.println("Seu triângulo é um ISÓSCELE");
            } else if (listAngles.size() == 1) {
                System.out.println("Seu triângulo é um ESCALENO");
            }   

            
            
        }
    
}

