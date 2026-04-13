class Solution {

    public List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder());
        return res;
    }

    private void dfs(int n, int open, int closed, StringBuilder sb) {
        if (open == n && closed == n) {
            res.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            dfs(n, open + 1, closed, sb);
            sb.setLength(sb.length() - 1);
        }
        if (closed < open) {
            sb.append(")");
            dfs(n, open, closed + 1, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
