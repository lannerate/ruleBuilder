package com.flagleader.server;

import com.flagleader.xml.XMLReceiveBean;

public class k
{
  XMLReceiveBean a;
  private int b;
  private String c;
  private int d = 0;

  public k(XMLReceiveBean paramXMLReceiveBean, String paramString)
  {
    this.a = paramXMLReceiveBean;
    this.c = paramString;
  }

  public String a()
  {
    if (this.d == 0)
      return "waiting";
    if (this.d == 1)
      return "running";
    return "complete";
  }

  public int b()
  {
    return this.b;
  }

  public void a(int paramInt)
  {
    this.b = paramInt;
  }

  public String c()
  {
    return this.c;
  }

  public void a(String paramString)
  {
    this.c = paramString;
  }

  public XMLReceiveBean d()
  {
    return this.a;
  }

  public void a(XMLReceiveBean paramXMLReceiveBean)
  {
    this.a = paramXMLReceiveBean;
  }

  public void e()
  {
    this.d = 1;
  }

  public void f()
  {
    this.d = 2;
  }

  public int g()
  {
    return this.d;
  }

  public void b(int paramInt)
  {
    this.d = paramInt;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.server.k
 * JD-Core Version:    0.6.0
 */