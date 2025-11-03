package lotto.model;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000L, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000L, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000L, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000L, "3개 일치 (5,000원)");

    private final int matchCount;
    private final long prizeMoney;
    private final String description;

    LottoRank(int matchCount, long prizeMoney, String description) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }

    public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 5) {
            return checkBonusMatch(bonusMatch);
        }

        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(null);
    }

    public static LottoRank checkBonusMatch(boolean bonusMatch) {
        if (bonusMatch) {
            return SECOND;
        }

        return THIRD;
    }
}
