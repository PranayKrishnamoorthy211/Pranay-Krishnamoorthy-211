package tower;

public class TowerSolver {
    private TowerModel model;

    public TowerSolver() {
    }

    public void solve(TowerModel model) {
        this.model = model;
        int n = model.getHeight(); 
        
        // Target rod 2, auxiliary rod 1
        solve(n, 0, 2, 1);
    }

    private void solve(int n, int from, int to, int aux) {
        if (n == 1) {
            // Base case: Move one disk
            model.move(from, to);
        } else if (n > 1) {
            solve(n - 1, from, aux, to);

            model.move(from, to);

            solve(n - 1, aux, to, from);
        } else {
            return;
        }
    }
}