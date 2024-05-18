package org.example;

public class Program {
    private final String channel;
    private final BroadcastsTime startTime;
    private final BroadcastsTime endTime;
    private final String name;

    public Program(String channel, BroadcastsTime startTime, BroadcastsTime endTime, String name) {
        this.channel = channel;
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
    }

    public String getChannel() {
        return channel;
    }

    public BroadcastsTime getStartTime() {
        return startTime;
    }

    public BroadcastsTime getEndTime() {
        return endTime;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %s-%s %s", channel, startTime, endTime, name);
    }
}
