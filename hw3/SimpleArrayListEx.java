package hw3;

public class SimpleArrayListEx {
	static SimpleArrayList<String> computer = new SimpleArrayList<String>();
	public static void main(String[] args) {
		String[] computerList = {"IBM", "Dell", "Asus","Vaio","Mac","Lenovo"};
		
		for(String x: computerList) computer.add(x);
		printComputer();
	}
	private static void printComputer() {
		System.out.println("There are "+computer.size()+" computers :");
		for(int j = 0; j < computer.size(); j++) {
			System.out.println(computer.get(j) + " ");
			System.out.println();
		}
	}
}
