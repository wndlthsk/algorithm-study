cnt_A, cnt_B = map(int, input().split())
A = set(map(int, input().split()))
B = set(map(int, input().split()))

a_minus_b = A - B
b_minus_a = B - A

res = a_minus_b | b_minus_a
print(len(res))