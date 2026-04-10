public class TrainConsistManagementApp {

    public static boolean linearSearch(String[] bogieIds, String key) {
        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true; // found
            }
        }
        return false; // not found
    }

    public static void main(String[] args) {
        String[] bogieIds = {"B101", "B205", "B309", "B412", "B523"};

        String searchKey = "B309";

        boolean found = linearSearch(bogieIds, searchKey);

        if (found) {
            System.out.println("Bogie found: " + searchKey);
        } else {
            System.out.println("Bogie not found: " + searchKey);
        }
    }
}
