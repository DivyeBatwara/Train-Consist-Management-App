import java.util.Arrays;

public class TrainConsistManagementApp {

    public static boolean binarySearch(String[] bogieIds, String key) {

        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available to search");
        }

        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = bogieIds[mid].compareTo(key);

            if (cmp == 0) return true;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
