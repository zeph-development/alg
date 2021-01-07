def number_of_carry_operation(a, b):
    carry = 0
    operation_count = 0
    while a > 0 or b > 0:
        a_reminder = int(a % 10)
        a = a / 10

        b_reminder = int(b % 10)
        b = b / 10

        if a_reminder + b_reminder + carry >= 10:
            operation_count += 1
            carry = 1
        else:
            carry = 0

    return operation_count


print(number_of_carry_operation(123, 456))
print(number_of_carry_operation(555, 555))
print(number_of_carry_operation(900, 11))
print(number_of_carry_operation(145, 55))
print(number_of_carry_operation(0, 0))
print(number_of_carry_operation(1, 99999))
print(number_of_carry_operation(999045, 1055))
print(number_of_carry_operation(101, 809))
print(number_of_carry_operation(189, 209))
