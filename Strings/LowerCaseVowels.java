public class LowerCaseVowels {
    public static void Count(String str){
        int count =0;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
            }
        }
        System.out.println("vowels are " + count);
    }
    public static void main(String[] args){
        String str = "a,e,i,o,u";
        Count(str);    
    }   
}
