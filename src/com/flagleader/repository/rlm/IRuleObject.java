package com.flagleader.repository.rlm;

import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementEditor;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.List;
import java.util.Map;

public abstract interface IRuleObject extends IElement
{
  public abstract IRuleContainer getRoot();

  public abstract void update();

  public abstract void setElementEditor(IElementEditor paramIElementEditor);

  public abstract IElementEditor getElementEditor();

  public abstract void findRelateObject(Map paramMap);

  public abstract void findAssignObject(Map paramMap, boolean paramBoolean);

  public abstract List getAssignVarNames();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.IRuleObject
 * JD-Core Version:    0.6.0
 */