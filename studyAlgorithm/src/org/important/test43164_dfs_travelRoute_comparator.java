// 다른 풀이 :  https://youjourney.tistory.com/111
package org.important;

import java.util.*;

public class test43164_dfs_travelRoute_comparator {

	public static void main(String[] args) {
		test43164_dfs_travelRoute_comparator t = new test43164_dfs_travelRoute_comparator();
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"},{"SFO","ACD"}};
		t.solution(tickets);
		String[][] tickets2 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		t.solution(tickets2);

	}
	static boolean[] visited;
	static int AllCnt;
	static Map<String, Integer> idxMatch;
	static String[] answer;
	static boolean isfinish;
    public String[] solution(String[][] tickets) {
        
        visited = new boolean[tickets.length];
        AllCnt = tickets.length + 1; // 모든 경유지의 수
        answer = new String[AllCnt];
        
        // 정렬
        ticketSortStart(tickets);
        ticketSortEnd(tickets);
        System.out.println();
        System.out.println("---start---");
        for(int i=0; i<tickets.length; i++) {
        	for(int j=0; j<2; j++) {
        		System.out.print(tickets[i][j]+" ");
        	}
        	System.out.println();
        }
        
        // 위치 뽑기
        idxMatch = new HashMap<String, Integer>();
        for(int i=0; i<tickets.length; i++) {
        	if(!idxMatch.containsKey (tickets[i][0])) {
        		idxMatch.put(tickets[i][0], i);
        	}
        }
        
        List<String> route = new ArrayList<String>();
        //visited[idxMatch.get("ICN")] = true;
        route.add("ICN");
        
        findRoute(tickets, "ICN", 1, route);
        
        return answer;
    }
    
    public static void findRoute(String[][] tickets, String start, int curCnt, List<String> route) {
    	System.out.println("start : "+start);
    	if(isfinish == true )
    		return;
    	if(curCnt == AllCnt) {
    		isfinish = true;
    		System.out.println("-----");
    		for(int i=0; i<AllCnt; i++) {
    			System.out.print(route.get(i)+" ");
    			answer[i] = route.get(i);
    		}
    		return;
    	}
    	else {
    		// 이걸로 시작하는게 없으면 패쓰
    		if(!idxMatch.containsKey(start)) return;
    		
    		int idx = idxMatch.get(start);
    		System.out.println(idx);
    		int next = 0;
    		while (tickets[ idx + next][0].equals(start)) {
    			if(visited[idx+next] == false) {
    				route.add(tickets[ idx + next][1]);
    				visited[idx+next] = true;
    				findRoute(tickets, tickets[idx + next][1] , curCnt+1, route);
    				route.remove(route.size()-1);
    				visited[idx+next] = false;
    		
    			}
    			next++;
    			// 더이상 방문할수있는 곳이 없다면 끝
    			if(idx + next >= visited.length )
    				return;
    		
    		}
    	}
    }
    
    public static void ticketSortStart(String[][] tickets) {

    	Arrays.sort(tickets, new Comparator<String[]>() {
			public int compare(String[] arr1, String[] arr2) {
					return ((Comparable) arr1[0]).compareTo(arr2[0]);
			}
		});
    }
    public static void ticketSortEnd(String[][] tickets) {

    	Arrays.sort(tickets, new Comparator<String[]>() {
			public int compare(String[] arr1, String[] arr2) {
				if(arr1[0].equals(arr2[0]))
					return ((Comparable) arr1[1]).compareTo(arr2[1]);
				else 
					return 0;
			}
		});
    }
}
