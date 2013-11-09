package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.k;
import com.flagleader.repository.rlm.DeleteModifyToken;
import com.flagleader.repository.rlm.editen.IModifierEditen;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleContainer;

public class StatementContainerToken$DeleteToken extends DeleteModifyToken
  implements IModifierEditen
{
  public StatementContainerToken$DeleteToken(StatementContainerToken paramStatementContainerToken, String paramString, k paramk)
  {
    super(paramString, paramk);
  }

  public boolean canPasteElement(IElement paramIElement)
  {
    return this.this$0.canPasteElement(paramIElement);
  }

  public IElement copyElement()
  {
    return this.this$0.deepClone();
  }

  public IElement cutElement()
  {
    return this.this$0.cutElement();
  }

  public boolean pasteElement(IElement paramIElement)
  {
    return this.this$0.pasteElement(paramIElement);
  }

  public String getNote()
  {
    if (this.this$0.getRoot().getRuleTree().isDevelopModel())
      return this.this$0.getJavaCode();
    return super.getNote();
  }

  public String getUuid()
  {
    return this.this$0.getUuid();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.StatementContainerToken.DeleteToken
 * JD-Core Version:    0.6.0
 */