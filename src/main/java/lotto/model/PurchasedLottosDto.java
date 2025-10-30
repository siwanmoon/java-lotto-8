package lotto.model;

import lotto.model.firstclasscollection.LottoTickets;

public record PurchasedLottosDto(long ticketsCount, LottoTickets lottoTickets) {

}
