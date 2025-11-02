package lotto.model.service;

import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.model.firstclasscollection.LottoTickets;

public interface LottoWinningService {

    LottoResult calculateStatistics(LottoTickets userTickets, WinningLotto winningLotto);;
}
