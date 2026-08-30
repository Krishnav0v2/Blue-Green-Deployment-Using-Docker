package in.sp.main.services;

import java.util.List;

import in.sp.main.entities.User;

public interface UserService 
{
	public List<User> searchByTitle(String Email);
}
