class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new TrieNode();
            }
            cur = cur.children[i];
        }
        cur.isEndOfWord = true;
    }

    public boolean search(String word) {
        char[] letters = word.toCharArray();
        return dfs(root, letters, 0);
    }

    private boolean dfs(TrieNode node, char[] letters, int i) {
        if (node == null) {
            return false;
        }
        if (i == letters.length) {
            return node.isEndOfWord;
        }
        if (letters[i] != '.') {
            int index = letters[i] - 'a';
            return dfs(node.children[index], letters, i + 1);
        }
        for (int j = 0; j < node.children.length; j++) {
            if (dfs(node.children[j], letters, i + 1)) {
                return true;
            }
        }
        return false;
    }
}
