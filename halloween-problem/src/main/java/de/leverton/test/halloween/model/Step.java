/* Copyright (c) 2017 Leverton GmbH - all rights reserved
 * Unauthorized reproduction, copying, modification, distribution or 
 * other use of this file via any medium is strictly prohibited.
 *  
 * Proprietary and confidential.
 *  
 * Written by Marc Ewert <marc.ewert@leverton.ai>, 2017-11-02
 */

package de.leverton.test.halloween.model;

public class Step {

    private final String targetId;
    private final double distanceTraveled;
    private final int sweetsCollected;

    public Step(String targetId, double distanceTraveled, int sweetsCollected) {
        this.targetId = targetId;
        this.distanceTraveled = distanceTraveled;
        this.sweetsCollected = sweetsCollected;
    }

    public String getTargetId() {
        return targetId;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public int getSweetsCollected() {
        return sweetsCollected;
    }
}
