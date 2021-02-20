package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.List;

import static lotto.domain.Rank.getRanksForStatistics;

public class OutputView {
    private OutputView() {
    }

    public static void showLottos(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.getNumberOfLotto());
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoSummary());
        }
        System.out.println();
    }

    public static void showResultStatistics(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        List<Integer> statistics = lottoStatistics.getWinCountByRank();
        List<Rank> ranksForStatistics = getRanksForStatistics();
        for (int i = 0; i < statistics.size(); i++) {
            System.out.printf("%s %d개\n", ranksForStatistics.get(i).getMessage(), statistics.get(i));
        }
        System.out.printf("총 수익률은 %.2f입니다.\n", lottoStatistics.getProfitRate());
    }
}
