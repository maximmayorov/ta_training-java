package com.epam.training.student_maksim_mayorov.io.main_task.utils;

import com.epam.training.student_maksim_mayorov.io.main_task.utils.constants.GlobalConstants;

import java.util.ArrayList;
import java.util.List;

public class DirectoryStructureReader {

    private final String fileName;
    private final List<String> folders;
    private final List<String> files;


    public DirectoryStructureReader(String fileName) {
        this.folders = new ArrayList<>();
        this.files = new ArrayList<>();
        this.fileName = fileName;
        processFile();
    }

    private void processFile() {
        List<String> fileLines = FileProcessor.readFile(fileName);
        if (!fileLines.isEmpty()) {
            // Delete root folder
            fileLines.remove(0);
        }
        for (String line: fileLines) {
            line = line.replace(GlobalConstants.FILE_PREFIX, "").trim();
            if (line.equals("")) {
                continue;
            }
            if (line.startsWith(GlobalConstants.FOLDER_PREFIX)) {
                folders.add(line.replace(GlobalConstants.FOLDER_PREFIX, ""));
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
