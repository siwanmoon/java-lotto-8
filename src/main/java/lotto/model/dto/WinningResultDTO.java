package lotto.model.dto;

import java.util.Map;
import lotto.model.LottoRank;
import lotto.model.LottoResult;

public record WinningResultDTO(Map<LottoRank, Integer> statistics, double profitRate) {

    public static WinningResultDTO of(LottoResult lottoResult, double profitRate) {
        return new WinningResultDTO(lottoResult.getStatistics(), profitRate);
    }
}
