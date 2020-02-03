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
        	// min, max ���� ������ �ٲ��� �ʴ� ������ �´�
        	// �׶��� �߰����� ������ ���̵ȴ�
        	// ������ mid���� ������ mid���� ������ ��.
        	if (preMid == mid) {
        		answer = mid;
        		System.out.println(answer);
        		break;
        	}
        	
        	for(int budget:budgets) {
        		if(budget > mid)
        			sum += mid;	// �Ҵ���ϴ� ���� ���� �Ҵ��Ҽ��ִ� ������ ũ�ٸ� �Ҵ��Ҽ��ִ� ���갪���� ��������Ѵ�
        		else
        			sum += budget;
        	}
        	
        	// ���� �Ҵ簪�� �Ҵ������� ���� �� ���� ���� ũ�ٸ� ���� �Ҵ� ���� ���δ�
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
