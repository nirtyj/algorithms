package com.leetcode.common;

public class Coordinate {

    public final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static boolean isValidCoordirnate(Coordinate newCoordinates, int[][] maze) {

        return (newCoordinates.x >= 0 && newCoordinates.x < maze.length)
                && (newCoordinates.y >= 0 && newCoordinates.y < maze.length)
                && maze[newCoordinates.x][newCoordinates.y] != 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (x != other.x)
            return false;
        return y == other.y;
    }
}
