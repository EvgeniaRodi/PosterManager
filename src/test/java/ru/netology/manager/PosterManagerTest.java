package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerTest {
    private PosterManager manager = new PosterManager();
    private MovieItem first = new MovieItem(1, 1, "first");
    private MovieItem second = new MovieItem(2, 2, "second");
    private MovieItem third = new MovieItem(3, 3, "third");
    private MovieItem fourth = new MovieItem(4, 4, "fourth");
    private MovieItem fifth = new MovieItem(5, 5, "fifth");
    private MovieItem sixth = new MovieItem(6, 6, "sixth");
    private MovieItem seventh = new MovieItem(7, 7, "seventh");
    private MovieItem eighth = new MovieItem(8, 8, "eighth");
    private MovieItem ninth = new MovieItem(9, 9, "ninth");
    private MovieItem tenth = new MovieItem(10, 10, "tenth");
    private MovieItem eleventh = new MovieItem(11, 11, "eleventh");

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
    public void shouldChangeMaxAmount() {
        PosterManager manager = new PosterManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{seventh, sixth, fifth,fourth,third};

        assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldShowMinusMovie() {
        PosterManager manager = new PosterManager (-3);

        MovieItem[] expected = new MovieItem[] {};
        MovieItem[] actual = manager.getAll();

        assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldShowNinthMovie() {

        MovieItem item = new MovieItem();
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowEleventhMovie() {
        manager.add(tenth);
        manager.add(eleventh);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldShow0Movie() {
        manager = new PosterManager ();

        MovieItem[] expected = new MovieItem[]{};
        MovieItem [] actual = manager.getAll();
    }
    @Test
    public void shouldRemoveMovie() {
        int idToRemove = 6;
        manager.removeById(idToRemove);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{ninth, eighth, seventh, fifth, fourth, third, second, first};


        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldGetTenMovies() {
        manager.add (tenth);
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotGetMoviesIfUnderZero () {
        manager = new PosterManager(-5);
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{};
        assertArrayEquals(expected, actual);
    }
}