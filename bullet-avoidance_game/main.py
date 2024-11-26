import pygame
from player import Player
from bullet import Bullet
from score import scor
import random as rnd
import time
import pickle
import datetime
from functools import cmp_to_key


def collision(obj1,obj2):  # 충돌함수
    dist = ((obj1.pos[0] - obj2.pos[0]) ** 2 + (obj1.pos[1] - obj2.pos[1]) ** 2) ** 0.5  # 두 점 사이의 거리 공식 이용
    return dist < 20

def draw_text(txt, size, pos, color):  # 글꼴 및 크기 지정
    font = pygame.font.Font('freesansbold.ttf', size)
    r = font.render(txt, True, color)  # 텍스트 객체 생성
    screen.blit(r, pos)

# score(생존시간) 파일에 기록하고 pickle에 업로드
try:
    with open('data/core','rb') as f:
        score_list = pickle.load(f)
except:
    print("score file not found")

pygame.init()  # 게임 실행 준비과정
WIDTH, HEIGHT = 800, 600  # 화면 크기

pygame.mixer.init()  # 스크린 생성

pygame.display.set_caption("총알 피하기")  # 윈도우 창 제목

screen = pygame.display.set_mode((WIDTH, HEIGHT))  # 스크린에 크기 적용

clock = pygame.time.Clock()  # 시간관리 해주는 코드
FPS = 60  

# 배경사진 블러오기
bg_image = pygame.image.load('data/bg.jpg')
bg_pos_x = 0 
bg_pos_y = 0

player = Player(WIDTH/2, HEIGHT/2, pygame.mixer)  # player 생성

mainChannel = pygame.mixer.Channel(0)

# 배경음악 불러오기
pygame.mixer.music.load('data/bgm.wav')
pygame.mixer.music.play(-1)  # 무한반복

bullets = []
for i in range(3):  # 초기에 총알 3개부터 생성
    bullets.append(Bullet(0,rnd.random()*HEIGHT,rnd.random()-0.5,rnd.random()-0.5))  # 총알 속도와 초기 위치 랜덤하게 설정

# 변수 지정
score_list = []  # 파일에 기록하기 위한 리스트
time_for_adding_bullets = 0  # 총알 수
score = 0  # 점수 0
gameover = False  # 게임 오버 상태 False
running = True  # Game Loop True
start_time = time.time()  # 시작 시간
nowtime = None  # 경과된 시간 None

# Game Loop
while running:

    dt = clock.tick(FPS)  # 60초에 한번 while문을 실행해주기

    # 이벤트 받는 부분 : 마우스 움직이기, 키보드 누르기 등등
    for event in pygame.event.get():  # 사용자가 입력했던 것들을 리스트로 들어오게
        if event.type == pygame.QUIT:  # 게임 창의 X버튼을 눌렀을 때
            running = False  # while문을 빠져나가도록
        elif event.type == pygame.KEYDOWN:  # 키보드 화살표 누르기
            if event.key == pygame.K_LEFT:  # 화살표 왼쪽 방향키 누름
                player.goto(-1, 0)
            elif event.key == pygame.K_RIGHT:
                player.goto(1, 0)
            elif event.key == pygame.K_UP:
                player.goto(0, -1)
            elif event.key == pygame.K_DOWN:
                player.goto(0, 1)
        elif event.type == pygame.KEYUP:
            if event.key == pygame.K_LEFT:
                player.goto(1, 0)
            elif event.key == pygame.K_RIGHT:
                player.goto(-1, 0)
            elif event.key == pygame.K_UP:
                player.goto(0, 1)
            elif event.key == pygame.K_DOWN:
                player.goto(0, -1)

    player.update(dt, screen)  # player 움직임 갱신

    # 화면 갱신 : 화면이 움직이는 것처럼
    # screen.fill((0, 0, 0)) # 검정색
    bg_pos_x -= dt * 0.01  # bg_image의 위치 지정과 화면 갱신 속도 지정
    bg_pos_y -= dt * 0.01
    screen.blit(bg_image, (bg_pos_x-player.pos[0], bg_pos_y-player.pos[1]))  # player의 위치를 계속해서 업데이트하여 따라가기 (반대방향으로)
    player.draw(screen)  # player 움직임 갱신

    for b in bullets:  # 총알 지속적으로 업데이트
        b.update_and_draw(dt,screen)

    elapsed_time = time.time() - start_time  # 경과된 시간

    if gameover:  # 게임 오버 될때
        draw_text("GAME OVER", 100, (WIDTH/2 - 300, HEIGHT/2 - 300), (255,255,255))  # 게임 종료 시 GAME OVER 문구 띄우기
        txt = f"Time: {score:.2f}, Bullet: {len(bullets)}"  # 현재 날아온 총알의 수와 생존 시간 출력
        draw_text(txt, 32, (WIDTH/2 - 150, HEIGHT/2 -180), (255, 255, 255))  # 위치설정

        for i in range(0, min(10, len(score_list))):
            txt = f"{i+1}th - Time: {score_list[i].score:.2f}, Bullet: {score_list[i].bullet}"
            draw_text(txt, 32, (WIDTH/2 - 170, HEIGHT/2 - 100 + 40*i), (255, 255, 255) if not nowtime == score_list[i] else (255, 255, 0))  # 10개의 기록안에 현재 기록 있다면 강조 표시

    else:
        txt = f"Time: {elapsed_time:.2f}, Bullet: {len(bullets)}, Health: {player.get_health()}"
        draw_text(txt, 32, (10, 10), (255, 255, 255))
        pygame.draw.rect(screen, (0,0,0) , [550, 10 , 200 , 30]) 
        pygame.draw.rect(screen, (255,0,0), [550, 10, 2*player.health, 30]) 

    pygame.display.update()  # 화면 갱신

    if not gameover:  # 게임 오버가 아닐때
        for b in bullets:
            if collision(b, player):  # 총알과 player가 충돌하면
                if player.hit(b.get_damage()):
                    gameover = True  # 게임오버
                    score = elapsed_time  # 기록 = 경과된 시간

                    nowtime = datetime.datetime.now().timestamp()

                    score_list.append(scor(score, len(bullets), nowtime))  # 점수 리스트에 기록을 추가

                    score_list = sorted(score_list, key=cmp_to_key(lambda x, y: y.score - x.score if x.score != y.score else x.time - y.time))  # 점수 기록 정렬

                    score_list = score_list[0:10]  # 10개까지 기록

                    print(score_list)  # 점수 리스트 출력

        time_for_adding_bullets += dt  # dt를 이용해서 1초 세기

        # 총알 수 늘리기
        if time_for_adding_bullets > 1000:
            bullets.append(Bullet(0,rnd.random()*HEIGHT,rnd.random()-0.5,rnd.random()-0.5))
            time_for_adding_bullets -= 1000

with open('data/score','wb') as f:  # pickle 파일 열기
    pickle.dump(score_list, f)

pygame.quit()