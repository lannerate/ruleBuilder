package com.flagleader.repository.lang.expression;

import com.flagleader.repository.IElement;
import com.flagleader.repository.d.s;
import com.flagleader.repository.d.u;
import com.flagleader.repository.rlm.action.AssignJudgeToken;
import com.flagleader.repository.rlm.action.AssignToken;
import com.flagleader.repository.rlm.action.NumberAssignJudgeToken;
import com.flagleader.repository.rlm.action.StringAssignJudgeToken;
import com.flagleader.repository.rlm.lang.IAssignToken;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rlm.value.FieldToken;
import com.flagleader.repository.rlm.value.ValueToken;

public class p extends a
  implements d
{
  private k e;
  private String f;
  private k g;

  public p(StatementSystem paramStatementSystem, String paramString)
  {
    super(paramStatementSystem, paramString);
    e(paramString);
  }

  private void e(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    for (int i = 0; i < StatementSystem.b.length; i++)
    {
      int j = localStringBuffer.toString().indexOf(StatementSystem.b[i]);
      if (j < 0)
        continue;
      this.e = f(localStringBuffer.substring(0, j));
      this.f = StatementSystem.b[i];
      this.g = f(localStringBuffer.substring(j + StatementSystem.b[i].length(), localStringBuffer.length()).trim());
      return;
    }
  }

  public IStatementToken a()
  {
    AssignToken localAssignToken = new AssignToken();
    FieldToken localFieldToken = new FieldToken();
    localAssignToken.addChildElement(localFieldToken);
    Object localObject;
    if (this.e != null)
    {
      this.e.a(localFieldToken);
      localObject = localFieldToken.getJavaType();
      if (((com.flagleader.repository.lang.g)localObject).m())
        localAssignToken.addChildElement(new StringAssignJudgeToken());
      else if ((((com.flagleader.repository.lang.g)localObject).b()) || (((com.flagleader.repository.lang.g)localObject).j()))
        localAssignToken.addChildElement(new NumberAssignJudgeToken());
      else
        localAssignToken.addChildElement(new AssignJudgeToken());
    }
    else
    {
      localAssignToken.addChildElement(new AssignJudgeToken());
    }
    if (this.f != null)
      localAssignToken.getAssign().setTextMessage(this.f);
    else
      throw new s(u.a("actionerror.expression", new String[] { this.b }));
    if (this.g != null)
    {
      localObject = (ValueToken)localAssignToken.getComparedValue();
      if (localObject == null)
      {
        localObject = new ValueToken(1, localFieldToken.getValueType(), localFieldToken.getValueType());
        localAssignToken.addChildElement((IElement)localObject);
      }
      this.g.a((ValueToken)localObject, localFieldToken.getValueType());
    }
    return (IStatementToken)localAssignToken;
  }

  private k f(String paramString)
  {
    return new k(this.a, paramString);
  }

  public k b()
  {
    return this.e;
  }

  public String c()
  {
    return this.f;
  }

  public k d()
  {
    return this.g;
  }

  public Object a(g paramg)
  {
    return paramg.a(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.p
 * JD-Core Version:    0.6.0
 */