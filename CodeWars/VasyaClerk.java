public class VasyaClerk {
    public static void main(String[] args) {
        System.out.println(Tickets(new int[] {25, 25, 50}));
    }
    public static String Tickets(int[] peopleInLine)
  {
        int currentMoney = 0;
        int twenties = 0;
        int fifties = 0;
        for(int i : peopleInLine)
        {
            if(currentMoney < i - 25 || twenties < i/25){
                return "NO";
            }
            if(i == 50)
                fifties++;
            if(i == 25)
                twenties++;
            
                currentMoney += 25;
        }
        return "YES";
  }
}
