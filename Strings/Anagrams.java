import java.util.*;
public class Anagrams {
    public static void Compare(String str, String str1){

        str = str.toLowerCase();
        str1 = str1.toLowerCase();

        // chech the length if is equal 
        if(str.length() == str1.length()){

            // convert string to chara
            char[] strcharaArray = str.toCharArray();
            char[] str1charaArray = str1.toCharArray();

            // Sort the Chara Array

            Arrays.sort(strcharaArray);
            Arrays.sort(str1charaArray);

            // if chara are same then it must me anagram

            boolean result = Arrays.equals(strcharaArray, str1charaArray);
            if(result){
                System.out.print(str + " and " + str1 + " is anagram word ");
            }else{
                System.out.print(str + " and " + str1 + " or not anagram word");
            }
        }else{
            System.out.print(str + " not " + str1 + " equal anagram word");
        }
    }
    public static void main(String[] args){
        String str = "Race";
        String str1 = "life";
        Compare(str, str1);
    }   
}
