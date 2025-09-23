class Stack:
  def __init__(self):
    self.stk = []

  def push(self, x):
    self.stk.append(x)

  def pop(self):
    return self.stk.pop() if self.stk else -1

  def size(self):
    return len(self.stk)

  def empty(self):
    return 0 if self.stk else 1

  def top(self):
    return self.stk[-1] if self.stk else -1


N = int(input())
stack = Stack()

for _ in range(N):
  cmd = input().split()
  if cmd[0] == "push":
    stack.push(cmd[1])
  elif cmd[0] == "pop":
    print(stack.pop())
  elif cmd[0] == "size":
    print(stack.size())
  elif cmd[0] == "empty":
    print(stack.empty())
  elif cmd[0] == "top":
    print(stack.top())