//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Homework.turnString("i love java");

        Homework.getDistinctNumbers(new int[]{1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9});

        System.out.println(Homework.findSecondMaxElement(new int[]{10, 15, 23, 11, 44, 13, 66, 1, 6, 47}));

        System.out.println(Homework.lengthOfLastWord("Hello world"));
        System.out.println(Homework.lengthOfLastWord("    fly me    to the moon    "));

        System.out.println(Homework.isPalindrome("abc"));
        System.out.println(Homework.isPalindrome("112233"));
        System.out.println(Homework.isPalindrome("aba"));
        System.out.println(Homework.isPalindrome("112211"));
    }
}