package pmdTest;

/**
 *
 *
 * @author Jon Doe
 */
public class Demo {
	public int sum(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {

		Demo d = new Demo();
		int x = d.sum(2, 3);
		System.out.println(x);
	}

}
