package Pyramid;
import java.util.Scanner;

public class Randombox {
	int Start() {
		System.out.println("============================================================");
		System.out.println("아이템얻기 미니게임을 선택하셨습니다. UP&DOWN 게임을 통해 아이템을 획득하세요!");

		Scanner scan = new Scanner(System.in);
		int inputNumber = 0;
		int count = 0;

		while (true) {
			int high = 99;
			int low = 0;
			int item = 0;

			System.out.println("수를 결정하였습니다. 맞추어 보세요.");
			System.out.println(low + "~" + high);
			int randomNumber = (int) (Math.random() * 99);

			while (true) {
				count++;
				System.out.print(count + " >> ");
				inputNumber = scan.nextInt();

				if (inputNumber < randomNumber) {
					System.out.print("UP! ");
					low = inputNumber;
					System.out.println(low + "~" + high);

				} else if (inputNumber > randomNumber) {
					System.out.print("DOWN! ");
					high = inputNumber;
					System.out.println(low + "~" + high);
				} else
					break;
			}
			if (inputNumber == randomNumber) {
				System.out.println("성공하셨습니다!");
				int Success = (int) (Math.random() * 2);
				System.out.print("0과 1중 박스를 선택하세요. 둘 중 하나가 아이템박스 입니다.(0/1) -> ");
				int Choice = scan.nextInt();

				if (Success == Choice) {
					System.out.println("축하드립니다! 아이템을 획득하셨습니다. 메인화면으로 돌아가겠습니다.");
					item += 1;

				} else if (Success != Choice) {
					System.out.println("꽝 입니다. 메인화면으로 돌아가겠습니다.");

				} else {
					scan.nextLine();
					System.out.println("0과 1만 입력가능합니다.");
				}
			}
			return item;
		}
	}
}
