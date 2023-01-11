import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Mapper extends Thread{

    public ArrayList<String> myList;
    ArrayList<HashMap> shuffleList = new ArrayList<HashMap>();
    public int ascii;
    public int nbReduce;
    public ArrayList<HashMap> outputList;

    public Mapper(ArrayList<String> myList, int nbReduce) {
        this.myList = myList;
        this.nbReduce = nbReduce;
    }

    public ArrayList<HashMap> getShuffleList(){
        for(int i=0; i<this.nbReduce; i++){
            HashMap<String, Integer> shuffle = new HashMap<String, Integer>();
            shuffleList.add(shuffle);
        }
        return shuffleList;
    }

    public int convertion(String word){
        ascii = 0;
        for(char carac : word.toCharArray()){
            ascii += carac;
        }
        return ascii;
    }

    public ArrayList<HashMap> getMap() {
        for (String word : this.myList){
            int codeAscii = convertion(word);
            HashMap map = shuffleList.get(codeAscii%this.nbReduce);
            if(map.containsKey(word))
                map.put(word, (Integer)map.get(word)+1);
            else
                map.put(word, 1);
        }
        return shuffleList;
    }
    @Override
    public void run(){

        this.getShuffleList();
        this.outputList = this.getMap();

    }

    public ArrayList<HashMap> getOutputList() {
        return outputList;
    }

    public void setOutputList(ArrayList<HashMap> outputList) {
        this.outputList = outputList;
    }
}
