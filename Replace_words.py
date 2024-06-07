class Solution_0:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        s = set(dictionary)
        sentence = sentence.split()
        for j, w in enumerate(sentence):
            for i in range(1, len(w)):
                if w[:i] in s: 
                    sentence[j] = w[:i]
                    break
        return " ".join(sentence)

class Solution_1:
    def replaceWords(self, roots, sentence):
        rootset = set(roots)

        def replace(word):
            for i in range(1, len(word)):
                if word[:i] in rootset:
                    return word[:i]
            return word

        return " ".join(map(replace, sentence.split()))

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        d = {w: len(w) for w in dictionary}
        mi, ma = min(d.values()), max(d.values())
        wrds = sentence.split()
        res = []
        for w in wrds:
            c = w
            for i in range(mi, min(ma, len(w)) + 1):
                ss = w[:i]
                if ss in d:
                    c = ss
                    break
            res.append(c)
        return " ".join(res)
