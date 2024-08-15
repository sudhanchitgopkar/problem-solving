class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        change = [0,0,0]

        for bill in bills:
            change [(bill // 10)] += 1
            if bill == 10:
                if not change[0]:
                    return False
                else:
                    change[0] -= 1
            if bill == 20:
                if not (change[0] and change[1]) and change[0] < 3:
                    return False
                elif change[1]:
                    change[1] -= 1
                    change[0] -= 1
                else:
                    change[0] -= 3

        return True
        