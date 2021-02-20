package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.Lotto.LOTTO_SIZE;
import static lotto.domain.Lotto.LOTTO_START_INDEX;
import static lotto.domain.LottoNumber.MAXIMUM_CANDIDATE_NUMBER;
import static lotto.domain.LottoNumber.MINIMUM_CANDIDATE_NUMBER;

public class LottoNumberGenerator {
    private static final List<Integer> candidateNumbers = new ArrayList<>();

    static {
        createCandidates();
    }

    private static void createCandidates() {
        for (int i = MINIMUM_CANDIDATE_NUMBER; i <= MAXIMUM_CANDIDATE_NUMBER; i++) {
            candidateNumbers.add(i);
        }
    }

    public List<LottoNumber> createLotto() {
        Collections.shuffle(candidateNumbers);
        List<Integer> numbers = candidateNumbers.subList(LOTTO_START_INDEX, LOTTO_SIZE);
        Collections.sort(numbers);

        return createLottoNumbers(numbers);
    }

    private List<LottoNumber> createLottoNumbers(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }


}
