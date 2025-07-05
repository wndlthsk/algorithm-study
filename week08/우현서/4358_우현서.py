import sys
from collections import defaultdict

trees = defaultdict(int)
count = 0

while True:
    tree = sys.stdin.readline().rstrip()
    if not tree:
        break
    trees[tree] += 1
    count += 1

sorted_trees = sorted(trees.items())
for i, j in sorted_trees:
    print(f"{i} {j / count * 100:.4f}") # round(j/count*100, 4)는 소수점 4자리 고정이 안됨.
