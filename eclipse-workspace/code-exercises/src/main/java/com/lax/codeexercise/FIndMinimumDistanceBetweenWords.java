package com.lax.codeexercise;

/*
 * Minimum distance between 2 words, counting the number of characters 
 * . from middle of both words
 * e.g. ABC is XYZ and ABC & XYZ are two distinct words.
 */
public class FIndMinimumDistanceBetweenWords {

	public static void main(String[] args) {
		String sentence = "quality and quality The picture quality is great of this camera";
		String word1 = "quality";
		String word2 = "quality";
		int minDistance = -1;
		if ((minDistance = finMinDistance(sentence, word1, word2)) != -1) {
			System.out.println("Minimum Distance is " + minDistance);
		}

	}

	public static int finMinDistance(String line, String word1, String word2) {
		String[] tokens = line.trim().split("\\s+");
		int minDistance = Integer.MAX_VALUE;
		int calcDistance = Integer.MAX_VALUE;
		int firstWordIndex = -1;
		int secondWordIndex = -1;

		for (int i = 0; i < tokens.length; i++) {
			if (word1.contentEquals(tokens[i])) {
				if (!word1.contentEquals(word2) || firstWordIndex == -1)
					firstWordIndex = i;
				else {
					if (secondWordIndex != -1)
						firstWordIndex = i;
				}
			}
			if (word2.contentEquals(tokens[i])) {
				if (i == firstWordIndex)
					continue;
				secondWordIndex = i;
			}

			if (firstWordIndex != -1 && secondWordIndex != -1) {
				minDistance = Math.min(Math.abs(secondWordIndex - firstWordIndex), minDistance);
			}
		}

		if (firstWordIndex == -1 || secondWordIndex == -1) {
			return -1;
		}
		return minDistance;

	}
}
