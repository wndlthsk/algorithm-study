def solution(my_string, queries):
    string = list(my_string)
    for s, e in queries:
        string[s : e+1] = string[s : e+1][::-1]
    
    return ''.join(string)