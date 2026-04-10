public class UseCase18 {

    static int linearSearch(String[] bogieIds, String key) {
        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    static void printResult(String key, int index) {
        if (index != -1) {
            System.out.println("[FOUND]     Bogie ID '" + key +
                               "' found at index " + index + ".");
        } else {
            System.out.println("[NOT FOUND] Bogie ID '" + key +
                               "' does not exist in the consist.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC18: Linear Search for Bogie ID ---\n");

        String[] bogieIds = {
            "BG005", "BG002", "BG008", "BG001",
            "BG007", "BG003", "BG006", "BG004"
        };

        System.out.println("Bogie IDs (Unsorted):");
        for (String id : bogieIds) System.out.print("  " + id);
        System.out.println("\n");

        String[] searchKeys = {"BG001", "BG005", "BG008", "BG010", "BG003"};

        for (String key : searchKeys) {
            int result = linearSearch(bogieIds, key);
            printResult(key, result);
        }

        System.out.println("\n--- Additional Test Cases ---\n");

        String[] single = {"BG001"};
        printResult("BG001", linearSearch(single, "BG001"));
        printResult("BG002", linearSearch(single, "BG002"));

        String[] empty = {};
        printResult("BG001", linearSearch(empty, "BG001"));
    }
}
