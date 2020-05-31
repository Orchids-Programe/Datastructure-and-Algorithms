package hw4_18001154;

public class CalculationOfValue {

	private LinkedlistStack<Character> operators = new LinkedlistStack<Character>();
	private LinkedlistStack<Integer> operands = new LinkedlistStack<Integer>();

	public int calculation(String str) {
		int vt = -1;
		for (int i = 0; i < str.length(); i++) {
			System.out.println("i=" + i + "s = " + str.charAt(i));
			operands.printStack();
			System.out.println("toan tu:");
			operators.printStack();
			if (str.charAt(i) == '+' || str.charAt(i) == '/' || str.charAt(i) == '-' || str.charAt(i) == '*') {
				operators.push(str.charAt(i));
			} else if (str.charAt(i) == ')') {
				int h1 = operands.pop();
				int h2 = operands.pop();
				int h = 0;
				char t = operators.pop();
				if (t == '+') {
					h = h2 + h1;
				}
				if (t == '-') {
					h = h2 - h1;
				}
				if (t == '*') {
					h = h2 * h1;
				}
				if (t == '/') {
					h = h2 / h1;
				}
				operands.push(h);
			} else if (str.charAt(i) != '(') {
				if (vt == -1)
					vt = i;
				if (str.length() == i + 1) {
					int k = (int) Integer.parseInt(str.substring(vt, i + 1));
					operands.push(k);
				} else {
					if ((str.charAt(i + 1) < '0' || str.charAt(i + 1) > '9')) {
						int k = (int) Integer.parseInt(str.substring(vt, i + 1));
						operands.push(k);
						System.out.println("K:" + k);
						vt = -1;

					}

				}

			}
		}
		return operands.pop();
	}

	public boolean check(String str) {
		LinkedlistStack<String> opstacks = new LinkedlistStack<String>();
		// String [] data = str.split("");

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				opstacks.push("(");

			} else if (str.charAt(i) == ')') {
				String s = opstacks.pop();

				if (s == null) {
					return false;
				}
			}
		}

		return opstacks.isEmpty();

	}
}
