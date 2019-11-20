package playListCodeandTesting;
import java.util.*;
public class Music {
	    private String[] playList;

	    public Music(String[] playList){
	        this.playList = playList;
	    }

	    public Integer selection(Integer startIndex, String selection){

	        //Create an arrayList from the array to utilize methods
	        ArrayList<String> musicSelections = new ArrayList<String>(Arrays.asList(this.playList));
	        int forwardCt = Math.abs(musicSelections.indexOf(selection) - startIndex);
	        int BackwardCt = Math.abs((musicSelections.size() + startIndex) - musicSelections.lastIndexOf(selection));
	        return Math.min(forwardCt, BackwardCt);
	    }

}
