public class ReversedStrings {
    public static void main(String[] args) {
        solution("reverse this!");
    }
    public static String solution(String str) {
        String reversedString = "";
        for (int i=str.length() - 1;i > -1; i--){
            reversedString += str.charAt(i);
        }
        return reversedString;
      }
    
}
