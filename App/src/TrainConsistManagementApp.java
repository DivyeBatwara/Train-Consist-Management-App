import java.util.Arrays;
public class TrainConsistManagementApp {

    public static boolean binarySearch(String[] bogieIds, String key) {
        Arrays.sort(bogieIds);
        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = bogieIds[mid].compareTo(key);

            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false; // not found
    }

    public static void main(String[] args) {
        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"}; // MUST be sorted

        String key = "BG309";

        if (binarySearch(bogieIds, key)) {
            System.out.println("Bogie found: " + key);
        } else {
            System.out.println("Bogie not found: " + key);
        }
    }
}