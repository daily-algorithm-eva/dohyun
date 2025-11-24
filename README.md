📘 DoHyun Algorithm Repository – EVA 개인 알고리즘 아카이브

“최소 하루 1문제, 반복 학습은 W1 → W2 → W3”
Issue · PR 중심의 체계적인 알고리즘 학습 레포지토리

🧭 목표 (Goals)

하루 1문제 이상 풀이

**오답 회차 관리(W1 ~ W3)** 반복 훈련 진행

PR 기반 코드리뷰 → 품질 향상

Issue 기반 학습 기록 아카이브

유형별 솔루션 정리로 장기 자산화

📂 디렉토리 구조
solved/
├── boj/
│ ├── wrong-1/ # 1회차 오답
│ ├── wrong-2/ # 2회차 오답
│ ├── wrong-3/ # 3회차 오답
│ └── solved/ # 최종 정답 코드
│ ├── greedy/
│ ├── bfs/
│ ├── dfs/
│ └── ...
└── programmers/
├── wrong-1/
├── wrong-2/
├── wrong-3/
└── solved/
├── greedy/
├── bfs/
├── dfs/
└── ...

🌿 브랜치 전략 (Branch Strategy)
브랜치명 역할
main 최종 정리본
solved 모든 정답 코드 모음
wrong-1 1회차 오답 정리
wrong-2 2회차 오답 정리
wrong-3 3회차 오답 정리
boj/<번호> 백준 문제 단위 작업 브랜치 (boj/1123)
prog/<번호> 프로그래머스 문제 단위 작업 브랜치 (prog/12909)
🔄 문제 풀이 Flow
1️⃣ 문제 풀이 시작

BOJ → boj/<문제번호> 브랜치 생성

Programmers → prog/<문제번호> 브랜치 생성

2️⃣ 오답일 경우

오답 횟수에 따라 다음 브랜치로 PR 생성:

1회차 오답 → wrong-1

2회차 오답 → wrong-2

3회차 오답 → wrong-3

각 PR 머지 후 Issue 생성:
[W1] BOJ 1102 형태로 기록

3️⃣ 재도전

지정된 날짜 이후 다시 풀기 → 또 틀리면 다음 wrong 회차로 이동
Issue는 같은 이슈 번호에 결과를 갱신

4️⃣ 정답을 맞춘 경우

solved 브랜치로 PR

유형별 폴더로 파일 이동 (greedy/bfs/dfs 등)

📝 Issue · PR 템플릿 규칙
📌 Issue 예시
[W1] BOJ 1629 곱셈

- 첫 시도 풀이
- 어디서 틀렸는지 분석
- 다음 재도전 예정일: 2025-02-01

📌 PR 제목 규칙
상황 예시
1회차 오답 W1: BOJ 1629
2회차 오답 W2: BOJ 1629
최종 정답 Solved: BOJ 1629
