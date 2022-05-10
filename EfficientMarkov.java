import java.util.*;

public class EfficientMarkov extends BaseMarkov {
	private Map<String,ArrayList<String>> myMap;
	
	public EfficientMarkov(){
		this(3);
	}

	public EfficientMarkov(int order) {
		super(order);
		myMap = new HashMap<>();
	}
// new coment

	@Override
	public void setTraining(String text) {
		super.setTraining(text);
		myMap.clear();
		// TODO: Finish implementing setTraining
		int theLength = text.length();
		for (int i = 0; i < theLength - myOrder + 1; i++){
			String givenString = text.substring(i, i + myOrder);
			String theString = " ";
			if(i == theLength - myOrder){
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
				theString = text.substring(i + myOrder, i + myOrder + 1);;
			}
			if(!myMap.containsKey(givenString)) {
				/*ArrayList<String> updatedValues = myMap.get(givenString);
				updatedValues.add(letterAfter);
				myMap.put(givenString, updatedValues);
				*/
				myMap.put(givenString, new ArrayList<>());
			}
			myMap.get(givenString).add(theString);
		}
	}

	@Override
	public ArrayList<String> getFollows(String key) {
		// DONE: Implement getFollows

		if (!myMap.containsKey(key)){
			throw new NoSuchElementException(key+" not in map");
	}

	else {
		return myMap.get(key);	
	}
		
	
}	
}