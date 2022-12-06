package Main;


public class User {

    public int rank;
    public int progress;

    public User() {
        rank = -8;
        progress = 0;
    }

    public void incProgress(int activityRank) {
        if (activityRank < -8 || activityRank > 8 || activityRank == 0)
            throw new IllegalArgumentException();
        if (rank == 8)
            return;
        progress += countProgress(rank, activityRank);
        while (progress >= 100) {
            rank++;
            if (rank == 0)
                rank++;
            if (rank == 8) {
                progress = 0;
                return;
            }
            progress -= 100;
        }
    }

    public static int countProgress(int userRank, int activityRank) {
        int dif = activityRank - userRank;
        if (activityRank > 0 && userRank < 0)
            dif--;
        if (activityRank < 0 && userRank > 0)
            dif++;
        if (dif <= -2)
            return 0;
        if (dif == -1)
            return 1;
        if (dif == 0)
            return 3;
        if (dif > 0)
            return 10 * dif * dif;
        throw new RuntimeException("Should have already returned some value");
    }
}