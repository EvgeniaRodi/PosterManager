package ru.netology.manager;

import ru.netology.domain.MovieItem;

public class PosterManager {
    private MovieItem[]  items = new MovieItem[0];
    private int maxAmount = 10;

    public PosterManager () {
    }

    public PosterManager (int maxAmount) {
        if (maxAmount <= 0) {
            return;
        }
        this.maxAmount = maxAmount;
    }

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
        int resultLength;
        if(items.length > maxAmount) {
            resultLength = maxAmount;
        } else {
            resultLength = items.length;
        }
        MovieItem[] result = new MovieItem[resultLength];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < resultLength; i++) {
            if (items.length > maxAmount) {
                int index = resultLength - i -1 + (items.length - maxAmount);
                result[i] = items[index];
            } else {
                int index = resultLength - i - 1;
                result[i] = items[index];
            }
        }
        return result;
    }
    public void removeById(int id) {
        int length = items.length - 1;
        MovieItem[] tmp = new MovieItem[length];
        int index = 0;
        for (MovieItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        // меняем наши элементы
        items = tmp;
    }


}