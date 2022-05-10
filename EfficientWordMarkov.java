import java.util.*;

public class EfficientWordMarkov extends BaseWordMarkov {
	private Map<WordGram,ArrayList<String>> myMap;

// new coment 

    public EfficientWordMarkov(){
		this(2);
	}

	public EfficientWordMarkov(int order) {
		super(order);
		myMap = new HashMap<>();
	}

    @Override
	public void setTraining(String text) {
		super.setTraining(text);
		myMap.clear();
		// TODO: Finish implementing setTraining
		for (int i = 0; i < myWords.length - myOrder + 1; i++){
			WordGram theGram = new WordGram(myWords,i,myOrder);
			String theString;
			if(i == myWords.length - myOrder){
				theString = PSEUDO_EOS;
				/*ArrayList<String> thisString = new ArrayList<>();
				thisString.add(PSEUDO_EOS);
				myMap.put(givenString, thisString);
				*/
			}
			else {
				/*ArrayList<String> theValues = new ArrayList<>();
				theValues.add(letterAfter);
				myMap.put(givenString, theValues);
				*/
				theString = myWords[i + myOrder];
			}
			if(!myMap.containsKey(theGram)) {
				/*ArrayList<String> updatedValues = myMap.get(givenString);
				updatedValues.add(letterAfter);
				myMap.put(givenString, updatedValues);
				*/
				myMap.put(theGram, new ArrayList<>());
			}
			myMap.get(theGram).add(theString);
		}
	}

	@Override
	public ArrayList<String> getFollows(WordGram givenGram) {
		// DONE: Implement getFollows

		if (!myMap.containsKey(givenGram)){
			throw new NoSuchElementException(givenGram+" not in map");
	}
		
	return myMap.get(givenGram);
}
}