package ru.netology.manager;

import ru.netology.domain.MovieItem;

public class PosterManager {
    private MovieItem[] items = new MovieItem[0];
    private int numberOfMovies = 10;

    public void add(MovieItem item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieItem[] getAll() {
        MovieItem[] result = new MovieItem[Math.min(items.length, numberOfMovies)];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }


    public PosterManager() {
    }

    public PosterManager(int numberOfMovies) {
        if (numberOfMovies < 0) {
            return;
        }
        this.numberOfMovies = numberOfMovies;
    }
}