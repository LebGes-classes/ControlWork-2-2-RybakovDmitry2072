package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProgramReader {
    private static final String fileName="C:/Users/user/Desktop/data.txt";

    public static List<String> readFile()  {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
    public static List<Program> parsePrograms(List<String> lines) {
        List<Program> programs = new ArrayList<>();
        String currentChannel = "";
        BroadcastsTime lastEndTime = null;

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.startsWith("#")) {
                currentChannel = line.substring(1).trim();
            } else if (line.matches("\\d{2}:\\d{2}")) {
                String time = line.trim();
                String[] timeParts = time.split(":");
                byte hour = Byte.parseByte(timeParts[0]);
                byte minute = Byte.parseByte(timeParts[1]);
                BroadcastsTime startTime = new BroadcastsTime(hour, minute);

                if (i + 1 < lines.size() && !lines.get(i + 1).startsWith("#")) {
                    String name = lines.get(++i).trim();
                    if (lastEndTime != null) {
                        programs.add(new Program(currentChannel, lastEndTime, startTime, name));
                    }
                    lastEndTime = startTime;
                }
            }
        }
        return programs;
    }
}
