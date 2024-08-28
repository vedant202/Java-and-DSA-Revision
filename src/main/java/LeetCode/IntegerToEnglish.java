package LeetCode;

public class IntegerToEnglish {
	public static void main(String[] args) {
		String[] ones = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		String[] tens = { "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
				"nineteen" };
		String[] tensMulti = { "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "nintey" };
		String[] hundreds = { "one hundred", "two hundred", "three hundred", "four hundred", "five hundred",
				"six hundred", "seven hundred", "eight hundred", "nine hundred" };
		String thoudand = "thousand";
		String tenThoudand = "ten thousand";
		String lakh = "lakh";
//		String tenLakh = "ten lakh";

		int no = 88_00_00_000;
//		int no = 2441;
		StringBuilder sb = new StringBuilder();

		int temp = no;

		while (temp > 0) {

			if (temp % 10 == 0 && temp <= 100) {

				sb.append(tensMulti[(temp / 10) - 1]);
				break;
			}

			if ((temp / 10) == 0) {
				sb.append(ones[temp - 1]);
				temp = temp / 10;
				break;
			} else if ((temp % 10) < 10 && temp < 20) {
//				System.out.println(tens[(temp % 10 - 1)]);
				sb.append(tens[(temp % 10) - 1]);
				temp = temp / 10;
				break;
			} else if (temp / 10 > 1 && temp / 10 < 10 && temp < 100) {
				int rem = temp / 10;
				sb.append(tensMulti[rem - 1]);
				temp = temp % 10;
			} else if (temp / 100 < 10) {
				sb.append(hundreds[temp / 100 - 1]);
				temp = temp % 100;
			} else if (temp % 1000 < 1000 && temp < 10000) {
				sb.append(ones[temp / 1000 - 1]);
				sb.append(" thousand ");
				temp = temp % 1000;
			} else if (temp > 9999 && temp < 100000) {
				// ten thousand
				if (temp / 1000 > 10 && temp / 1000 < 20) {
					int t = temp / 1000;
					sb.append(tens[t % 10 - 1]);
					temp = temp % 1000;

				} else {
					sb.append(tensMulti[temp / 10000 - 1]);
					temp = temp % 10000;
				}

				if (temp < 1000) {
					sb.append(" thousand ");
				}
			} else if (temp > 99999 && temp < 1000000) {
				// lakh
				sb.append(ones[temp / 100000 - 1]);
				sb.append(" lakh ");
				temp = temp % 100000;

			} else if (temp > 999999 && temp < 1_00_00_000) {
				// ten lakh
				if (temp / 100000 > 10 && temp / 100000 < 20) {
					int t = temp / 100000;
					sb.append(tens[t % 10 - 1]);
					temp = temp % 100000;

				} else {
					sb.append(tensMulti[temp / 10_00_000 - 1]);
					temp = temp % 1000000;
				}

				if (temp < 100000) {
					sb.append(" lakh ");
				}
			} else if (temp > 99_99_999 && temp < 10_00_00_000) {
				// Crore
				sb.append(ones[temp / 1_00_00_000 - 1]);
				sb.append(" Crore ");
				temp = temp % 1_00_00_000;

			} else if (temp > 9_99_99_999 && temp < 100_00_00_000) {
				// ten crore
				if (temp / 1_00_00_000 > 10 && temp / 1_00_00_000 < 20) {
					int t = temp / 1_00_00_000;
					sb.append(tens[t % 10 - 1]);
					temp = temp % 1_00_00_000;

				} else {
					sb.append(tensMulti[temp / 10_00_00_000 - 1]);
					temp = temp % 10_00_00_000;
				}

				if (temp < 1_00_00_000) {
					sb.append(" Crore ");
				}
			}

			if (temp > 0) {
				sb.append(" ");
			}
		}

		System.out.println(sb.toString());

	}
}
