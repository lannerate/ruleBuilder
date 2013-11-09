package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.c.i;
import com.flagleader.repository.k;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.value.FieldToken;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleContainer;

public class StatementContainerToken$ActionTypeToken extends JudgeToken
{
  public StatementContainerToken$ActionTypeToken(StatementContainerToken paramStatementContainerToken)
  {
  }

  public StatementContainerToken$ActionTypeToken(StatementContainerToken paramStatementContainerToken, ActionTypeToken paramActionTypeToken)
  {
    super(paramActionTypeToken);
  }

  public String getName()
  {
    return "ActionTypeToken";
  }

  public int getCount()
  {
    return this.this$0.getEventCount();
  }

  public boolean acceptType(g paramg)
  {
    return true;
  }

  protected k b(int paramInt)
  {
    String str = a(paramInt);
    for (int i = 0; i < StatementContainerToken.access$2(this.this$0).length; i++)
      if (StatementContainerToken.access$2(this.this$0)[i].c().equalsIgnoreCase(str))
        return StatementContainerToken.access$2(this.this$0)[i];
    return new i();
  }

  protected String a(int paramInt)
  {
    if ((getRoot() != null) && (getRoot().getRuleTree().isDevelopModel()))
    {
      if (this.this$0.isInit())
        return StatementContainerToken.access$3()[paramInt];
      return StatementContainerToken.access$4()[paramInt];
    }
    if (this.this$0.isInit())
      return StatementContainerToken.access$5()[paramInt];
    return StatementContainerToken.access$6()[paramInt];
  }

  public String getDisplayName()
  {
    if (this.this$0.getChildrenCount() > 0)
      return "  ";
    return getLocalString("selectAction.edit");
  }

  public boolean isLocked()
  {
    return this.this$0.isLocked();
  }

  public IElement copyElement()
  {
    return this.this$0.deepClone();
  }

  public IElement cutElement()
  {
    return this.this$0.cutElement();
  }

  public boolean canCopy()
  {
    return true;
  }

  public boolean canCut()
  {
    return true;
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    if (((paramObject instanceof IFunctionObject)) || ((paramObject instanceof IVariableObject)))
      return true;
    if (((paramObject instanceof IElement)) && (this.this$0.canPasteElement((IElement)paramObject)))
      return true;
    return super.acceptBusinessObject(paramObject);
  }

  public boolean pasteBusinessObject(Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof IVariableObject))
    {
      h();
      localObject = new AssignToken().init();
      this.this$0.addChildElement((IElement)localObject);
      if (((FieldToken)((AssignToken)localObject).getFirstValue()).acceptBusinessObject(paramObject))
        ((FieldToken)((AssignToken)localObject).getFirstValue()).setMemberElement((IVariableObject)paramObject);
      g();
      update();
      return true;
    }
    if ((paramObject instanceof IFunctionObject))
    {
      h();
      localObject = new MethodToken();
      this.this$0.addChildElement((IElement)localObject);
      if (((MethodToken)localObject).acceptBusinessObject(paramObject))
        ((MethodToken)localObject).setMemberElement((IFunctionObject)paramObject);
      g();
      update();
      return true;
    }
    if (((paramObject instanceof IElement)) && (this.this$0.canPasteElement((IElement)paramObject)))
    {
      if (this.this$0.pasteElement(((IElement)paramObject).deepClone()))
        this.this$0.getRoot().getRuleTree().updateViewer();
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.StatementContainerToken.ActionTypeToken
 * JD-Core Version:    0.6.0
 */