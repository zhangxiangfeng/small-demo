import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LinuxCommandTest {
    public static void main(String args[]) throws IOException {
        Process process = Runtime.getRuntime().exec(args);

        InputStream fis = process.getInputStream();

        InputStreamReader isr = new InputStreamReader(fis);

        BufferedReader br = new BufferedReader(isr);
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}