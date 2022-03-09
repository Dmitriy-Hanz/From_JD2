package JD2.Kurs_09_03_2022;

import java.util.Comparator;

public class MassComparator implements Comparator<String[]> {

    @Override
    public int compare(String[] o1, String[] o2) {
        for (int i = 0; i < o1.length; i++) {
            try {
                Integer.parseInt(o1[i]);
            } catch (NumberFormatException e){
                return -1;
            }
            try {
                Integer.parseInt(o2[i]);
            } catch (NumberFormatException e){
                return 1;
            }
            if (o1[i].compareTo(o2[i]) != 0) {
                return o1[i].compareTo(o2[i]);
            }
        }
        return 0;
    }
}
