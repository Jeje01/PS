/**
 * 캐슬 디펜스 - G4
 * 시뮬레이션
 * 43,108 kb
 * 892 ms
 * 
 * * 풀이
 * 모든 적을 리스트에 넣고 매 공격 매 궁수마다 정렬해서 첫번째 적을 구함
 * -> 리스트 말고 입력대로 행렬에 관리하며 거리를 늘려가며 왼쪽부터 탐색해서 처음 나오는 적으로 하면 됨 : 제일 빠르다고 함
 * 
 * 궁수 위치는 열 값만 관리/ 행은 전체에 하나로 관리
 * 
 * while문 돌 때 List, Set, int 값 등 초기화 잊지 않기
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, D, answer, kill, archerR;
	static List<Integer> archers = new ArrayList<>();
	static List<Enemy> enemies = new ArrayList<>();
	static List<Enemy> tmpEnemies = new ArrayList<>();
	static Set<Integer> set = new HashSet<>();

	static class Enemy{
		int idx;
		int r;
		int c;
		
		public Enemy(int idx, int r, int c) {
			super();
			this.idx = idx;
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Enemy [idx=" + idx + ", r=" + r + ", c=" + c + "]";
		}
		
		

	}

	
	
	static int attackEnemies() {
		while(true) {
			if(enemies.size()==0) break;
			for(int i=0; i<3; i++) { // 궁스가 공격할 적
				int next = archers.get(i);
				Collections.sort(enemies, (o1, o2)->{
					int dis1 = Math.abs(o1.r-archerR)+Math.abs(o1.c-next);
					int dis2 = Math.abs(o2.r-archerR)+Math.abs(o2.c-next);
					if(dis1==dis2) {
						return Integer.compare(o1.c, o2.c);
					}else {
						return Integer.compare(dis1, dis2);
					}
				});
				int dis = Math.abs(enemies.get(0).r-archerR)+Math.abs(enemies.get(0).c-next);
				if(dis<=D) set.add(enemies.get(0).idx);
			}
			Iterator<Integer> it = set.iterator();
			while(it.hasNext()) {
				int n = it.next();
				for(int i=0; i<enemies.size(); i++) {
					if(enemies.get(i).idx==n ) {
						enemies.remove(i);
						kill++;
					}
				}
			}
			archerR--;


			int listIdx = 0;
			while(enemies.size()!=0 && listIdx < enemies.size()) {
				if(enemies.get(listIdx).r>=archerR) {
					enemies.remove(listIdx);
				}else {
					listIdx++;
				}
			}
			set.clear();
			if(enemies.size()==0) break;
			
		}
		
		return kill;
	}
	
	static void makeCombination(int flag, int idx, int start) {
		if(idx==3) {
			archers.clear();
			for(int i=0; i<M; i++) {
				if((flag&1<<i)!=0) {
					archers.add(i);
				}
			}
			enemies.clear();
			for(Enemy e: tmpEnemies) {
				enemies.add(e);
			}
			kill = 0;
			archerR = N;
			int success = attackEnemies();
			answer = Math.max(success, answer);
			set.clear();
			return;
		}
		for(int i=start; i<M; i++) {
			if((flag&1<<i)==0) {
				makeCombination(flag|1<<i, idx+1, i+1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken()); // 성의 개수
		D = Integer.parseInt(tokens.nextToken());
		int eIdx = 0;
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<M; j++) {
				String tmp = tokens.nextToken();
				if(tmp.equals("1")) { // 적이면
					enemies.add(new Enemy(eIdx++, i, j));
				}
			}
		}
		for(Enemy e: enemies) {
			tmpEnemies.add(e);
		}
		makeCombination(0, 0, 0);
		output.append(answer);
		System.out.println(output.toString());
	}
}
