package com.flagleader.engine;

import com.flagleader.util.TempID;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class ExpressionFactory
{
  private static ExpressionFactory a = new ExpressionFactory();
  private static Hashtable b = new Hashtable();

  public static ExpressionFactory getInstance()
  {
    return a;
  }

  public IExpression createExpression()
  {
    return new MultiExpression(this);
  }

  public boolean exitsExpression(String paramString, IExpression paramIExpression)
  {
    Object localObject = b.get(paramString);
    if ((localObject != null) && ((localObject instanceof IExpression)))
      return ((IExpression)localObject).equals(paramIExpression);
    return false;
  }

  public String expName(IExpression paramIExpression)
  {
    Iterator localIterator = b.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = localIterator.next().toString();
      IExpression localIExpression = (IExpression)b.get(str);
      if (paramIExpression.equals(localIExpression))
        return str;
    }
    return TempID.newShortTempID();
  }

  public void putExpression(String paramString, IExpression paramIExpression)
  {
    b.put(paramString, paramIExpression);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.engine.ExpressionFactory
 * JD-Core Version:    0.6.0
 */