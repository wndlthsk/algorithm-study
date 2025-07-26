def solution(bandage, health, attacks):
    answer = health
    cnt = 0 #연속 붕대감기 스택
    start = 0
    for t,attack in attacks: #t는 공격시간, attack은 공격할 때 데미지
        cnt = t- start-1 #(다음 공격까지의 텀//초)
        answer+=bandage[1]*cnt  #다음 공격까지 체력회복
        cnt =cnt// bandage[0]   #다음 공격까지 모을 수 있는 스택
        
        if cnt != 0:
            answer+=bandage[2]*cnt #추가 회복하기
            
        if answer > health: #최대체력은 넘어가면 안됨
                answer= health
        answer-=attack
        cnt = 0  #공격 맞으면 초기화
        if answer<=0:
            return -1
        start = t
    return answer