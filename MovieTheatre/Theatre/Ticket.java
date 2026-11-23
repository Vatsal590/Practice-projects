public class Ticket {
    private String movie_name = "";
    private double movie_price = 0.0;
    private String salon = "";
    private String seat = "";


    //constructor
    public Ticket(String movie_name, double movie_price, String salon, String seat){ // name for parameters are not to be the same as instance variables
// tickets need a name, price, and a salon
        this.movie_name = movie_name;
        this.movie_price = movie_price;
        this.salon = salon;
        this.seat = seat;
        // when it is this, it can be the same name. that is the purpose of this. 
    }

    //ascessors

    // this is how theater can access the private 

    //mutators


    //methods


    //toString
}
