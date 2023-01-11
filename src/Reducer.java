import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reducer extends Thread {

    public ArrayList<HashMap> shuffleList;
    public HashMap<String, Integer> reduced;

    public HashMap<String, Integer> getReduced() {
        return reduced;
    }

    public void setReduced(HashMap<String, Integer> reduced) {
        this.reduced = reduced;
    }

    public Reducer(ArrayList<HashMap> shuffleList) {
        this.shuffleList = shuffleList;
    }

    public HashMap<String, Integer> getReduce(){
        HashMap<String, Integer> reduced = new HashMap<String, Integer>();
        for (HashMap<String, Integer> map : this.shuffleList){
            for (Map.Entry<String, Integer> entry : map.entrySet()){
                String word = entry.getKey();
                Integer value = entry.getValue();
                if(reduced.containsKey(word))
                    reduced.put(word, (Integer)reduced.get(word)+value);
                else
                    reduced.put(word, value);
            }
        }
        return reduced;
    }
    @Override
    public void run(){
        this.reduced = this.getReduce();


    }
}
