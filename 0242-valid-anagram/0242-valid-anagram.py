class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sfreq = {}
        tfreq = {}
        
        for char in s:
            if char in sfreq:
                sfreq[char] = sfreq[char] + 1
            else:
                sfreq[char] = 1
                
        for char in t:
            if char in tfreq:
                tfreq[char] = tfreq[char] + 1
            else:
                tfreq[char] = 1
        
        for char in sfreq:
            if char in tfreq:
                if sfreq[char] != tfreq[char]:
                    return False
            else:
                return False
        
        for char in tfreq:
            if char in sfreq:
                if sfreq[char] != tfreq[char]:
                    return False
            else:
                return False
        
        return True
        