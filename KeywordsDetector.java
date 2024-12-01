public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        boolean found = false;
        int sentencesLength = sentences.length;
        int keywordsLength = keywords.length;
        String str1;
        String str2;
        for (int i = 0; i < sentencesLength; i++) {
            str1 = lowerCase(sentences[i]);
            for (int k = 0; k < keywordsLength; k++) {
                str2 = lowerCase(keywords[k]);
                if (contains(str1, str2) && !found) { //checks if a keyword is found in the current sentence
                    System.out.println(sentences[i]); //prints the sentence
                    found = false;
                    break;
                }
            }
        }
    }
    
    //Same program as the one from Q3 (MyString)
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
    
    //Same program as the one from Q3 (MyString)
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
