import java.util.*;

public class CoinProblem {

    private static int[] coins = {500, 100, 50, 1};

    public static void main(String[] args) {
        HashMap<Integer, Integer> payInfo = payCoin(4720);
        HashMap<Integer, Integer> result = sortByKey(payInfo);
        System.out.println(result);
    }

    private static HashMap<Integer, Integer> sortByKey(HashMap<Integer, Integer> payInfo) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(payInfo.entrySet());
        HashMap<Integer, Integer> result = new HashMap<>();

        Collections.sort(list, Map.Entry.comparingByKey());

//        list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> data : list) {
            result.put(data.getKey(), data.getValue());
        }

        return result;
    }

    private static HashMap<Integer, Integer> payCoin(int toBePaid) {
        HashMap<Integer, Integer> result = new HashMap<>();

        for (int coin : coins) {
            int temp = toBePaid / coin;
            toBePaid -= coin * temp;
            result.put(coin, temp);
        }

        return result;
    }

}
