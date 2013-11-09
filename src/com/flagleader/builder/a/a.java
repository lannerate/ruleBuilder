package com.flagleader.builder.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.d.c;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.ITreeNode;
import java.util.Observable;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;

public abstract class a extends Observable
  implements IElementViewer
{
  protected bu a;
  private BuilderManager e;
  protected Composite b;
  protected ITreeNode c;
  protected long d = 0L;
  private Menu f = null;

  public a(ITreeNode paramITreeNode, Composite paramComposite, bu parambu)
  {
    this.c = paramITreeNode;
    this.a = parambu;
    this.b = paramComposite;
    if (this.a != null)
    {
      this.e = parambu.i();
      addObserver(this.e.getMenuAndToolBar());
    }
    if (paramITreeNode != null)
      paramITreeNode.addViewer(this);
  }

  protected BuilderManager a()
  {
    return this.e;
  }

  public abstract String getCompositeUuid();

  public void update()
  {
    this.d = System.currentTimeMillis();
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < this.c.getModifyTime());
  }

  public void dispose()
  {
    if ((this.f != null) && (!this.f.isDisposed()))
      this.f.dispose();
    this.c.removeViewer(this);
    if (this.a != null)
      this.a.a(getCompositeUuid(), this.b);
  }

  protected boolean b()
  {
    if (this.c.isLocked())
      return true;
    return c.g(this.c.getName());
  }

  public boolean canCopy()
  {
    return false;
  }

  public boolean canCut()
  {
    return false;
  }

  public boolean canDelete()
  {
    return false;
  }

  public boolean canPaste()
  {
    return false;
  }

  public boolean c()
  {
    return false;
  }

  public boolean canRedo()
  {
    return false;
  }

  public boolean canUndo()
  {
    return false;
  }

  public void copy()
  {
  }

  public void cut()
  {
  }

  public void delete()
  {
  }

  public boolean paste()
  {
    return false;
  }

  public void d()
  {
  }

  public boolean redo()
  {
    return false;
  }

  public void selectAll()
  {
  }

  public boolean undo()
  {
    return false;
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
    return false;
  }

  public void a(BuilderManager paramBuilderManager)
  {
    this.e = paramBuilderManager;
  }

  public void a(bu parambu)
  {
    this.a = parambu;
    if (parambu == null)
      deleteObserver(this.e.getMenuAndToolBar());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a
 * JD-Core Version:    0.6.0
 */