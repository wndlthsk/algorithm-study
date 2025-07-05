class Node(object):
    def __init__(self, key, data=None):
        self.key = key # 현재 노드의 문자
        self.data = data # 단어 끝인지 여부 (None이면 단어 끝이 아님)
        self.children = {}

class Trie(object):
    def __init__(self): # 루트 노드 생성
        self.head = Node(None)

    def insert(self, string):
        now = self.head
        for char in string:
            if char not in now.children:
                now.children[char] = Node(char)
            now = now.children[char]
        now.data = string
        same_nickname[string] += 1 # 같은 닉네임 카운트

    def search(self, string):
        now = self.head
        alias = ''
        for char in string:
            alias += char
            if char in now.children:
                now = now.children[char] # 다음 노드로 이동
            else:
                return alias # 현재 닉네임에 존재하지 않는 글자 나오면 alias 정해짐

        if now.data is not None: # 같은 닉네임이 있으면 숫자 붙이기
            alias += str(same_nickname[string] + 1)

        return alias


import sys
from collections import defaultdict

n = int(sys.stdin.readline())

nickname = []
same_nickname = defaultdict(int)

trie = Trie() # 같은 트라이에서 검색하고 삽입하기 위해

# 최소한의 고유한 접두사 찾고, 후에 삽입해야 함.
# 아니면 이미 단어가 존재하는 상태기 때문에 중복된 닉네임인지 바로 알 수 없음
for i in range(n):
    nickname.append(sys.stdin.readline().strip())

    print(trie.search(nickname[i]))
    trie.insert(nickname[i])
