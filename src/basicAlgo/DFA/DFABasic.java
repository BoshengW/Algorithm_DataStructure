package basicAlgo.DFA;

public class DFABasic {


    public boolean buildDFA(String s, String sub) {

        if(sub=="") {
            return true;
        }
        // button-up

        int n = s.length();
        int[][] dfa = new int[n+1][26];

        for(int i=n-1;i>=0;i--) {
            for(char j='a'; j<='z';j++) {
                dfa[i][j - 'a'] = dfa[i+1][j - 'a'];
            }
            dfa[i][s.charAt(i) - 'a'] = i+1;
        }

        int nextIdx = 0;
        for(int i=0;i<sub.length();i++) {
            nextIdx = dfa[nextIdx][sub.charAt(i) - 'a'];
            if(nextIdx==0) return false;
        }

        return true;

    }



    public static void main(String[] args) {
        String test = "ablgjdgjfjsg";
        String sub = "als";

        DFABasic obj = new DFABasic();
        System.out.println(obj.buildDFA(test, sub));
    }

}

