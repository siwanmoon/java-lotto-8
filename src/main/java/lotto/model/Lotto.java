package lotto.model;

import static lotto.common.Strategy.LOTTO_MAX_NUMBER;
import static lotto.common.Strategy.LOTTO_MIN_NUMBER;
import static lotto.common.Strategy.LOTTO_NUMBER_SEPERATOR;
import static lotto.common.Strategy.LOTTO_SIZE;
import static lotto.common.message.ErrorMessage.INVALID_LOTTO_SIZE;
import static lotto.common.message.ErrorMessage.LOTTO_NUMBER_DECIMAL;
import static lotto.common.message.ErrorMessage.LOTTO_NUMBER_DUPLICATE;
import static lotto.common.message.ErrorMessage.LOTTO_NUMBER_NOT_BLANK;
import static lotto.common.message.ErrorMessage.LOTTO_NUMBER_NOT_NUMERIC;
import static lotto.common.message.ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.common.message.ErrorMessage.LOTTO_NUMBER_TOO_BIG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateUnique(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < LOTTO_MIN_NUMBER || n > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    public static Lotto of(String input) {
        return new Lotto(parseNumbers(input));
    }

    private static List<Integer> parseNumbers(String input) {
        List<Integer> lottoNumbers = new ArrayList<>();
        String[] numbers = input.split(LOTTO_NUMBER_SEPERATOR, -1);

        for (String number : numbers) {
            lottoNumbers.add(validateInputNumber(number));
        }

        return lottoNumbers;
    }

    private static int validateInputNumber(String input) {
        checkNotBlank(input);

        try {
            double number = Double.parseDouble(input.trim());
            checkNotDecimal(number);
            return changeNumberToInteger(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_NUMBER_NOT_NUMERIC.getMessage());
        }
    }

    private static void checkNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_NOT_BLANK.getMessage());
        }
    }

    private static void checkNotDecimal(double number) {
        if (number % 1 != 0) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DECIMAL.getMessage());
        }
    }

    private static int changeNumberToInteger(double number) {
        if (number > Integer.MAX_VALUE || number < Integer.MIN_VALUE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_TOO_BIG.getMessage());
        }

        return (int) number;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int input) {
        return numbers.stream().anyMatch(integer -> integer == input);
    }

    public int countMatches(Lotto other) {
        return (int) this.numbers.stream().filter(other::contains).count();
    }
}
