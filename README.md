Enum Dictionary
	
								-----Summary-----
	The interactive dictionary uses Java’s Enum class as the database. 
	The sample outputs show that we are loading data into the dictionary from the Enum class. When the program is finished loading, it prompts the user to make a search. The search input is based on 3 keywords. The first keyword should be they key word to search for(ex: CSC210). The 2nd Keyword and 3rd key word can be interchangeable. They must be either the part of speech key word or the key word “Distinct”. Distinct is used in order to get one distinct part of speech. This basically means don’t display any copy’s from the database that have the same part of speech from the key word. The problem this program is solving is figuring out what data structures are best used to store information and get information from the dictionary based on key words. 

	The way I stored Enum objects is by having 3 separate strings in each object. The first string is the Keyword, 2nd is the part of speech, and 3rd is the definition. The reason why I did this was so that it would be easy to construct the constructor. Also, this makes the database more dynamic. I can easily add values to the database and it won’t affect how the interface will act.


								-----Data Structures-----
	The data structures I used were Array List and Hash Map. I used Array List because the array of Enum objects needs to be dynamic. I need to use an array but normal arrays in Java must have a fixed size. Array List data structure allows for dynamic sized arrays and implements the List interface. I used hash maps because of the basic implementation of Map interface. It stores the data by taking in a Key and Value. The key can be the users input while the Values are being passed by the ArrayList<Dictionary>. Dictionary is the name of my Enum class.