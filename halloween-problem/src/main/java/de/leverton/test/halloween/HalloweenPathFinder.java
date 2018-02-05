/* Copyright (c) 2017 Leverton GmbH - all rights reserved
 * Unauthorized reproduction, copying, modification, distribution or 
 * other use of this file via any medium is strictly prohibited.
 *  
 * Proprietary and confidential.
 *  
 * Written by Marc Ewert <marc.ewert@leverton.ai>, 2017-11-01
 */

package de.leverton.test.halloween;

import de.leverton.test.halloween.model.ConnectedHouse;
import de.leverton.test.halloween.model.House;
import de.leverton.test.halloween.model.Step;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Finds a solution for the problem described in README.md.
 */
class HalloweenPathFinder {

	private Map<String, House> houses = new HashMap<String, House>();
	
	private Long maxSweets = Long.MIN_VALUE;
	private Long minDistance = Long.MAX_VALUE;
	private ArrayList<Step> finalResult = new ArrayList<Step>();
	private HashSet<String> visitedHouses = new HashSet<String>();

    /**
     * Creates a new instance of the problem solver. Please don't change the parameter list.
     * @param housesJson JSON containing the houses of the problem. See src/main/resources/houses.json for an example.
     * @param pathsJson JSON containing the paths between the houses. See src/main/resources/paths.json for an example.
     * @throws ParseException 
     */
	HalloweenPathFinder(String housesJson, String pathsJson) {
		JSONParser parser = new JSONParser();
		try {
			JSONArray housesJsonArray = (JSONArray) parser.parse(housesJson);
			for (int i = 0; i < housesJsonArray.size(); i++) {
				JSONObject obj = (JSONObject) housesJsonArray.get(i);
				House h = new House((String) obj.get("id"), (Long) obj.get("sweets"));
				houses.put(h.getId(), h);
			}
			JSONArray pathsJsonArray = (JSONArray) parser.parse(pathsJson);
			for (int i = 0; i < pathsJsonArray.size(); i++) {
				JSONObject obj = (JSONObject) pathsJsonArray.get(i);
				House leftHouse = houses.get((String) obj.get("leftId"));
				House rightHouse = houses.get((String) obj.get("rightId"));
				Long distance = (long) obj.get("distance");
				leftHouse.connectHouse(rightHouse, distance);
				rightHouse.connectHouse(leftHouse, distance);
			}
		} catch (Exception e) {
			throw new HalloweenException(e.getLocalizedMessage());
		}
		printHouses();
	}

	private void printHouses() {
		for (House h : houses.values()) {
			System.out.println(h.toString());
		}
	}

    /**
     * Actually returns the solution for the given starting point and maximal distance to walk.
     * Please don't change the parameter list.
     * @param originId Defines the house to start the walk.
     * @param maxDistance Maximal distance in meters to walk.
     * @return Returns the steps to walk, for getting the most sweets in the shortest distance.
     */
	List<Step> findPerfectRoute(String originId, double maxDistance) {
		if (!houses.containsKey(originId)) {
			return Collections.emptyList();
		} else {
			maxSweets = Long.MIN_VALUE;
			minDistance = Long.MAX_VALUE;
			visitedHouses.clear();

			House h = houses.get(originId);
			visitedHouses.add(h.getId());

			Step s = new Step(h.getId(), 0, h.getNumberOfSweets().intValue());
			List<Step> tempResult = new ArrayList<Step>();
			tempResult.add(s);

			finalResult = new ArrayList<>(tempResult);
			findPerfectRouteHelper(originId, h, 0, maxDistance, h.getNumberOfSweets(), tempResult);
			return finalResult;
		}
	}

	private void findPerfectRouteHelper(String originId, House h, long currentDistance, double maxDistance, long currentSweets,
			List<Step> result) {

		for (ConnectedHouse ch : h.getConnectedHouses()) {
			long nextDistance = ch.getDistance() + currentDistance;
			// base condition to end the infinite loop. stop recursion if the current exceeds max
			if (nextDistance > maxDistance) {
				continue;
			}

			if (visitedHouses.contains(ch.getHouse().getId())) {
				// if its visited, the sweets collected is 0. So, Stays at current currSweets
				Step s = new Step(ch.getHouse().getId(), ch.getDistance(), 0);
				result.add(s);
				
				// everytime you see max sweets, update the max sweet and reset the minDistance to the max possible
				if (currentSweets > maxSweets && originId.equals(ch.getHouse().getId())) {
					maxSweets = currentSweets;
					finalResult = new ArrayList<>(result);
					minDistance = Long.MAX_VALUE;
				} else if (currentSweets == maxSweets && originId.equals(ch.getHouse().getId()) && nextDistance < minDistance) {
					// this is when you hit the maxSweets, but see a path with minDistance than the current one 
					minDistance = nextDistance;
					finalResult = new ArrayList<>(result);
				}

				findPerfectRouteHelper(originId, ch.getHouse(), nextDistance, maxDistance, currentSweets, result);
				result.remove(result.size() - 1);
			} else {
				Step s = new Step(ch.getHouse().getId(), ch.getDistance(),
						ch.getHouse().getNumberOfSweets().intValue());
				result.add(s);
				visitedHouses.add(ch.getHouse().getId());
				// visiting a new house. increase the sweet count
				long nextSweets = currentSweets + ch.getHouse().getNumberOfSweets();

				// everytime you see max sweets, update the max sweet and reset the minDistance to the max possible
				if (nextSweets > maxSweets && originId.equals(ch.getHouse().getId())) {
					maxSweets = nextSweets;
					finalResult = new ArrayList<>(result);
					minDistance = Long.MAX_VALUE;
				} else if (nextSweets == maxSweets && originId.equals(ch.getHouse().getId()) && nextDistance < minDistance) {
					// this is when you hit the maxSweets, but see a path with minDistance than the current one 
					minDistance = nextDistance;
					finalResult = new ArrayList<>(result);
				}

				findPerfectRouteHelper(originId, ch.getHouse(), nextDistance, maxDistance, nextSweets, result);
				visitedHouses.remove(ch.getHouse().getId());
				result.remove(result.size() - 1);
			}
		}
	}
}
