import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

	public static final String MILLIARD = "milliard";

	public static final int[] STEPS = { 10, 100, 1000, 10000, 100000, 1000000, 5000000, 10000000, 50000000, 100000000 };

	public static void main(String[] args) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get("./resources/xaa")));
		for (int step : STEPS) {
			BufferedWriter writer = new BufferedWriter(new FileWriter("./resources/" + step + ".digt"));
			writer.write(content.substring(0, step));

			writer.close();
		}
	}

}
