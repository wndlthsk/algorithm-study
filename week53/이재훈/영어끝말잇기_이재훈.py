def solution(n, words):
    used = set()
    
    for i, word in enumerate(words):
        if word in used or (i > 0 and words[i - 1][-1] != word[0]):
            person = i % n + 1
            turn = i // n + 1
            return [person, turn]
        
        used.add(word)
    
    return [0, 0]