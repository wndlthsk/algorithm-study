def solution(m, musicinfos):
    def convert(part, melodys):
        for key, value in melodys.items():
            part = part.replace(key, value)

        return part
    
    def get_playing_sec(before, after):
        b_hh, b_mm = map(int, before.split(':'))
        a_hh, a_mm = map(int, after.split(':'))
        h = a_hh - b_hh
        m = a_mm + h * 60 - b_mm
        
        return m
    
    melodys = {
        "C#": "c", "D#": "d", "F#": "f",
        "G#": "g", "A#": "a",
    }

    timeline = []
    for x in musicinfos:
        before, after, title, lylic = x.split(',')
        sec = get_playing_sec(before, after)
        lylic = convert(lylic, melodys)
        
        lylic_dup = lylic * ((sec // len(lylic)) + 1)
        timeline.append((title, sec, lylic_dup[:sec]))
    
    cvrt_m = convert(m, melodys)
    res_title = ''
    res_sec = 0
    for x in timeline:
        if cvrt_m in x[2] and res_sec < x[1]:
            res_title = x[0]
            res_sec = x[1]
    
    return res_title if res_title else "(None)"