package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.IElement;
import com.flagleader.repository.k;
import com.flagleader.repository.rlm.AppendModifyToken;
import com.flagleader.repository.rlm.editen.IModifierEditen;

public class MultiConditionToken$AppendToken extends AppendModifyToken
  implements IModifierEditen
{
  public MultiConditionToken$AppendToken(MultiConditionToken paramMultiConditionToken, String paramString, k paramk)
  {
    super(paramString, paramk);
  }

  public boolean canPasteElement(IElement paramIElement)
  {
    return this.this$0.canPasteElement(paramIElement);
  }

  public boolean pasteElement(IElement paramIElement)
  {
    return this.this$0.pasteElement(paramIElement);
  }

  public String getUuid()
  {
    return this.this$0.getUuid();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.MultiConditionToken.AppendToken
 * JD-Core Version:    0.6.0
 */