package de.vitale.bmiapp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class BMICalculatorTest {

	@Test
	void should_ReturnTrue_When_DietRecommended() {
		
		// given
		double weight = 89.0;
		double height = 1.72;
		// when
		boolean recommended = BMICalculator.isDietRecommended(weight, height);
		// then 
		assertTrue(recommended);
	}
	
	@Test
	void should_ReturnFalse_When_DietNotRecommended() {
		
		// given
		double weight = 50.0;
		double height = 1.92;
		// when
		boolean recommended = BMICalculator.isDietRecommended(weight, height);
		// then 
		assertFalse(recommended);
	}
	
	@Test
	void should_ThrowArithmeticException_When_HeightZero() {
		
		// given
		double weight = 50.0;
		double height = 0.0;
		
		// when
		Executable executable = () -> BMICalculator.isDietRecommended(weight, height);
		
		// then 
		assertThrows(ArithmeticException.class, executable);
	}
	
	@Test
	void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty() {
		
		// given
		List<User> coders = new ArrayList<>();
		coders.add(new User(1.80, 60.0));
		coders.add(new User(1.82, 98.0));
		coders.add(new User(1.82, 64.7));
		
		// when
		User coderWorstBMI = BMICalculator.findUserWithWorstBMI(coders);
		
		// then
		assertAll (
			() -> assertEquals(1.82, coderWorstBMI.getHeight()),
			() -> assertEquals(98.0, coderWorstBMI.getWeight())				
		);
	}
	
	@Test
	void should_ReturnNullWorstBMICoder_When_CoderListEmpty() {
		
		// given
		List<User> coders = new ArrayList<>();
		
		
		// when
		User coderWorstBMI = BMICalculator.findUserWithWorstBMI(coders);
		
		// then
		assertNull(coderWorstBMI);
	}
	
	@Test
	void should_ReturnCorrectBMIScoreArray_When_CoderListNotEmpty() {
		
		// given
		List<User> coders = new ArrayList<>();
		coders.add(new User(1.80, 60.0));
		coders.add(new User(1.82, 98.0));
		coders.add(new User(1.82, 64.7));
		double[] expected = {18.52, 29.59, 19.53};
		
		// when
		double[] bmiScores = BMICalculator.getBMIScores(coders);
		
		// then
		assertArrayEquals(expected, bmiScores);
	}

}
