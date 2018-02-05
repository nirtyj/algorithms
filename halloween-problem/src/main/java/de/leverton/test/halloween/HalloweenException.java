/* Copyright (c) 2017 Leverton GmbH - all rights reserved
 * Unauthorized reproduction, copying, modification, distribution or 
 * other use of this file via any medium is strictly prohibited.
 *  
 * Proprietary and confidential.
 *  
 * Written by Marc Ewert <marc.ewert@leverton.ai>, 2017-11-01
 */

package de.leverton.test.halloween;

public class HalloweenException extends RuntimeException {

    public HalloweenException(String message) {
        super(message);
    }

    public HalloweenException(String message, Throwable cause) {
        super(message, cause);
    }
}
