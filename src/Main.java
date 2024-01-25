import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] cards1 = new String[]{"i", "water", "drink"};
        String[] cards2 = new String[]{"want", "to"};
        String[] goal = new String[]{"i", "want", "to", "drink", "water"};

        // goal을 Map으로 변환
        Map<String, Integer> goalMap = new LinkedHashMap<>();

        // goal기준 순서로 순차적Value부여
        for (int i = 0; i < goal.length; i++) {
            goalMap.put(goal[i],i);
        }
        System.out.println(goalMap);

        // 각 카드뭉치의 goal의 key값과 동일한 key값을 가지면 goal의 value를 부여하여 Map생성
        // 동일하지 않은 값에는 null부여
        Map<String, Integer> cards1Map = new LinkedHashMap<>();
        for (int i = 0; i < cards1.length; i ++) {
            if(Objects.equals(goalMap.get(cards1[i]), cards1Map.get(cards1[i]))) {
                System.out.println("No");
            }
            cards1Map.put(cards1[i], goalMap.get(cards1[i]));
        }
        System.out.println(cards1Map);

        // 각 카드뭉치의 goal의 key값과 동일한 key값을 가지면 goal의 value를 부여하여 Map생성
        // 동일하지 않은 값에는 null부여
        Map<String, Integer> cards2Map = new LinkedHashMap<>();
        for (int i = 0; i < cards2.length; i ++) {
            if(Objects.equals(goalMap.get(cards2[i]), cards2Map.get(cards2[i]))) {
                System.out.println("No");
            }
            cards2Map.put(cards2[i], goalMap.get(cards2[i]));
        }
        System.out.println(cards2Map);

        List<Integer> goalValueList = new ArrayList<>(goalMap.values());
        List<Integer> cards1ValueList = new ArrayList<>(cards1Map.values());
        List<Integer> cards2ValueList = new ArrayList<>(cards2Map.values());

        // null제거
        while(cards1ValueList.remove(null)){        }
        while(cards2ValueList.remove(null)){        }

        List<Integer> rawCards1ValueList = new ArrayList<>(cards1ValueList);
        List<Integer> rawCards2ValueList = new ArrayList<>(cards2ValueList);
        Collections.sort(cards1ValueList);
        Collections.sort(cards2ValueList);

        int card1Sum = 0;
        int card2Sum = 0;
        int goalSum = 0;
        for( int num : cards1ValueList) {
            card1Sum += num;
        }
        for( int num : cards2ValueList) {
            card2Sum += num;
        }
        for( int num : goalValueList) {
            goalSum += num;
        }

        boolean a = rawCards1ValueList.equals(cards1ValueList) && rawCards2ValueList.equals(cards2ValueList);
        boolean b = card1Sum + card2Sum == goalSum;

        System.out.println(a && b);


    }
}
