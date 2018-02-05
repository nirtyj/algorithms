/* Copyright (c) 2017 Leverton GmbH - all rights reserved
 * Unauthorized reproduction, copying, modification, distribution or 
 * other use of this file via any medium is strictly prohibited.
 *  
 * Proprietary and confidential.
 *  
 * Written by Marc Ewert <marc.ewert@leverton.ai>, 2017-11-01
 */

package de.leverton.test.halloween;

import de.leverton.test.halloween.model.Step;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Main application for executing the halloween pathfinder.
 */
public class HalloweenApp {

    public static void main(String[] args) {
        String houses = readResource("/houses.json");
        String paths = readResource("/paths.json");
        List<Step> steps = new HalloweenPathFinder(houses, paths).findPerfectRoute("a", 300);
        System.out.println("Perfect route is:\n");
        printSteps(steps);
    }

    private static void printSteps(List<Step> steps) {
        int off = 0;
        for (Step step : steps) {
            if (off++ == 0) {
                System.out.println("Starting from " + step.getTargetId() + ": " + step.getSweetsCollected() + " sweets");
            } else {
                System.out.println("Move to " + step.getTargetId() + ": " + step.getSweetsCollected() + " sweets, " + step.getDistanceTraveled() + " meters");
            }
        }
        System.out.println("Total " + steps.stream().mapToInt(Step::getSweetsCollected).sum() + " sweets, " + steps.stream().mapToDouble(Step::getDistanceTraveled).sum() + " meters");
    }

    private static String readResource(String path) {
        try (InputStream in = HalloweenApp.class.getResourceAsStream(path)) {
            return IOUtils.toString(in, "UTF-8");
        } catch (IOException e) {
            throw new HalloweenException("Failed to read resource: " + path, e);
        }
    }
}
