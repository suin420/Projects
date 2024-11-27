## 🔐 QR코드를 활용한 차량용 안심 주차번호
<br><br>
## 프로젝트 배경 및 목적
주차 시 차량 앞에 부착된 사용자 전화번호가 개인정보로 쉽게 노출되어 이를 악용한 범죄가 빈번히 발생하고 있다. 특히, 전화번호는 SNS를 통해 다른 개인정보들도 쉽게 취득할 수 있다. 이를 방지하기 위해 OTP 기술을 활용한 일회용 전화번호를 생성하고, QR 코드로 제공하는 방식이 필요하다.
<br><br>
## 주최/주관 및 팀원
- 국민대학교 정보보안암호수학과 금융보안개론 수업의 일회용 비밀번호 구현 프로젝트
- AI빅데이터융합경영학과 전공생 2명, 정보보안암호수학과 전공생 2명
<br><br>
## 프로젝트 기간
2023.10 ~ 2023.11 (2개월)
<br><br>
## 프로젝트 소개
OTP 기술 중 질의-응답 방식을 적용하여 일회용 전화번호를 생성한다. 질의-응답 OTP는 사용자가 안심번호 갱신을 원하기 까지 번호가 유지되어야 상대방과 연락이 필요한 상황에 문제가 발생하지 않기 때문에 선정하였다. 따라서 사용자가 어플을 통해 지문을 등록할 때마다 안심번호가 갱신되고, 외부인은 차량에 부탁된 QR 코드를 통해 사용자에게 연락할 수 있다.
<br><br>
## 프로세스
Code 파일은 main.ipynb와 Server.ipynb 두 가지로 이루어져있으며, main은 사용자가 이용하는 APP이고, Server는 서버 역할을 한다. <br>

- 동작 과정
<img width="600" src="https://github.com/user-attachments/assets/1aade12a-ffaa-4541-966a-8016ea5f2103">

1. Server에 아이디, 지문 등록
2. 사용자가 app을 통해 아이디 입력
3. app은 서버에 ID전달
3. Server는 ID 유효성 확인 후 유효하다면 앱에게 난수 전달
4. 앱은 사용자에게 지문인증 요청
5. 사용자는 앱에 지문 입력
6. 앱은 지문과 핸드폰 번호로 K 생성 후 RV를 이용해 otp생성 후 서버에 전달
7. 서버는 미리 등록해둔 K와 RV이용해 otp계산 후 앱에서 받은 otp가 같은지 확인
8. 서버는 앱에게 안심번호 전달
9. 앱은 안심번호 정보를 담고 있는 QR코드 생성
<br>

- 2FA의 기능으로, 두 가지 인증 요소가 결합되어 보안의 "최종" 강화를 제공
<img width="600" src="https://github.com/user-attachments/assets/7b8e0572-45a8-4df0-a6ad-203c41b4678e">
<br><br>

- 결과물 시연 영상

https://github.com/user-attachments/assets/3994ed16-ffc2-48f2-a90f-1a9e12d0a160

<br>

## 역할
- 안심번호 구현 및 발표 준비
  - Challenge-Response 기법 적용한 안심번호 생성
  - QR 코드 생성 및 안심번호 연동
- 알고리즘 구체화 및 PPT 제작
  - 지문의 해쉬 값 생성 및 안심번호와 QR코드 생성
<br><br>
## 배우고 느낀 점
이번 프로젝트에서는 일회용 비밀번호(OTP) 기술을 실제 생활에 어떻게 적용할 수 있을지 고민하며, 간단한 서버-클라이언트 시스템을 구현하였다. 처음에는 클라이언트 측만 구현하다 보니, OTP를 처리하는 데 있어 어려움이 있었는데, 팀원들이 구축한 서버 덕분에 OTP 발급과 검증이 원할히 이루어졌다. 이를 통해 서버의 중요성을 실감했고, 완성도 높은 프로젝트를 마무리할 수 있어 뿌듯했다.

[*발표 자료](https://github.com/suin420/Projects/blob/main/OTP_Project/Presentation.pdf)