def sum_of_two_numbers(nums, target):
    required = {}
    for i in range(len(nums)):
        if target - nums[i] in required:
            return [required[target - nums[i]], i]
        else:
            required[nums[i]] = i


array = [2, 3, 123, 33, 12, 432, 234]
print(len(array))
print(sum_of_two_numbers(array, 5))


def longest_substring_without_repeating_chars(text: str):
    if not text:
        raise RuntimeError("String is empty or null")

    i = 0
    chars = [0] * 128
    sub_text = str()
    while i < len(text):
        current_char: int = ord(text[i])
        chars[current_char] += 1
        if chars[current_char] == 1:
            sub_text += text[i]
        i += 1

    chars = list(filter(lambda char: char != 0, chars))
    print("The answer is \"{}\", with the length of \"{}\"".format(sub_text, len(chars)))


longest_substring_without_repeating_chars("abcdac")


def print_zig_zag_text(text, n):
    if n == 1:
        print(text)
        return

    text_length = len(text)
    arr = ["" for _ in range(text_length)]
    row = 0

    for i in range(text_length):

        arr[row] += text[i]
        if row == n - 1:
            down = False
        elif row == 0:
            down = True
        if down:
            row += 1
        else:
            row -= 1

    for i in range(n):
        print(arr[i], end="")


text = "CodeSquadDevelopment"
n = 3
print_zig_zag_text(text, n)
