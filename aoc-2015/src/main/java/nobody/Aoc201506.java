package nobody;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Aoc201506 {

    public static void main(String[] args) throws IOException {
        int[][] grid = new int[1000][1000];
        var str = new String(Files.readAllBytes(Paths.get("aoc-2015/gridcord.txt")));
        String[] lines = str.split("\\n");

        // Initialize the grid
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                grid[i][j] = 0;
            }
        }

        for (String line : lines) {
            String command;
            String[] start;
            String[] end;

            if (line.contains("turn on")) {
                String[] parts = line.split("turn on");
                command = "turn on";
                String[] coordinates = parts[1].trim().split(" through ");
                start = coordinates[0].split(",");
                end = coordinates[1].split(",");
            } else if (line.contains("turn off")) {
                String[] parts = line.split("turn off");
                command = "turn off";
                String[] coordinates = parts[1].trim().split(" through ");
                start = coordinates[0].split(",");
                end = coordinates[1].split(",");
            } else { // toggle
                String[] parts = line.split("toggle");
                command = "toggle";
                String[] coordinates = parts[1].trim().split(" through ");
                start = coordinates[0].split(",");
                end = coordinates[1].split(",");
            }

            System.out.println("Command: " + command);
            System.out.println("Start: (" + start[0] + ", " + start[1] + ")");
            System.out.println("End: (" + end[0] + ", " + end[1] + ")");
            System.out.println();

            // Change values from start to end
            for (int i = Integer.parseInt(start[0]); i <= Integer.parseInt(end[0]); i++) {
                for (int j = Integer.parseInt(start[1]); j <= Integer.parseInt(end[1]); j++) {
                    switch (command) {
                        case "toggle":
                            grid[i][j] = grid[i][j] == 0 ? 1 : 0; // Toggle the value
                            break;
                        case "turn on":
                            grid[i][j] = 1; // Turn on the light
                            break;
                        case "turn off":
                            grid[i][j] = 0; // Turn off the light
                            break;
                        default:
                            System.out.println("Invalid command");
                            break;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        System.out.println("Lights On in the grid: " + count);


        // Print the grid
/*        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }*/


    }
}
