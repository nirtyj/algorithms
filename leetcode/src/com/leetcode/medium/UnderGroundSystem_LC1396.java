package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement the UndergroundSystem class:
 *
 * void checkIn(int id, string stationName, int t)
 * A customer with a card id equal to id, gets in the station stationName at time t.
 * A customer can only be checked into one place at a time.
 * void checkOut(int id, string stationName, int t)
 * A customer with a card id equal to id, gets out from the station stationName at time t.
 * double getAverageTime(string startStation, string endStation)
 * Returns the average time to travel between the startStation and the endStation.
 * The average time is computed from all the previous traveling from startStation to endStation that happened directly.
 * Call to getAverageTime is always valid.
 * You can assume all calls to checkIn and checkOut methods are consistent. If a customer gets in at time t1 at some station, they get out at time t2 with t2 > t1. All events happen in chronological order.
 */
public class UnderGroundSystem_LC1396 {
    static class Rider {
        int id;
        String stationName;
        int t;
        Rider(int id, String stationName, int t) {
            this.id = id;
            this.stationName = stationName;
            this.t = t;
        }
    }

    static class StationTime {
        double avg;
        int cnt;
        StationTime(double avg, int cnt) {
            this.avg = avg;
            this.cnt = cnt;
        }
    }

    Map<Integer, Rider> checkedIn;
    Map<String, StationTime> stationTimes;

    public UnderGroundSystem_LC1396() {
        checkedIn = new HashMap<>();
        stationTimes =  new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Rider r = new Rider(id, stationName, t);
        checkedIn.put(id, r);
    }

    public void checkOut(int id, String stationName, int t) {
        Rider r = checkedIn.remove(id);
        int timeTaken = t - r.t;
        String stationToStation = r.stationName + "$$" + stationName;
        StationTime st = stationTimes.getOrDefault(stationToStation, new StationTime(0, 0));
        double newAvg = (st.avg * st.cnt + timeTaken ) / (st.cnt + 1);
        st.avg = newAvg;
        st.cnt = st.cnt + 1;
        stationTimes.put(stationToStation, st);
    }

    public double getAverageTime(String startStation, String endStation) {
        StationTime t  = stationTimes.getOrDefault(startStation + "$$" + endStation, new StationTime(0, 0));
        return t.avg;
    }
}