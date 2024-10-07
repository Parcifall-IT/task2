package practice2;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task5 implements Task {
    private final String firstDir;
    private final String secondDir;
    private final String resultDir;
    private final Character mode;

    public Task5(String firstDir, String secondDir, String resultDir, Character mode) {
        this.firstDir = firstDir;
        this.secondDir = secondDir;
        this.resultDir = resultDir;
        this.mode = mode;
    }

    @Override
    public void Start() {
        try {
            System.out.println("Start synchronization");
            List<File> filesA = Arrays.asList(new File(firstDir).listFiles());
            List<File> filesB = Arrays.asList(new File(secondDir).listFiles());
            List<String> similar = new ArrayList<>();

            for (File file1 : filesA) {
                for (File file2 : filesB) {
                    if (file1.getName().equals(file2.getName())) {
                        similar.add(file1.getName());
                    }
                }
            }

            if (similar.isEmpty())
                System.out.println("The same names not found");
            else
                System.out.println("The same names were found");

            for (File file : filesA) {
                if (similar.contains(file.getName()) && mode == 's')
                    continue;
                StringBuilder data = ReadFile(file);
                CreateAndWriteFile(file.getName(), data);
            }

            for (File file : filesB) {
                if (similar.contains(file.getName()) && mode == 'f')
                    continue;
                StringBuilder data = ReadFile(file);
                CreateAndWriteFile(file.getName(), data);
            }
            System.out.println("Synchronization is finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private StringBuilder ReadFile(File file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        StringBuilder builder = new StringBuilder();
        byte[] buffer = new byte[1024];
        int bytesRead;
        System.out.println("Read file " + file);
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            builder.append(new String(buffer, 0, bytesRead));
        }
        inputStream.close();
        return builder;
    }

    private void CreateAndWriteFile(String name, StringBuilder data) throws IOException {
        File myFile = new File(String.format("%s/%s", resultDir, name));
        System.out.println("Create file " + myFile);
        myFile.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(myFile);
        byte[] buffer = data.toString().getBytes();
        System.out.println("Write file " + myFile);
        outputStream.write(buffer);
        outputStream.close();
    }

    @Override
    public void Stop() {
        System.exit(0);
    }
}

interface Task {
    void Start();

    void Stop();
}