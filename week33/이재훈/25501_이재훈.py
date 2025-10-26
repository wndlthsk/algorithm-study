T = int(input())

def recursion(str, left, right):
  if left >= right:
    return 1, 1
  if str[left] != str[right]:
    return 0, 1
  
  is_p, call_cnt = recursion(str, left + 1, right - 1)
  return is_p, call_cnt + 1

for _ in range(T):
  string = input()
  is_palindrome, call_cnt = recursion(string, 0, len(string) - 1)
  print(is_palindrome, call_cnt)