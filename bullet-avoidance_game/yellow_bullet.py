from bullet import Bullet

# 노란 총알: 반지름 6, 데미지 20
class YellowBullet(Bullet):
    def __init__(self,x,y,to_x,to_y):
        super().__init__(x,y,to_x,to_y)

        self.radius = 6
        self.color = (190,190,0)

        self.damage = 20 # add damage