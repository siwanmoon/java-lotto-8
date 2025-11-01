package lotto.model;

import java.util.List;

public record LottoDTO(List<Integer> numbers) {

    public static LottoDTO from(Lotto lotto) {
        return new LottoDTO(lotto.getNumbers());
    }
}
