import sys

lst = list(sys.stdin.readline().rstrip())
# print(lst)

stack = []
for l in lst:
    if l == '(' or l == '[':
        stack.append(l)

    elif l == ')' or l == ']':
        if not stack:
            print(0)
            exit(0)

        temp = 0
        while stack:
            top = stack.pop()

            if type(top) == int:
                temp += top
            elif (top=='(' and l==')') or (top=='[' and l==']'):
                if temp == 0:
                    if l == ')':
                        stack.append(2)
                    else:
                        stack.append(3)
                else:
                    if l == ')':
                        stack.append(temp * 2)
                    else:
                        stack.append(temp * 3)
                break
            else:
                print(0)
                exit(0)
        else: # stack이 비어서 while문이 끝난 경우(여는 괄호 못찾고 끝남)
            print(0)
            exit(0)

result = 0
for x in stack:
    if type(x) == int:
        result += x
    else:
        print(0)
        exit(0)
print(result)