def solution(message, spoiler_ranges):
    n = len(message)

    # 1. 단어 파싱 (start, end, word)
    words = []
    i = 0
    while i < n:
        if message[i] == ' ':
            i += 1
            continue
        j = i
        while j < n and message[j] != ' ':
            j += 1
        words.append((i, j - 1, message[i:j]))
        i = j

    # 2. 각 문자 reveal 시점
    reveal_time = [0] * n
    for t, (s, e) in enumerate(spoiler_ranges, start=1):
        for i in range(s, e + 1):
            if reveal_time[i] == 0:
                reveal_time[i] = t

    # 3. "완전히 비스포인 단어" 미리 수집
    outside_words = set()
    for s, e, w in words:
        all_outside = True
        for i in range(s, e + 1):
            if reveal_time[i] > 0:
                all_outside = False
                break
        if all_outside:
            outside_words.add(w)

    # 4. 단어별 정보 계산
    word_infos = []
    for idx, (s, e, w) in enumerate(words):
        is_spo_word = False
        max_time = 0

        for i in range(s, e + 1):
            if reveal_time[i] > 0:
                is_spo_word = True
            max_time = max(max_time, reveal_time[i])

        word_infos.append((max_time, s, w, is_spo_word))

    # 5. 시간 + 위치 기준 정렬
    word_infos.sort()

    # 6. 처리
    seen = set()
    count = 0

    for time, s, w, is_spo_word in word_infos:
        if not is_spo_word:
            continue
        if w in outside_words:
            continue
        if w in seen:
            continue

        seen.add(w)
        count += 1

    return count