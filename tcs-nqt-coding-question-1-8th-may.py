# Online Python compiler (interpreter) to run Python online.
# Write Python 3 code in this online editor and run it.
a = int(input())
b = int(input())

rem = a % b
quo = a // b

nn = a - rem # nn - nearest number to a
fn = a - rem + b # fn - far number from a

dnn = abs(a - nn) # difference between a and nearest number
dfn = abs(a - fn) #  difference between a and farest number

res = min(dnn,dfn)

if res == dnn:
    print(nn)
else:
    print(fn)
