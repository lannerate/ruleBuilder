package com.flagleader.repository.tree;

import java.util.List;

public class l
{
  List a;
  int[] b;

  public l(List paramList)
  {
    this.a = paramList;
    this.b = new int[paramList.size()];
    for (int i = 0; i < this.b.length; i++)
      this.b[i] = 1;
  }

  public List a()
  {
    return this.a;
  }

  public int[] b()
  {
    return this.b;
  }

  public int a(int paramInt)
  {
    if (paramInt < this.b.length)
      return this.b[paramInt];
    return 1;
  }

  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < this.b.length)
      this.b[paramInt1] = paramInt2;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.l
 * JD-Core Version:    0.6.0
 */