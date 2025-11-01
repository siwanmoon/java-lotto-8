package lotto.model.firstclasscollection;

import java.util.List;
import lotto.model.LottoDTO;

public record LottoTicketsDTO(List<LottoDTO> lottoTicketsDTO) {

    public static LottoTicketsDTO from(LottoTickets lottoTickets) {
        List<LottoDTO> lottoTicketsDTO = lottoTickets.getLottoTickets().stream()
                .map(LottoDTO::from)
                .toList();

        return new LottoTicketsDTO(lottoTicketsDTO);
    }
}
