package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerTest {
    private PosterManager manager = new PosterManager();
    private MovieItem first = new MovieItem(1, 1, "first", "comedy", 10);
    private MovieItem second = new MovieItem(2, 2, "second", "cartoon", 11);
    private MovieItem third = new MovieItem(3, 3, "third", "thriller", 12);
    private MovieItem fourth = new MovieItem(4, 4, "fourth", "horror", 13);
    private MovieItem fifth = new MovieItem(5, 5, "fifth", "drama", 14);
    private MovieItem sixth = new MovieItem(6, 6, "sixth", "musical", 15);
    private MovieItem seventh = new MovieItem(7, 7, "seventh", "science-fiction", 16);
    private MovieItem eighth = new MovieItem(8, 8, "eighth", "biography", 17);
    private MovieItem ninth = new MovieItem(9, 9, "ninth", "mystery", 18);
    private MovieItem tenth = new MovieItem(10, 10, "tenth", "documentary", 19);
    private MovieItem eleventh = new MovieItem(11, 11, "eleventh", "detective", 20);
    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
    }

    @Test
    public void shouldGetTenMovies() {
        manager.add (tenth);
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMoviesLessThanTen() {
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMoviesMoreThanTen() {
        manager.add (tenth);
        manager.add (eleventh);
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldNotGetMoviesIfUnderZero () {
        manager = new PosterManager(-1);
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldZeroFilms() {
        manager = new PosterManager(0);

        MovieItem[] expected = new MovieItem[] {};
        MovieItem[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldTenFilms() {
        manager.add(tenth);
        MovieItem[] expected = new MovieItem[] {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        MovieItem[] actual = manager.getAll();

        assertArrayEquals(expected, actual);

    }

}