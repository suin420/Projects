# 🔍 관심 분야의 키워드 검색을 통한 텍스트 데이터 분석 프로젝트
<br>

- **프로젝트 목표:** 10만 건의 텍스트 데이터 크롤링 & 키워드 및 주제 분석

- **프로젝트 기간:** 2023년 4월 ~ 6월
<br>

## 프로세스
### 1. 데이터 수집
- 데이터 수집 키워드: 미국, 여행, 네이버 서비스(지도, 쇼핑, 블로그, 클라우드)
- 네이버 검색 API, BeautifulSoup 활용
- 크롤링 대상: 네이버 블로그, 네이버 뉴스
- title, link, description 세 가지 컬럼으로 데이터프레임 생성
<img width="500" src="https://github.com/user-attachments/assets/e9b68e43-86f8-4ac9-94c2-f85f777bb889">
<img width="500" src="https://github.com/user-attachments/assets/bab009b7-945b-40c6-b5ba-c059a7f7a4bd">
<img width="500" src="https://github.com/user-attachments/assets/3dc614b4-53c4-4852-96e5-2bf573e04616">
<img width="500" src="https://github.com/user-attachments/assets/662ad5dc-c3a9-463d-ac05-c54fad58a872">
<br><br>

### 2. 데이터 전처리
- 미국, 여행, 네이버 키워드는 WordCloud 생성을 목적으로 전처리 진행
<img width="600" alt="스크린샷 2024-11-27 01 43 03" src="https://github.com/user-attachments/assets/5b8902b4-8ac7-45bf-b427-8704ddc8d1e7">
<img width="600" alt="스크린샷 2024-11-27 01 43 16" src="https://github.com/user-attachments/assets/49e3eaec-2676-4457-8604-3d76ef0821e5">
<br><br>

- 네이버 지도, 쇼핑, 블로그, 클라우드 키워드는 LDA 분석을 목적으로 전처리 진행
<img width="600" src="https://github.com/user-attachments/assets/a3df9eee-2186-4f3c-8c5a-339117955a41">

<br><br>

### 3. WordCloud
<img width="500" src="https://github.com/user-attachments/assets/460122cf-9986-44b7-be3e-e82a77e260d1">
<img width="500" src="https://github.com/user-attachments/assets/bda50a07-44dc-43c1-83ae-75ef181a9ce6">
<img width="500" src="https://github.com/user-attachments/assets/b08bc438-e7ea-4d13-9263-fc4eb1756dfa">
<img width="500" src="https://github.com/user-attachments/assets/367a4cc1-1e54-4545-b0f0-cee6fa9e6c7a">
<br><br>

### 4. LDA
<img width="500" src="https://github.com/user-attachments/assets/2ac13baf-f4e5-40bd-a782-fc630ff7fc6e">
<img width="500" src="https://github.com/user-attachments/assets/ab59899a-dc14-4e63-882e-4bfda884054e">
<img width="500" src="https://github.com/user-attachments/assets/8b6629c9-1dde-4854-b84c-755908401ae7">
<img width="500" src="https://github.com/user-attachments/assets/4bbb8bb5-0e2a-4906-b240-bfb6eefbec03">
<img width="500" src="https://github.com/user-attachments/assets/a7a5956a-d586-44f7-bfda-50827b76911f">
<img width="500" src="https://github.com/user-attachments/assets/ddb00531-fac2-49c1-aaa4-9d9e682ef48e">
<img width="500" src="https://github.com/user-attachments/assets/bc47b06d-136a-450a-b5ac-87399c89fb72">
<img width="500" src="https://github.com/user-attachments/assets/88b881f7-03c2-412b-aae4-7ae403bf336b">
<img width="500" src="https://github.com/user-attachments/assets/65b7721a-2644-441e-a669-68d2ef2d542d">
<img width="500" src="https://github.com/user-attachments/assets/50bdfa34-4df5-456d-a21e-008bda4a17ca">
<br><br>

[*프로젝트 설명 자료](https://github.com/suin420/Projects/blob/main/Text_Data_Analysis/Project_Description.pdf)
