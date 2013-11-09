package com.flagleader.repository.rlm;

import com.flagleader.repository.IElement;
import com.flagleader.repository.o;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.PackageHistory;

public abstract class AbstractRuleContainer extends AbstractRuleObject
  implements IRuleContainer
{
  private transient o undoable = null;

  public AbstractRuleContainer()
  {
  }

  public AbstractRuleContainer(AbstractRuleContainer paramAbstractRuleContainer)
  {
    super(paramAbstractRuleContainer);
  }

  public boolean isChangeLine(String paramString)
  {
    if ((getRuleTree().getMainPackage() != null) && (getRuleTree().getMainPackage().getHistory() != null))
    {
      IPackageElement localIPackageElement = getRuleTree().getMainPackage().getHistory().findRuleHistory(getUuid(), toString());
      if ((localIPackageElement != null) && (localIPackageElement.getText().indexOf(paramString) < 0))
        return true;
    }
    return false;
  }

  public IPackageElement getRuleTree()
  {
    if ((this instanceof IPackageElement))
      return (IPackageElement)this;
    if ((getParent() instanceof IPackageElement))
      return (IPackageElement)getParent();
    if (getParent() == null)
      return null;
    if ((getParent().getParent() instanceof IPackageElement))
      return (IPackageElement)getParent().getParent();
    if (((getParent() instanceof IRuleObject)) && (((IRuleObject)getParent()).getRoot() != null))
      return ((IRuleObject)getParent()).getRoot().getRuleTree();
    return null;
  }

  public void setModified(boolean paramBoolean)
  {
    if (getRuleTree() != null)
      getRuleTree().setModified(paramBoolean);
  }

  public void setNeedSave()
  {
    IPackageElement localIPackageElement = getRuleTree();
    if (localIPackageElement != null)
      localIPackageElement.setNeedSave();
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
    setModified(true);
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
    setModified(true);
    return getUndoable().undo();
  }

  public void initUndoable()
  {
    getUndoable().initUndoable();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.AbstractRuleContainer
 * JD-Core Version:    0.6.0
 */