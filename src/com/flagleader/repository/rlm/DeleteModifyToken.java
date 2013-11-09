package com.flagleader.repository.rlm;

import com.flagleader.repository.k;
import com.flagleader.repository.rlm.editen.IModifierEditen;

public abstract class DeleteModifyToken extends ModifyToken
  implements IModifierEditen
{
  public DeleteModifyToken()
  {
  }

  public DeleteModifyToken(String paramString, k paramk)
  {
    super(paramString, paramk);
  }

  public String getName()
  {
    return "DeleteModifyToken";
  }

  public String getImageName()
  {
    return "del";
  }

  public boolean canCopy()
  {
    return true;
  }

  public boolean canCut()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.DeleteModifyToken
 * JD-Core Version:    0.6.0
 */