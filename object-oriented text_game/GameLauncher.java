package Pyramid;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameLauncher {

	Random r = new Random();
	static String[][] Pyramid = new String[7][7];
	static ArrayList<String> Cards = new ArrayList<>();
	ArrayList<Integer> nonoverlap = new ArrayList<>();
	static int item = 0;
	static int Score = 10;

	// 기본 카드 데이터
	// ♥ = 9829, ♣ = 9827, ♠ = 9824, ■ = 9632

	String[] data = { "1♥", "2♥", "3♥", "4♥", "5♥", "6♥", "7♥", "8♥", "9♥", "J♥", "Q♥", "K♥", "1♣", "2♣", "3♣", "4♣",
			"5♣", "6♣", "7♣", "8♣", "9♣", "J♣", "Q♣", "K♣", "1♠", "2♠", "3♠", "4♠", "5♠", "6♠", "7♠", "8♠", "9♠", "J♠",
			"Q♠", "K♠", "1■", "2■", "3■", "4■", "5■", "6■", "7■", "8■", "9■", "J■", "Q■", "K■" };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Randombox box = new Randombox();

		GameLauncher game = new GameLauncher();

		System.out.print("이름을 입력하시오 : ");
		String Username = scan.next();

		System.out.print("아이템을 얻을 수 있는 미니게임이 있습니다. 진행하겠습니까?(y / n) : ");

		while (true) {
			String yesOrNo = scan.next();
			char tmp = yesOrNo.charAt(0);

			if (tmp == 'y' || tmp == 'Y') {
				item = box.Start();
				System.out.println(item);
				System.out.println("게임을 시작합니다(카드 더미를 사용할려면 높이를 8로 입력하세요!)");
				game.GameStart();
				break;
			} else if (tmp == 'n' || tmp == 'N') {
				System.out.println("게임을 시작합니다(카드 더미를 사용할려면 높이를 8로 입력하세요!)");
				game.GameStart();
				break;
			} else {
				System.out.println("y와 n만 입력가능합니다.");
			}
		}

		System.out.println("성공하셨습니다!");
		System.out.println(Username + "결과 : " + Score + " ");

		scan.close();
	}

	void GameStart() {
		Quiz Q = new Quiz();
		Boss B = new Boss();
		int q = 0;
		Scanner scan = new Scanner(System.in);

		GameLauncher game = new GameLauncher();

		game.set_Pyramid();

		if (item == 1) {
			System.out.println("아이템을 사용합니다!");
			for (int i = 0; i < 7; i++)
				Pyramid[6][i] = "__";
			Score += 45;
			game.draw_Pyramid(Score);
		}

		while (true) {
			// 카드 다 없어지면 끝
			if (Pyramid[0][0] == "__") {
				B.Start(Score);
				break;
			}

			if (Cards.size() == 10 && q == 0) {
				Q.Start();
				q = 1;
			}

			// 입력
			System.out.print("없앨 첫 번째 카드의 높이, 위치를 입력하시오 : ");

			int height1 = scan.nextInt() - 1;
			int User_input1 = scan.nextInt() - 1;

			if (height1 == -2) {
				System.out.println("항복하셨습니다...");
				System.exit(0);
			}

			System.out.print("없앨 두 번째 카드의 높이, 위치를 입력하시오 : ");

			int height2 = scan.nextInt() - 1;
			int User_input2 = scan.nextInt() - 1;

			int pyramid1, pyramid2;
			String card1 = "";
			String card2 = "";

			// 카드 더미 처리 (pyramid1이 카드)
			if (height1 == 7) {
				card1 = Cards.get(User_input1);
				pyramid1 = card1.charAt(0) - 48;
			} else if (6 == height1)
				pyramid1 = Pyramid[height1][User_input1].charAt(0) - 48;
			else if (6 > height1) {
				if (Pyramid[height1 + 1][User_input1] == "__" && Pyramid[height1 + 1][User_input1 + 1] == "__") {
					pyramid1 = Pyramid[height1][User_input1].charAt(0) - 48;
				} else {
					System.out.println("다시 입력해주세요.");
					continue;
				}
			} else
				pyramid1 = 0;

			// 카드 더미 처리 (pyramid2이 카드)
			if (height2 == 7) {
				card2 = Cards.get(User_input2);
				pyramid2 = card2.charAt(0) - 48;
			} else if (6 == height2)
				pyramid2 = Pyramid[height2][User_input2].charAt(0) - 48;
			else if (6 > height2) {
				if (Pyramid[height2 + 1][User_input2] == "__" && Pyramid[height2 + 1][User_input2 + 1] == "__")
					pyramid2 = Pyramid[height2][User_input2].charAt(0) - 48;
				else {
					System.out.println("다시 입력해주세요.");
					continue;
				}

			} else
				pyramid2 = 0;

			System.out.println("");

			// 카드 지우기
			if (height1 == 7) {
				// 1번째 입력이 draw
				if ((pyramid1 + pyramid2 == 10) || ((pyramid1 > 25 || pyramid2 > 25)
						&& Pyramid[height2][User_input2].charAt(1) == card1.charAt(1))) {
					Cards.remove(User_input1);
					Pyramid[height2][User_input2] = "__";
					PlusScore S = new PlusScore(pyramid1, pyramid2);
					Score += S.Score();
				}
			} else if (height2 == 7) {
				if ((pyramid1 + pyramid2 == 10) || (pyramid1 > 25 || pyramid2 > 25)
						&& Pyramid[height1][User_input1].charAt(1) == card2.charAt(1)) {
					Pyramid[height1][User_input1] = "__";
					Cards.remove(User_input2);
					PlusScore S = new PlusScore(pyramid1, pyramid2);
					Score += S.Score();
				}
			} else if (((pyramid1 + pyramid2 == 10) || ((pyramid1 > 25 || pyramid2 > 25)
					&& Pyramid[height1][User_input1].charAt(1) == Pyramid[height1][User_input2].charAt(1)))
					&& 8 > User_input1 && 8 > User_input2) {

				Pyramid[height1][User_input1] = "__";
				Pyramid[height2][User_input2] = "__";
				PlusScore S = new PlusScore(pyramid1, pyramid2);
				Score += S.Score();
			} else
				System.out.println("잘 못된 입력입니다.");

			System.out.println("--------------------------------");
			game.draw_Pyramid(Score);
		}

		scan.close();

	}

	void draw_Pyramid(int number) {
		int cnt = 7;
		Score = number;

		System.out.println("점수 : " + Score);
		for (int i = 1; i <= 7; i++) {
			for (int j = 0; j < cnt; j++) {
				System.out.print("   ");
			}
			for (int k = 0; k < i; k++) {
				System.out.printf(" %s   ", Pyramid[i - 1][k]);
			}
			System.out.println("");

			cnt--;
		}
		System.out.println("");
		System.out.printf("카드 더미 : " + Cards + " (총 %d장입니다.)\n", Cards.size());

	}

	void set_Pyramid() {

		for (String card : data)
			Cards.add(card);

		int cnt = 7;

		System.out.println("점수 : " + Score);
		for (int i = 1; i <= 7; i++) {
			for (int j = 0; j < cnt; j++) {
				System.out.print("   ");
			}
			for (int k = 0; k < i; k++) {
				int randomcard = r.nextInt(Cards.size());
				// 중복확인
				for (int number : nonoverlap)
					if (randomcard == number)
						continue;
				// 피라미드 그리기
				Pyramid[i - 1][k] = Cards.get(randomcard);
				Cards.remove(randomcard);
				System.out.printf(" %s   ", Pyramid[i - 1][k]);
			}
			System.out.println("");

			cnt--;
		}
		System.out.println("");
		System.out.printf("카드 더미 : " + Cards + " (총 %d장입니다.)\n", Cards.size());
	}

}
