package lotto.model.firstclasscollection;

import java.util.List;
import java.util.Map;
import lotto.model.LottoRank;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.model.BonusNumber;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @Test
    void getLottoTickets가_생성된_티켓_리스트를_정확히_반환한다() {
        Lotto ticket1 = Lotto.of("1,2,3,4,5,6");
        Lotto ticket2 = Lotto.of("7,8,9,10,11,12");
        List<Lotto> tickets = List.of(ticket1, ticket2);

        LottoTickets lottoTickets = new LottoTickets(tickets);

        assertThat(lottoTickets.getLottoTickets())
                .hasSize(2)
                .containsExactly(ticket1, ticket2);
    }

    @Test
    void calculateStatistics가_당첨_통계를_정확히_계산한다() {
        WinningLotto winningLotto = new WinningLotto(Lotto.of("1,2,3,4,5,6"), new BonusNumber("7"));

        List<Lotto> userTicketsList = List.of(
                Lotto.of("1,2,3,10,11,12"), // 5등
                Lotto.of("4,5,6,13,14,15"), // 5등
                Lotto.of("1,2,3,4,16,17"), // 4등
                Lotto.of("1,2,19,20,21,22"), // 꽝
                Lotto.of("1,2,3,4,5,7"),  // 2등
                Lotto.of("10,11,12,13,14,15") // 꽝
        );
        LottoTickets lottoTickets = new LottoTickets(userTicketsList);

        LottoResult result = lottoTickets.calculateStatistics(winningLotto);
        Map<LottoRank, Integer> statistics = result.getStatistics();

        assertThat(statistics)
                .hasSize(3)
                .containsEntry(LottoRank.FIFTH, 2)
                .containsEntry(LottoRank.FOURTH, 1)
                .containsEntry(LottoRank.SECOND, 1)
                .doesNotContainKey(LottoRank.FIRST)
                .doesNotContainKey(LottoRank.THIRD);
    }

    @Test
    void calculateStatistics가_모든_등수를_포함하여_정확히_계산한다() {
        WinningLotto winningLotto = new WinningLotto(Lotto.of("1,2,3,4,5,6"), new BonusNumber("7"));

        List<Lotto> userTicketsList = List.of(
                Lotto.of("1,2,3,4,5,6"), // 1등
                Lotto.of("1,2,3,4,5,7"), // 2등
                Lotto.of("1,2,3,4,5,8"), // 3등
                Lotto.of("1,2,3,4,8,9"), // 4등
                Lotto.of("1,2,3,8,9,10") // 5등
        );
        LottoTickets lottoTickets = new LottoTickets(userTicketsList);

        LottoResult result = lottoTickets.calculateStatistics(winningLotto);
        Map<LottoRank, Integer> statistics = result.getStatistics();

        assertThat(statistics)
                .hasSize(5)
                .containsEntry(LottoRank.FIRST, 1)
                .containsEntry(LottoRank.SECOND, 1)
                .containsEntry(LottoRank.THIRD, 1)
                .containsEntry(LottoRank.FOURTH, 1)
                .containsEntry(LottoRank.FIFTH, 1);
    }

    @Test
    void calculateStatistics가_당첨_내역이_없으면_빈_맵을_반환한다() {
        WinningLotto winningLotto = new WinningLotto(Lotto.of("1,2,3,4,5,6"), new BonusNumber("7"));

        List<Lotto> userTicketsList = List.of(
                Lotto.of("10,11,12,13,14,15"), // 꽝
                Lotto.of("1,11,12,13,14,15")  // 꽝
        );
        LottoTickets lottoTickets = new LottoTickets(userTicketsList);

        LottoResult result = lottoTickets.calculateStatistics(winningLotto);
        Map<LottoRank, Integer> statistics = result.getStatistics();

        assertThat(statistics).isEmpty();
    }
}
