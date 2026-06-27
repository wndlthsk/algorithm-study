def solution(n, lost, reserve):
    lost = set(lost)
    reserve = set(reserve)

    both = lost & reserve
    lost -= both
    reserve -= both

    for student in sorted(reserve):
        if student - 1 in lost:
            lost.remove(student - 1)
        elif student + 1 in lost:
            lost.remove(student + 1)

    return n - len(lost)