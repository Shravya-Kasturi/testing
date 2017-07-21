
public class Flight {
	Scanner sc;
	  Flight()
	  {sc=new Scanner(System.in);
	  }
	  void controlStation(){
	    try{
	    Random rand=new Random();
	    int weather_stability=rand.nextInt(3);
	    if(weather_stability==3)
	    throw new BadWeather();
	    }
	    finally{
	    System.out.println("Check the Weather condition");
	    }
	    }
}
