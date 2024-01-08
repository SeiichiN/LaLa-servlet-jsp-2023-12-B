package load_static;

public class Main {

	public static void main(String[] args) {
		int num = MyUtil.random(10);
		Class<?> clazz = MyUtil.class;
		System.out.println(clazz.getClassLoader());
	}

}
