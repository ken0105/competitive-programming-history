def main():
    a, b, x, = map(int, input().split())
    if a * 1 + b * 1 > x:
        print(0)
        exit()

    ok = 1
    ng = 10 ** 9 + 1
    while abs(ok - ng) > 1:
        mid = (ok + ng) // 2
        if is_ok(a,b,mid,x):
            ok = mid
        else:
            ng = mid
    print(ok)

def is_ok(a, b, mid, x):
    return a * mid + b * len(str(mid)) <= x


if __name__ == '__main__':
    main()
