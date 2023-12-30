# Sales by match
# https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

def socks_merchant(n, ar):
    pairs = 0
    socks_by_color = [0] * 256
    i = 0
    while i < n:
        socks_by_color[ar[i]] += 1
        if socks_by_color[ar[i]] % 2 == 0:
            pairs += 1
        i += 1
    return pairs


socks = [10, 20, 20, 10, 10, 30, 50, 10, 20]
print(socks_merchant(len(socks), socks))


# https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
# Counting Valleys

def counting_valleys(steps, path):
    valleys_count = 0
    level = 0
    for i, char in enumerate(path):
        if char == 'D':
            level -= 1
        else:
            level += 1

        if level == 0 and path[i] == 'U':
            valleys_count += 1

    return valleys_count


path = "UDDDUDUU"
print(counting_valleys(len(path), path))


# https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?filter=python3&filter_on=language&h_l=interview&page=1&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup&h_r=next-challenge&h_v=zen
# Jumping on the clouds

def jumping_on_clouds(c):
    i = 0
    jumps_count = 0
    while i < len(c) - 1:
        if i < len(c) - 2 and c[i + 2] == 0:
            jumps_count += 1
            i += 2
        elif c[i + 1] == 1:
            jumps_count += 1
            i += 2
        else:
            jumps_count += 1
            i += 1
    return jumps_count


clouds = [0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0,
          0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0,
          1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0]
print(jumping_on_clouds(clouds))


# https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
# Repeated string

def repeated_string(s, n):
    int_repeat_number = int(n / len(s))
    int_repeat_reminder = n % len(s)
    return list(s).count('a') * int_repeat_number \
           + list(s[0:int_repeat_reminder]).count('a')


s = 'aba'
n = 10
print(repeated_string(s, n))
