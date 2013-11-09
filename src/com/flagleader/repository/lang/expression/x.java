package com.flagleader.repository.lang.expression;

import com.flagleader.repository.d.s;
import com.flagleader.repository.d.u;
import com.flagleader.repository.rlm.action.MethodToken;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class x extends a
  implements d, f
{
  protected ArrayList e = new ArrayList();
  private String f;
  private String g;
  private int h = 0;
  private int i = 0;

  public x(StatementSystem paramStatementSystem, String paramString)
  {
    super(paramStatementSystem, paramString);
    e(paramString);
  }

  private void e(String paramString)
  {
    StringBuffer localStringBuffer1 = new StringBuffer(paramString);
    while (d(localStringBuffer1.toString()))
    {
      if (!d(localStringBuffer1.toString()))
        continue;
      this.h += 1;
      localStringBuffer1.deleteCharAt(0);
    }
    String str1 = localStringBuffer1.toString();
    for (int j = 0; j < StatementSystem.k.length; j++)
    {
      if (!localStringBuffer1.toString().endsWith(StatementSystem.k[j]))
        continue;
      str1 = localStringBuffer1.substring(0, localStringBuffer1.length() - StatementSystem.k[j].length());
      this.f = StatementSystem.k[j];
      break;
    }
    StringBuffer localStringBuffer2 = new StringBuffer();
    int k = 0;
    StringTokenizer localStringTokenizer = new StringTokenizer(str1, "{");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str2 = localStringTokenizer.nextToken().trim();
      if (k == 0)
      {
        localStringBuffer2.append(str2);
        k++;
      }
      else
      {
        if (str2.indexOf("}") < 0)
          continue;
        a(new k(this.a, str2.substring(0, str2.indexOf("}"))));
        localStringBuffer2.append("{arg").append(k++).append(str2.substring(str2.indexOf("}")));
      }
    }
    this.g = localStringBuffer2.toString().trim();
  }

  public IStatementToken a()
  {
    MethodToken localMethodToken = new MethodToken();
    IBusinessObject localIBusinessObject = this.a.a(this.g);
    if (localIBusinessObject != null)
    {
      localMethodToken.setValueType(localIBusinessObject.getValueType());
      localMethodToken.setMemberElement(localIBusinessObject);
      if ((localIBusinessObject.getAllParams().size() > 0) && (this.e.size() > 0))
      {
        List localList = localMethodToken.getValueTokens();
        for (int j = 0; j < localList.size(); j++)
        {
          ValueToken localValueToken = (ValueToken)localList.get(j);
          if (this.e.size() <= j)
            continue;
          ((k)this.e.get(j)).a(localValueToken, localValueToken.getValueType());
        }
      }
    }
    else
    {
      throw new s(u.a("notexitsbo.expression", new String[] { this.g }));
    }
    return localMethodToken;
  }

  public ArrayList g()
  {
    return this.e;
  }

  protected void a(k paramk)
  {
    this.e.add(paramk);
  }

  public void f()
  {
  }

  public String toString()
  {
    String str = this.g;
    for (int j = 0; j < this.e.size(); j++)
      str = StringUtil.replace("arg" + j, ((k)this.e.get(j)).toString(), str);
    if (this.f != null)
      str = str + this.f;
    return str;
  }

  public String c()
  {
    return this.f;
  }

  public String b()
  {
    return this.g;
  }

  public int d()
  {
    return this.h;
  }

  public int e()
  {
    return this.i;
  }

  public Object a(g paramg)
  {
    return paramg.a(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.x
 * JD-Core Version:    0.6.0
 */