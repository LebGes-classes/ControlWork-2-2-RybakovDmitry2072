package org.example;

import java.util.Objects;

public class BroadcastsTime implements Comparable<BroadcastsTime> {
    private final byte hour;
    private final byte minute;

    public BroadcastsTime(byte hour, byte minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public byte getHour() {
        return hour;
    }

    public byte getMinute() {
        return minute;
    }

    @Override
    public int compareTo(BroadcastsTime other) {
        if (this.hour != other.hour) {
            return Byte.compare(this.hour, other.hour);
        }
        return Byte.compare(this.minute, other.minute);
    }

    public boolean after(BroadcastsTime t) {
        return this.compareTo(t) > 0;
    }

    public boolean before(BroadcastsTime t) {
        return this.compareTo(t) < 0;
    }

    public boolean between(BroadcastsTime t1, BroadcastsTime t2) {
        return this.after(t1) && this.before(t2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BroadcastsTime that = (BroadcastsTime) o;
        return hour == that.hour && minute == that.minute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }
}