from bullet import Bullet

# 빨간 총알: 반지름 7, 데미지 30
class RedBullet(Bullet):
    def __init__(self,x,y,to_x,to_y):
        super().__init__(x,y,to_x,to_y)

        self.radius = 7
        self.color = (190,0,0)

        self.damage = 30  # add damage
