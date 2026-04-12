f_body, f_tail = input().split()
m_body, m_tail = input().split()

s = set([f_body, f_tail, m_body, m_tail])

srt = sorted(s)

for body in srt:
  for tail in srt:
    print(body, tail)