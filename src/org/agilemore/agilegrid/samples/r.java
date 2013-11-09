package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.al;

class r
  implements al
{
  r(q paramq)
  {
  }

  public String a(Object paramObject)
  {
    int i = 1;
    String str = (String)paramObject;
    for (int j = 0; j < str.length(); j++)
    {
      if (Character.isDigit(str.charAt(j)))
        continue;
      i = 0;
      break;
    }
    if (i != 0)
      return null;
    return "The value should be digital.";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.r
 * JD-Core Version:    0.6.0
 */