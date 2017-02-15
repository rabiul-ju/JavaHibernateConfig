package com.dao;

import java.util.List;

public interface CommonDao {

public Integer insert(Object object);
    
    public int update(Object object);

    public int delete(Object object);
    
    public Object getObjectById(String number);
	
    public List<?> getAllObjects();
}
