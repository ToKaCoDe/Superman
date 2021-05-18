package com.nortal.clark.training.assignment.controller;

public class BrakeDistance {

	public static final double WATER_DRAG_THRESHOLD = 1.6;

	public static final int FRAME_SIZE_MILLIS = 500;

	public double calculateBrakeDistance(double currentSpeed) {

		double brakeDistance = 0;
		double brakeLastDisplacement = 0;

		while (currentSpeed > 0) {
			brakeLastDisplacement = calculateDisplacementWithDrag(currentSpeed);
			brakeDistance = brakeDistance + brakeLastDisplacement;
			currentSpeed = calculateNewSpeedWithDrag(currentSpeed);
		}

		return brakeDistance + brakeLastDisplacement;
	}

	public double calculateNewSpeedWithDrag(double currentSpeed) {

		double timeSpentSeconds = FRAME_SIZE_MILLIS / 1000.0;
		double dragAcceleration = getDragAcceleration(currentSpeed);
		double newSpeed = calculateNewSpeed(currentSpeed, dragAcceleration, timeSpentSeconds);

		// compensate overshooting. Drag does not make Clark to change direction
		if (currentSpeed == 0 || (currentSpeed < 0 && newSpeed > 0) || (currentSpeed > 0 && newSpeed < 0)) {
			newSpeed = 0;
		}

		return newSpeed;
	}

	double calculateNewSpeed(double currentSpeed, double acceleration, double timeSpentSeconds) {
		return currentSpeed + acceleration * timeSpentSeconds;
	}

	public double calculateDisplacementWithDrag(double currentSpeed) {

		double timeSpentSeconds = FRAME_SIZE_MILLIS / 1000.0;
		double dragAcceleration = getDragAcceleration(currentSpeed);
		double displacement = calculateDisplacement(currentSpeed, dragAcceleration, timeSpentSeconds);

		// compensate overshooting. Drag does not make Clark to change direction
		if (currentSpeed == 0 || (currentSpeed < 0 && displacement > 0) || (currentSpeed > 0 && displacement < 0)) {
			displacement = 0;
		}

		return displacement;
	}

	private double getDragAcceleration(double currentSpeed) {
		// 0 if currentSpeed = 0
		double dragDirectionalModifier = -Math.signum(currentSpeed);
		//
		// Clark's maximum speed is x²
		double waterDrag = WATER_DRAG_THRESHOLD + (Math.pow(currentSpeed, 2) / 200);
		return dragDirectionalModifier * waterDrag;
	}

	private double calculateDisplacement(double currentSpeed, double acceleration, double timeSpentSeconds) {
		double exactDisplacement = currentSpeed * timeSpentSeconds
				+ 1.0 / 2.0 * acceleration * Math.pow(timeSpentSeconds, 2);
		return (double) Math.round(exactDisplacement * 100) / 100;

	}

}
