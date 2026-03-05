N = int(input())
size_numbers = list(map(int, input().split()))
T, P = map(int, input().split())

mod = 0
for cnt in size_numbers:
  mod += (cnt + T - 1) // T

print(mod)
print(N // P, N % P)