package ssafy.ssafyGit.movie;

import java.util.Arrays;

public class MovieManager {
    private final int MAX_SIZE = 100;

    private Movie[] movieList = new Movie[MAX_SIZE];
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void add(Movie movie) {
        if (size != MAX_SIZE) {
            movieList[size++] = movie;
        } else {
            System.out.println("FULL");
        }
    }

    public Movie[] getList() {
        return Arrays.copyOfRange(movieList, 0, size);
    }

    public Movie searchByTile(String title) {
        for (int i = 0; i < size; i++) {
            if (movieList[i].getTitle().contains(title)) {
                return movieList[i];
            }
        }
        return null;
    }
}
