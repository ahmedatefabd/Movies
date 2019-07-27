package com.c1ctech.androiddagger2example.model_db;
import com.c1ctech.androiddagger2example.model.Movie;
import java.util.List;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "MovieDB")
public class Movie_DB {

    private static Movie_DB instance;

    @PrimaryKey
    private int id;

    @ColumnInfo(name ="vote_count")
    private int voteCount;

    @ColumnInfo(name ="video")
    private boolean video;

    @ColumnInfo(name ="vote_average")
    private double voteAverage;

    @ColumnInfo(name ="title")
    private String title;

    @ColumnInfo(name ="popularity")
    private double popularity;

    @ColumnInfo(name ="poster_path")
    public String posterPath;

    @ColumnInfo(name ="original_language")
    private String originalLanguage;

    @ColumnInfo(name ="original_title")
    private String originalTitle;

    @ColumnInfo(name ="backdrop_path")
    private String backdropPath;

    @ColumnInfo(name ="adult")
    private boolean adult;

    @ColumnInfo(name ="overview")
    private String overview;

    @ColumnInfo(name ="release_date")
    private String releaseDate;


    public Movie_DB(int id, int voteCount, boolean video,
                    double voteAverage, String title,
                    double popularity, String posterPath,
                    String originalLanguage, String originalTitle, String backdropPath,
                    boolean adult, String overview, String releaseDate) {

        this.id = id;
        this.voteCount = voteCount;
        this.video = video;
        this.voteAverage = voteAverage;
        this.title = title;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.backdropPath = backdropPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public static Movie_DB getInstance(int id, int voteCount, boolean video,
                                       double voteAverage, String title,
                                       double popularity, String posterPath,
                                       String originalLanguage, String originalTitle, String backdropPath,
                                       boolean adult, String overview, String releaseDate) {
        if (instance == null) {
            synchronized (Movie.class) {
                if (instance == null) {
                    System.out.println("getInstance(): First time getInstance was invoked!");
                    instance = new Movie_DB( id, voteCount, video,
                            voteAverage, title, popularity, posterPath,
                            originalLanguage, originalTitle, backdropPath,
                            adult, overview, releaseDate);
                }
            }
        }
        return instance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
