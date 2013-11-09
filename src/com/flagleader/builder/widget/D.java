package com.flagleader.builder.widget;

import java.util.Hashtable;

public class D
{
  protected Hashtable a = null;
  protected StringBuffer b = new StringBuffer();
  protected String c;
  protected int d;
  protected int e;
  protected int f;
  protected boolean g = false;
  private String[] i = { "<head>", "</head>", "<html>", "</html>", "<body", "</body>", "<title>", "</title>", "<script", "</script>", "/>", "<table", "</table>", "<input", "</input>", "<rsp", "</rsp", "<tr", "</tr>", "<td", "</td>", "<a", "</a>", "<center>", "</center>", "<div", "</div>", "<IFRAME", "</IFRAME>", "<meta", "<img", "<option", "</option>", "<select", "</select>", "<font", "</font>", "</form>", "</form>", "<link", ">" };

  private boolean a(char paramChar)
  {
    if (((paramChar <= 'z') && (paramChar >= 'a')) || ((paramChar <= 'Z') && (paramChar >= 'A')))
      return true;
    if (paramChar == '<')
      return true;
    if (paramChar == '/')
      return true;
    return paramChar == '>';
  }

  public D(C paramC)
  {
    b();
  }

  public final int a()
  {
    return this.d - this.f;
  }

  void b()
  {
    this.a = new Hashtable();
    Integer localInteger = new Integer(2);
    for (int j = 0; j < this.i.length; j++)
      this.a.put(this.i[j], localInteger);
  }

  public final int c()
  {
    return this.f;
  }

  public int d()
  {
    this.f = this.d;
    int j;
    switch (j = e())
    {
    case -1:
      return -1;
    case 47:
      j = e();
      if (j == 47)
      {
        do
          j = e();
        while ((j != -1) && (j != 10));
        a(j);
        return 3;
      }
      a(j);
      return 6;
    case 39:
      while (true)
      {
        j = e();
        switch (j)
        {
        case 39:
          return 5;
        case -1:
          a(j);
          return 5;
        case 92:
          j = e();
        }
      }
    case 34:
      while (true)
      {
        j = e();
        switch (j)
        {
        case 34:
          return 5;
        case -1:
          a(j);
          return 5;
        case 92:
          j = e();
        }
      }
    case 48:
    case 49:
    case 50:
    case 51:
    case 52:
    case 53:
    case 54:
    case 55:
    case 56:
    case 57:
      do
        j = e();
      while (Character.isDigit((char)j));
      a(j);
      return 7;
    }
    if (Character.isWhitespace((char)j))
    {
      do
        j = e();
      while (Character.isWhitespace((char)j));
      a(j);
      return 1;
    }
    if (a((char)j))
    {
      this.b.setLength(0);
      do
      {
        this.b.append((char)j);
        j = e();
      }
      while ((this.a.get(this.b.toString()) == null) && (a((char)j)));
      a(j);
      Integer localInteger = (Integer)this.a.get(this.b.toString());
      if (localInteger != null)
        return localInteger.intValue();
      return 0;
    }
    return 6;
  }

  protected int e()
  {
    if (this.d <= this.e)
      return this.c.charAt(this.d++);
    return -1;
  }

  public void a(String paramString)
  {
    this.c = paramString;
    this.d = 0;
    this.e = (this.c.length() - 1);
  }

  protected void a(int paramInt)
  {
    if (paramInt != -1)
      this.d -= 1;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.D
 * JD-Core Version:    0.6.0
 */