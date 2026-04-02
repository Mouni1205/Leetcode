class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> solutions = new ArrayList<String>();
    restoreIp(s, solutions, 0, "", 0);
    return solutions;
}

private void restoreIp(String ip, List<String> solutions, int idx, String restored, int count) {
    if (count == 4) {
        if (idx == ip.length()) solutions.add(restored); // Add valid IP
        return; // Stop recursion when count is 4
    }
    
    for (int i = 1; i < 4; i++) {
        if (idx + i > ip.length()) break;
        //decides where you want to put .
        String s = ip.substring(idx, idx + i);
        //check if where you are putting . after a string, would that string start with 0 or >256 then abort
        if ((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) >= 256)) continue;
        //add that to the current string and add .  and increase count 
        restoreIp(ip, solutions, idx + i, restored + s + (count == 3 ? "" : "."), count + 1);
    }
}
    
}