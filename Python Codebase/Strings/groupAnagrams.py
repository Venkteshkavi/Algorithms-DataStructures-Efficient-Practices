import collections
from typing import List
class GPA:
    def __init__(self,strs):
        self.str = strs
    def groupAnagrams_1(self,strs: List[str]) -> List[List[str]]:
        # Default dict do not raise key errors compared to normal dictionaries -> the parameter here is the default value
        # which needs to be created.
        ans = collections.defaultdict(list)
        print(ans)
        for s in strs:
            # strings are immutable so s.sort() will not work on them
            s = sorted(s)
            sti = tuple(s)
            ans[sti].append(s)
        return ans.values()
    
    def groupAnagrams_2(self,strs):
        ans = collections.defaultdict(list)
        for s in strs:
            count = [0] * 26
            for c in s:
                count[ord(c) - ord('a')] += 1
            ans[tuple(count)].append(s)
        return ans

strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
obj = GPA(strs)
print(obj.groupAnagrams_1(strs))
print('\n')
print(obj.groupAnagrams_2(strs))
