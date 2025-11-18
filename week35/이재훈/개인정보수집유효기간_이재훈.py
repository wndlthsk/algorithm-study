# 날짜를 day 단위로 변환
def to_days(date):
    y, m, d = map(int, date.split('.'))
    return y * 12 * 28 + m * 28 + d

def solution(today, terms, privacies):
    today_days = to_days(today)

    # 약관 딕셔너리
    dic = {}
    for t in terms:
        key, val = t.split()
        dic[key] = int(val) * 28   # 개월 → 일로 변환

    res = []

    for idx, p in enumerate(privacies):
        date, term_type = p.split()
        start = to_days(date)
        expire = start + dic[term_type]   # 만료일

        # 만료일 < 오늘 → 폐기 대상
        if expire <= today_days:
            res.append(idx + 1)

    return res
