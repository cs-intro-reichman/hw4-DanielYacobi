public class MyString {
    public static void main(String[] args) {
        System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));  

        System.out.println("Testing contains:");
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true 
    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        String low = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 65 && str.charAt(i) <= 90)
                low = low + (char)(str.charAt(i) + 32); //converts from uppercase to lowercase
            else
                low = low + str.charAt(i);
        }
        return low;
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        if (str2.length() == 0) //every string contains ""
            return true;
        if (str1.length() < str2.length()) //a string cannot contain a longer string
            return false;
        boolean isTrue = false;
        for (int i = 0; i < str1.length() - str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) { //will go over some checks to see if the first string contains the second one
                isTrue = true;
                for (int k = 0; k < str2.length(); k++) {
                    if (str1.charAt(k + i) != str2.charAt(k)) {
                        isTrue = false;
                        break;
                    }
                }
                if (isTrue) //finished going over the second string and the value is still true
                    return isTrue;
            }
        }
        return isTrue;
    }
}
