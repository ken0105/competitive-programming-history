from collections import deque


def main():
    n,m = map(int, input().split())
    l = [[] for _ in range(n)]
    dist = [0] * n
    for _ in range(m):
        a,b = map(lambda x : int(x) - 1, input().split())
        l[a].append(b)
    queue = deque()
    queue.append(0)
    while queue:
        land = queue.pop()
        candidate = l[land]
        for i in candidate:
            if dist[i] == 0:
                queue.append(i)
                dist[i] = dist[land] + 1
    if dist[n-1] == 2:
        print("POSSIBLE")
    else:
        print("IMPOSSIBLE")





if __name__ == '__main__':
    main()
