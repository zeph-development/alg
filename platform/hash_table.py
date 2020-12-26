# https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
# Hash Tables: Ransom Note

def add_m(map, key):
    if key in map:
        map[key] += 1
    else:
        map[key] = 1


def check_magazine(magazine, note):
    mc, nc = {}, {}
    for m in magazine.split(" "):
        add_m(mc, m)

    for n in note.split(" "):
        add_m(nc, n)

    answer = True
    for n_key in nc.keys():
        if n_key not in mc or mc[n_key] - nc[n_key] < 0:
            answer = False

    if answer:
        print("Yes")
    else:
        print("No")


check_magazine("ive got a lovely bunch of coconuts", "ive got some coconuts")
