def solution(wallpaper):
    rows = []
    cols = []

    for r in range(len(wallpaper)):
        for c in range(len(wallpaper[r])):
            if wallpaper[r][c] == "#":
                rows.append(r)
                cols.append(c)

    return [min(rows), min(cols), max(rows) + 1, max(cols) + 1]