package model;

public class HealthCheckLogic {
	
	/**
	 * 身長と体重をもとにBMI値と体型を
	 * healthビーンズにセットする
	 * @param health 参照を受け取っているので
	 *   変更したら、即反映される。
	 */
	public void execute(Health health) {
		double weight = health.getWeight();
		double height = health.getHeight() / 100.0;
		double bmi = weight / (height * height);
		health.setBmi(bmi);
		
		String bodyType = null;
		if (bmi < 18.5) {
			bodyType = "痩せ型";
		} else if (bmi < 25.0) {
			bodyType = "普通";
		} else {
			bodyType = "肥満";
		}
		health.setBodyType(bodyType);
		
	}
}
