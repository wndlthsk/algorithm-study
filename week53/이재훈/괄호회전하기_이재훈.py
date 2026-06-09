def solution(s):
    def is_valid(string):
        stack = []
        pair = {
            ')': '(',
            ']': '[',
            '}': '{'
        }
        
        for ch in string:
            if ch in '([{':
                stack.append(ch)
            else:
                if not stack or stack[-1] != pair[ch]:
                    return False
                stack.pop()
        
        return not stack
    
    answer = 0
    
    for i in range(len(s)):
        rotated = s[i:] + s[:i]
        
        if is_valid(rotated):
            answer += 1
    
    return answer