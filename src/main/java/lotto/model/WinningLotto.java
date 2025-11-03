package lotto.model;

import static lotto.common.message.ErrorMessage.BONUS_NUMBER_DUPLICATION;

public class WinningLotto {

    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank calculateRank(Lotto userTicket) {
        int matchCount = userTicket.countMatches(winningLotto);
        boolean bonusMatch = userTicket.contains(bonusNumber.getBonusNumber());

        return LottoRank.valueOf(matchCount, bonusMatch);
    }

    private void validateBonusNumber(Lotto winningTicket, BonusNumber bonusNumber) {
        if (winningTicket.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION.getMessage());
        }
    }
}
