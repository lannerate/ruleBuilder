package com.flagleader.repository.d;

import com.flagleader.repository.IElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class b extends ArrayList
  implements List
{
  public b()
  {
  }

  public b(int paramInt)
  {
    super(paramInt);
  }

  public b(Collection paramCollection)
  {
    super(paramCollection);
  }

  public IElement a(int paramInt)
  {
    return (IElement)get(paramInt);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.d.b
 * JD-Core Version:    0.6.0
 */