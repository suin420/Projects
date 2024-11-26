import pygame

# player가 조종할 비행기의 class 생성
class Player:
    def __init__(self, x, y, mixer):
        self.image = pygame.image.load('data/player.png')  # player 이미지 불러오기
        self.image = pygame.transform.scale(self.image, (64, 64)) 
        
        self.effect_image = pygame.image.load('data/bomb.png')  # bomb 이미지 불러오기
        self.effect_image = pygame.transform.scale(self.effect_image, (64,64))

        self.show_effect = False  # 충돌 False
        self.show_effect_during = 0  # 충돌시간 0

        self.pos = [x, y]  # position
        self.to = [0, 0]  # Player class에 움직이는 방향을 나타내는 변수 to 추가
        self.angle = 0

        self.channel = mixer.Channel(1)  # 음악재생 module

        self.sound = mixer.Sound('data/explosion.wav')  # 충돌 효과음

        self.health = 100  # 초기 health

        self.is_god = False  # 무적화 False
        self.is_god_during = 0  # 무적화 시간 0

    def get_pos(self):
        return self.pos
    
    def get_to(self):
        return self.to

    def get_health(self):
        return self.health

    def goto(self, x, y):  # update할 때 to의 방향으로 Player의 위치 이동
        self.to[0] += x 
        self.to[1] += y

    def update(self, dt, screen):  # update 할 때 player의 위치 이동
        width, height = screen.get_size()
        phw = self.image.get_width() / 2
        phh = self.image.get_height() / 2
        self.pos[0] = self.pos[0] + dt * self.to[0]
        self.pos[1] = self.pos[1] + dt * self.to[1]
        self.pos[0] = min(max(self.pos[0], phw), width-phw)  # player가 화면 밖으로 안가게
        self.pos[1] = min(max(self.pos[1], phh), height-phh)  # player가 화면 밖으로 안가게

        self.show_effect_during -= dt  # dt를 이용해서 충돌 시간 줄이기
        if self.show_effect_during < 0:  # 충돌시간 < 0 일때
            self.show_effect = False  # 충돌 False
        
        self.is_god_during -= dt  # dt를 이용해서 무적 시간 줄이기
        if self.is_god_during < 0:  # 무적 시간 < 0 일때
            self.is_god = False  # 무적화 False

    def draw(self, screen):  # 스크린 파라미터 받기 
        # 비행기 회전시키기
        if self.to == [-1,-1]: self.angle = 45  # to가 바뀌는 방향에 따라 angle 바뀌기
        elif self.to == [-1,0]: self.angle = 90
        elif self.to == [-1,1]: self.angle = 135
        elif self.to == [0,1]: self.angle = 180
        elif self.to == [1,1]: self.angle = 225
        elif self.to == [1,0]: self.angle = 270
        elif self.to == [1,-1]: self.angle = 315
        elif self.to == [0,-1]: self.angle = 0
        
        # if show bomb effect
        rotated = None

        if self.show_effect:  # 충돌 시
            rotated = pygame.transform.rotate(self.effect_image, self.angle)
        else:  # 충돌이 아닐 때
            rotated = pygame.transform.rotate(self.image, self.angle)

        # player를 화면 가운데에 놓기
        calib_pos = (self.pos[0] - rotated.get_width()/2, 
                     self.pos[1] - rotated.get_height()/2)

        # 무적화 상태에서 비행가기 반짝 거리도록
        if self.is_god:  # 무적화 일때
            if self.is_god_during // 100 % 2 == 0: 
                screen.blit(rotated, calib_pos)  # ()위치 안에 이미지 그리기
        else:
            screen.blit(rotated, calib_pos)

    def hit(self, damage):  # 데미지 입히기
        # if player is not god: show effects
        if not self.is_god:
            self.channel.play(self.sound)  # 충돌 시 음악 재생

            self.health -= damage  # 충돌 시 health 감소
            
            self.show_effect = True  # 충돌 시 효과
            self.show_effect_during = 1000

            self.is_god = True  # 충돌 시 무적
            self.is_god_during = 1000

        return bool(self.health <= 0)  # health가 없어지면

    def is_out_of_screen(self, screen):
        width, height = screen.get_size()
        phw = self.image.get_width() / 2
        phh = self.image.get_height() / 2
        return bool(self.pos[0] < phw or self.pos[0] > width - phw or self.__pos[1] < phh or self.__pos[1] > height - phh)