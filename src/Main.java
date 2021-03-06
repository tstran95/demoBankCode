import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<String> bankCodes = Arrays.asList("1233", "1234", "1241", "1231");
        List<String> listResult = Arrays.asList("123301", "123302", "123303", "123304", "123305", "123306", "123308", "123307", "123309");
        System.out.println(recall("1233", listResult, 5));
    }

    public static StringBuilder generateNumber() {
        Random random = new Random();
        Integer num = random.nextInt(1000000);
        StringBuilder numStr = new StringBuilder(num.toString());
        while (numStr.length() < 6) {
            numStr.insert(0, "0");
        }
        return numStr;
    }

    public static StringBuilder generateNumberTest() {
        Random random = new Random();
        Integer num = random.nextInt(10);
        StringBuilder numStr = new StringBuilder(num.toString());
        while (numStr.length() < 2) {
            numStr.insert(0, "0");
        }
        return numStr;
    }

    public static String checkDone(String str) {
        return str + generateNumberTest();
    }

    public static String recall(String str1, List<String> stringList, int count) {
        for (int i = count; i > 0 ; i--) {
            String strCompare = str1 + generateNumberTest();
            boolean flag = true;
            for (int j = 0; j < stringList.size(); j++) {
                if (strCompare.equals(stringList.get(j))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return strCompare;
            }
        }
        System.out.println("Cant gen code");
        return null;
    }

}
