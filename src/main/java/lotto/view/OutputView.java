package lotto.view;

import static lotto.common.message.ViewMessage.LOTTO_NUMBER_SEPERATOR;
import static lotto.common.message.ViewMessage.PRINT_LOTTO_NUMBER_PREFIX;
import static lotto.common.message.ViewMessage.PRINT_LOTTO_NUMBER_SUFFIX;
import static lotto.common.message.ViewMessage.PRINT_TICKETS_COUNT;
import static lotto.common.message.ViewMessage.REQUEST_PURCHASE_AMOUNT;

import java.util.stream.Collectors;
import lotto.model.LottoDTO;
import lotto.model.firstclasscollection.LottoTicketsDTO;

public class OutputView {

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
                .collect(Collectors.joining(LOTTO_NUMBER_SEPERATOR.getMessage()))
                + PRINT_LOTTO_NUMBER_SUFFIX.getMessage();
    }
}
