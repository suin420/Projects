import pygame

class Bullet:
    def __init__(self,x,y,to_x,to_y):
        self.pos = [x,y]
        self.to = [to_x, to_y]
        self.radius = 7
        self.color = (190,0,0)
        self.damage = 5  # add damage property

    def get_damage(self):  # damage 추가 방법
        return self.damage
    
    def get_pos(self):  # position
        return self.pos

    def update_and_draw(self,dt,screen):
        width, height = screen.get_size()
        self.pos[0] = (self.pos[0] + self.to[0]*dt) % width
        self.pos[1] = (self.pos[1] + self.to[1]*dt) % height
        pos_int = (int(self.pos[0]), int(self.pos[1]))
        pygame.draw.circle(screen, self.color, pos_int, self.radius)  # 원 그리기

from red_bullet import RedBullet
from yellow_bullet import YellowBullet
from green_bullet import GreenBullet
from random import randint as rnint

def Bullet(x,y,to_x,to_y):
    rnd = rnint(1, 100)  # 총알 종류별 랜덤하게 설정

    if rnd <= 40:  # 40이하의 수 일경우 초록 총알
        return GreenBullet(x,y,to_x,to_y)
    elif rnd <= 80:  # 40초과 80이하의 수 일경우 노란 총알
        return YellowBullet(x,y,to_x,to_y)
    else:  # 그 외 일경우 빨간 총알
        return RedBullet(x,y,to_x,to_y)    