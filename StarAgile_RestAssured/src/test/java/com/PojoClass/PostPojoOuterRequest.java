package com.PojoClass;

public class PostPojoOuterRequest 
{
    public String name;
    public PostPojoData data;

    public PostPojoOuterRequest(String name, PostPojoData data) {
        this.name = name;
        this.data = data;
    }

    public PostPojoOuterRequest() {}
}
