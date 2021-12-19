package com.epam.training.student_maksim_mayorov.io.main_task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTreeReader {

    public static final String FOLDER_PREFIX = "-----";
    private String fileName;
    private List<String> folders;
    private List<String> files;


    public FileTreeReader(String fileName) {
        this.folders = new ArrayList<>();
        this.files = new ArrayList<>();
        this.fileName = fileName;
        processFile();
    }

    private List<String> readFile() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private void processFile() {
        List<String> fileLines = readFile();
        if (!fileLines.isEmpty()) {
            fileLines.remove(0);
        }
        for (String line: fileLines) {
            line = line.replace("|", "").trim();
            if (line.equals("")) {
                continue;
            }
            if (line.startsWith(FOLDER_PREFIX)) {
                folders.add(line.replace(FOLDER_PREFIX, ""));
            } else {
                files.add(line);
            }
        }
    }

    public int getNumberOfFolders() {
        return folders.size();
    }

    public int getNumberOfFiles() {
        return files.size();
    }

    public double getAverageFileNameLength() {
        int sum = 0;
        for (String file: files) {
            sum += file.length();
        }
        return sum / (double) files.size();
    }

    public double getAverageNumberFilesInFolder() {
        return files.size() / (double) folders.size();
    }

}
