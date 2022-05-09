package au.com.planittesting.challenge2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class find the character that has the highest number of occurrences
 * within a certain string, ignoring case. If there is more than one character
 * with equal highest occurrences, return the character that appeared first
 * within the string.
 *
 * @author Parbati Budhathoki
 * @Created On May 7, 2022 12:16:39 PM
 */
public class HighestOccuranceCharacterAscii {

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter a String: ");
            String inStr = input.nextLine().toLowerCase();  //it should ignore the case so taking all to the lowercase
            int[] hashTable = new int[256];        //ASCII chars are 256 so setting size to 256
            int inLen = inStr.length();
            ArrayList<Character> highOccurence = new ArrayList<>();
            int max_count = 0;

            for (int i = 0; i < inLen; i++) {
                hashTable[inStr.charAt(i)]++;
            }
            for (int i = 0; i < 256; i++) {

                if (hashTable[i] >= max_count && hashTable[i] > 0) {

                    max_count = hashTable[i];
                    highOccurence.add((char) i);  //adding all the char which has same max count
                }

            }
            //if there are more than one high occurance show the first one on the string
            if (highOccurence.size() > 1) {
                //if size is more than one check which character appeared first within string
                for (Character c : inStr.toCharArray()) {
                    if (highOccurence.contains(c)) {
                        System.out.println(c);
                        break;                  //if char is in arraylist then break from the loop
                    }
                }
            } else {
                System.out.println(highOccurence.get(0));
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Sorry you've not entered a String.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
