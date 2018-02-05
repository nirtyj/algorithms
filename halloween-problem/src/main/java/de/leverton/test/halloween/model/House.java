package de.leverton.test.halloween.model;

import java.util.ArrayList;
import java.util.List;

public class House {

	private String id;
	private Long numberOfSweets;
	private List<ConnectedHouse> connectedHouses = new ArrayList<>();
	
	public House(String id, Long numberOfSweets) {
		this.id = id;
		this.numberOfSweets = numberOfSweets;
	}

	public String getId() {
		return id;
	}

	public Long getNumberOfSweets() {
		return numberOfSweets;
	}

	public void connectHouse(House h, Long distance) {
		this.connectedHouses.add(new ConnectedHouse(h, distance));
	}

	public List<ConnectedHouse> getConnectedHouses() {
		return connectedHouses;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("House [id=" + id + ", numberOfSweets=" + numberOfSweets + "]\n");
		sb.append("Connected Houses : \n");
		for (ConnectedHouse ch : connectedHouses) {
			sb.append("\t" + ch.getHouse().id + " is at a distance of  - " + ch.getDistance() + " with - " +  ch.getHouse().getNumberOfSweets() + " sweets\n");
		}
		return sb.toString();
	}

}
