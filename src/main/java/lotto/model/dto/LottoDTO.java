package lotto.model.dto;

import java.util.List;
import lotto.model.Lotto;

public record LottoDTO(List<Integer> numbers) {

    public static LottoDTO from(Lotto lotto) {
        return new LottoDTO(lotto.getNumbers());
    }
}
