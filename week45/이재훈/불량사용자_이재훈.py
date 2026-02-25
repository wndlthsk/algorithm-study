# banned_id 하나를 보고, user_id를 하나씩 순회하며 가능한 지 체크.
# 가능한 경우에서(이미 매핑된 user_id 제외) + "다음" banned_id를 보고, user_id 하나씩 순회

def solution(user_id, banned_id):
    used = [False] * len(user_id)
    res = set()
    
    def canBe(ban_user, user_name):
        if len(ban_user) != len(user_name):
            return False
        for b, u in zip(ban_user, user_name):
            if b != '*' and b != u:
                return False
        return True
    
    def dfs(ban_idx):
        if ban_idx == len(banned_id):
            selected = []
            for i in range(len(user_id)):
                if used[i]:
                    selected.append(user_id[i])
            res.add(tuple(sorted(selected)))
            return
        
        for idx, user in enumerate(user_id):
            if not used[idx] and canBe(banned_id[ban_idx], user):
                used[idx] = True
                dfs(ban_idx + 1)
                used[idx] = False
    dfs(0)
    
    return len(res)