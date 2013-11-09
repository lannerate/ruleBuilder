package com.flagleader.builder.a.f;

import com.flagleader.builder.a.b;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.d;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.editen.IMultiLineEditen;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class bm extends b
{
  private IMultiLineEditen l;

  public bm(IMultiLineEditen paramIMultiLineEditen, Composite paramComposite, bu parambu)
  {
    super(paramComposite, parambu);
    this.l = paramIMultiLineEditen;
  }

  protected void e()
  {
    if (this.l != null)
      this.l.acceptVisitor(this);
  }

  public boolean canRedo()
  {
    return false;
  }

  public boolean canUndo()
  {
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
      this.l.getRoot().setModified(true);
      this.k = false;
      update();
    }
  }

  public boolean needUpdate()
  {
    return false;
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
        update();
      return bool;
    }
    return false;
  }

  public boolean redo()
  {
    return false;
  }

  public boolean undo()
  {
    return false;
  }

  public boolean canCopy()
  {
    return f().size() > 0;
  }

  public boolean canCut()
  {
    if (this.l == null)
      return false;
    if (this.l.isLocked())
      return false;
    return f().size() > 0;
  }

  public boolean canDelete()
  {
    if (this.l == null)
      return false;
    if (this.l.isLocked())
      return false;
    return f().size() > 0;
  }

  public boolean canPaste()
  {
    if (this.l == null)
      return false;
    if (this.l.isLocked())
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
      }
    }
    return false;
  }

  public void cut()
  {
    if (this.l.isLocked())
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
      this.l.getRoot().setModified(true);
      update();
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
  }

  protected boolean g()
  {
    return this.l.isLocked();
  }

  public String getCompositeUuid()
  {
    return this.l.getEditUuid();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bm
 * JD-Core Version:    0.6.0
 */