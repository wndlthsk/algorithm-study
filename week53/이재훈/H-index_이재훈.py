def solution(citations):
    citations.sort(reverse=True)

    h = 0

    for i, citation in enumerate(citations, start=1):
        if citation >= i:
            h = i
        else:
            break

    return h