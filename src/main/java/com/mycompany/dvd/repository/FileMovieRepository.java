package com.mycompany.dvd.repository;

import com.mycompany.dvd.entity.Movie;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileWriter;

public class FileMovieRepository implements MovieRepositoryInterface {
@Value("movies.file.location")
private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void add(Movie movie) {

        FileWriter writer;

        try{
            writer = new FileWriter("movies.txt", true);
            writer.write(movie.getTitle());
            writer.write("\n");
            writer.write(movie.getGenre());
            writer.write("\n");
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("The movie "+movie.getTitle()+" has been added.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
