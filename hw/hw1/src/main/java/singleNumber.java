import java.util.*;

public class singleNumber{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Integer arraySize = sc.nextInt();
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(Integer i = 0;i<arraySize;i++) {
            Integer cur = sc.nextInt();
            array.add(cur);
        }
        System.out.println(helperFunc(array));
    }
    public static int helperFunc(ArrayList<Integer> array){
        Map<Integer,Integer> check = new HashMap<Integer, Integer>();
        for(Integer i = 0;i<array.size();i++){
            if(check.containsKey(array.get(i))){
                Integer n = check.get(array.get(i))+1;
                check.put(array.get(i),n);
            }
            else {
                check.put(array.get(i),1);
            }
        }
        for(Integer key:check.keySet())
        {
            if(check.get(key)==1){
                return key;
            }
        }
        return 0;
    }
}