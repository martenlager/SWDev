package piglatin;

public class ProposeWord {
  private int index = 4;

  public String proposeWord() {
    index = (index+1)%5;
    return getWord(index+1);
  }
	
	public String getWord(int index){
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
