package com.learning.j10.service;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import com.learning.j10.model.ABC;
import static com.learning.j10.utility.Utility.in;;

public class ABCService extends Object {

	public ABC[] getAlphabets(String displayMode, String highlight) {

		Predicate<ABC> isPlaceHolder = e -> false;
		Predicate<ABC> isABCMode = e -> true;
		Predicate<ABC> isVowel = e -> in(e.getUpperCase(), 'A', 'E', 'I', 'O', 'U');
		Predicate<ABC> isConsonant = isVowel.negate();

		if (displayMode.equals("vow")) {
			isPlaceHolder = isVowel;
		} 
		else if (displayMode.equals("abc")) {
			isPlaceHolder = isABCMode;
		} 
		else if (displayMode.equals("con")) {
			isPlaceHolder = isConsonant; // could also make isPlaceHolder = isVowel.negate(); and remove line 17
		}

		if (highlight.equals("vow")) {

		}

		Function<ABC, ABC> funcHighlight = abc -> {

			if (highlight.equals("vow")&& isVowel.test(abc)) {
				abc.setHighlight("highlight");
			}
			else if (highlight.equals("con")&& isConsonant.test(abc)) {
				abc.setHighlight("highlight");
			}
			return abc;
		};

		ABC[] letters = IntStream.rangeClosed(65, 90)
				.mapToObj(ABC::new)
				.filter(isPlaceHolder)
				.map(funcHighlight)
				.toArray(ABC[]::new);

		return letters;
	}

}
