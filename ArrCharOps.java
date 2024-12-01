

/** A library of operations on arrays of characters (char values).
 *  The library also features a string comparison method. */
public class ArrCharOps {
    public static void main(String[] args) {
        String str = "clearly";
        char[] arr1 = {'c','l','e','a','r','l','y'};
        char[] arr2 = {'U','n','d','e','r','s','t', 'o', 'o', 'd'};
        System.out.println(str);  // Prints the string
        println(arr1);            // Prints an array of characters
        System.out.println(charAt(arr1,2));      
        System.out.println(indexOf(arr1,'l'));  
        System.out.println(indexOf(arr1,'l',3)); 
        System.out.println(lastIndexOf(arr1, 'l'));
        System.out.println(concat(arr1, arr2));
        System.out.println(subArray(arr2, 2, 9)); 
        System.out.println(compareTo("abcd", "abcd"));
        System.out.println(compareTo("abc", "abcd"));
        System.out.println(compareTo("abw", "abcd"));
        System.out.println(compareTo("Abcd", "a"));
        System.out.println(compareTo("apple", "banana"));
        System.out.println(compareTo("apple", "applepie"));
        System.out.println(compareTo("Zoo", "zoo")); 
        System.out.println(hashCode(arr1));
        System.out.println(hashCode(arr2)); 
    }

    /** Prints the given array of characters, and moves the cursor to the next line.
     */
    public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /** Returns the char value at the specified index. Assume that the array is non-empty.
     */
    public static char charAt(char[] arr, int index) {
        return arr[index];
    }

    /** If the two arrays have the same value in every index, 
     *  returns true; Otherwise returns false.
     */
    public static boolean equals(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) //should be the same length
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) //checks if values in the same index are equal
                return false;
        }
        return true;
    }

    /** Returns the index within the given array of the first occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int indexOf(char[] arr, char ch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ch)
                return i;
        }
        return -1;
    }

    /** Same as indexOf(char[], char), but starts the search in the given index.
     */
    public static int indexOf(char[] arr, char ch, int fromIndex) {
        for (int i = fromIndex; i < arr.length; i++) { //same but starts the loop from the given int
            if (arr[i] == ch)
                return i;
        }
        return -1;
    }

    /** Returns the index within the given arr of the last occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int lastIndexOf(char[] arr, char ch) {
        for (int i = arr.length-1; i >= 0; i--) { //goes from end to beginning
            if (arr[i] == ch)
                return i;
        }
        return -1;
    }

    /* Returns an array which is the concatanation of the two given arrays.
    */
    public static char[] concat(char[] arr1, char[] arr2) {
        char[] arr3 = new char[arr1.length+arr2.length];
        for (int i = 0; i < arr1.length + arr2.length; i++) {
            if (i < arr1.length)
                arr3[i] = arr1[i]; //puts the first arrays values in
            else
                arr3[i] = arr2[i - arr1.length]; //puts the second arrays values in
        } 
        return arr3;
    }

    /** Returns a new array that can be described as a sub-array of this array.
     *  The sub-array begins at the specified beginIndex and extends to the character at index endIndex - 1.
     *  For example, if arr contains the characters "hamburger", then subArray(4, 8) returns an array of
     *  characters containing the characters "urge".
     */     
    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        char[] sub = new char[endIndex - beginIndex]; //length will be subtraction of the given ints
        for (int i = beginIndex; i < endIndex; i++) {
            sub[i - beginIndex] = arr[i]; //creates the new array
        }
        return sub;
    }

     /** Returns a single integer that represents the given array. This integer is sometimes 
     *  referred to as the array's "hash code". Later in the course we'll explain what these 
     *  hash codes are used for. For now, simply implement the specification given below.
     *  The hash code is computed as: arr[0]*7^(n-1) + arr[1]*7^(n-2) + ... + arr[n-2]*7 + arr[n-1]
     *  where arr[i] is the i'th character of the array, and n is the array's length.
     *  The hash value of an empty array is zero.
     */
    public static long hashCode(char[] arr) {
        long hash = 0;
        for (int i = 0; i < arr.length; i++) {
            hash = hash + ((int)arr[i] * (int)Math.pow(7, arr.length-i-1)); //hash code formula
        }
        return hash;
    }

    /**
     * Compares the two strings lexicographically.
     * Assume that both strings are not empty.
     * 
     * Characters are compared one by one from left to right, using their numeric Unicode values,
        as follows:
     * 1. If two characters at the same position in both strings are different,
     *    the string with the smaller character is considered lexicographically smaller.
     * 2. If all characters in the shorter string match the corresponding characters
     *    in the longer string, the shorter string is considered lexicographically smaller.
     * 3. If both strings have the same characters and the same length, they are considered equal.
     * 
     * Examples:
     * - "apple" is less than "banana" because 'a' comes before 'b'.
     * - "abc" is less than "abcd" because it is shorter.
     * - "hello" is equal to "hello".
     * - "date" is greater than "dark" because 't' comes after 'k'.
     * 
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return -1 if str1 is lexicographically less than str2,
     *         zero if they are equal, and 1 if str1 is
     *         lexicographically greater than str2.
     *         return -2 if there is an error with the input.
     */
    public static int compareTo(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) //special case
            return -2;
        if (str1.length() > str2.length()) {
            for (int i = 0; i < str2.length(); i++) { 
                if (str1.charAt(i) < 65 || str1.charAt(i) > 122 || (str1.charAt(i) > 90 && str1.charAt(i) < 97)) //special notes
                    return -2;
                if (str2.charAt(i) < 65 || str2.charAt(i) > 122 || (str2.charAt(i) > 90 && str2.charAt(i) < 97)) //special notes
                    return -2;
                if (str1.charAt(i) > str2.charAt(i))
                    return 1;
                if (str1.charAt(i) < str2.charAt(i))
                    return -1;
            }
            return 1;
        }
        else {
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) < 65 || str1.charAt(i) > 122 || (str1.charAt(i) > 90 && str1.charAt(i) < 97)) //special notes
                    return -2;
                if (str2.charAt(i) < 65 || str2.charAt(i) > 122 || (str2.charAt(i) > 90 && str2.charAt(i) < 97)) //special notes
                    return -2;
                if (str1.charAt(i) > str2.charAt(i))
                    return 1;
                if (str1.charAt(i) < str2.charAt(i))
                    return -1;
            }
            if (str1.length() < str2.length())
                return -1;
        }
        return 0; //if nothing was returned by now then the strings are equal
    }
}
