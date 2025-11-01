package lotto.view;

import lotto.model.firstclasscollection.LottoTicketsDTO;

public class LottoView {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String requestPurchaseAmount() {
        outputView.requestPurchaseAmount();
        return inputView.getTrimmedInput();
    }

    public void printPurchasedLottos(LottoTicketsDTO lottoTicketsDTO) {
        outputView.printTicketsCount(lottoTicketsDTO);
        outputView.printTickets(lottoTicketsDTO);
    }
}
