package org.programmers;

import java.util.*;

public class test43237_budget {

	public static void main(String[] args) {
		test43237_budget t = new test43237_budget();
		int[] budgets = {120, 110, 140, 150};
		t.solution(budgets, 485);

	}
    public int solution(int[] budgets, int M) {
        int answer = 0;
        
        int min = budgets[0];
        int max = budgets[budgets.length-1];
        int mid = 0;
        int sum = 0;
        int preMid = 0;
        
        Arrays.sort(budgets);
        for(int b:budgets)
        	sum += b;
        if(sum == M)
        	return budgets[budgets.length-1];
        
        while(true) {
        	sum = 0;
        	mid = ( min + max ) / 2;
        	System.out.println("max="+max+", min="+min);
        	// min, max 값이 이전과 바뀌지 않는 순간이 온다
        	// 그때의 중간값이 최적의 값이된다
        	// 이전의 mid값과 현재의 mid값이 같으면 끝.
        	if (preMid == mid) {
        		answer = mid;
        		System.out.println(answer);
        		break;
        	}
        	
        	for(int budget:budgets) {
        		if(budget > mid)
        			sum += mid;	// 할당원하는 예산 보다 할당할수있는 예산이 크다면 할당할수있는 예산값으로 더해줘야한다
        		else
        			sum += budget;
        	}
        	
        	// 예상 할당값을 할당했을때 값이 총 예산 보다 크다면 예상 할당 값을 줄인다
        	if (sum > M)
        		max = mid;
        	else if (sum < M)
        		min = mid;
        	
        	preMid = mid;
        }
        
        
        	
        return answer;
    }
    public int solution1(int[] budgets, int M) {
        int answer = 0;
        List<Integer> budget = new ArrayList<>();
         
        Arrays.sort(budgets);
        	
        for(Integer b:budgets)
        	budget.add(b);
        answer = function(budget, M);
        return answer;
    }
    
    
    public static int function(List<Integer> budget, int expect) {
    
    	int answer = 0;
    	int newExpect = budget.get(0) * budget.size();
    
    	if( newExpect == expect)
    		return budget.get(0);
    	else if (newExpect > expect)
    		return expect / budget.size();
    	else if (newExpect < expect) {
    		int remain = expect - newExpect;
    		answer = budget.get(0);
    		
    		
    		budget.remove(0);
    		List<Integer> newBudget = new ArrayList<>();
    		for(int i=0; i<budget.size(); i++)
    			newBudget.add(budget.get(i) - answer);

    		answer += function(newBudget, remain);
    	}
    	return answer;	
    }
}
