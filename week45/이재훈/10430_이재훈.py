A, B, C = map(int, input().split())

a_mod = A % C
b_mod = B % C

print((A + B) % C)
print((a_mod + b_mod) % C)
print((A * B) % C)
print((a_mod * b_mod) % C)