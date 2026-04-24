def solution(id_pw, db):
    srt = sorted(db, key=lambda x: x[0])
    
    for s in srt:
        if id_pw == s:
            return "login"
        if s[0] == id_pw[0] and s[1] != id_pw[1]:
            return "wrong pw"
    
    return "fail"