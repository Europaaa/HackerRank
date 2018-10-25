import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

// Link: https://www.hackerrank.com/challenges/frequency-queries/problem
public class FreqQuery {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<int[]> queries) {
        Map<Integer, Long> numbers = new HashMap<>();
        Map<Long, Set<Integer>> frequencies = new HashMap<>();

        List<Integer> results = new ArrayList<>();
        for (int[] query : queries) {
            Integer type = query[0];
            Integer number = query[1];

            switch (type) {
                case 1:
                    Long frequency = numbers.getOrDefault(number, 0l);
                    numbers.put(number, frequency + 1);

                    frequencies.getOrDefault(frequency, new HashSet<>()).remove(number);

                    Set<Integer> fNumbers = frequencies.getOrDefault(frequency + 1, new HashSet<>());
                    fNumbers.add(number);
                    frequencies.put(frequency + 1, fNumbers);

                    break;
                case 2:
                    frequency = numbers.getOrDefault(number, 0l);
                    if (frequency == 0) {
                        break;
                    }

                    numbers.put(number, frequency - 1);

                    frequencies.getOrDefault(frequency, new HashSet<>()).remove(number);

                    fNumbers = frequencies.getOrDefault(frequency - 1, new HashSet<>());
                    fNumbers.add(number);
                    frequencies.put(frequency - 1, fNumbers);

                    break;
                default:
                    fNumbers = frequencies.getOrDefault(Long.valueOf(number), new HashSet<>());
                    results.add(fNumbers.isEmpty() ? 0 : 1);

                    break;
            }
        }
        return results;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<int[]> queries = new ArrayList<>();

        Pattern p = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
        IntStream.range(0, q).forEach(i -> {
            int[] query = new int[2];
            try {
                Matcher m = p.matcher(bufferedReader.readLine());
                if (m.matches()) {
                    query[0] = Integer.parseInt(m.group(1));
                    query[1] = Integer.parseInt(m.group(2));
                    queries.add(query);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
