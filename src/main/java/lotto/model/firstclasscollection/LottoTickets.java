package lotto.model.firstclasscollection;

import java.util.List;
import lotto.model.Lotto;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public boolean containsNumber(int number) {
        return this.lottoTickets.stream().anyMatch(lotto -> lotto.contains(number));
    }
}
