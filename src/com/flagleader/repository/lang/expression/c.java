package com.flagleader.repository.lang.expression;

import com.flagleader.repository.rlm.condition.ConditionToken;
import com.flagleader.repository.rlm.condition.MultiConditionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;

public class c extends a
{
  j[] e = e(paramString);

  public c(StatementSystem paramStatementSystem, String paramString)
  {
    super(paramStatementSystem, paramString);
  }

  public j[] e(String paramString)
  {
    paramString = StringUtil.replace("\r", "", paramString);
    String[] arrayOfString = paramString.trim().split("[\r\n]");
    j[] arrayOfj = new j[arrayOfString.length];
    for (int i = 0; i < arrayOfj.length; i++)
      arrayOfj[i] = new j(this.a, arrayOfString[i].trim());
    return arrayOfj;
  }

  public IMultiConditionToken b()
  {
    MultiConditionToken localMultiConditionToken = new MultiConditionToken();
    localMultiConditionToken.setParent(this.a.c());
    for (int i = 0; i < this.e.length; i++)
    {
      if (this.e[i].b_())
        continue;
      ConditionToken localConditionToken1 = new ConditionToken();
      localConditionToken1.init();
      localMultiConditionToken.addChildElement(localConditionToken1);
      ArrayList localArrayList = this.e[i].b();
      if (localArrayList.size() > 0)
        ((w)localArrayList.get(0)).a(localConditionToken1);
      if (localArrayList.size() <= 1)
        continue;
      ConditionToken localConditionToken2 = localConditionToken1;
      for (int j = 1; j < localArrayList.size(); j++)
      {
        ConditionToken localConditionToken3 = new ConditionToken();
        localConditionToken3.init();
        localConditionToken2.addChildElement(localConditionToken3);
        ((w)localArrayList.get(j)).a(localConditionToken3);
      }
    }
    return localMultiConditionToken;
  }

  public Object a(g paramg)
  {
    return paramg.a(this);
  }

  public j[] c()
  {
    return this.e;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.c
 * JD-Core Version:    0.6.0
 */