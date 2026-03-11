def solution(schedules, timelogs, startday):
    cnt = 0
    for t, times in enumerate(timelogs):
        hope_h, hope_m = schedules[t] // 100, schedules[t] % 100
        next_m = hope_m + 10
        need_h, need_m = hope_h + (next_m // 60), next_m % 60
        need_time = need_h * 100 + need_m
        check = startday
        is_fail = False
        for x in times:
            if check > 7:
                check = 1
            if check > 5:
                check += 1
                continue
            
            if not (x <= need_time):
                is_fail = True
                break
            check += 1
        if not is_fail:
            cnt += 1
    return cnt