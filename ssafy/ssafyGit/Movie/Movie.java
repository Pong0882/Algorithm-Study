package ssafy.ssafygit.movie;

public class Movie {
    private int id;
    private String title;
    private String director;
    private String genre;
    private int runningTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String sitle) {
        this.title = sitle;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public Movie() {
        super();
    }

    public Movie(int id, String sitle, String director, String genre, int runningTime) {
        this.id = id;
        this.title = sitle;
        this.director = director;
        this.genre = genre;
        this.runningTime = runningTime;
    }

    @Override
    public String toString() {
        return "Movie [id=" + id + ", sitle=" + title + ", director=" + director + ", genre=" + genre + ", runningTime="
                + runningTime + "]";
    }

}
