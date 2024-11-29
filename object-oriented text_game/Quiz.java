package Pyramid;
import java.util.Scanner;

public class Quiz {
	void Start() {
		System.out.println("피라미드가 무너지는 것을 눈치챈 스핑크스가 나타났다!");
		System.out.println("스핑크스 : 내가 내는 문제를 풀지 못하면 더이상 지나가지 못한다.");
		String[] qu = { "아침에는 네 개의 다리로 걷고, 점심에는 두 개의 다리로 걷고, 저녁에는 세 개의 다리로 걷는 생물은?",
				"이것은 새와 짐승, 나무, 꽃 그 모든것을 집어삼키고, 쇠를 갉아먹고 단단한 돌을 가루로 갈아내며, 왕을 죽이고, 마을을 파괴하며, 높은 산을 깎는다 ",
				"죽은 자를 살려내며 너를 울고 웃게 하고, 젊게 만들어 주며, 찰나에 태어나지만, 평생 지속되는 것은?", "밤이면 부르지 않아도 나타나며, 낮에는 도둑맞지 않아도 사라지는 것은?",
				"살아있지만, 공기를 내뱉지 않는다. 살아있어도 죽은 듯이 차갑다. 절대 목마르지 않지만 항상 마신다.",
				"거대하지만 절대 성장하지 않고, 뿌리가 있지만 드러나지 않으며, 나무보다 큰 것은?",
				"움직일 수 있지만 절대 걷지 않고, 삼킬 수 있지만 절대 말하지 않고, 높은 곳에 있으면 낮은 곳을 향하고, 누워 있어도 잠들지 않는 것은?" };
		String[] an = { "human", "time", "memory", "star", "fish", "mountain", "river" };

		int life = 3;
		int as = 3;
		Scanner scan = new Scanner(System.in);
		while (as >= 0 && life >= 0) {
			int um = (int) (Math.random() * 6);
			System.out.println(qu[um]);
			String ans = scan.next();

			if (ans.equals(an[um])) {
				System.out.println("문제를 맞혔다!");
				as -= 1;
			} else {
				System.out.println("틀렸다!");
				life -= 1;
			}
		}
		if (as < 0) {
			System.out.println("스핑크스가 분해하며 자리를 비킵니다.");
			return;
		} else {
			System.out.println("스핑크스가 당신을 처형합니다.");
			System.out.println("게임 오버...");
			System.exit(0);
		}

	}
}
