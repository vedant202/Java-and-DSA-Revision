package LeetCode;

import java.util.ArrayList;

public class FirstLetterToAppearTwice {
	public static char repeatedCharacter(String s) {
        ArrayList<Character> seenLetter = new ArrayList<Character>();

        for(char c:s.toCharArray()){
            if(seenLetter.contains(c)){
                return c;
            }else{
                seenLetter.add(c);
            }
        }
        return '0';
    }
	public static void main(String[] args) {
		String str = "abccbade";
		System.out.println(repeatedCharacter(str));
	}
}
