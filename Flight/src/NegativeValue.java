
class NegativeValue extends Exception {
public String toString()
{
	return "a negative value is entered..pls check";
}
}

class MoreLuggageException extends Exception{
	public String toString()
	{
		return "passesnger luggage is more than allowed";
	}
}

class BadWeather extends Exception{
	public String toString(){
	    return "the weather is very bad flight is delayed by 2 hours..take rest";
	    }

}