import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

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

        Mapper map1 = new Mapper(myList1,4);
        map1.getShuffleList();
        ArrayList<HashMap> mappped1 = map1.getMap();
        System.out.println(mappped1);

        Mapper map2 = new Mapper(myList2,4);
        map2.getShuffleList();
        ArrayList<HashMap> mappped2 = map2.getMap();
        System.out.println(mappped2);

        Mapper map3 = new Mapper(myList3,4);
        map3.getShuffleList();
        ArrayList<HashMap> mappped3 = map3.getMap();
        System.out.println(mappped3);

        Mapper map4 = new Mapper(myList4,4);
        map4.getShuffleList();
        ArrayList<HashMap> mappped4 = map4.getMap();
        System.out.println(mappped4);


        ArrayList<HashMap> reducedList1 = new ArrayList<HashMap>();
        ArrayList<HashMap> reducedList2 = new ArrayList<HashMap>();
        ArrayList<HashMap> reducedList3 = new ArrayList<HashMap>();
        ArrayList<HashMap> reducedList4 = new ArrayList<HashMap>();

        reducedList1.add(mappped1.get(0));
        reducedList1.add(mappped2.get(0));
        reducedList1.add(mappped3.get(0));
        reducedList1.add(mappped4.get(0));

        System.out.println(reducedList1);

        reducedList2.add(mappped1.get(1));
        reducedList2.add(mappped2.get(1));
        reducedList2.add(mappped3.get(1));
        reducedList2.add(mappped4.get(1));

        reducedList3.add(mappped1.get(2));
        reducedList3.add(mappped2.get(2));
        reducedList3.add(mappped3.get(2));
        reducedList3.add(mappped4.get(2));

        reducedList4.add(mappped1.get(3));
        reducedList4.add(mappped2.get(3));
        reducedList4.add(mappped3.get(3));
        reducedList4.add(mappped4.get(3));


        Reducer red1 = new Reducer(reducedList1);
        HashMap<String, Integer> reduced1 = red1.getReduce();
        reducedListfinale.add(reduced1);
        System.out.println(reduced1);

        Reducer red2 = new Reducer(reducedList2);
        HashMap<String, Integer> reduced2 = red2.getReduce();
        reducedListfinale.add(reduced2);
        System.out.println(reduced2);

        Reducer red3 = new Reducer(reducedList3);
        HashMap<String, Integer> reduced3 = red3.getReduce();
        reducedListfinale.add(reduced3);
        System.out.println(reduced3);

        Reducer red4 = new Reducer(reducedList4);
        HashMap<String, Integer> reduced4 = red4.getReduce();
        reducedListfinale.add(reduced4);
        System.out.println(reduced4);

        System.out.println(reducedListfinale);

        Reducer red5 = new Reducer(reducedListfinale);
        HashMap<String, Integer> reduced5 = red5.getReduce();
        System.out.println(reduced5);

    }


}
