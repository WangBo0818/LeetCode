/**
 * @author wb
 * @date 2019/12/21 - 18:36
 * 剑指offer---5.替换空格
 */
public class SwordMeansOffer_5_ReplaceSpace {
    /**
     * 解法一
     * */
    public String replaceSpace(StringBuffer str) {
        StringBuffer st = new StringBuffer();
        for(int i = 0; i < str.length() ; i++){
            char s = str.charAt(i);
            if(String.valueOf(s).equals(" ")){
                st.append("%20");
            }else{
                st.append(s);
            }
        }
        return st.toString();
    }

    /**
     *解法二
     * */
    public String replaceSpace2(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }
}
