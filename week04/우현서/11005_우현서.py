import sys

n, b = map(int, sys.stdin.readline().split())
num_list = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

result = ""
while n > 0:
    n, mod = divmod(n, b) # 몫과 나머지 한번에 구하는 함수
    result = num_list[mod] + result

print(result)