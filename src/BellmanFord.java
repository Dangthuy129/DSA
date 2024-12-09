import java.util.ArrayList;
import java.util.List;

public class BellmanFord {
    static class Edge {
        int source, target, weight;
        Edge(int source, int target, int weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }
    }

    // Hàm Bellman-Ford tìm đường đi ngắn nhất từ đỉnh nguồn
    public static void bellmanFord(List<Edge> edges, int vertices, int source) {
        int[] distances = new int[vertices];
        // Khởi tạo khoảng cách đến tất cả các đỉnh là vô cùng lớn (trừ đỉnh nguồn)
        for (int i = 0; i < vertices; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[source] = 0;

        // Thực hiện V-1 lần lặp để tìm đường đi ngắn nhất
        for (int i = 1; i < vertices; i++) {
            for (Edge edge : edges) {
                if (distances[edge.source] != Integer.MAX_VALUE &&
                        distances[edge.source] + edge.weight < distances[edge.target]) {
                    distances[edge.target] = distances[edge.source] + edge.weight;
                }
            }
        }

        // Kiểm tra xem đồ thị có chu trình âm hay không
        for (Edge edge : edges) {
            if (distances[edge.source] != Integer.MAX_VALUE &&
                    distances[edge.source] + edge.weight < distances[edge.target]) {
                System.out.println("Đồ thị chứa chu trình âm.");
                return;
            }
        }

        // In ra kết quả nếu không có chu trình âm
        for (int i = 0; i < vertices; i++) {
            System.out.println("Distance from " + source + " to " + i + " is: "
                    + (distances[i] == Integer.MAX_VALUE ? "không thể tiếp cận" : distances[i]));
        }
    }

    public static void main(String[] args) {
        int vertices = 5; // Số đỉnh
        int source = 0; // Đỉnh bắt đầu

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, -1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 2));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(4, 3, -3));

        bellmanFord(edges, vertices, source);
    }
}
