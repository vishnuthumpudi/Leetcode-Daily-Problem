MOD = 998244353
BASE = 6752341

class Solution:
    def beautifulIndices(self, s: str, a: str, b: str, k: int) -> List[int]:
        n = len(s)
        
        ai = []
        bi = [-1e8]
        out = []
        
        ha = 0
        for c in a:
            ha *= BASE
            ha += ord(c)
            ha %= MOD
            
        aa = len(a)
        ch = 0
        sub = pow(BASE, aa, MOD)
        for i in range(n):
            ch *= BASE
            ch += ord(s[i])
            if i >= aa:
                ch -= ord(s[i - aa]) * sub
            ch %= MOD
            
            if ch == ha:
                ai.append(i - aa + 1)
    
        #print(ai)

        hb = 0
        for c in b:
            hb *= BASE
            hb += ord(c)
            hb %= MOD
        bb = len(b)
        ch = 0
        sub = pow(BASE, bb, MOD)
        for i in range(n):
            ch *= BASE
            ch += ord(s[i])
            if i >= bb:
                ch -= ord(s[i - bb]) * sub
            ch %= MOD
            
            if ch == hb:
                bi.append(i - bb + 1)
                
        out = []
        while ai:
            u = ai.pop()
            while bi[-1] > u + k:
                bi.pop()

            if bi[-1] >= u - k:
                out.append(u)

        return sorted(out)