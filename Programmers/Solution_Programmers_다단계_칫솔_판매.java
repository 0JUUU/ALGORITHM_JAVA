import java.util.HashMap;

class Solution_Programmers_다단계_칫솔_판매 {
	static class Employee{
		String name;
		int num;
		int result;
		public Employee(String name, int num) {
			super();
			this.name = name;
			this.num = num;
			this.result = 0;
		}
	}
	
	static public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};
        int employeeCnt = enroll.length;
        int[] parent = new int[employeeCnt+1];
        HashMap<String, Integer> map = new HashMap<>();
        Employee[] emp = new  Employee[employeeCnt+1];
        for(int i = 1; i<=employeeCnt;i++) {
        	emp[i] = new Employee(enroll[i-1], i);
        	map.put(enroll[i-1], i);
        }
        
        for(int i = 1; i<=employeeCnt;i++) {
        	String parentName = referral[i-1];
        	if(parentName.equals("-")) {
        		parent[i] = 0;
        	} else {
        		int parentNum = map.get(parentName);
        		parent[i] = parentNum;
        	}
        }
        
        for(int i = 0, len = seller.length;i<len;i++) {
        	String sellerName = seller[i];
        	int sellCnt = amount[i];
        	int money = sellCnt * 100;
        	int sellerNum = map.get(sellerName);
        	int index = sellerNum;
        	if(parent[index] == 0) {
        		emp[index].result += money - (int)(money*0.1);
        	}
        	else {
            	while(true) {
            		if(parent[index] == 0) {
            			emp[index].result += money - (int)(money*0.1);
            			break;
            		}
            		emp[index].result += money - (int)(money*0.1);
            		index = parent[index];
            		money = (int)(money*0.1);
            	}
        	}

        }
        
        answer = new int[employeeCnt];
        for(int i = 1; i<=employeeCnt;i++) {
        	answer[i-1] = emp[i].result;
        }
        return answer;
    }
}