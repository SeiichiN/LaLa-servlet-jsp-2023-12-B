package load_static;

public class Main {

	public static void main(String[] args) {
		// MyUtilクラスのstaticメソッドを実行すると、
		// MyUtilクラスがクラスローダによってメモリ上にロードされる。
		int num = MyUtil.random(10);
		// MyUtilクラスのクラス情報を clazzを使って取得できる。
		Class<?> clazz = MyUtil.class;
		// ここではクラスローダを調べている。
		System.out.println(clazz.getClassLoader());
		caseString();
	}
	
	public static void caseString() {
		System.out.println("----- case String -----");
		String hum = "hum";
		Class<?> clazz = hum.getClass();
		System.out.println(clazz.getClassLoader());
	}

}
