import java.io.*;
import java.util.*;
/*
    Text Editor Used: NetBeans
    A.T 
*/


public enum Dictionary {
    /*Data to be stored in dictionary*/
    PLACEHOLDERADJECTIVE1("Placeholder", "adjective", "To Be Updated..."),
    PLACEHOLDERADJECTIVE2("Placeholder", "adjective", "To Be Updated..."),
    PLACEHOLDERADJECTIVE3("Placeholder", "adverb", "To Be Updated..."),
    PLACEHOLDERCONJUNCTION("Placeholder", "connjunction", "To Be Updated..."),
    PLACEHOLDERINTERJUNCTION("Placeholder", "interjection", "To Be Updated..."),
    PLACEHOLDERNOUN1("Placeholder", "noun", "To Be Updated..."),
    PLACEHOLDERNOUN2("Placeholder", "noun", "To Be Updated..."),
    PLACEHOLDERNOUN3("Placeholder", "noun", "To Be Updated..."),
    PLACEHOLDERPREPOSITION("Placeholder", "preposition", "To Be Updated..."),
    PLACEHOLDERPRONOUN("Placeholder", "pronoun", "To Be Updated..."),
    CSC210ADJECTIVE1("CSC210", "adjective", "Comfortable with Objects and Classes."),
    CSC210ADJECTIVE2("CSC210", "adjective", "Ready for CSC 220."),
    CSC210NOUN("CSC210", "noun", "Intro to Java."),
    CSC210VERB("CSC210", "verb", "To learn Java."),
    CSC220ADJECTIVE("CSC220", "adjective", "To learn Java."),
    CSC220NOUN("CSC220", "noun", "Ready to create complex data structures."),
    CSC220VERB("CSC220", "verb", "To create data structures"),
    CSC340ADJECTIVE("CSC340", "adjective", "= C++ version of CSC210 + CSC220 + more."),
    CSC340NOUN1("CSC340", "noun", "A CS upper division course."),
    CSC340NOUN2("CSC340", "noun", "many hours outside of class."),
    CSC340NOUN3("CSC340", "noun", "Programming Methodology."),
    VERBVERB1("Verb", "noun", "Verb is a word or group of words that expresses an action(such as happen) or state (such as exist)."),
    BOOKNOUN1("Book", "noun", "A set of pages."),
    BOOKNOUN2("Book", "noun", "A written work published in printed or electronic form."),
    BOOKVERB1("Book", "verb", "To arrange for someone to have a seat on a plane."),
    BOOKVERB2("Book", "verb", "To arrange for something on a particular date."),
    BOOKABLEADJECTIVE("Bookable", "adjective", "Can be ordered in advance."),
    CONJUNCTION("Conjunction", "noun", "Conjunction is a word that joins words, phrases or sentences, for example 'and', 'but', 'or'."),
    INTERJECTION("Interjection", "noun", "Interjection is a short sound, word or phrase an emotion. Oh!, Look Out! and Ow! are interjections."),
    ADJECTIVE("Adjective", "noun", "Adjective is a word that describes a person or thing, for example big, red and clever in a big house, red wine and a clever idea.");

    private final String generalNote = "Dictionary";
    private String keyword;
    private String partOfSpeech;
    private String definition;

    /*Constructor*/
    private Dictionary(String keyword, String partOfSpeech, String definition) {
        this.keyword = keyword;
        this.partOfSpeech = partOfSpeech;
        this.definition = definition;
    }

    public String getKeyword() {
        return this.keyword.toUpperCase();
    }

    public String partOfSpeech() {
        return this.partOfSpeech;
    }

