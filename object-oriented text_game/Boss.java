package Pyramid;
import java.util.Random;
import java.util.Scanner;

public class Boss {

	static int Anubis_hp = 100;
	static int Anubis_attack = 10;

	static int Player_hp;
	static int attack = 10;

	void Start(int Score) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		Player_hp = Score;

		System.out.println("피라미드를 없애자 잠들어있던 아누비스가 나타났습니다! 전투를 시작합니다!");
		System.out.println("");

		System.out.println("=============================== 게임 설명 ==================================");
		System.out.println("공격 : 적에게 10만큼의 피해를 입힌다. 적이 치유 중이라면 2배의 피해를 입힌다.");
		System.out.println("방어 : 적의 공격을 방어한다. 만약 적의 공격을 방어한다면 적에게 10의 피해를 입힌다.");
		System.out.println("치유 : 10만큼의 체력을 회복한다. 적이 방어중이라면 2배의 체력을 회복한다.(최대 체력을 넘을 순 없다.)");
		System.out.println("");
		System.out.println("유저와 아누비스(보스)는 매 턴마다 공격, 방어, 치유 3가지 행동 중 하나의 행동을 할 수 있다.");
		System.out.println("운이 좋으면 아누비스의 행동을 간파할 수 있다... 아누비스를 처치하고 게임을 끝내자!");
		System.out.println("=========================================================================");

		for (int i = 0; i < 2; i++)
			System.out.println(" ");

		while (true) {
			if (Anubis_hp <= 0) {
				System.out.println("아누비스와의 전투에서 승리했습니다!!!");
				break;
			}

			if (Player_hp <= 0) {
				System.out.println("아누비스와의 전투에서 패배하였습니다...");
				System.exit(0);
			}

			int random = r.nextInt(6) + 1;
			int Anubis_realact;

			System.out.println("아누비스의 체력 : " + Anubis_hp);
			String Anubis_act = switch (random) {
			case 1 -> ("아누비스가 공격을 준비합니다...");
			case 3 -> ("아누비스가 회복을 할려고 합니다!");
			case 2 -> ("아누비스가 방어 태세를 취합니다..");
			default -> ("아누비스가 경계 태세를 취합니다..");
			};

			System.out.println("보스의 행동 : " + Anubis_act);

			if (3 >= random && random > 0)
				Anubis_realact = random;
			else
				Anubis_realact = r.nextInt(3) + 1;

			System.out.println("");
			System.out.println("================= 내 채력 : " + Player_hp + " =======================");
			System.out.println("  행동 중 하나를 골라 아누비스에 대항하세요!                     ");
			System.out.println("       1. 공격        2. 방어         3.치유           ");
			System.out.println("====================================================");

			int User = sc.nextInt();

			// 유저가 공격을 택한 경우
			if (User == 1) {
				if (Anubis_realact == 1) {
					System.out.println("서로의 공격이 부딪힙니다!");
					Anubis_hp -= attack;
					Player_hp -= Anubis_attack;

				} else if (Anubis_realact == 2) {
					System.out.println("아누비스의 방어가 성공했습니다! 역공이 펼쳐집니다!");
					Player_hp -= Anubis_attack * 2;
				} else if (Anubis_realact == 3) {
					System.out.println("아누비스의 회복을 저지하는데 성공했습니다!");
					Anubis_hp -= attack * 2;
				}
			}

			// 유저가 방어를 택한 경우
			if (User == 2) {
				if (Anubis_realact == 1) {
					System.out.println("방어에 성공했습니다! 역공을 펼칩니다!");
					Anubis_hp -= attack * 2;
				} else if (Anubis_realact == 2) {
					System.out.println("아무런 일도 일어나지 않았습니다.");
				} else if (Anubis_realact == 3) {
					System.out.println("아누비스가 더 많은 체력을 회복합니다!");
					Anubis_hp += Anubis_attack * 2;
					if (Anubis_hp > 100)
						Anubis_hp = 100;
				}
			}

			// 유저가 치유를 택한 경우
			if (User == 3) {
				if (Anubis_realact == 1) {
					System.out.println("회복이 저지당하여 더 많은 피해를 입습니다!");
					Player_hp -= Anubis_attack * 2;
				} else if (Anubis_realact == 2) {
					System.out.println("더 많은 회복을 성공합니다!");
					Player_hp += attack * 2;
					if (Player_hp > Score)
						Player_hp = Score;
				} else if (Anubis_realact == 3) {
					System.out.println("서로의 회복이 성공합니다!");
					Anubis_hp += Anubis_attack;
					Player_hp += attack;
					if (Anubis_hp > 100)
						Anubis_hp = 100;
					if (Player_hp > Score)
						Player_hp = Score;
				}
			}
		}
		sc.close();
		return;

	}

}
