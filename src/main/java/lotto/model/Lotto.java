package lotto.model;

import static lotto.common.Strategy.LOTTO_SIZE;
import static lotto.common.message.ErrorMessage.ERROR_MESSAGE_PREFIX;
import static lotto.common.message.ErrorMessage.INVALID_LOTTO_SIZE;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX.getMessage() + INVALID_LOTTO_SIZE.getMessage());
        }
    }
}
