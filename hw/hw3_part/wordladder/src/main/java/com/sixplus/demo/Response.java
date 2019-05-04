package com.sixplus.demo;

public class Response {
    private final long id;
    private final String start;
    private final String dest;
    private final String answer;

    public Response(long id,String start,String dest,String answer)
    {
        this.id = id;
        this.start = start;
        this.dest = dest;
        this.answer = answer;
    }

    public long getId(){return id;}
    public String getStart(){return start;}
    public String getDest(){return dest;}
    public String getAnswer(){return answer;}
}
