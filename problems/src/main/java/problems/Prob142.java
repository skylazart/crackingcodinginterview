package problems;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.*;

/**
 * Created by fsantos on 2/8/17.
 */
public class Prob142 {
    public static class MyFile implements Comparable<MyFile> {
        private final String fileName;
        private final int size;
        private static final DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-mm-dd");
        private final DateTime creationDateTime;


        public MyFile(String fileName, int size, DateTime creationDateTime) {
            this.fileName = fileName;
            this.size = size;
            this.creationDateTime = creationDateTime;
        }

        @Override
        public int compareTo(MyFile o) {
            return fileName.compareTo(o.fileName);
        }

        public String getFileName() {
            return fileName;
        }

        public int getSize() {
            return size;
        }

        public DateTime getCreationDateTime() {
            return creationDateTime;
        }

        @Override
        public String toString() {
            return "MyFile{" +
                    "fileName='" + fileName + '\'' +
                    ", size=" + size +
                    ", creationDateTime=" + getCreationDateTime().toString(fmt) +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<MyFile> list = new ArrayList<>();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-mm-dd");

        list.add(new MyFile("test1", 2, DateTime.parse("2017-02-08", fmt)));
        list.add(new MyFile("test1", 1, DateTime.parse("2016-02-08", fmt)));
        list.add(new MyFile("test1", 500, DateTime.parse("2016-02-08", fmt)));

        Collections.sort(list, new Comparator<MyFile>() {
            @Override
            public int compare(MyFile o1, MyFile o2) {
                int cmp = o1.getCreationDateTime().compareTo(o2.getCreationDateTime());
                if (cmp != 0)
                    return cmp;

                return o2.getSize() - o1.getSize();
            }
        });

        for (MyFile x: list) {
            System.out.println(x);
        }
    }
}
