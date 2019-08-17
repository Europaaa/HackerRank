import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Link: https://www.hackerrank.com/contests/hourrank-30/challenges/video-conference/problem
public class VideoConference {

    private static List<String> assignNames(List<String> names) {
        List<String> conferenceNames = new ArrayList<>();

        // Duplicates with other names
        Map<String, Integer> duplicateNames = new HashMap<>();

        // Conference names that can't be assigned anymore, including names in used or prefixes
        Set<String> assignedNames = new HashSet<>();

        for (String name : names) {
            // Update duplicate names
            duplicateNames.put(name, duplicateNames.getOrDefault(name, 0) + 1);

            // Check for duplicates
            if (duplicateNames.get(name) > 1) {
                String conferenceName = name + " " + duplicateNames.get(name);

                conferenceNames.add(conferenceName);
                continue;
            }

            // Check for duplicates in assigned names
            boolean nameAssigned = false;
            for (int i = 1; i <= name.length(); i++) {
                String conferenceName = name.substring(0, i);

                if (!nameAssigned && !assignedNames.contains(conferenceName)) {
                    conferenceNames.add(conferenceName);
                    nameAssigned = true;
                }
                assignedNames.add(conferenceName);
            }

            if (!nameAssigned) {
                conferenceNames.add(name);
            }
        }

        return conferenceNames;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<String> names = IntStream.range(0, n)
                .mapToObj(i -> scanner.nextLine())
                .collect(Collectors.toList());

        scanner.close();

        List<String> result = assignNames(names);
        result.stream().forEach(System.out::println);
    }
}
