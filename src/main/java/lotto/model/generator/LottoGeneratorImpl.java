package lotto.model.generator;

import static lotto.common.Strategy.LOTTO_MIN_NUMBER;
import static lotto.common.Strategy.LOTTO_MAX_NUMBER;
import static lotto.common.Strategy.LOTTO_SIZE;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

public class LottoGeneratorImpl implements LottoGenerator {

    public Lotto buyOneLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
        return new Lotto(numbers);
    }
}
