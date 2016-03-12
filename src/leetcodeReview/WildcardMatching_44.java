package leetcodeReview;

public class WildcardMatching_44 {
	public boolean isMatch(String s, String p) {
		int s_pos=0;
        int p_pos=0;
        int s_star_pos=0;
        int p_star_pos=0;
        boolean findStar=false;
        while(s_pos<s.length()){
        		if(p_pos<p.length()&&(p.charAt(p_pos)=='?'||p.charAt(p_pos)==s.charAt(s_pos))){
        			p_pos++;
        			s_pos++;
        			continue;
        		}
        		if(p_pos<p.length()&&p.charAt(p_pos)=='*'){
        			p_star_pos=p_pos;
        			s_star_pos=s_pos;
        			p_pos++;
        			findStar=true;
        			continue;
        		};
        		if(findStar){
        			s_pos=++s_star_pos;
        			p_pos=p_star_pos;
        			p_pos++;
        			continue;
        		}
        		return false;
        }
        if(s_pos!=s.length())
            return false;
        while(p_pos<p.length()&&p.charAt(p_pos)=='*')
        		p_pos++;
        return p_pos==p.length();
    }
}
