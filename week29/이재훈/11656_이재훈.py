S = input()

suffix = [S[i:] for i in range(len(S))]
print('\n'.join(sorted(suffix)))