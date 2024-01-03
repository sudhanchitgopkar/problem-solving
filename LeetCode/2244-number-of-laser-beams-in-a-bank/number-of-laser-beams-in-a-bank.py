class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        sol, prev_devices = 0, 0

        for row in bank:
            curr_devices = row.count('1')
            sol += curr_devices * prev_devices
            if curr_devices != 0:
                prev_devices = curr_devices 
        
        return sol
        