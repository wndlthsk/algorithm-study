def solution(dartResult):
    scores = []
    i = 0

    while i < len(dartResult):
        if dartResult[i:i+2] == "10":
            num = 10
            i += 2
        else:
            num = int(dartResult[i])
            i += 1

        bonus = dartResult[i]
        i += 1

        if bonus == "S":
            score = num ** 1
        elif bonus == "D":
            score = num ** 2
        else:
            score = num ** 3

        if i < len(dartResult):
            if dartResult[i] == "*":
                score *= 2

                if scores:
                    scores[-1] *= 2

                i += 1

            elif dartResult[i] == "#":
                score *= -1
                i += 1

        scores.append(score)

    return sum(scores)