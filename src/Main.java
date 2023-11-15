import javafx.util.Pair;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        frequencyCheck();
    }


    public static void primeTest(){
        Scanner input = new Scanner(System.in);
        String again = "Y";
        boolean prime;
        do{
            prime = true;
            System.out.print("Enter the number to test: ");
            int num = input.nextInt();

            if (num < 1)
                System.out.println("Not greater than 1");
            else {
                for (int i=2; i<num; i++){
                    if(num%i==0){
                        System.out.println("Not prime");
                        prime = false;
                        break;
                    }
                }
            }

            // check if prime is true
            if (prime)
                System.out.println("Is Prime");

            // repeat for another number
            System.out.print("Would you like to test another number? ");
            again = input.next();

        }while(again.equals("Y"));
    }

    public static void vowelQuest(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the word to test: ");
        String word = input.next();

        char[] newWord = word.toCharArray();
        int vowelCount = 0;
        ArrayList<Integer> vowelPosition = new ArrayList<Integer>();

        // find how many vowels and their position
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i) =='a' || word.charAt(i) =='e' ||
                    word.charAt(i) =='i' || word.charAt(i) =='o'|| word.charAt(i) =='u'){
                vowelCount++;
                vowelPosition.add(i);
            }
        }

        // print word and position
        System.out.println("Word is "+ word);
        System.out.println("There are "+ vowelCount+" vowels");
        for (int item :vowelPosition )
            System.out.print(item + ", ");


        // iterate over half of the charArray, and swap the values in the vowel position
        for(int i=0; i<vowelCount/2; i++){
            char temp = newWord[vowelPosition.get(i)];
            newWord[vowelPosition.get(i)] = newWord[vowelPosition.get(vowelCount-1-i)];
            newWord[vowelPosition.get(vowelCount-1-i)] = temp;
        }

        System.out.println();
        for(char c: newWord)
            System.out.print(c);

    }

    public static void insertionSort(){
        int[] myArray = {5, 2, 4, 6, 1, 3, 4};

        for(int item: myArray)
            System.out.print(item + "  ");

        int key, position;

        for(int i=1; i<myArray.length;i++){
            key = myArray[i];
            position = i-1;

            while (position >=0 && myArray[position] > key  ){
                // move value down
                myArray[position+1] = myArray[position];
                position--;
            }

            // now we have found the right position for key
            myArray[position+1] = key;
        }

        System.out.println("\n\nAfter sorting");

        for(int item: myArray)
            System.out.print(item + "  ");


    }

    public static void frequencyCheck(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the data to check: ");
        String data = input.next();

        Hashtable<Character, Integer> values = new Hashtable<>();

        for(Character c: data.toCharArray()){
            if(values.containsKey(c))
                values.put(c,values.get(c)+1);
            else
                values.put(c,1);
        }


        int frequency = Integer.MIN_VALUE;
        char charFrequency = ' ';
        for(Map.Entry<Character, Integer> item: values.entrySet()){
            if(item.getValue() > frequency){
                frequency = item.getValue();
                charFrequency = item.getKey();
            }
            System.out.print(item.getKey() + " -> " +item.getValue()+", ");
        }

        System.out.println("\nFrequency is "+frequency);
        System.out.println("Value is "+ charFrequency);

    }


}