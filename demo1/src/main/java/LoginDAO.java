



public class LoginDAO
{
	public boolean isValidUser(String username,String password)
	{
		if(username.equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

