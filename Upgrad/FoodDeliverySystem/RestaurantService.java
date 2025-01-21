import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private List<Restaurant> restaurants;

    public RestaurantService() {
        this.restaurants = new ArrayList<>();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public Restaurant getRestaurant(String name) {
        for(Restaurant c : restaurants){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurants;
    }
}