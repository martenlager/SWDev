package piglatin;

public class ProposeWord {

	
	public String proposeWord(int index){
		switch(index){
		case 1: return "pig";
		case 2: return "latin";
		case 3: return "banana";
		case 4: return "cheers";
		case 5: return "eat";
		default: return "wordMissing";
		}
	}
}
