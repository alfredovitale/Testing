package de.vitale.bmiapp;

import java.util.Comparator;
import java.util.List;

public class BMICalculator {
	
	private static final double BMI_THRESHOLD = 25.0;

	public static boolean isDietRecommended(double weight, double height) {
		if (height == 0.0) throw new ArithmeticException();
		double bmi = weight / (height * height);
		if (bmi < BMI_THRESHOLD)
			return false;
		return true;
	}

	public static User findUserWithWorstBMI(List<User> users) {
		return users.stream().sorted(Comparator.comparing(BMICalculator::calculateBMI))
				.reduce((first, second) -> second).orElse(null);
	}
	
	// akzeptiert eine Liste von Usern und gibt BMI-Scores als Array aus
	
	public static double[] getBMIScores(List<User> users) {
		double[] bmiScores = new double[users.size()];
		for (int i = 0; i < bmiScores.length; i++) {
			bmiScores[i] = BMICalculator.calculateBMI(users.get(i));
		}
		return bmiScores;
	}

	private static double calculateBMI(User user) {
		double height = user.getHeight();
		double weight = user.getWeight();
		if (height == 0.0)
			throw new ArithmeticException();
		double bmi = weight / (height * height);
		return Math.round(bmi * 100) / 100.0;
	}

}
