import java.util.*;

class Solution {

    List<Integer>[] tree;
    int[] parent, depth, heavy, size;
    int[] head, pos;
    int curPos;
    int[] seg;
    int n;

    // 🔥 METHOD NAME & RETURN TYPE MATCH DRIVER
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        size = new int[n];
        Arrays.fill(heavy, -1);

        head = new int[n];
        pos = new int[n];

        dfs(0, -1);
        curPos = 0;
        decompose(0, 0);

        seg = new int[4 * n];
        for (int i = 0; i < n; i++) {
            updateSeg(1, 0, n - 1, pos[i], 1 << (s.charAt(i) - 'a'));
        }

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                updateSeg(1, 0, n - 1, pos[u], 1 << (c - 'a'));
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int mask = queryPath(u, v);
                ans.add(mask == 0 || (mask & (mask - 1)) == 0);
            }
        }

        return ans;
    }

    // ---------- DFS ----------
    private int dfs(int u, int p) {
        size[u] = 1;
        parent[u] = p;
        int maxSize = 0;

        for (int v : tree[u]) {
            if (v != p) {
                depth[v] = depth[u] + 1;
                int sub = dfs(v, u);
                size[u] += sub;
                if (sub > maxSize) {
                    maxSize = sub;
                    heavy[u] = v;
                }
            }
        }
        return size[u];
    }

    // ---------- HLD ----------
    private void decompose(int u, int h) {
        head[u] = h;
        pos[u] = curPos++;

        if (heavy[u] != -1) {
            decompose(heavy[u], h);
        }

        for (int v : tree[u]) {
            if (v != parent[u] && v != heavy[u]) {
                decompose(v, v);
            }
        }
    }

    // ---------- SEGMENT TREE ----------
    private void updateSeg(int idx, int l, int r, int pos, int val) {
        if (l == r) {
            seg[idx] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid) updateSeg(idx * 2, l, mid, pos, val);
        else updateSeg(idx * 2 + 1, mid + 1, r, pos, val);
        seg[idx] = seg[idx * 2] ^ seg[idx * 2 + 1];
    }

    private int querySeg(int idx, int l, int r, int ql, int qr) {
        if (qr < l || r < ql) return 0;
        if (ql <= l && r <= qr) return seg[idx];
        int mid = (l + r) / 2;
        return querySeg(idx * 2, l, mid, ql, qr)
             ^ querySeg(idx * 2 + 1, mid + 1, r, ql, qr);
    }

    // ---------- PATH QUERY ----------
    private int queryPath(int u, int v) {
        int res = 0;
        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int tmp = u; u = v; v = tmp;
            }
            res ^= querySeg(1, 0, n - 1, pos[head[u]], pos[u]);
            u = parent[head[u]];
        }
        if (depth[u] > depth[v]) {
            int tmp = u; u = v; v = tmp;
        }
        res ^= querySeg(1, 0, n - 1, pos[u], pos[v]);
        return res;
    }
}