class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        sol, prev_devices = 0, 0

        for row in bank:
            curr_devices = sum([int(x) for x in row])
            sol += curr_devices * prev_devices
            prev_devices = curr_devices if curr_devices != 0 else prev_devices
        
        return sol
        