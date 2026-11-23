import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

    String a = reader.readLine();

    char[] charArray = a.toCharArray();
    StringBuilder result = new StringBuilder();

    Map<Integer, String> decoderMap =
        IntStream.rangeClosed(1, 26)
            .boxed()
            .collect(Collectors.toMap(
                i -> i,
                i -> String.valueOf((char) ('a' + i - 1))
            ));

    for (int i = charArray.length - 1; i >= 0; i--) {
      if (charArray[i] == '#') {
        String symbol = decoderMap.get((charArray[i-2] - '0') * 10 + (charArray[i-1] - '0'));
        result.append(symbol);
        i -= 2;
      } else {
        String symbol = decoderMap.get(charArray[i] - '0');
        result.append(symbol);
      }
    }

    writer.write(result.reverse().toString());

    reader.close();
    writer.close();
    }
}