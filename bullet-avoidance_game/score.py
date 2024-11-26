class scor:  # 기록할 scor 클래스 만들기
    def __init__(self, score, bullet, time):
        self.score = score
        self.bullet = bullet
        self.time = time

    def __repr__(self):
        return f"Score: {self.score}, Bullet: {self.bullet}, Time: {self.time}"  # 기록 저장 형식
    
    def __eq__(self, other):  # 특수 메서드 __eq__
        if isinstance(other, scor):  # 클래스 비교 isinstance 함수
            return bool(self.score == other.score and self.bullet == other.bullet and self.time == other.time)
        elif isinstance(other, float):  # 타입 비교
            return bool(self.time == other)
        else:
            raise TypeError(f"{type(other)} isan't compare scor")