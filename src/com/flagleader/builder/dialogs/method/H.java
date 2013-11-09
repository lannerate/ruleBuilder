package com.flagleader.builder.dialogs.method;

import java.util.Comparator;

class H
  implements Comparator
{
  private int b;

  public H(MethodShell paramMethodShell, int paramInt)
  {
    this.b = paramInt;
  }

  public int compare(Object paramObject1, Object paramObject2)
  {
    String[] arrayOfString1 = (String[])paramObject1;
    String[] arrayOfString2 = (String[])paramObject2;
    return arrayOfString1[this.b].compareTo(arrayOfString2[this.b]);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.H
 * JD-Core Version:    0.6.0
 */