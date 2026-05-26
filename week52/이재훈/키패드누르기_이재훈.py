def solution(numbers, hand):
    pos = {
        1: (0, 0), 2: (0, 1), 3: (0, 2),
        4: (1, 0), 5: (1, 1), 6: (1, 2),
        7: (2, 0), 8: (2, 1), 9: (2, 2),
        '*': (3, 0), 0: (3, 1), '#': (3, 2),
    }
    def get_distance(x, thumb):
        cur_x, cur_y = pos[x]
        thumb_x, thumb_y = pos[thumb]

        return abs(cur_x - thumb_x) + abs(cur_y - thumb_y)
    
    left_thumb = '*'
    right_thumb = '#'
    
    res = []
    for x in numbers:
        if x in [1, 4, 7]:
            left_thumb = x
            res.append('L')
        elif x in [3, 6, 9]:
            right_thumb = x
            res.append('R')
        else:
            l_dist = get_distance(x, left_thumb)
            r_dist = get_distance(x, right_thumb)
            
            if l_dist < r_dist:
                left_thumb = x
                res.append('L')
            elif l_dist > r_dist:
                right_thumb = x
                res.append('R')
            elif l_dist == r_dist:
                if hand == 'left':
                    left_thumb = x
                    res.append('L')
                else:
                    right_thumb = x
                    res.append('R')
    
    return ''.join(res)