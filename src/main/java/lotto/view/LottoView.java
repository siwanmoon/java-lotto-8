package lotto.view;

import lotto.model.dto.WinningResultDTO;
import lotto.model.dto.LottoTicketsDTO;

public class LottoView {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void printErrorMessage(String errorMessage) {
        outputView.printErrorMessage(errorMessage);
    }

    public String requestPurchaseAmount() {
        outputView.requestPurchaseAmount();
        return inputView.getTrimmedInput();
    }

    public void printPurchasedLottos(LottoTicketsDTO lottoTicketsDTO) {
        outputView.printTicketsCount(lottoTicketsDTO);
        outputView.printTickets(lottoTicketsDTO);
    }

    public String requestLottoWinningNumber() {
        outputView.requestLottoWinningNumber();
        return inputView.getTrimmedInput();
    }

    public String requestBonusNumber() {
        outputView.requestBonusNumber();
        return inputView.getTrimmedInput();
    }

    public void printWinningResult(WinningResultDTO winningResultDTO) {
        outputView.printStatistics(winningResultDTO);
        outputView.printProfitRate(winningResultDTO);
    }
}
