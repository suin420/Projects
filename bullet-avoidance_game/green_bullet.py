from bullet import Bullet

# 초록 총알: 반지름 5, 데미지 10
class GreenBullet(Bullet):
    def __init__(self,x,y,to_x,to_y):
        super().__init__(x,y,to_x,to_y)

        self.radius = 5
        self.color = (0,190,0)

        self.damage = 10  # add damage