package lotto.model;

import static lotto.common.message.ErrorMessage.BONUS_NUMBER_DUPLICATION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        Lotto winningLotto = Lotto.of("1,2,3,4,5,6");
        BonusNumber duplicateBonus = new BonusNumber("6");

        assertThatThrownBy(() -> new WinningLotto(winningLotto, duplicateBonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_DUPLICATION.getMessage());
    }

    @Test
    void 보너스_번호가_중복되지_않으면_객체_생성에_성공한다() {
        Lotto winningLotto = Lotto.of("1,2,3,4,5,6");
        BonusNumber validBonus = new BonusNumber("7");

        WinningLotto winningLottoModel = new WinningLotto(winningLotto, validBonus);
        assertThat(winningLottoModel).isNotNull();
    }

    @Test
    void calculateRank가_1등부터_5등까지_정확히_계산한다() {
        Lotto winningLotto = Lotto.of("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7");
        WinningLotto winningLottoModel = new WinningLotto(winningLotto, bonusNumber);

        Lotto ticket1st = Lotto.of("1,2,3,4,5,6");
        Lotto ticket2nd = Lotto.of("1,2,3,4,5,7");
        Lotto ticket3rd = Lotto.of("1,2,3,4,5,8");
        Lotto ticket4th = Lotto.of("1,2,3,4,8,9");
        Lotto ticket5th = Lotto.of("1,2,3,8,9,10");

        assertThat(winningLottoModel.calculateRank(ticket1st)).isEqualTo(LottoRank.FIRST);
        assertThat(winningLottoModel.calculateRank(ticket2nd)).isEqualTo(LottoRank.SECOND);
        assertThat(winningLottoModel.calculateRank(ticket3rd)).isEqualTo(LottoRank.THIRD);
        assertThat(winningLottoModel.calculateRank(ticket4th)).isEqualTo(LottoRank.FOURTH);
        assertThat(winningLottoModel.calculateRank(ticket5th)).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    void calculateRank가_꽝인_경우_null을_반환한다() {
        Lotto winningLotto = Lotto.of("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7");
        WinningLotto winningLottoModel = new WinningLotto(winningLotto, bonusNumber);

        Lotto ticketMiss2 = Lotto.of("1,2,10,11,12,13");
        Lotto ticketMiss0 = Lotto.of("10,11,12,13,14,15");

        assertThat(winningLottoModel.calculateRank(ticketMiss2)).isNull();
        assertThat(winningLottoModel.calculateRank(ticketMiss0)).isNull();
    }
}
