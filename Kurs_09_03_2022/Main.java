package JD2.Kurs_09_03_2022;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File f = new File("src/JD2/Kurs_09_03_2022/in.txt");
        List<String[]> list = ReadFile(f);
        list.sort(new MassComparator());
        File fOut = new File("src/JD2/Kurs_09_03_2022/out.txt");
        WriteFile(fOut, list);

    }

    public static List<String[]> ReadFile(File file) {
        FileReader fr;
        BufferedReader br;
        List<String[]> list = new LinkedList<String[]>();
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            while (br.ready()) {
                list.add(br.readLine().split(" "));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void WriteFile(File file, List<String[]> list) {
        FileWriter fw;
        BufferedWriter bf;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            bf = new BufferedWriter(fw);
            for (int i = 0; i < list.size(); i++) {
                String s = Arrays.stream(list.get(i)).reduce((p1,p2) -> p1 + " " + p2).get();
                bf.write(s + "\n");
            }
            bf.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



