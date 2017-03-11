package problems;

import java.util.*;

/**
 * Created by fsantos on 3/7/17.
 */
public class Prob174 {
    public static class TopSong {
        private Map<String, String> topSongPlayedByBandName = new HashMap<>();
        private Map<String, Map<String, Integer>> frequencyPlayedByBandName = new HashMap<>();
        private Map<String, Integer> topMaxByBandName = new HashMap<>();

        public TopSong() {

        }

        public void play(String bandName, String songName) {
            Map<String, Integer> bySongName = frequencyPlayedByBandName.get(bandName);
            if (bySongName == null) {
                bySongName = new HashMap<>();
                bySongName.put(songName, 1);
                frequencyPlayedByBandName.put(bandName, bySongName);
                topMaxByBandName.put(bandName, 1);
                topSongPlayedByBandName.put(bandName, songName);
            } else {
                Integer c = bySongName.get(songName);
                if (c == null) {
                    c = 1;
                } else {
                    c++;
                }

                bySongName.put(songName, c);

                Integer top = topMaxByBandName.get(bandName);
                if (c.compareTo(top) > 0) {
                    topMaxByBandName.put(bandName, c);
                    topSongPlayedByBandName.put(bandName, songName);
                }
            }
        }

        public String topSong(String bandName) {
            return topSongPlayedByBandName.get(bandName);
        }
    }

    public static void main(String[] args) {
        TopSong topSong = new TopSong();
        topSong.play("Lady Gaga", "Treasure");
        topSong.play("System of a Down", "Radio");
        topSong.play("System of a Down", "Radio");

        System.out.println(topSong.topSong("Lady Gaga"));
        System.out.println(topSong.topSong("System of a Down"));

        topSong.play("Lady Gaga", "Pokerface");
        topSong.play("Lady Gaga", "Pokerface");

        System.out.println(topSong.topSong("Lady Gaga"));
        System.out.println(topSong.topSong("System of a Down"));
    }
}
