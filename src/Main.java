import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();


        ArrayList<String> myList1 = new ArrayList<String>();
        ArrayList<HashMap> reducedListfinale = new ArrayList<HashMap>();

        File file1 = new File("C:\\Users\\theo1\\Desktop\\cours\\Java\\Map_Reduce\\data\\test.txt");
        BufferedReader br1 = new BufferedReader(new FileReader(file1));
        String st1;
        while ((st1 = br1.readLine()) != null){
            List<String> strings = Arrays.asList(st1.split(" "));
            myList1.addAll(strings);
        }

        ArrayList<String> myList2 = new ArrayList<String>();
        File file2 = new File("C:\\Users\\theo1\\Desktop\\cours\\Java\\Map_Reduce\\data\\test2.txt");
        BufferedReader br2 = new BufferedReader(new FileReader(file2));
        String st2;
        while ((st2 = br2.readLine()) != null){
            List<String> strings = Arrays.asList(st2.split(" "));
            myList2.addAll(strings);
        }

        ArrayList<String> myList3 = new ArrayList<String>();
        File file3 = new File("C:\\Users\\theo1\\Desktop\\cours\\Java\\Map_Reduce\\data\\test3.txt");
        BufferedReader br3 = new BufferedReader(new FileReader(file3));
        String st3;
        while ((st3 = br3.readLine()) != null){
            List<String> strings = Arrays.asList(st3.split(" "));
            myList3.addAll(strings);
        }

        ArrayList<String> myList4 = new ArrayList<String>();
        File file4 = new File("C:\\Users\\theo1\\Desktop\\cours\\Java\\Map_Reduce\\data\\test4.txt");
        BufferedReader br4 = new BufferedReader(new FileReader(file4));
        String st4;
        while ((st4 = br4.readLine()) != null){
            List<String> strings = Arrays.asList(st4.split(" "));
            myList4.addAll(strings);
        }



        ArrayList<Mapper> lesMaps =new ArrayList<>();
        Mapper map1 = new Mapper(myList1,4);
        /*map1.getShuffleList();
        ArrayList<HashMap> mappped1 = map1.getMap();
        System.out.println(mappped1);*/

        Mapper map2 = new Mapper(myList2,4);
        /*map2.getShuffleList();
        ArrayList<HashMap> mappped2 = map2.getMap();
        System.out.println(mappped2); */

        Mapper map3 = new Mapper(myList3,4);
       /* map3.getShuffleList();
        ArrayList<HashMap> mappped3 = map3.getMap();
        System.out.println(mappped3); */

        Mapper map4 = new Mapper(myList4,4);
        /* map4.getShuffleList();
        ArrayList<HashMap> mappped4 = map4.getMap();
        System.out.println(mappped4);  */


        map1.start();
        map2.start();
        map3.start();
        map4.start();

        lesMaps.add(map1);
        lesMaps.add(map2);
        lesMaps.add(map3);
        lesMaps.add(map4);

        for(int i=0 ; i < lesMaps.size();i++){
            lesMaps.get(i).join();
        }


        ArrayList<HashMap> reducedList1 = new ArrayList<HashMap>();
        ArrayList<HashMap> reducedList2 = new ArrayList<HashMap>();
        ArrayList<HashMap> reducedList3 = new ArrayList<HashMap>();
        ArrayList<HashMap> reducedList4 = new ArrayList<HashMap>();

        reducedList1.add(map1.getOutputList().get(0));
        reducedList1.add(map2.getOutputList().get(0));
        reducedList1.add(map3.getOutputList().get(0));
        reducedList1.add(map4.getOutputList().get(0));

        System.out.println(reducedList1);

        reducedList2.add(map1.getOutputList().get(1));
        reducedList2.add(map2.getOutputList().get(1));
        reducedList2.add(map3.getOutputList().get(1));
        reducedList2.add(map4.getOutputList().get(1));


        reducedList3.add(map1.getOutputList().get(2));
        reducedList3.add(map2.getOutputList().get(2));
        reducedList3.add(map3.getOutputList().get(2));
        reducedList3.add(map4.getOutputList().get(2));

        reducedList4.add(map1.getOutputList().get(3));
        reducedList4.add(map2.getOutputList().get(3));
        reducedList4.add(map3.getOutputList().get(3));
        reducedList4.add(map4.getOutputList().get(3));


        Reducer red1 = new Reducer(reducedList1);
       /* HashMap<String, Integer> reduced1 = red1.getReduce();
        reducedListfinale.add(reduced1);
        System.out.println(reduced1);*/

        Reducer red2 = new Reducer(reducedList2);
        /*HashMap<String, Integer> reduced2 = red2.getReduce();
        reducedListfinale.add(reduced2);
        System.out.println(reduced2);*/

        Reducer red3 = new Reducer(reducedList3);
        /*HashMap<String, Integer> reduced3 = red3.getReduce();
        reducedListfinale.add(reduced3);
        System.out.println(reduced3);*/

        Reducer red4 = new Reducer(reducedList4);
        /*HashMap<String, Integer> reduced4 = red4.getReduce();
        reducedListfinale.add(reduced4);
        System.out.println(reduced4);*/

        ArrayList<Reducer> lesReds =new ArrayList<>();

        red1.start();
        red2.start();
        red3.start();
        red4.start();

        lesReds.add(red1);
        lesReds.add(red2);
        lesReds.add(red3);
        lesReds.add(red4);

        for(int i=0 ; i < lesReds.size();i++){
            lesReds.get(i).join();
        }


        reducedListfinale.add(red1.getReduced());
        reducedListfinale.add(red2.getReduced());
        reducedListfinale.add(red3.getReduced());
        reducedListfinale.add(red4.getReduced());



        Reducer red5 = new Reducer(reducedListfinale);
        red5.start();
        red5.join();

        System.out.println(red5.getReduced());
        /*HashMap<String, Integer> reduced5 = red5.getReduce();
        System.out.println(reduced5); */


        long endTime = System.nanoTime();
        long totalTime =endTime-startTime;
        System.out.println("temps d'exec de notre code : "+ (totalTime*0.000000001) + " secondes");

    }


}
