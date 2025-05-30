s = input()
result = []
word = ''
in_tag = False

for char in s:
    if char == '<':
        if word:
            result.append(word[::-1])
            word = ''
        in_tag = True
        result.append(char)
    elif char == '>':
        in_tag = False
        result.append(char)
    elif in_tag:
        result.append(char)
    elif char == ' ':
        if word:
            result.append(word[::-1])
            word = ''
        result.append(char)
    else:
        word += char

if word:
    result.append(word[::-1])

print(''.join(result))
