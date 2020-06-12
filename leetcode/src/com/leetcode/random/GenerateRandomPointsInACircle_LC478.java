package com.leetcode.random;

import java.util.Random;

/**
 * Given the radius and x-y positions of the center of a circle,
 * write a function randPoint which generates a uniform random point in the circle.
 *
 * Note:
 *
 * input and output values are in floating-point.
 * radius and x-y position of the center of the circle is passed into the class constructor.
 * a point on the circumference of the circle is considered to be in the circle.
 * randPoint returns a size 2 array containing x-position and y-position of the random point, in that order.
 * Example 1:
 *
 * Input:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[1,0,0],[],[],[]]
 * Output: [null,[-0.72939,-0.65505],[-0.78502,-0.28626],[-0.83119,-0.19803]]
 * Example 2:
 *
 * Input:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[10,5,-7.5],[],[],[]]
 * Output: [null,[11.52438,-8.33273],[2.46992,-16.21705],[11.13430,-12.42337]]
 */
public class GenerateRandomPointsInACircle_LC478 {

    double r;
    double x;
    double y;
    Random rand = new Random();

    public GenerateRandomPointsInACircle_LC478(double radius, double x_center, double y_center) {
        this.r = radius;
        this.x = x_center;
        this.y = y_center;
    }

    public double[] randPoint() {
        // https://leetcode.com/problems/generate-random-point-in-a-circle/discuss/155650/Explanation-with-Graphs-why-using-Math.sqrt()
        double newR = r * Math.sqrt(rand.nextDouble()); // the effect or radius multiplied will make it not randomly distributed. hence sqrt to get it multipied to get the same effect
        double newAngle = 360 * rand.nextDouble();
        double radians = Math.toRadians(newAngle);
        return new double[] { x + (newR * Math.cos(radians)), y + (newR * Math.sin(radians))};
    }
}
