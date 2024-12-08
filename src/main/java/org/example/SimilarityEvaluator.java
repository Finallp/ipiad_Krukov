package org.example;

import java.util.HashSet;
import java.util.Set;

public class SimilarityEvaluator {
    public static double computeJaccardIndex(Set<String> setA, Set<String> setB) {
        Set<String> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        Set<String> union = new HashSet<>(setA);
        union.addAll(setB);

        return intersection.isEmpty() ? 0.0 : (double) intersection.size() / union.size();
    }

    public static double computeMinHashSimilarity(int[] signatureA, int[] signatureB) {
        int matchCount = 0;
        for (int i = 0; i < signatureA.length; i++) {
            if (signatureA[i] == signatureB[i]) {
                matchCount++;
            }
        }
        return (double) matchCount / signatureA.length;
    }
}
