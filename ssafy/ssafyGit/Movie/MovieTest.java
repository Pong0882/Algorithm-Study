package ssafy.ssafyGit.movie;

public class MovieTest {
    public static void main(String[] args) {

        Movie movie = new Movie(1, "movie1", "Pong", "happy", 120);
        Movie movie2 = new Movie(2, "movie2", "Pong", "happy", 120);
        MovieManager mm = new MovieManager();

        mm.add(movie);
        mm.add(movie2);

        for (int i = 0; i < mm.getSize(); i++) {
            System.out.println(mm.getList()[i]);
        }
    }
}
