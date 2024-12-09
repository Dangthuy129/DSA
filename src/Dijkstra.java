public class Dijkstra {
    static final int V = 5; // Số lượng đỉnh

    // Hàm tìm đỉnh chưa được xử lý có khoảng cách nhỏ nhất
    int minDistance(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++) {
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    // Hàm Dijkstra tìm đường đi ngắn nhất
    void dijkstra(int graph[][], int src) {
        int dist[] = new int[V]; // Mảng lưu khoảng cách ngắn nhất
        Boolean sptSet[] = new Boolean[V]; // Mảng đánh dấu các đỉnh đã xử lý

        // Khởi tạo tất cả các khoảng cách là vô cực và đánh dấu tất cả các đỉnh chưa được xử lý
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Khoảng cách từ đỉnh nguồn đến chính nó là 0
        dist[src] = 0;

        // Tìm đường đi ngắn nhất cho tất cả các đỉnh
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);

            // Đánh dấu đỉnh u đã được xử lý
            sptSet[u] = true;

            // Cập nhật khoảng cách đến các đỉnh kề của u
            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // In kết quả
        printSolution(dist);
    }

    // Hàm in ra kết quả
    void printSolution(int dist[]) {
        System.out.println("Đỉnh \t Khoảng cách từ nguồn");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        // Khai báo đồ thị dưới dạng ma trận kề
        int graph[][] = new int[][]{
                {0, 10, 0, 0, 5},
                {4, 0, 1, 0, 2},
                {0, 8, 0, 4, 0},
                {7, 0, 6, 0, 0},
                {0, 3, 9, 2, 0}
        };

        // Tạo đối tượng Dijkstra và chạy thuật toán từ đỉnh 0
        Dijkstra t = new Dijkstra();
        t.dijkstra(graph, 0);
    }
}
