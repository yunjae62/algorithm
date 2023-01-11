"""
    숨바꼭질 3 (Gold 5)
    https://www.acmicpc.net/problem/13549
"""

from collections import deque

MAX_NUM = 100_001 # 위치값의 범위 0 ~ 100,000
N, K = map(int, input().split())
visited = [False] * MAX_NUM # 방문 여부 기록
sec_list = [0] * MAX_NUM # 각 좌표에 도달할 때의 시간 기록

def bfs(): # bfs로 한칸 전, 후, 2배로 이동하는 3가지 경우를 q에 넣어 최단시간 기록
    dq = deque() # 덱.
    dq.append(N) # 최초 시작점 삽입
    visited[N] = True # 최초 시작점 방문 체크
    sec_list[N] = 0 # 최초 시작점에선 시간은 0초

    while dq:
        nxt = dq.popleft()
        if nxt == K: # 동생의 위치에 도달시 함수 종료
            return
        # *** 순간이동은 0초이므로 덱의 맨 앞에 넣어서 최우선으로 처리!!
        if nxt * 2 < MAX_NUM and not visited[nxt * 2]: # 순간이동(현재 위치에 2배)이 범위 내에 있고 방문 안 했으면,
            dq.appendleft(nxt * 2) # 최우선으로 덱에서 처리하고자 맨 앞에 넣음.  ***
            visited[nxt * 2] = True
            sec_list[nxt * 2] = sec_list[nxt] # 순간이동은 0초이니까 시간은 동일.

        if 0 <= nxt - 1 < MAX_NUM and not visited[nxt - 1]: # 한칸 앞이 범위 내에 있고 방문 안 했으면
            dq.append(nxt - 1) # 큐에 넣고,
            visited[nxt - 1] = True # 방문 체크를 하고,
            sec_list[nxt - 1] = sec_list[nxt] + 1 # 현재까지 걸린 시간에 + 1 초

        if nxt + 1 < MAX_NUM and not visited[nxt + 1]: # 한칸 뒤가 범위 내에 있고 방문 안 했으면, 이후 똑같음.
            dq.append(nxt + 1)
            sec_list[nxt + 1] = sec_list[nxt] + 1
            visited[nxt + 1] = True

bfs()

print(sec_list[K]) # 동생의 위치에 도달했을 때의 걸린 시간 출력.

"""
5 17

"""
