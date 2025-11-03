package lotto.model.dto;

import java.util.List;
import lotto.model.firstclasscollection.LottoTickets;

public record LottoTicketsDTO(List<LottoDTO> lottoTicketsDTO) {

    public static LottoTicketsDTO from(LottoTickets lottoTickets) {
        List<LottoDTO> lottoTicketsDTO = lottoTickets.getLottoTickets().stream()
                .map(LottoDTO::from)
                .toList();

        return new LottoTicketsDTO(lottoTicketsDTO);
    }

    public int getTicketCount() {
        return lottoTicketsDTO.size();
    }
}
