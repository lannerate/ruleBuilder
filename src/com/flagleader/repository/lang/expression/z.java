package com.flagleader.repository.lang.expression;

import com.flagleader.repository.IElement;
import com.flagleader.util.filesystem.FileUtil;
import com.flagleader.util.prefs.Messages;
import com.flagleader.util.prefs.Preferences;
import com.flagleader.util.prefs.PropertyBundle;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class z
  implements g
{
  protected PrintWriter f;
  private boolean a;
  private boolean b;
  private int c;
  private int d;
  public static final String g = FileUtil.newline;

  public z()
  {
    this.a = false;
    this.b = true;
    this.c = 0;
    this.d = 4;
  }

  public z(PrintWriter paramPrintWriter)
  {
    this.f = paramPrintWriter;
    this.a = false;
    this.b = true;
    this.c = 0;
    this.d = 4;
  }

  public z(PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    this.f = paramPrintWriter;
    this.a = paramBoolean;
    this.b = true;
    this.c = 0;
    this.d = 4;
  }

  protected void a(int paramInt)
  {
    this.c += paramInt;
  }

  protected void b(int paramInt)
  {
    this.c -= paramInt;
  }

  public void b()
  {
    this.f.close();
  }

  public void c()
  {
    this.f.flush();
  }

  private int a()
  {
    return this.c * this.d;
  }

  protected int d()
  {
    return this.d;
  }

  protected void e()
  {
    c(a());
  }

  protected void c(int paramInt)
  {
    for (int i = 0; i < paramInt; i++)
      a(' ');
  }

  private boolean a(IElement paramIElement)
  {
    return paramIElement != null;
  }

  private void h()
  {
    f();
  }

  protected void a(char paramChar)
  {
    this.f.print(paramChar);
  }

  protected void a(String paramString)
  {
    this.f.print(paramString);
  }

  protected void f()
  {
    this.f.print(g);
  }

  protected void b(char paramChar)
  {
    this.f.print(paramChar);
    f();
  }

  protected void b(String paramString)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, g);
    while (localStringTokenizer.hasMoreTokens())
    {
      String str = localStringTokenizer.nextToken().trim();
      e();
      this.f.print(str);
      f();
    }
  }

  protected void a(String paramString1, String paramString2)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString1, g);
    while (localStringTokenizer.hasMoreTokens())
    {
      String str = localStringTokenizer.nextToken().trim();
      e();
      this.f.print(paramString2 + str);
      f();
    }
  }

  protected void g()
  {
    this.c = 0;
  }

  private void d(int paramInt)
  {
    this.d = paramInt;
  }

  private boolean i()
  {
    return this.b;
  }

  private void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  private String c(String paramString)
  {
    PropertyBundle localPropertyBundle = Messages.getMessages().getPropertyBundle("repository");
    if ((paramString == null) || (paramString.length() == 0))
      return "";
    if (paramString.charAt(0) == '&')
      return Preferences.getString(localPropertyBundle, paramString.substring(1) + ".edit", paramString.substring(1));
    return Preferences.getString(localPropertyBundle, paramString, paramString);
  }

  private boolean j()
  {
    return this.a;
  }

  private void b(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public Object a(b paramb)
  {
    return null;
  }

  public Object a(c paramc)
  {
    return null;
  }

  public Object a(i parami)
  {
    return null;
  }

  public Object a(j paramj)
  {
    return null;
  }

  public Object a(k paramk)
  {
    return null;
  }

  public Object a(l paraml)
  {
    return null;
  }

  public Object a(m paramm)
  {
    return null;
  }

  public Object a(n paramn)
  {
    return null;
  }

  public Object a(p paramp)
  {
    return null;
  }

  public Object a(q paramq)
  {
    return null;
  }

  public Object a(r paramr)
  {
    return null;
  }

  public Object a(s params)
  {
    return null;
  }

  public Object a(t paramt)
  {
    return null;
  }

  public Object a(u paramu)
  {
    return null;
  }

  public Object a(v paramv)
  {
    return null;
  }

  public Object a(w paramw)
  {
    return null;
  }

  public Object a(x paramx)
  {
    return null;
  }

  public Object a(y paramy)
  {
    return null;
  }

  public Object a(A paramA)
  {
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.z
 * JD-Core Version:    0.6.0
 */