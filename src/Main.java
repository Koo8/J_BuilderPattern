import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // ArrayList
//        OracleArrayList<Integer> list = new OracleArrayList<>();
//        for (int i = 0; i < 25; i++)
//        {
//            list.add(i);
//        }
//
//        for (int i = 0; i <list.size() ; i++) {
//            System.out.println(list.get(i));
//        }


        // hashmap
        OracleHashMap.HashProvider<String> provider = new OracleHashMap.HashProvider<String>() {
            @Override
            public int getHashNumber(String key)
            {
//                int index = 0;
//                for (int i = 0; i <key.length() ; i++)
//                {
//                    index +=key.charAt(i) *(i+1);
//                }

                // commemt out the above to make the possibility of returning the same hash real
                // To avoid this may happen, use Arraylist instead of Array in OracleHashMap - see OracleHashMap class
                return 0;
            }
        };

        OracleHashMap<String, Integer> mHashMap = new OracleHashMap<>(provider);
        mHashMap.put("Susan", 2022);
        mHashMap.put("Grail", 2033);
        mHashMap.put("ssuan", 3300);

        int score =  mHashMap.get("Susan");
        System.out.println(score);



    }

}
