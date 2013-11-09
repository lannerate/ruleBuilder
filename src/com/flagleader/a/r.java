package com.flagleader.a;

import com.flagleader.util.collection.IList;

class r extends w
{
  r(q paramq, IList paramIList)
  {
    super(paramIList);
  }

  public Object next()
  {
    Y localY = (Y)super.next();
    return localY == null ? null : localY.e();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.r
 * JD-Core Version:    0.6.0
 */