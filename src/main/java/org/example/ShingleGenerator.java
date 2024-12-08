package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShingleGenerator {
    public static List<String> generateShingles(String text, int size) {
        List<String> shingleList = new ArrayList<>();
        String[] tokens = text.split(" "); // Разделяем текст на слова.
        for (int i = 0; i <= tokens.length - size; i++) { // Перебираем возможные диапазоны.
            StringBuilder shingle = new StringBuilder();
            for (int j = 0; j < size; j++) { // Объединяем слова в диапазоне [i, i+size).
                if (j > 0) {
                    shingle.append(" "); // Добавляем пробел между словами.
                }
                shingle.append(tokens[i + j]); // Добавляем следующее слово.
            }
            shingleList.add(shingle.toString()); // Добавляем шингл в список.
        }
        return shingleList;
    }
}
