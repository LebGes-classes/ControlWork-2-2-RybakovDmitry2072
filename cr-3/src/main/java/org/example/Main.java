package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Program> programs = ProgramReader.parsePrograms(ProgramReader.readFile()) ;

        // Сортировка по каналу и времени
        ProgramManager.sortProgramsByChannelAndTime(programs);
        System.out.println("Отсортированные программы:");
        programs.forEach(System.out::println);

        // Получение текущих программ
        BroadcastsTime currentTime = new BroadcastsTime((byte) 14, (byte) 30);
        List<Program> currentPrograms = ProgramManager.getCurrentPrograms(programs, currentTime);
        System.out.println("Текущие программы:");
        currentPrograms.forEach(System.out::println);

        // Программы по названию
        String searchName = "ПОДКАСТ.ЛАБ. Психика";
        List<Program> programsByName = ProgramManager.getProgramsByName(programs, searchName);
        System.out.println("Программы по названию:");
        programsByName.forEach(System.out::println);

        // Текущие программы на определенном канале
        String channel = "Первый";
        List<Program> currentProgramsByChannel = ProgramManager.getCurrentProgramsByChannel(programs, channel, currentTime);
        System.out.println("Текущие программы на канале:");
        currentProgramsByChannel.forEach(System.out::println);

        // Программы на определенном канале в промежутке времени
        BroadcastsTime start = new BroadcastsTime((byte) 10, (byte) 0);
        BroadcastsTime end = new BroadcastsTime((byte) 15, (byte) 0);
        List<Program> programsByChannelAndTimeRange = ProgramManager.getProgramsByChannelAndTimeRange(programs, channel, start, end);
        System.out.println("Программы на канале в заданном временном диапазоне:");
        programsByChannelAndTimeRange.forEach(System.out::println);

        // Сохранение в Excel
        ExcelWriter.writeProgramsToExcel(programs, "programs.xlsx");
    }
}
