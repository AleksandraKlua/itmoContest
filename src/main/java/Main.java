package main.java;

import java.util.*;

import static java.lang.System.*;

public class Main {
    public static void main(String... args) {
        try {
            int inputArraySize = getInputArraySize();
            String[] inputStringArrayValues = getInputStringArrayValues();

            checkArraySize(inputStringArrayValues, inputArraySize);

            String[] result = removeDuplicates(inputStringArrayValues);
            HashMap<Integer, Integer> resultMap = getResultMap(result);
            compareAndPrintValues(resultMap);
        } catch (NumberFormatException | InputMismatchException | ArrayInputSizeMismatchException ex) {
            System.exit(0);
        }
    }

    private static int getInputArraySize() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String[] getInputStringArrayValues() {
        Scanner scanner2 = new Scanner(System.in);
        String inputArray = scanner2.nextLine();
        return inputArray.split(" ");
    }

    private static void checkArraySize(String[] inputStringArrayValues, int inputArraySize) throws ArrayInputSizeMismatchException {
        int arraySize = inputStringArrayValues.length;
        if (arraySize != inputArraySize) {
            throw new ArrayInputSizeMismatchException();
        }
    }

    private static String[] removeDuplicates(String[] inputStringArrayValues) {
        Set<String> set = new HashSet<>(Arrays.asList(inputStringArrayValues));
        return set.toArray(new String[set.size()]);
    }

    private static HashMap<Integer, Integer> getResultMap(String[] result) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for (String s : result) {
            int[] value = splitValue(s);
            int sum = getSum(value);
            resultMap.put(Integer.parseInt(s), sum);
        }
        return resultMap;
    }

    private static void compareAndPrintValues(HashMap<Integer, Integer> valueSize) {
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        valueSize.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(it -> tempMap.put(it.getKey(), it.getValue()));
        tempMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(it -> out.println(it.getKey()));
    }

    private static int getSum(int[] splittedValue){
        int size = 0;
        for (int value : splittedValue) {
            size += stringValueSize(value);
        }
        return size;
    }

    private static int[] splitValue(String value) {
        if(Integer.parseInt(value) > 100) {
            String[] value2 = value.split("");
            String hundreds = value2[0] + "00";
            if(Integer.parseInt(value2[1] +  value2[2]) > 20) {
                return new int[]{Integer.parseInt(hundreds), Integer.parseInt(value2[1] +  value2[2])};
            } else {
                String dozens = value2[1] + "0";
                String units = value2[2];
                return new int[]{Integer.parseInt(hundreds), Integer.parseInt(dozens), Integer.parseInt(units)};
            }
        } else if(Integer.parseInt(value) > 20) {
            String[] value2 = value.split("");
            String dozens = value2[0] + "0";
            String units = value2[1];
            return new int[]{Integer.parseInt(dozens), Integer.parseInt(units)};
        } else return new int[]{Integer.parseInt(value)};
    }

    private static int stringValueSize(int inputValue) {
        switch (inputValue) {
            case 1:
            case 5:
            case 7:
                return 4;
            case 2:
            case 3:
            case 100:
                return 3;
            case 4:
            case 8:
            case 9:
            case 10:
            case 200:
            case 300:
                return 6;
            case 6:
            case 40:
                return 5;
            case 11:
            case 16:
            case 80:
                return 11;
            case 12:
            case 13:
            case 15:
            case 17:
            case 60:
                return 10;
            case 14:
            case 18:
            case 19:
                return 12;
            case 20:
            case 30:
            case 600:
                return 8;
            case 50:
            case 70:
            case 90:
            case 400:
            case 800:
            case 900:
                return 9;
            case 500:
            case 700:
                return 7;
        }
        return 0;
    }
}