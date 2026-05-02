def solution(common):
    diff = common[1] - common[0]
    if common[1] + diff == common[2]:
        return common[-1] + diff
    else:
        diff = common[1] / common[0]
        return common[-1] * diff