def main():
    n = int(input())
    h = [0] + list(map(int, input().split()))
    dp = [float('inf')] * (n + 1)
    dp[1] = 0
    for i in range(1,n):
        dp[i+1] = min(dp[i+1], dp[i] + abs(h[i+1] - h[i]))
        if i + 2 > n:
            break
        dp[i+2] = min(dp[i+2], dp[i] + abs(h[i+2] - h[i]))
    print(dp[n])

if __name__ == '__main__':
    main()
