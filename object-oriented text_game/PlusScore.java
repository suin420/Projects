package Pyramid;

public class PlusScore {
    private int card1;
    private int card2;

    // 생성자: 두 카드의 값을 받아 초기화
    public PlusScore(int card1, int card2) {
        this.card1 = card1;
        this.card2 = card2;
    }

    // 점수 계산 메서드
    public int Score() {
        // 카드 값의 합이 10인 경우 추가 점수 10점
        if (card1 + card2 == 10) {
            return 10;
        }
        // 특정 조건에 따라 다른 점수 계산 가능
        // 예: 두 카드가 동일한 문양일 경우 추가 점수 5점
        else if (card1 > 25 || card2 > 25) {
            return 5;
        }
        // 기본 점수 2점
        else {
            return 2;
        }
    }
}
