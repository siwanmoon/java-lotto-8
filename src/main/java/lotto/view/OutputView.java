package lotto.view;

import static lotto.common.message.ErrorMessage.ERROR_MESSAGE_PREFIX;
import static lotto.common.message.ViewMessage.PRINT_LOTTO_NUMBER_SEPERATOR;
import static lotto.common.message.ViewMessage.PRINT_LOTTO_NUMBER_PREFIX;
import static lotto.common.message.ViewMessage.PRINT_LOTTO_NUMBER_SUFFIX;
import static lotto.common.message.ViewMessage.PRINT_PROFIT_RATE_PREFIX;
import static lotto.common.message.ViewMessage.PRINT_PROFIT_RATE_SUFFIX;
import static lotto.common.message.ViewMessage.PRINT_RESULT_STATISTICS;
import static lotto.common.message.ViewMessage.PRINT_TICKETS_COUNT;
import static lotto.common.message.ViewMessage.REQUEST_BONUS_NUMBER;
import static lotto.common.message.ViewMessage.REQUEST_LOTTO_WINNING_NUMBER;
import static lotto.common.message.ViewMessage.REQUEST_PURCHASE_AMOUNT;
import static lotto.common.message.ViewMessage.STATISTICS_DELIMITER;
import static lotto.common.message.ViewMessage.TICKET_COUNT_UNIT;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.common.LottoRank;
import lotto.model.LottoDTO;
import lotto.model.WinningLotto;
import lotto.model.WinningResultDTO;
import lotto.model.firstclasscollection.LottoTicketsDTO;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_PREFIX.getMessage() + message);
    }

    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT.getMessage());
    }

    public void printTicketsCount(LottoTicketsDTO lottoTicketsDTO) {
        System.out.println(lottoTicketsDTO.getTicketCount() + PRINT_TICKETS_COUNT.getMessage());
    }

    public void printTickets(LottoTicketsDTO purchasedLottos) {
        for(LottoDTO lottoDTO : purchasedLottos.lottoTicketsDTO()) {
            System.out.println(LottoNumbers(lottoDTO));
        }
    }

    private String LottoNumbers(LottoDTO lottoDTO) {
        return PRINT_LOTTO_NUMBER_PREFIX.getMessage()
                + lottoDTO.numbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(PRINT_LOTTO_NUMBER_SEPERATOR.getMessage()))
                + PRINT_LOTTO_NUMBER_SUFFIX.getMessage();
    }

    public void requestLottoWinningNumber() {
        System.out.println(REQUEST_LOTTO_WINNING_NUMBER.getMessage());
    }

    public void requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER.getMessage());
    }

    public void printStatistics(WinningResultDTO winningResultDTO) {
        System.out.println(PRINT_RESULT_STATISTICS.getMessage());

        Map<LottoRank, Integer> statistics = winningResultDTO.statistics();
        List<LottoRank> ranksToDisplay = List.of(
                LottoRank.FIFTH,
                LottoRank.FOURTH,
                LottoRank.THIRD,
                LottoRank.SECOND,
                LottoRank.FIRST);

        for (LottoRank rank : ranksToDisplay) {
            int count = statistics.getOrDefault(rank, 0);
            System.out.println(rank.getDescription() + STATISTICS_DELIMITER.getMessage()
                    + count + TICKET_COUNT_UNIT.getMessage());
        }
    }

    public void printProfitRate(WinningResultDTO winningResultDTO) {
        double profitRate = winningResultDTO.profitRate();
        String formattedRate = String.format("%.1f", profitRate);

        System.out.println(PRINT_PROFIT_RATE_PREFIX.getMessage() + formattedRate + PRINT_PROFIT_RATE_SUFFIX.getMessage());
    }
}
