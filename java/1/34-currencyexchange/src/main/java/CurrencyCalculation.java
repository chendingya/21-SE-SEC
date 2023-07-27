import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CurrencyCalculation {

	public static void main(String[] args) {
		double euros = 0;
		double rate = 0;
		double dollar = 0;
		String temp = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(" How many euros are you exchanging?");
			temp = br.readLine();
			euros = Double.parseDouble(temp);
			System.out.println(" What is the exchange rate?");
			temp = br.readLine();
			rate = Double.parseDouble(temp);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		dollar = euros / 100 * rate;
		System.out.println(String.format("%.2f", euros) + " euros at an exchange rate of " + String.format("%.2f", rate) + " is " + String.format("%.2f", dollar) + " U.S. dollars.");

	}

}
