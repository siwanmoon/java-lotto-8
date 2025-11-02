package lotto.model;

import static lotto.common.Strategy.LOTTO_MIN_NUMBER;
import static lotto.common.Strategy.LOTTO_MAX_NUMBER;
import static lotto.common.Strategy.LOTTO_SIZE;

import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGeneratorImpl implements LottoGenerator {

    public Lotto buyOneLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
