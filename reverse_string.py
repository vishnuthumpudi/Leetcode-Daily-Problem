with open("user.out", "w") as f:
    for case in stdin:
        f.write(f"{dumps(loads(case.strip())[::-1]).replace(', ', ',')}\n")
exit()  
