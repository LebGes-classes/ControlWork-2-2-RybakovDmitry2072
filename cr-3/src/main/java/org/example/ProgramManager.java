package org.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramManager {

    public static void sortProgramsByChannelAndTime(List<Program> programs) {
        programs.sort(Comparator.comparing(Program::getChannel)
                .thenComparing(Program::getStartTime));
    }

    public static List<Program> getCurrentPrograms(List<Program> programs, BroadcastsTime currentTime) {
        return programs.stream()
                .filter(p -> p.getStartTime().before(currentTime) && p.getEndTime().after(currentTime))
                .collect(Collectors.toList());
    }

    public static List<Program> getProgramsByName(List<Program> programs, String name) {
        return programs.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public static List<Program> getCurrentProgramsByChannel(List<Program> programs, String channel, BroadcastsTime currentTime) {
        return programs.stream()
                .filter(p -> p.getChannel().equalsIgnoreCase(channel) &&
                        p.getStartTime().before(currentTime) && p.getEndTime().after(currentTime))
                .collect(Collectors.toList());
    }

    public static List<Program> getProgramsByChannelAndTimeRange(List<Program> programs, String channel, BroadcastsTime start, BroadcastsTime end) {
        return programs.stream()
                .filter(p -> p.getChannel().equalsIgnoreCase(channel) &&
                        p.getStartTime().between(start, end) && p.getEndTime().between(start, end))
                .collect(Collectors.toList());
    }
}
