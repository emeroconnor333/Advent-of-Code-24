import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder();

        System.out.println("Enter numbers and enter 'end' to finish: ");
        // input holds all the numbers with spaces
        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("end")) {
                break;
            }
            input.append(line);
        }
        //System.out.println("Input: " + input);

        //inputNumbersOnly is a string of all the numbers, no spaces
        String stringInput = String.valueOf(input);
        String inputNumbersOnly = stringInput.replaceAll("\\s", "");
        //System.out.println(inputNumbersOnly);

        String num = "";
        ArrayList<String> stringArray = new ArrayList<>();
        for (int i=0; i< (inputNumbersOnly.length()); i+=5) {
            num = inputNumbersOnly.substring(i, i+5);
            stringArray.add(num);
        }
        for (String value : stringArray) {
            System.out.println(value);
        }


        int[] inputArrayInt = new int[stringArray.toArray().length];
        for (int i=0; i < inputArrayInt.length; i++) {
            inputArrayInt[i] = Integer.parseInt(stringArray.get(i));
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i=0; i < inputArrayInt.length; i++) {
            if (i%2 == 1) {
                list2.add(inputArrayInt[i]);
            }
            else {
                list1.add(inputArrayInt[i]);
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

        int difference = 0;
        for (int i=0; i<list1.toArray().length; i++) {
            difference += Math.abs(list1.get(i) - list2.get(i));
        }
        System.out.println("Difference: " + difference);

        int count = 0;
        int similarityScore = 0;
        for (int i=0; i<list1.toArray().length; i++) {
            count = Collections.frequency(list2, list1.get(i));
            similarityScore += count * list1.get(i);
        }
        System.out.println("Similarity Score: " + similarityScore);
    }
}
