import sys
input = sys.stdin.readline

N, M = map(int, input().split())

word_memory = []
for _ in range(N):
  word = input().rstrip()
  if len(word) >= M:
    word_memory.append(word)

freq = {}
for word in word_memory:
  freq[word] = freq.get(word, 0) + 1

srt = sorted(freq.keys(), key=lambda word: (-freq[word], -len(word), word))

print('\n'.join(map(str, srt)))