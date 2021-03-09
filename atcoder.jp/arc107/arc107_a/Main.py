def main():
    a,b,c = map(int, input().split())
    ans = (1 + c) * c // 2 * (1 + b) * b //2  * (1 + a) * a // 2 % 998244353
    print(ans)


if __name__ == '__main__':
    main()
