package lotto.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    void 여섯_개가_일치하면_1등을_반환한다() {
        assertThat(LottoRank.valueOf(6, true)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.valueOf(6, false)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void 다섯_개_일치와_보너스_볼이_일치하면_2등을_반환한다() {
        assertThat(LottoRank.valueOf(5, true)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    void 다섯_개만_일치하면_3등을_반환한다() {
        assertThat(LottoRank.valueOf(5, false)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void 네_개가_일치하면_4등을_반환한다() {
        assertThat(LottoRank.valueOf(4, true)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.valueOf(4, false)).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void 세_개가_일치하면_5등을_반환한다() {
        assertThat(LottoRank.valueOf(3, true)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.valueOf(3, false)).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    void 두_개_이하가_일치하면_null을_반환한다() {
        assertThat(LottoRank.valueOf(2, true)).isNull();
        assertThat(LottoRank.valueOf(1, false)).isNull();
        assertThat(LottoRank.valueOf(0, true)).isNull();
    }

    @Test
    void 각_등수의_상금과_설명을_정확히_반환한다() {
        assertThat(LottoRank.FIRST.getPrizeMoney()).isEqualTo(2_000_000_000L);
        assertThat(LottoRank.FIRST.getDescription()).isEqualTo("6개 일치 (2,000,000,000원)");

        assertThat(LottoRank.THIRD.getPrizeMoney()).isEqualTo(1_500_000L);
        assertThat(LottoRank.THIRD.getDescription()).isEqualTo("5개 일치 (1,500,000원)");

        assertThat(LottoRank.FIFTH.getPrizeMoney()).isEqualTo(5_000L);
        assertThat(LottoRank.FIFTH.getDescription()).isEqualTo("3개 일치 (5,000원)");
    }

    @Test
    void checkBonusMatch가_정확히_동작한다() {
        assertThat(LottoRank.checkBonusMatch(true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.checkBonusMatch(false)).isEqualTo(LottoRank.THIRD);
    }
}
