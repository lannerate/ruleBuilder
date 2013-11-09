package com.flagleader.repository.rlm;

import com.flagleader.repository.IElement;
import com.flagleader.repository.k;
import com.flagleader.repository.rlm.editen.IModifierEditen;

public abstract class AppendModifyToken extends ModifyToken
  implements IModifierEditen
{
  public AppendModifyToken()
  {
  }

  public AppendModifyToken(String paramString, k paramk)
  {
    super(paramString, paramk);
  }

  public String getName()
  {
    return "AppendModifyToken";
  }

  public String getImageName()
  {
    return "more";
  }

  public boolean canCopy()
  {
    return false;
  }

  public boolean canCut()
  {
    return false;
  }

  public IElement copyElement()
  {
    return null;
  }

  public IElement cutElement()
  {
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.AppendModifyToken
 * JD-Core Version:    0.6.0
 */