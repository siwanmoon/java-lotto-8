package lotto.model.service;

import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.model.firstclasscollection.LottoTickets;

public class LottoWinningServiceImpl implements LottoWinningService {

    @Override
    public LottoResult calculateStatistics(LottoTickets userTickets, WinningLotto winningLotto) {
        return userTickets.calculateStatistics(winningLotto);
    }
}
