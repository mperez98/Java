public class Main {

    public static void main(String[] args) {
	  // Project Euler Q5: Find smallest integer divisible by all numbers 1-20
        int start = 20;

        while (start%2!=0 || start%3!=0 || start%4!=0 || start%5!=0 || start%6!=0 || start%7!=0 || start%8!=0 || start%9!=0 || start%10!=0 || start%11!=0 ||start%12!=0 || start%13!=0 || start%14!=0 || start%15!=0 || start%16!=0 || start%17!=0 ||start%18!=0 || start%19!=0 || start%20!=0) {
            start = start+20;
        }
        System.out.println(start);
        System.exit(0);
    }
}
