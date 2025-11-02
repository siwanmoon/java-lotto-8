package lotto.view;

import static lotto.common.message.ErrorMessage.ERROR_MESSAGE_PREFIX;
import static lotto.common.message.ViewMessage.PRINT_LOTTO_NUMBER_SEPERATOR;
import static lotto.common.message.ViewMessage.PRINT_LOTTO_NUMBER_PREFIX;
import static lotto.common.message.ViewMessage.PRINT_LOTTO_NUMBER_SUFFIX;
import static lotto.common.message.ViewMessage.PRINT_TICKETS_COUNT;
import static lotto.common.message.ViewMessage.REQUEST_BONUS_NUMBER;
import static lotto.common.message.ViewMessage.REQUEST_LOTTO_WINNING_NUMBER;
import static lotto.common.message.ViewMessage.REQUEST_PURCHASE_AMOUNT;

import java.util.stream.Collectors;
import lotto.model.LottoDTO;
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
}