    @Override
    public String toString() {
        return this.keyword + " [" + this.partOfSpeech + "] : " + this.definition;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("! Loading data...");

        /*Creating Hashmap with ArrayList<Dictionary> as values*/
        HashMap<String, ArrayList<Dictionary>> hmap = new HashMap<String, ArrayList<Dictionary>>();

        /*Loop to through Enum class called Dictionary*/
        /*Loading in hashmap*/
        for (Dictionary dict : Dictionary.values()) {

                /*Store keyword using method created in Enum class*/
                String keyword = dict.getKeyword();

                /*Add values to arrayList based on keyword*/
                ArrayList<Dictionary> list = (hmap.containsKey(keyword)) ? hmap.get(keyword) : new ArrayList<Dictionary>();
                list.add(dict);
                hmap.put(keyword, list);		
        }

        System.out.println("! Loading Complete...");
        System.out.println("\n-----DICTIONARY 340 JAVA-----\n");

        Boolean quite = true;

        /*Run program*/
        do {                    
            /*User input*/
            System.out.print("Search: ");
            String userinput = input.nextLine();
            String[] splited = userinput.split(" ");

            String word = null;  
            Boolean requestDistinct = false;
            String partOfSpeech = null;

            if (splited.length > 0) {
                word = splited[0];
            }
            
            String[] partOfSpeeches = {"noun", "verb", "adjective", "adverb", "pronoun", "preposition", "conjunction", "interjection"};
            if (splited.length > 1 && splited[1]!= null) {
                if (splited[1].equalsIgnoreCase("distinct")) {
                   requestDistinct = true;
                } else if (Arrays.asList(partOfSpeeches).contains(splited[1].toLowerCase())){
                    partOfSpeech = splited[1];
                } else {
                    System.out.println("   |");
                    System.out.println("    <2nd argument must be a part of speech or \"distinct\">");
                    System.out.println("   |");
                    continue;
                }
            }
            if (splited.length > 2 && splited[2]!= null) {
                if (splited[2].equalsIgnoreCase("distinct")) {
                   requestDistinct = true;
                } else if (Arrays.asList(partOfSpeeches).contains(splited[2].toLowerCase())){
                    partOfSpeech = splited[2];
                } else {
                    System.out.println("   |");
                    System.out.println("    <2nd argument must be a part of speech or \"distinct\">");
                    System.out.println("   |");
                    continue;
                }
            }
                       
            if(!userinput.equalsIgnoreCase("!q")) {
                System.out.println("   |");
                ArrayList<Dictionary> result = hmap.get(word.toUpperCase());
                ArrayList<Dictionary> secondResult = (requestDistinct) ? returnDictionaryWithDistinctPartOfSpeech(result) : result;
                ArrayList<Dictionary> thirdResult = (partOfSpeech != null) ? returnDictionaryWithSamePartOfSpeech(secondResult, partOfSpeech) : secondResult;

                if (thirdResult != null && thirdResult.size()>0) {
                    for(Dictionary key : thirdResult) {
                        System.out.print("    " + key + "\n");
                    }
                } else {
                    System.out.println("    <Not Found>");
                }
                System.out.println("   |");
            } else {
                System.out.println("\n----Thank You---");
                quite = false;
            }
        } while(quite);
    }
        
    /*create a new hashmap function, returns an array list of dictionary class*/
    public static ArrayList<Dictionary> returnDictionaryWithDistinctPartOfSpeech(ArrayList<Dictionary> dictList) {
        HashMap<String, Dictionary> hMap = new HashMap<String, Dictionary>();
        if (dictList != null) {
            for(Dictionary dict : dictList) {
                String partOfSpeech = dict.partOfSpeech();
                if(!hMap.containsKey(partOfSpeech)) {
                    hMap.put(partOfSpeech, dict);
                }
            }
        }
        return new ArrayList<Dictionary>(hMap.values());
    }

    /*returns new array list based on existing array list and part of speech user inputs*/
    public static ArrayList<Dictionary> returnDictionaryWithSamePartOfSpeech(ArrayList<Dictionary> dictList, String partOfSpeech) {
        ArrayList<Dictionary> result = new ArrayList<Dictionary>();
        if (dictList != null) {
            for(Dictionary dict : dictList) {
                if (dict.partOfSpeech().equalsIgnoreCase(partOfSpeech)) {
                    result.add(dict);
                }
            }
        }
        return result;
    }
}