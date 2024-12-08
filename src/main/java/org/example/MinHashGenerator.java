package org.example;

import java.util.Random;
import java.util.Set;

public class MinHashGenerator {
    private final int hashCount;
    private final int[] coefA;
    private final int[] coefB;
    private final int primeNumber;

    public MinHashGenerator(int hashCount, int primeNumber) {
        this.hashCount = hashCount;
        this.primeNumber = primeNumber;
        this.coefA = new int[hashCount];
        this.coefB = new int[hashCount];
        Random random = new Random();
        for (int i = 0; i < hashCount; i++) {
            coefA[i] = random.nextInt(primeNumber - 1) + 1;
            coefB[i] = random.nextInt(primeNumber);
        }
    }

    public int[] computeSignature(Set<String> elements) {
        int[] signature = new int[hashCount];
        for (int i = 0; i < hashCount; i++) {
            signature[i] = Integer.MAX_VALUE;
        }

        for (String element : elements) {
            int hashValue = element.hashCode();
            for (int i = 0; i < hashCount; i++) {
                int compositeHash = (coefA[i] * hashValue + coefB[i]) % primeNumber;
                signature[i] = Math.min(signature[i], compositeHash);
            }
        }
        return signature;
    }
}