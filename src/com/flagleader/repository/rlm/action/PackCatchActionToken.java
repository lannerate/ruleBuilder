package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.o;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.Iterator;

public class PackCatchActionToken extends MultiActionToken
  implements IRuleContainer
{
  private transient o undoable = null;

  public PackCatchActionToken()
  {
  }

  public PackCatchActionToken(int paramInt)
  {
    super(paramInt);
  }

  public PackCatchActionToken(MultiActionToken paramMultiActionToken)
  {
    super(paramMultiActionToken);
  }

  public IElement deepClone()
  {
    return new PackCatchActionToken(this);
  }

  public String getName()
  {
    return "PackCatchActionToken";
  }

  public IRuleContainer getRoot()
  {
    return this;
  }

  public void setModified(boolean paramBoolean)
  {
    if ((paramBoolean) && (getRuleTree() != null))
      getRuleTree().setModified(paramBoolean);
  }

  public boolean paste(IElement paramIElement)
  {
    return super.pasteElement(paramIElement);
  }

  public boolean isEmpty()
  {
    return !getActions().hasNext();
  }

  public boolean isChangeLine(String paramString)
  {
    return false;
  }

  public IPackageElement getRuleTree()
  {
    if ((getParent() instanceof IPackageElement))
      return (IPackageElement)getParent();
    return null;
  }

  public void setNeedSave()
  {
    if (getRuleTree() != null)
      getRuleTree().setNeedSave();
  }

  public String getNote()
  {
    return getText();
  }

  public o getUndoable()
  {
    if (this.undoable == null)
      this.undoable = new o(this);
    return this.undoable;
  }

  public boolean canRedo()
  {
    return getUndoable().canRedo();
  }

  public boolean canUndo()
  {
    return getUndoable().canUndo();
  }

  public boolean redo()
  {
    return getUndoable().redo();
  }

  public void takeSnapshot()
  {
    getUndoable().a(true);
    getUndoable().takeSnapshot();
    getUndoable().a(false);
  }

  public boolean undo()
  {
    return getUndoable().undo();
  }

  public void initUndoable()
  {
    getUndoable().initUndoable();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.PackCatchActionToken
 * JD-Core Version:    0.6.0
 */