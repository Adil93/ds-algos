package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
You are on a flight and wanna watch two movies during this flight.
You are given List<Integer> movieDurations which includes all the movie durations.
You are also given the duration of the flight which is d in minutes.
Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min).

Find the pair of movies with the longest total duration and return their indexes. If multiple found, return the pair with the longest movie.
*/
public class MovieDuration {

    public static void main(String[] argsu) {
        int[] movie_duration1 = { 90, 85, 75, 60, 120, 150, 125 };
        int d1 = 250;
        int[] movie_duration2 = { 90, 85, 75, 60, 155, 150, 125 };
        int d2 = 250;
        int[] movie_duration3 = { 90, 85, 75, 60, 120, 110, 110, 150, 125 };
        int d3 = 250;
        System.out.println(Arrays.toString(get2SumClosest(movie_duration1, d1)));
        System.out.println(Arrays.toString(get2SumClosest(movie_duration2, d2)));
        System.out.println(Arrays.toString(get2SumClosest(movie_duration3, d3)));
    }

    private static int[] get2SumClosest(int[] movieDuration, int d) {

        if (movieDuration == null || movieDuration.length == 0)
            return new int[0];

        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        int maxTime = d - 30;
        int len = movieDuration.length;

        for (int i = 0; i < len; i++) {
            indexMap.putIfAbsent(movieDuration[i], new ArrayList<Integer>());
            indexMap.get(movieDuration[i]).add(i);
        }

        Arrays.sort(movieDuration);

        int low = 0, high = len - 1;

        int maxSoFar = Integer.MIN_VALUE;
        int[] result = new int[2];

        while (low <= high) {

            int tempMax = movieDuration[low] + movieDuration[high];
            if ((tempMax <= maxTime)
                    && (tempMax > maxSoFar || (tempMax == maxSoFar && movieDuration[high] > result[1]))) {
                maxSoFar = tempMax;
                result[0] = movieDuration[low];
                result[1] = movieDuration[high];
            }

            if (tempMax > maxTime)
                high--;
            else
                low++;

        }

        if (result[0] == result[1]) {
            result[1] = indexMap.get(result[1]).get(1);
        } else {
            result[1] = indexMap.get(result[1]).get(0);
        }
        result[0] = indexMap.get(result[0]).get(0);
        return result;

    }
}
