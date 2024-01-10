import java.util.Map;
import java.util.TreeMap;

public class DishReview {

    static class Dish {
        int totalRating;
        int reviewCount;

        void addReview(int rating) {
            totalRating += rating;
            reviewCount++;
        }

        double getAverageRating() {
            return (double) totalRating / reviewCount;
        }
    }

    static void initDishTree(int n, int[][] ratings, TreeMap<Integer, Dish> dishRatings){
        for (int i = 0; i < n; i++) {
            int dishId = ratings[i][0];
            int rating = ratings[i][1];

            dishRatings.putIfAbsent(dishId, new Dish());
            dishRatings.get(dishId).addReview(rating);
        }
    }

    static int solution(int n, int[][] ratings){
        int result = 0;
        TreeMap<Integer, Dish> dishRatings = new TreeMap<>();
        initDishTree(n, ratings, dishRatings);

        double highestAvgRating = 0;
        int bestDishId = -1;

        for (Map.Entry<Integer, Dish> entry : dishRatings.entrySet()) {
            double avgRating = entry.getValue().getAverageRating();
            int dishId = entry.getKey();

            if (avgRating > highestAvgRating || (avgRating == highestAvgRating && dishId < bestDishId)) {
                highestAvgRating = avgRating;
                bestDishId = dishId;
            }
        }

        return bestDishId;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] ratings = { { 123, 2 }, { 456, 3 }, { 123, 4 }, { 456, 5 } };

        System.out.println("The highest-rated dish ID is: " + solution(n, ratings));
    }
}