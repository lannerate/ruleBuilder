package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.d;
import com.flagleader.manager.a;
import com.flagleader.manager.r;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.rlm.action.AbstractPackageField;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.tree.DecisionElementValue;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.ITreeNode;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class aW extends com.flagleader.builder.a.b
  implements IElementViewer
{
  private IRuleContainer l;

  public aW(IRuleContainer paramIRuleContainer, Composite paramComposite, bu parambu)
  {
    super(paramComposite, parambu);
    this.l = paramIRuleContainer;
    if ((this.l instanceof ITreeNode))
      ((ITreeNode)this.l).addViewer(this);
    else if ((this.l.getParent() instanceof ITreeNode))
      ((ITreeNode)this.l.getParent()).addViewer(this);
  }

  protected void e()
  {
    if (this.l != null)
      this.l.acceptVisitor(this);
  }

  public boolean canCopy()
  {
    return f().size() > 0;
  }

  public boolean canCut()
  {
    if (this.l == null)
      return false;
    if (g())
      return false;
    return f().size() > 0;
  }

  public boolean canDelete()
  {
    if (this.l == null)
      return false;
    if (g())
      return false;
    return f().size() > 0;
  }

  public boolean canPaste()
  {
    if (this.l == null)
      return false;
    if (g())
      return false;
    Object localObject1 = new Clipboard(Display.getCurrent()).getContents(d.a());
    if (localObject1 == null)
      return false;
    if ((localObject1 instanceof ILineEditen))
      return true;
    if ((localObject1 instanceof ElementContainer))
    {
      Iterator localIterator = ((ElementContainer)localObject1).getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if ((localObject2 instanceof ILineEditen))
          return true;
        if ((localObject2 instanceof IValueContainerToken))
          return ((this.l instanceof DecisionElementValue)) || ((this.l instanceof AbstractPackageField));
      }
    }
    else if ((localObject1 instanceof IValueContainerToken))
    {
      return ((this.l instanceof DecisionElementValue)) || ((this.l instanceof AbstractPackageField));
    }
    return false;
  }

  public boolean h()
  {
    return false;
  }

  public boolean canRedo()
  {
    if (g())
      return false;
    if (this.l != null)
      return this.l.canRedo();
    return false;
  }

  public boolean canUndo()
  {
    if (g())
      return false;
    if (this.l != null)
      return this.l.canUndo();
    return false;
  }

  public void delete()
  {
    if (g())
      return;
    List localList = f();
    if (localList.size() > 0)
    {
      for (int i = 0; i < localList.size(); i++)
        ((ILineEditen)localList.get(i)).dispose();
      this.l.setModified(true);
      this.k = false;
      update();
    }
    else if ((this.l instanceof ITreeNode))
    {
      if (this.b.showQuestion(ResourceTools.formatMessage("to_delete", new String[] { this.l.getDisplayName() })))
        ((ITreeNode)this.l).disposeAndUpdate();
    }
  }

  public void i()
  {
  }

  public boolean redo()
  {
    if (g())
      return false;
    boolean bool = this.l.redo();
    if (bool)
      this.l.setModified(true);
    update();
    setChanged();
    notifyObservers();
    return bool;
  }

  public void find()
  {
  }

  public void findNext()
  {
  }

  public boolean isCanFind()
  {
    return false;
  }

  public boolean isCanSelectAll()
  {
    return true;
  }

  public boolean undo()
  {
    if (g())
      return false;
    boolean bool = this.l.undo();
    if (bool)
      this.l.setModified(true);
    update();
    setChanged();
    notifyObservers();
    return bool;
  }

  public void cut()
  {
    if (g())
      return;
    List localList = f();
    if (localList.size() > 0)
    {
      ElementContainer localElementContainer = new ElementContainer();
      if (localList.size() == 0)
        return;
      for (int i = 0; i < localList.size(); i++)
        localElementContainer.addChildElement(((ILineEditen)localList.get(i)).cutElement());
      new Clipboard(Display.getCurrent()).setContents(new Object[] { localElementContainer }, new Transfer[] { d.a() });
      this.l.setModified(true);
      this.k = false;
      update();
    }
    else if ((this.l instanceof ITreeNode))
    {
      new Clipboard(Display.getCurrent()).setContents(new Object[] { ((ITreeNode)this.l).cut() }, new Transfer[] { d.a() });
    }
  }

  public void copy()
  {
    List localList = f();
    if (localList.size() > 0)
    {
      ElementContainer localElementContainer = new ElementContainer();
      if (localList.size() == 0)
        return;
      for (int i = 0; i < localList.size(); i++)
        localElementContainer.addChildElement(((ILineEditen)localList.get(i)).copyElement());
      new Clipboard(Display.getCurrent()).setContents(new Object[] { localElementContainer }, new Transfer[] { d.a() });
    }
    else if ((this.l instanceof ITreeNode))
    {
      new Clipboard(Display.getCurrent()).setContents(new Object[] { ((ITreeNode)this.l).copy() }, new Transfer[] { d.a() });
    }
  }

  public boolean paste()
  {
    if (g())
      return false;
    Object localObject = new Clipboard(Display.getCurrent()).getContents(d.a());
    if ((localObject != null) && ((localObject instanceof IElement)))
    {
      boolean bool = this.l.paste(((IElement)localObject).deepClone());
      if (bool)
      {
        update();
        this.l.setModified(true);
      }
      return bool;
    }
    return false;
  }

  public void dispose()
  {
    super.dispose();
    if ((this.l instanceof ITreeNode))
    {
      ((ITreeNode)this.l).removeViewer(this);
      this.a.a(((ITreeNode)this.l).getEditUuid(), this.c);
    }
    else if ((this.l.getParent() instanceof ITreeNode))
    {
      ((ITreeNode)this.l.getParent()).removeViewer(this);
      this.a.a(((ITreeNode)this.l.getParent()).getEditUuid(), this.c);
    }
  }

  public boolean needUpdate()
  {
    if ((this.c == null) || (this.c.isDisposed()) || (!equals(this.a.e())))
      return false;
    if (this.e == 0L)
      return true;
    if ((this.l instanceof IPackageElement))
    {
      if ((this.e < ((IPackageElement)this.l).getMaxModifyTime()) || (this.e < ((IPackageElement)this.l).getEnvionment().getMaxModifyTime()))
        return true;
    }
    else if ((this.l.getRuleTree() != null) && ((this.l.getRuleTree() instanceof IPackageElement)) && ((this.e < this.l.getRuleTree().getMaxModifyTime()) || (this.e < this.l.getRuleTree().getEnvionment().getMaxModifyTime())))
      return true;
    return false;
  }

  public void update()
  {
    this.k = false;
    super.update();
    if ((!this.l.isLocked()) && (this.a.i().getConfigManager().E()))
      this.a.i().getRulesManager().c().a(this.l.getRuleTree());
  }

  protected boolean g()
  {
    if (this.l != null)
      return this.l.isLocked();
    return false;
  }

  public String getCompositeUuid()
  {
    return this.l.getEditUuid();
  }

  public IRuleContainer j()
  {
    return this.l;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.aW
 * JD-Core Version:    0.6.0
 */