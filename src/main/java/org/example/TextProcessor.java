package org.example;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class TextProcessor {
    public static String normalizeText(String input) {
        // Убираем лишние пробелы
        input = input.strip().replaceAll("\\s+", " ");
        // Приводим все символы к нижнему регистру
        input = input.toLowerCase();
        // Избавляемся от нежелательных символов
        input = input.replaceAll("[^\\w\\s]", "");
        // Применяем Unicode нормализацию
        input = Normalizer.normalize(input, Normalizer.Form.NFD);
        input = Pattern.compile("\\p{M}+").matcher(input).replaceAll("");
        return input;
    }
}
