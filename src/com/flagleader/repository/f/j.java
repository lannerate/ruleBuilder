package com.flagleader.repository.f;

import com.flagleader.repository.d.f;
import com.flagleader.repository.d.l;
import com.flagleader.util.StringUtil;
import java.io.File;

public class j
  implements b
{
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  l a;

  public j(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
  }

  public j()
  {
  }

  public boolean a()
  {
    return ("local".equalsIgnoreCase(this.b)) && (!StringUtil.isEmpty(this.c));
  }

  public boolean b()
  {
    return ("ftp".equalsIgnoreCase(this.b)) && (!StringUtil.isEmpty(this.e));
  }

  public String c()
  {
    return this.b;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public String d()
  {
    return this.c;
  }

  public void b(String paramString)
  {
    this.c = paramString;
  }

  public String e()
  {
    return this.d;
  }

  public void c(String paramString)
  {
    this.d = paramString;
  }

  public String f()
  {
    return this.e;
  }

  public void d(String paramString)
  {
    this.e = paramString;
  }

  public String g()
  {
    return this.f;
  }

  public void e(String paramString)
  {
    this.f = paramString;
  }

  public String h()
  {
    return this.g;
  }

  public void f(String paramString)
  {
    this.g = paramString;
  }

  public String i()
  {
    return this.h;
  }

  public void g(String paramString)
  {
    this.h = paramString;
  }

  public String a(File paramFile, String paramString)
  {
    String str = this.c + paramString.replace('.', '/') + ".rsc";
    return j().a(str, paramFile, true);
  }

  public l j()
  {
    if (this.a == null)
      this.a = new f(this.e, Integer.parseInt(this.g), this.d, this.f, "ftps".equalsIgnoreCase(this.h));
    return this.a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.f.j
 * JD-Core Version:    0.6.0
 */