package de.leverton.test.halloween.model;

public class ConnectedHouse {

	private House house;
	private Long distance;

	public ConnectedHouse(House house, Long distance) {
		super();
		this.house = house;
		this.distance = distance;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Long getDistance() {
		return distance;
	}

	public void setDistance(Long distance) {
		this.distance = distance;
	}

}
