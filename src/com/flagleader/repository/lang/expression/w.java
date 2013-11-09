package com.flagleader.repository.lang.expression;

import com.flagleader.repository.d.u;
import com.flagleader.repository.rlm.condition.ConditionToken;
import com.flagleader.repository.rlm.lang.IJudgeToken;
import com.flagleader.repository.rlm.lang.ILogicalToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.util.StringUtil;

public class w extends a
{
  private String e;
  private int f = 0;
  private int g = 0;
  private k h;
  private String i;
  private k j;

  public w(StatementSystem paramStatementSystem, String paramString)
  {
    super(paramStatementSystem, paramString);
    if (!b_())
      e(paramString);
  }

  public int b()
  {
    if ((!StringUtil.isEmpty(this.e)) && ((this.e.equalsIgnoreCase("||")) || (this.e.equalsIgnoreCase(u.a("isNary.edit")))))
      return 0;
    return 1;
  }

  public void a(ConditionToken paramConditionToken)
  {
    MemberToken localMemberToken = (MemberToken)paramConditionToken.getFirstValue();
    if ((this.h != null) && (!this.h.b_()))
      this.h.a(localMemberToken);
    com.flagleader.repository.lang.g localg = localMemberToken.getJavaType();
    paramConditionToken.getLogicalOperator().setNewType(b());
    paramConditionToken.setLeftParenthesisNumber(this.f);
    paramConditionToken.setRightParenthesisNumber(this.g);
    if (this.i != null)
      paramConditionToken.getCompareOperator().setTextMessage(this.i);
    if (this.j != null)
      if (paramConditionToken.getComparedValue() != null)
        this.j.a((ValueToken)paramConditionToken.getComparedValue(), localMemberToken.getValueType());
      else
        paramConditionToken.addChildElement(this.j.a(localMemberToken.getValueType(), localMemberToken.getValueType()));
  }

  private void e(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    for (int k = 0; k < StatementSystem.a.length; k++)
    {
      if (!localStringBuffer.toString().trim().startsWith(StatementSystem.a[k]))
        continue;
      this.e = StatementSystem.a[k];
      localStringBuffer = new StringBuffer(localStringBuffer.toString().trim().substring(StatementSystem.a[k].length()).trim());
      break;
    }
    while ((d(localStringBuffer.toString())) || (c(localStringBuffer.toString())))
      if (d(localStringBuffer.toString()))
      {
        this.f += 1;
        localStringBuffer.deleteCharAt(0);
      }
      else
      {
        if (!c(localStringBuffer.toString()))
          continue;
        this.g += 1;
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
    int m;
    for (k = 0; k < StatementSystem.d.length; k++)
    {
      m = localStringBuffer.toString().indexOf(StatementSystem.d[k]);
      if (m < 0)
        continue;
      this.h = f(localStringBuffer.substring(0, m));
      this.i = StatementSystem.d[k];
      return;
    }
    for (k = 0; k < StatementSystem.c.length; k++)
    {
      m = localStringBuffer.toString().indexOf(StatementSystem.c[k]);
      if (m < 0)
        continue;
      this.h = f(localStringBuffer.substring(0, m));
      this.i = StatementSystem.c[k];
      this.j = f(localStringBuffer.substring(m + StatementSystem.c[k].length(), localStringBuffer.length()).trim());
      return;
    }
    if (this.i == null)
    {
      this.i = StatementSystem.c[0];
      this.j = f(localStringBuffer.toString());
    }
  }

  private k f(String paramString)
  {
    return new k(this.a, paramString.trim());
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.e != null)
      localStringBuffer.append(this.e);
    for (int k = 0; k < this.f; k++)
      localStringBuffer.append("(");
    if (this.h != null)
      localStringBuffer.append(this.h);
    if (this.i != null)
      localStringBuffer.append(this.i);
    if (this.j != null)
      localStringBuffer.append(this.j);
    for (k = 0; k < this.g; k++)
      localStringBuffer.append(")");
    return super.toString();
  }

  public String c()
  {
    return this.e;
  }

  public int d()
  {
    return this.f;
  }

  public int e()
  {
    return this.g;
  }

  public k f()
  {
    return this.h;
  }

  public String g()
  {
    return this.i;
  }

  public k h()
  {
    return this.j;
  }

  public Object a(g paramg)
  {
    return paramg.a(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.w
 * JD-Core Version:    0.6.0
 */