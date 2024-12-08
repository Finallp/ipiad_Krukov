package org.example;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class DuplicateDetection {
    public static void main(String[] args) {
        String doc1 = "Пример текста для анализа схожести.";
        String doc2 = "Анализ текстов: пример похожего содержания.";
// 1. Нормализация
        doc1 = TextProcessor.normalizeText(doc1);
        doc2 = TextProcessor.normalizeText(doc2);

        // 2. Генерация шинглов
        List<String> shingles1 = ShingleGenerator.generateShingles(doc1, 3);
        List<String> shingles2 = ShingleGenerator.generateShingles(doc2, 3);

        // Преобразуем в множества
        Set<String> shingleSet1 = new HashSet<>(shingles1);
        Set<String> shingleSet2 = new HashSet<>(shingles2);

        // 3. MinHash
        int hashFunctions = 120;
        int largePrime = 101111; // Простое число
        MinHashGenerator minHashGen = new MinHashGenerator(hashFunctions, largePrime);

        int[] signature1 = minHashGen.computeSignature(shingleSet1);
        int[] signature2 = minHashGen.computeSignature(shingleSet2);

        // 4. Сравнение
        double jaccardSimilarity = SimilarityEvaluator.computeJaccardIndex(shingleSet1, shingleSet2);
        double minHashSimilarity = SimilarityEvaluator.computeMinHashSimilarity(signature1, signature2);

        System.out.println("Сходство по Джаккарду: " + jaccardSimilarity);
        System.out.println("Сходство по MinHash: " + minHashSimilarity);
    }
}
