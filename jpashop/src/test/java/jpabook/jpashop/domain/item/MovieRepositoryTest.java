package jpabook.jpashop.domain.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void save_movie() {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Movie movie = new Movie();
            movie.setName("라라랜드" + i);
            movie.setPrice(12000 + i);
            movie.setStockQuantity(10 + i);
            movie.setActor("고슬링" + i);
            movie.setDirector("제작자" + i);
            movies.add(movie);
        }
        movieRepository.saveAll(movies);
    }

}