## 🦷 흡연, 음주, 당뇨병이 구강건강에 미치는 영향
<br>

- **프로젝트 주제:** 회귀모형을 이용한 국건영 자료 분석
  
- **프로젝트 기간:** 2022년 6월
  
- **데이터 출처:** 국민건강영양조사
  
- **연구 목표:** 흡연과 음주와 당이 구강건강에 나쁜 영향을 끼치는지, 회귀분석을 통해 증명하기 위해 다음과 같은 연구를 진행하였다. 흡연과 음주와 당뇨병으로 인해 구강건강에 문제가 생겼을 시 우식경험이 있는 영구치 수에 영항을 주는지 그 변수들간에 상관관계를 알아본다.
  
- **연구 내용:** 성인을 기준으로 하루평균 흡연량과 한번에 마시는 음주량, 당뇨병 진단시기가 성인의 우식치아를 설명할 수 있는지 그 설명변수들과의 관계에 대해 연구한다.
  
- **연구 방법**
  - ID: 아이디
  - age: 만나이
  - sex: 성별
  - tooth: 우식경험영구치 수 (O_DMFTP)
  - smok: 하루 평균 흡연량_개비 (BS3_2)
  - ach: 한번에 마시는 음주량_잔 (BD2_14)
  - diab: 당뇨병 진단 시기 (DE1_ag) <br>
  - tooth를 반응변수 Y, smok, ach, diab들을 설명변수로 설정하여 중선형회귀분석을 진행한다. 모형을 설정하고 모수들을 추정하고 추정된 모형의 적합도 조사와 회귀계수 추정량에 대한 구간추정과 가설검정, 잔차분석 등을 진행한다.
<br>
<img width="500" src="https://github.com/user-attachments/assets/fda107c4-4cfd-4be1-8c75-299b06b9b1d7">
<img width="500" src="https://github.com/user-attachments/assets/50f5e083-8884-4600-8367-b92ce05c3f6f">
<img width="500" src="https://github.com/user-attachments/assets/c201e38c-b111-4fe6-97a5-f086ac3253d5">
<img width="500" src="https://github.com/user-attachments/assets/bb1cf9bf-0367-4848-b409-d99151e9dce4">
<img width="500" src="https://github.com/user-attachments/assets/2a5cdcdb-7a8a-4b46-9607-4c79643b5e3f">
<img width="500" src="https://github.com/user-attachments/assets/cb5d36e8-729b-4df6-afbd-89065148eb19">
<img width="500" src="https://github.com/user-attachments/assets/67b3781a-cc56-4087-8878-8867cf69ec37">
<img width="500" src="https://github.com/user-attachments/assets/49954142-4794-491f-9940-c6709bbecea1">
<img width="500" src="https://github.com/user-attachments/assets/0a329621-71b0-4e50-b7fe-c2fb7374704a">
<img width="500" src="https://github.com/user-attachments/assets/787572ad-152f-43b1-9c9d-368d259af50a">
<img width="500" src="https://github.com/user-attachments/assets/3cbe74a5-9849-47a7-adc8-3bb206c4b561">
<img width="500" src="https://github.com/user-attachments/assets/fed55dd8-4874-4894-bdf6-e8dd6901e042"><br>
<br>

- **결론 및 아쉬운 점:** 최종 회귀모형은 설명변수 X1을 제거한 Reduced Model이다. 본 회귀분석의 결과, 음주량이 적을수록, 당뇨병 진단시기가 늦어질수록 우식경험 영구치 수가 많아지고, 흡연이 구강건강에 영향을 주지 않는 것으로 나타났다. 이러한 결과들은 우리가 흔히 알고 있는 사실과는 다른 결과이며, 결론의 신뢰성이 다소 낮음을 알 수 있다. 처음 변수를 지정할 때 각각의 변수들, 그 중 성인의 우식경험 영구치 수가 구강건강을 충분히 설명하지 못한 결과라고 예상한다. 직접 실습해봤던 본 프로젝트는 이론에서 나아가 어떻게 적용하는지 배울 수 있었던 시간이었다.

