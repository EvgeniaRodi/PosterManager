package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerLengthTest {
    private PosterManager manager = new PosterManager(5);
    private MovieItem first = new MovieItem(1, 1, "first", "comedy", 10);
    private MovieItem second = new MovieItem(2, 2, "second", "cartoon", 11);
    private MovieItem third = new MovieItem(3, 3, "third", "thriller", 12);
    private MovieItem fourth = new MovieItem(4, 4, "fourth", "horror", 13);
    private MovieItem fifth = new MovieItem(5, 5, "fifth", "drama", 14);
    private MovieItem sixth = new MovieItem(6, 6, "sixth", "musical", 15);


    @Test
    public void shouldAddFourMovies () {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[] {fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddFiveMovies () {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[] {fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldAddSixMovies () {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[] {sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

}

