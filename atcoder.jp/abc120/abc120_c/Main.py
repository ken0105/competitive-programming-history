from collections import deque

if __name__ == '__main__':
    s = input()
    print(min(s.count("1"), s.count("0")) * 2)

