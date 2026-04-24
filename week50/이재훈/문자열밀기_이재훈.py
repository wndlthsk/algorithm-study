def solution(A, B):
    n = len(A)

    for i in range(n):
        if A[-i:] + A[:-i] == B:
            return i
        
    return -1